package pl.marczak.ifixpicturesrenderer.availablePictures

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import pl.marczak.ifixpicturesrenderer.codebase.BaseFragment
import pl.marczak.ifixpicturesrenderer.MainActivity
import pl.marczak.ifixpicturesrenderer.R
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import org.jetbrains.anko.support.v4.find
import pl.marczak.ifixpicturesrenderer.ifixPicture.IfixScreenFragment


typealias FIX = IfixScreenFragment
class AvailablePicturesFragment : BaseFragment<MainActivity>(), AvailablePicturesView {

    private val adapter: AvailablePicturesAdapter = AvailablePicturesAdapter()

    private var recyclerView: RecyclerView? = null
    private var progressBar: ProgressBar? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private var presenter: AvailablePicturesPresenter? = null

    override fun onCreateView(inflater: android.view.LayoutInflater?, root: ViewGroup?,
                              savedInstanceState: Bundle?): android.view.View? {
        // Inflate the layout for this fragment
        val v = inflater!!.inflate(R.layout.fragment_available_pictures, root, false)

        return v
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = AvailablePicturesPresenter(restClient = parentActivity.opcDaClient)
        presenter?.view = this
        setupViews()
    }

    private fun setupViews() {

        recyclerView = find(R.id.recyclerView)

        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        recyclerView?.adapter = adapter
        adapter.listener = presenter

        swipeRefreshLayout = find(R.id.swipeRefreshLayout)
        swipeRefreshLayout?.setOnRefreshListener {

            presenter?.requestForPictures()

        }
    }

    override fun onPicturesReceived(pictures: List<String>) {

        Log.d(TAG, "onPicturesReceived")

        if (pictures.isEmpty()) {
            Snackbar.make(swipeRefreshLayout!!, "No pictures to show, try again later", Snackbar.LENGTH_SHORT).show()
        } else {
            adapter.refreshDataset(pictures)
        }
        swipeRefreshLayout?.post { swipeRefreshLayout?.isRefreshing = false }

    }

    override fun onPicturesError() {
        Log.d(TAG, "onPicturesError")
        onPicturesReceived(emptyList())
    }

    override fun switchToPicture(picture: String) {
        parentActivity.switchToFragment(FIX.newInstance(picture), FIX.TAG)
    }

    override fun onLoadStart() {
        progressBar?.post { progressBar?.visibility = View.VISIBLE }
    }

    override fun onLoadEnd() {
        progressBar?.post { progressBar?.visibility = View.GONE }
        swipeRefreshLayout?.post { swipeRefreshLayout?.isRefreshing = false }

    }

    companion object {
        val TAG = AvailablePicturesFragment.javaClass.simpleName!!

        fun newInstance(): AvailablePicturesFragment = AvailablePicturesFragment()
    }

}
