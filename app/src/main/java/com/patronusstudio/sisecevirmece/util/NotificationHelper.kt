package com.patronusstudio.sisecevirmece.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.patronusstudio.sisecevirmece.R

class NotificationHelper(
    val mContext: Context, val channelID: String,
    val baslik: String,
    val mesaj: String
) {
    private lateinit var mChannel: NotificationChannel

    fun showNotification() {
        val builder: NotificationCompat.Builder = notiffff(baslik, mesaj)
        val notification: NotificationManagerCompat = NotificationManagerCompat.from(mContext)
        notification.notify(999, builder.build())
    }


    private fun notiffff(
        notificationTitle: String,
        notificationContent: String
    ): NotificationCompat.Builder {
        val mNotificationManager: NotificationManager =
            mContext.getSystemService(Context.NOTIFICATION_SERVICE) as (NotificationManager)

        var importance = 0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            importance = NotificationManager.IMPORTANCE_HIGH

        }

        val builder: NotificationCompat.Builder = NotificationCompat.Builder(mContext, channelID)
        builder.setContentTitle(mContext.getString(R.string.app_name))
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(notificationTitle)
            .setContentText(notificationContent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mChannel =
                NotificationChannel(channelID, mContext.getString(R.string.app_name), importance)
            mChannel.enableLights(true)
            mChannel.lightColor = Color.RED
            mChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            mNotificationManager.createNotificationChannel(mChannel)
        } else {
            builder.setPriority(NotificationCompat.PRIORITY_HIGH)
                .setColor(ContextCompat.getColor(mContext, R.color.colorPrimary))
                .setVibrate(longArrayOf(100, 250))
                .setLights(Color.YELLOW, 500, 5000)
                .setAutoCancel(true)
        }
        return builder
    }
}