package com.sergiocasero.notifikationmanager

import android.app.NotificationManager
import android.content.Context
import android.support.v7.app.NotificationCompat

/**
 * Notification.
 */
fun Context.displayNotification(id: Int = 0,
                                title: String = "Default title",
                                description: String = "Default description",
                                iconId: Int = R.drawable.notification_icon_background) {
    val builder = NotificationCompat.Builder(this)
            .setContentTitle(title)
            .setContentText(description)
            .setSmallIcon(iconId)

    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.notify(id, builder.build())
}