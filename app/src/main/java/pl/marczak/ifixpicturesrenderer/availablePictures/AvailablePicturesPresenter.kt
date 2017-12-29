package pl.marczak.ifixpicturesrenderer.availablePictures

import android.util.Log
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import pl.marczak.ifixpicturesrenderer.codebase.RxCommons
import pl.marczak.ifixpicturesrenderer.connection.OpcDaClient
import java.util.*
import java.util.concurrent.TimeUnit

class AvailablePicturesPresenter(restClient: OpcDaClient) : AvailablePicturesAdapter.ClickListener {

    val TAG = AvailablePicturesPresenter::class.java.simpleName
    val client: OpcDaClient = restClient

    var viewDisposable: Disposable? = null;

    var picturesAvailable: BehaviorSubject<List<String>> = BehaviorSubject.create()

    var view: AvailablePicturesView? = null
        set (value) {
            Log.d(TAG, "setView")
            viewDisposable?.dispose()
            subscribeView(value)
            field = value
        }

    init {
        requestForPictures()
    }

    private fun subscribeView(view: AvailablePicturesView?) {

        Log.d(TAG, "subscribeView")

        view?.onLoadStart()

        viewDisposable = picturesAvailable
                .compose(RxCommons.applyObservableSchedulers())
                .doFinally { view?.onLoadEnd() }
                .subscribe({
                    Log.d(TAG, "onNext" + Arrays.toString(it.toTypedArray()))
                    view?.onPicturesReceived(it)
                }, {
                    Log.e("ReposPresenter", "Error", it)
                    view?.onPicturesError()
                })
    }


    fun requestForPictures() {

        Log.d(TAG, "requestForPictures")

        client.availablePictures
                .compose(RxCommons.applySingleSchedulers())
                .timeout(7, TimeUnit.SECONDS)
                .doFinally { view?.onLoadEnd() }
                .subscribe(object : SingleObserver<List<String>> {
                    override fun onSuccess(value: List<String>?) {
                        Log.d(TAG, "onSuccess")
                        picturesAvailable.onNext(value)
                    }

                    override fun onError(e: Throwable?) {
                        Log.d(TAG, "onError")
                        picturesAvailable.onError(e)
                    }

                    override fun onSubscribe(d: Disposable?) {

                    }
                })
    }

    override fun onClicked(title: String) {
        view?.switchToPicture(title)
    }
}