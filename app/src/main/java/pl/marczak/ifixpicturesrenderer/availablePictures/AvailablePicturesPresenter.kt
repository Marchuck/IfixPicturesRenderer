package pl.marczak.ifixpicturesrenderer.availablePictures

import android.util.Log
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import pl.marczak.ifixpicturesrenderer.codebase.RxCommons
import pl.marczak.ifixpicturesrenderer.connection.OpcDaClient
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * Project "IfixPicturesRenderer"
 *
 * Created by Lukasz Marczak
 * on 25.05.2017.
 */

class AvailablePicturesPresenter : AvailablePicturesAdapter.ClickListener {

    val TAG = AvailablePicturesPresenter::class.java.simpleName
    val client: OpcDaClient

    constructor(restClient: OpcDaClient) {
        this.client = restClient
        requestForPictures()
    }

    var viewDisposable: Disposable? = null

    var picturesAvailable: BehaviorSubject<List<String>> = BehaviorSubject.create()

    var view: AvailablePicturesView? = null
        set (value) {
            Log.d(TAG, "setView")
            viewDisposable?.dispose()
            subscribeView(value)
            field = value
        }

    private fun subscribeView(view: AvailablePicturesView?) {

        Log.d(TAG, "subscribeView")

        picturesAvailable.doOnSubscribe { view?.onLoadStart() }
                 .compose(RxCommons.applySchedulers2())
                .doFinally { view?.onLoadEnd() }
                .subscribe(object : Observer<List<String>> {
                    override fun onSubscribe(d: Disposable) {
                        viewDisposable = d
                    }

                    override fun onError(e: Throwable) {
                        Log.e("ReposPresenter", "Error", e)
                        view?.onPicturesError()
                    }

                    override fun onNext(pictures: List<String>) {
                        Log.d(TAG, "onNext" + Arrays.toString(pictures.toTypedArray()))

                        view?.onPicturesReceived(pictures)
                    }

                    override fun onComplete() {
                    }
                })
    }


    fun requestForPictures() {

        Log.d(TAG, "requestForPictures")

        client.availablePictures
                .compose(RxCommons.applySchedulers())
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