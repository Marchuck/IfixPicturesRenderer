package pl.marczak.ifixpicturesrenderer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import pl.marczak.ifixpicturesrenderer.availablePictures.AvailablePicturesFragment
import pl.marczak.ifixpicturesrenderer.connection.OpcDaClient
import pl.marczak.ifixpicturesrenderer.parsing.XmlParserWrapper

class MainActivity : AppCompatActivity() {

    lateinit var opcDaClient: OpcDaClient
    val xmlParser = XmlParserWrapper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        opcDaClient = App.getApp(this).client

        switchToFragment(AvailablePicturesFragment.newInstance(), AvailablePicturesFragment.TAG)
    }

    fun switchToFragment(f: Fragment, tag: String) {

        val transaction = supportFragmentManager.beginTransaction()

        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.content_frame, f, tag)

        if (supportFragmentManager.hasAnyFragment()) {
            transaction.addToBackStack(null)
        }

        transaction.commitAllowingStateLoss()

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}

private fun FragmentManager.hasAnyFragment(): Boolean {
    val size = this.fragments?.count() ?: 0
    return size > 0
}

