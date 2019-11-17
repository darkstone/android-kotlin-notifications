package com.example.android.eggtimernotifications.messaging

import android.app.NotificationManager
import android.util.Log
import androidx.core.content.getSystemService
import com.example.android.eggtimernotifications.util.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refresh token token: $token")
        sendRegistrationToServer(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "Remote message from ${remoteMessage.from}")
        remoteMessage.data.let { payload -> Log.d(TAG, "Message payload: $payload") }
        remoteMessage.notification?.body?.let(this::sendNotification)
    }

    private fun sendNotification(message: String) {
        applicationContext
            .getSystemService<NotificationManager>()
            ?.sendNotification(applicationContext, message)
    }

    private fun sendRegistrationToServer(token: String) {
    }

    companion object {
        const val TAG = "MessagingService"
    }
}