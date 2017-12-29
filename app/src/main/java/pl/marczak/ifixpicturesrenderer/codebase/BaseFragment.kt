package pl.marczak.ifixpicturesrenderer.codebase

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<out T : FragmentActivity> : Fragment() {

    val parentActivity: T
        get() = activity as T
}
