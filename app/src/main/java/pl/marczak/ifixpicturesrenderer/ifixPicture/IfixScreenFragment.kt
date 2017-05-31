package pl.marczak.ifixpicturesrenderer.ifixPicture

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import org.jetbrains.anko.support.v4.find
import pl.marczak.ifixpicturesrenderer.MainActivity
import pl.marczak.ifixpicturesrenderer.R
import pl.marczak.ifixpicturesrenderer.codebase.BaseFragment
import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.ItemValueResult
import pl.marczak.ifixpicturesrenderer.model.IfixPicture
import pl.marczak.ifixpicturesrenderer.model.data.DataRect
import pl.marczak.ifixpicturesrenderer.model.data.SynopticView
import pl.marczak.ifixpicturesrenderer.parsing.XmlParseResponse
import java.util.concurrent.TimeUnit


class IfixScreenFragment : BaseFragment<MainActivity>(), IfixScreenView {


    internal var pictureName: String? = null

    var endpointEditText: EditText? = null
    var enable_switch: Switch? = null
    var synopticView: SynopticView? = null
    var contentView: RelativeLayout? = null
    var progressBar: ProgressBar? = null

    var presenter: IfixScreenPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            pictureName = arguments.getString(PICTURE_NAME, null)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, root: ViewGroup?, s: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater!!.inflate(R.layout.fragment_ifix_screen, root, false)

        return v
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = IfixScreenPresenter(
                view = this,
                restClient = parentActivity.opcDaClient,
                parser = parentActivity.xmlParser
        )
        endpointEditText = find<EditText>(R.id.endpointEditText)
        endpointEditText?.setText(parentActivity.opcDaClient.currentEndpoint)

        enable_switch = find<Switch>(R.id.enable_switch)
        progressBar = find<ProgressBar>(R.id.progressBar)

        enable_switch?.setOnClickListener {

            // enable_switch?.isChecked = !enable_switch?.isChecked!!

            if (enable_switch?.isChecked!!) {
                Toast.makeText(activity, "updates enabled", Toast.LENGTH_SHORT).show()
                presenter?.requestUpdates()
            } else {
                Toast.makeText(activity, "updates disabled", Toast.LENGTH_SHORT).show()
                presenter?.stopUpdates()
            }
        }

        presenter?.fetchPicture(pictureName!!)
    }

    override fun onLoadStart() {
        progressBar?.post { progressBar?.visibility = View.VISIBLE }
    }

    override fun onLoadEnd() {
        progressBar?.post { progressBar?.visibility = View.GONE }
    }

    override fun onPictureError() {
        progressBar?.post { progressBar?.visibility = View.GONE }
    }

    override fun onPictureReceived(obj: IfixPicture) {

        Log.d(TAG, "onPictureReceived: " + obj?.toString())

        val screen = obj.createScreen()

        (screen.children)?.let {
            for (data in screen.children) {
                if (data is DataRect) {
                    Log.e(TAG, "Rect id: " + data.id)
                }
            }
        }

        screen.keys?.let {
            for (s in screen.keys) {
                Log.w(TAG, "binding key: " + s)
            }
        }

        screen.values?.let {
            for (s in screen.values) {
                Log.w(TAG, "binding value: " + s)
            }
        }
        screen.animations?.let {
            for (animation in screen.animations) {
                Log.i(TAG, "animation: " + animation.id + "\n" + animation)
            }
        }

        synopticView = SynopticView(this.activity)

        val rootLayout = LinearLayout(this.activity)
        rootLayout.setBackgroundColor(Color.DKGRAY)

        synopticView?.init(screen)

        rootLayout.addView(synopticView, LinearLayout.LayoutParams(-1, -1))

        contentView = find<RelativeLayout>(R.id.contentView)
        contentView?.removeAllViews()
        contentView?.addView(rootLayout)

        presenter!!.newResults.throttleFirst(200, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<List<ItemValueResult>>() {
                    override fun onComplete() {
                    }

                    override fun onNext(value: List<ItemValueResult>) {
                        Log.d(TAG, "onNext " + value.size)
                        synopticView?.invalidateData(value)
                    }

                    override fun onError(e: Throwable) {

                    }
                })
    }

    override fun onPictureRecycle(value: List<ItemValueResult>) {
        Log.i(TAG, "onPictureRecycle[" + value.size + " items updated]")
        synopticView?.post {
            synopticView?.invalidateData(value)
        }
    }

    companion object {

        private val PICTURE_NAME = "PICTURE_NAME"

        val TAG = IfixScreenFragment.javaClass.simpleName!!

        fun newInstance(pictureName: String): IfixScreenFragment {
            val fragment = IfixScreenFragment()
            val args = Bundle()
            args.putString(PICTURE_NAME, pictureName)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
