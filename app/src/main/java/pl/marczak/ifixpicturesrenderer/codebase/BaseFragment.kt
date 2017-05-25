package pl.marczak.ifixpicturesrenderer.codebase

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

/**
 * Project "IfixPicturesRenderer"
 *
 *
 * Created by Lukasz Marczak
 * on 25.05.2017.
 */

abstract class BaseFragment<out T : FragmentActivity> : Fragment() {

    val parentActivity: T
        get() = activity as T
}
