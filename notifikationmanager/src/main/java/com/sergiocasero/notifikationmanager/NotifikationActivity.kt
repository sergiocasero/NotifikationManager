package com.sergiocasero.notifikationmanager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*

/**
 * NotifikationActivity.
 */
abstract class NotifikationActivity : AppCompatActivity(), Observer {

    private val notificationManager = NotifikationManager

    protected abstract fun onNotificationReceived(any: Any)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        notificationManager.addObserver(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        notificationManager.deleteObserver(this)
    }

    override fun update(p0: Observable?, p1: Any?) {
        if (p1 != null) {
            onNotificationReceived(p1)
        }
    }
}