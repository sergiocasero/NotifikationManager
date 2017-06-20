package com.sergiocasero.notificationmanager

import android.app.Application
import android.content.Intent


/**
 * SampleApp.
 */
class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startService(Intent(this, MainService::class.java))
    }

}