package pl.marczak.ifixpicturesrenderer.ifixPicture

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import pl.marczak.ifixpicturesrenderer.codebase.RxCommons
import pl.marczak.ifixpicturesrenderer.connection.OpcDaClient
import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.Image
import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.ItemValueResult
import pl.marczak.ifixpicturesrenderer.model.IfixPicture
import pl.marczak.ifixpicturesrenderer.parsing.XmlParseResponse
import pl.marczak.ifixpicturesrenderer.parsing.XmlParserWrapper
import java.util.concurrent.TimeUnit

/**
 * Project "IfixPicturesRenderer"
 *
 * Created by Lukasz Marczak
 * on 25.05.2017.
 */
class IfixScreenPresenter(view: IfixScreenView?, restClient: OpcDaClient, parser: XmlParserWrapper) {

    var view: IfixScreenView? = null

    val restClient: OpcDaClient
    val parser: XmlParserWrapper
    var disposable: Disposable? = null
    var updatesDisposable: Disposable? = null
    var updatesEnabled: Boolean = false

    init {
        this.view = view
        this.restClient = restClient
        this.parser = parser
    }

    fun fetchPicture(name: String) {


        restClient.getPicture(name)
                .doOnSubscribe {
                    view?.onLoadStart()
                }
                .compose(RxCommons.applySchedulers<Image>())
                .map { image -> image.content }
                .map { xml -> parser.parse(xml, IfixPicture::class.java) }
                .doFinally { view?.onLoadEnd() }
                .subscribeWith(object : SingleObserver<XmlParseResponse<IfixPicture>> {
                    override fun onSubscribe(d: Disposable) {
                        disposable = d
                    }

                    override fun onSuccess(value: XmlParseResponse<IfixPicture>) {
                        if (value.isSuccesful) {
                            view?.onPictureReceived(value.obj)
                            //view?.showRestOfTheLayout()
                        } else {
                            view?.onPictureError()
                        }

                    }

                    override fun onError(e: Throwable) {
                        view?.onPictureError()
                    }
                })

    }

    fun requestUpdates() {
        updatesEnabled = true
        performUpdate()
    }

    fun performUpdate() {
        disposeIfNotDisposed()
        restClient.workspace
                .delay(200, TimeUnit.MILLISECONDS)
                .doOnSubscribe { view?.onLoadStart() }
                .compose(RxCommons.applySchedulers<List<ItemValueResult>>())
                .subscribeWith(object : SingleObserver<List<ItemValueResult>> {
                    override fun onSubscribe(d: Disposable) {
                        updatesDisposable = d
                    }

                    override fun onSuccess(value: List<ItemValueResult>) {
                        view?.onPictureRecycle(value)
                        if (updatesEnabled) {
                            requestUpdates()
                        }

                    }

                    override fun onError(e: Throwable) {
                        view?.onPictureError()
                    }
                })

    }

    fun stopUpdates() {
        updatesEnabled = false
        disposeIfNotDisposed()
    }

    fun disposeIfNotDisposed(): Unit {
        updatesDisposable?.dispose()
    }

    fun onDestroy() {
        disposable?.dispose()
        updatesDisposable?.dispose()
    }
}