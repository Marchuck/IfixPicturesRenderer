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

open class AvailablePic : RealmObject() {
    @PrimaryKey var name = "-"
    var content: String? = null
}
