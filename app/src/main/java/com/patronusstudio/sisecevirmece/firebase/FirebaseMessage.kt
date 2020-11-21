package com.patronusstudio.sisecevirmece.firebase

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.patronusstudio.sisecevirmece.util.NotificationHelper


class FirebaseMessage : FirebaseMessagingService() {
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        setNotification(p0)
    }

    fun setNotification(p0: RemoteMessage) {
        val baslik = p0.notification?.title ?: "Özledik"
        val mesaj = p0.notification?.body ?: "Gelin bir tur şişe çevirin ve eğlenin"
        val notifHelper = NotificationHelper(applicationContext, "bildirim", baslik, mesaj)
        notifHelper.showNotification()
    }

}