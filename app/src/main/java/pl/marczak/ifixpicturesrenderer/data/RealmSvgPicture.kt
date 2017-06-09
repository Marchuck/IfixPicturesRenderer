package pl.marczak.ifixpicturesrenderer.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Project "IfixPicturesRenderer"
 *
 *
 * Created by Lukasz Marczak
 * on 09.06.2017.
 */

open class RealmSvgPicture : RealmObject() {
    @PrimaryKey
    var id: String = ""

    var picture: String? = null

    var name: String = "-"
}