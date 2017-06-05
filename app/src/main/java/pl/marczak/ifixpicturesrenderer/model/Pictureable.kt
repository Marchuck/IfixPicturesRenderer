package pl.marczak.ifixpicturesrenderer.model

import pl.marczak.ifixpicturesrenderer.model.data.IfixScreen

/**
 * Project "IfixPicturesRenderer"
 *
 *
 * Created by Lukasz Marczak
 * on 05.06.2017.
 */

interface Pictureable {
    fun createScreen(): IfixScreen
}
