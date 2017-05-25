package pl.marczak.ifixpicturesrenderer.availablePictures

import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import pl.marczak.ifixpicturesrenderer.codebase.RxCommons
import pl.marczak.ifixpicturesrenderer.connection.OpcDaClient

/**
 * Project "IfixPicturesRenderer"
 *
 * Created by Lukasz Marczak
 * on 25.05.2017.
 */

class AvailablePicturesPresenter(view: AvailablePicturesView?, restClient: OpcDaClient)
    : AvailablePicturesAdapter.ClickListener {

    var view: AvailablePicturesView? = null
    val client: OpcDaClient
    var disposable: Disposable? = null

    init {
        this.view = view
        this.client = restClient
    }

    fun requestForPictures() {

        client.availablePictures
                .doOnSubscribe { view?.onLoadStart() }
                .compose(RxCommons.applySchedulers())
                .doFinally { view?.onLoadEnd() }
                .subscribeWith(object : SingleObserver<List<String>> {
                    override fun onSubscribe(d: Disposable) {
                        disposable = d
                    }

                    override fun onSuccess(value: List<String>) {
                        view?.onPicturesReceived(value)
                    }

                    override fun onError(e: Throwable) {
                        view?.onPicturesReceived(ArrayList<String>())
                    }
                })
    }

    override fun onClicked(title: String) {
        view?.switchToPicture(title)
    }

}