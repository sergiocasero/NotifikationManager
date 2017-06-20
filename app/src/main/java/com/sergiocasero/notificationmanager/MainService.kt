package com.sergiocasero.notificationmanager

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import com.sergiocasero.notifikationmanager.NotifikationManager
import com.sergiocasero.notifikationmanager.displayNotification


/**
 * MainService.
 */
class MainService : Service() {

    private val notificationManager = NotifikationManager

    companion object {
        val DELAY = 60000L
    }

    // Only for sample, don't use this method in a Service!
    override fun onCreate() {
        super.onCreate()

        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                if (notificationManager.isAppInForeground()) {
                    notificationManager.notify("Hello foreground! :)")
                } else {
                    displayNotification(0, "Background", "Hello Background!! :)")
                }
                handler.postDelayed(this, DELAY)
            }
        }

        handler.postDelayed(runnable, DELAY)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}