package pl.marczak.ifixpicturesrenderer.ifixPicture

import pl.marczak.ifixpicturesrenderer.codebase.Loadable
import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.ItemValueResult
import pl.marczak.ifixpicturesrenderer.model.IfixPicture

/**
 * Project "IfixPicturesRenderer"
 *
 * Created by Lukasz Marczak
 * on 25.05.2017.
 */
interface IfixScreenView : Loadable {

    fun onPictureError()

    fun onPictureReceived(obj: IfixPicture)

    fun  onPictureRecycle(value: List<ItemValueResult>)


}