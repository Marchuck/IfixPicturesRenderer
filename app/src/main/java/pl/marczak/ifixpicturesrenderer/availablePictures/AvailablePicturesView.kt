package pl.marczak.ifixpicturesrenderer.availablePictures

import pl.marczak.ifixpicturesrenderer.codebase.Loadable

/**
 * Project "IfixPicturesRenderer"
 *
 * Created by Lukasz Marczak
 * on 25.05.2017.
 */
interface AvailablePicturesView : Loadable{

    fun onPicturesReceived(pictures: List<String>)

    fun switchToPicture(picture: String)

    fun onPicturesError()
}