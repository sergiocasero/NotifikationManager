package com.sergiocasero.notifikationmanager

import android.app.NotificationManager
import android.content.Context
import android.support.v7.app.NotificationCompat

/**
 * Notification.
 */
fun Context.displayNotification(id: Int, title: String, description: String) {
    val builder = NotificationCompat.Builder(this)
            .setContentTitle(title)
            .setContentText(description)

    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.notify(id, builder.build())
}