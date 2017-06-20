package com.sergiocasero.notifikationmanager

import android.support.v7.app.AppCompatActivity
import java.util.*

/**
 * NotifikationActivity.
 */
abstract class NotifikationActivity : AppCompatActivity(), Observer {

    private val notificationManager = NotifikationManager

    protected abstract fun onNotificationReceived(any: Any)

    override fun onResume() {
        super.onResume()
        notificationManager.addObserver(this)
    }

    override fun onPause() {
        super.onPause()
        notificationManager.deleteObserver(this)
    }

    override fun update(p0: Observable?, p1: Any?) {
        if (p1 != null) {
            onNotificationReceived(p1)
        }
    }
}