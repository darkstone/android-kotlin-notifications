/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.eggtimernotifications.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.example.android.eggtimernotifications.MainActivity
import com.example.android.eggtimernotifications.R

// Notification ID.
private const val NOTIFICATION_ID = 0
private const val REQUEST_CODE = 0
private const val FLAGS = 0

// TODO: Step 1.1 extension function to send messages (GIVEN)
/**
 * Builds and delivers the notification.
 *
 * @param context, activity context.
 */
fun NotificationManager.sendNotification(
    context: Context,
    messageBody: String
) {
    // Create the content intent for the notification, which launches
    // this activity
    // TODO: Step 1.11 create intent
    val contentIntent = Intent(context, MainActivity::class.java)
    val contentPending = PendingIntent.getActivity(
        context,
        NOTIFICATION_ID,
        contentIntent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )


    // TODO: Step 1.12 create PendingIntent

    // TODO: Step 2.0 add style

    // TODO: Step 2.2 add snooze action

    // TODO: Step 1.2 get an instance of NotificationCompat.Builder
    // Build the notification
    val notification = NotificationCompat.Builder(
        context,
        context.getString(R.string.breakfast_notification_channel_id)
    )
    // TODO: Step 1.3 set title, text and icon to builder
    notification.setSmallIcon(R.drawable.egg_icon)
    notification.setContentTitle(context.getString(R.string.egg_notification_title))
    notification.setContentTitle(messageBody)
    notification.setAutoCancel(true)

    // TODO: Step 1.4 call notify to send notification
    //notify(NOTIFICATION_ID, builder.build())

    // TODO: Step 1.8 use the new 'breakfast' notification channel
    notification.setChannelId(context.getString(R.string.breakfast_notification_channel_id))


    // TODO: Step 1.13 set content intent
    notification.setContentIntent(contentPending)

    // TODO: Step 2.1 add style to builder
    val eggImage = BitmapFactory.decodeResource(context.resources, R.drawable.cooked_egg)
    val bitPictureStyle = NotificationCompat.BigPictureStyle()
        .bigPicture(eggImage)
        .bigLargeIcon(null)

    notification.setStyle(bitPictureStyle)
    notification.setLargeIcon(eggImage)


    // TODO: Step 2.3 add snooze action

    // TODO: Step 2.5 set priority
    notification.priority = NotificationCompat.PRIORITY_DEFAULT

    // TODO: Step 1.4 call notify

    notify(NOTIFICATION_ID, notification.build())

}

// TODO: Step 1.14 Cancel all notifications

fun NotificationManager.cancelNotifications() {
    cancelAll()
}