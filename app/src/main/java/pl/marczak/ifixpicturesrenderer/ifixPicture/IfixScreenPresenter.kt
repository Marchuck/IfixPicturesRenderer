package pl.marczak.ifixpicturesrenderer.ifixPicture

import android.util.Log
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import pl.marczak.ifixpicturesrenderer.codebase.RxCommons
import pl.marczak.ifixpicturesrenderer.connection.OpcDaClient
import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.Image
import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.ItemValueResult
import pl.marczak.ifixpicturesrenderer.model.Pictureable
import pl.marczak.ifixpicturesrenderer.model.SingleIfixPicture
import pl.marczak.ifixpicturesrenderer.model.data.IfixScreen
import pl.marczak.ifixpicturesrenderer.model.newAge.PumpIfixPicture
import pl.marczak.ifixpicturesrenderer.parsing.XmlParseResponse
import pl.marczak.ifixpicturesrenderer.parsing.XmlParserWrapper

/**
 * Project "IfixPicturesRenderer"
 *
 * Created by Lukasz Marczak
 * on 25.05.2017.
 */
class IfixScreenPresenter(view: IfixScreenView?, restClient: OpcDaClient, parser: XmlParserWrapper) {

    companion object {
        val TAG = IfixScreenPresenter::class.java.simpleName
    }

    val newResults: PublishSubject<List<ItemValueResult>> = PublishSubject.create()
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

    fun createScreen(response: XmlParseResponse<*>): IfixScreen? {

        if (response.isSuccesful && response.obj is Pictureable) {

            val screen = (response.obj as Pictureable).createScreen()

            return screen
        }


        return null
    }

    fun fetchPicture(name: String) {

        Log.w(TAG, "fetchPicture")

        restClient.getPicture(name)
                .doOnSubscribe {
                    view?.onLoadStart()
                }
                .compose(RxCommons.applySingleSchedulers<Image>())
                .map { image -> image.content }
                .map { xml ->
                    parser.parse(xml, arrayListOf(
                            SingleIfixPicture::class.java, PumpIfixPicture::class.java))
                }
                .map { fixPicture: XmlParseResponse<*> -> createScreen(fixPicture) }
                .doFinally { view?.onLoadEnd() }
                .subscribeWith(object : SingleObserver<IfixScreen?> {
                    override fun onSubscribe(d: Disposable) {
                        disposable = d
                    }

                    override fun onSuccess(value: IfixScreen?) {

                        if (value != null) {
                            view?.onPictureReceived(value)
                            //view?.showRestOfTheLayout()
                        } else {
                            Log.e(TAG, "error: xmlParse response ")
                            view?.onPictureError()
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.e(TAG, "error: " + e)
                        view?.onPictureError()
                    }
                })

    }

    fun fetchPictureFromXml(xml: String) {

        Log.w(TAG, "fetchPicture")

        Single.just(

                parser.parse(xml,
                        arrayListOf(SingleIfixPicture::class.java, PumpIfixPicture::class.java))

        ).map { fixPicture: XmlParseResponse<*> -> createScreen(fixPicture) }
                .doFinally { view?.onLoadEnd() }
                .subscribeWith(object : SingleObserver<IfixScreen?> {
                    override fun onSubscribe(d: Disposable) {
                        disposable = d
                    }

                    override fun onSuccess(value: IfixScreen?) {

                        if (value != null) {
                            view?.onPictureReceived(value)
                            //view?.showRestOfTheLayout()
                        } else {
                            Log.e(TAG, "error: xmlParse response ")
                            view?.onPictureError()
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.e(TAG, "error: " + e)
                        view?.onPictureError()
                    }
                })

    }

    fun requestUpdates() {
        updatesEnabled = true
        performUpdate()
    }

    fun performUpdate() {
        Log.w("IfixScreenPresenter", "performUpdate")
        disposeIfNotDisposed()
        restClient.goFuckYourself()
                .doOnSubscribe { d -> updatesDisposable = d }
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(object : DisposableObserver<List<ItemValueResult>>() {

                    override fun onNext(value: List<ItemValueResult>) {
                        Log.d("IfixScreenPresenter", "performUpdate")
                        newResults.onNext(value)
                        performUpdate()
                    }

                    override fun onError(e: Throwable) {
                        Log.e("IfixScreenPresenter", "error: ", e)
                        view?.onPictureError()
                    }

                    override fun onComplete() {
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