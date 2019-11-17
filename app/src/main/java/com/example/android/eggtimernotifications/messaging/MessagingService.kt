package com.example.android.eggtimernotifications.messaging

import android.util.Log
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
    }

    private fun sendRegistrationToServer(token: String) {
    }

    companion object {
        const val TAG = "MessagingService"
    }
}