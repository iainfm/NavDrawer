package com.example.mcclaren.navdrawer;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MesssagingService extends FirebaseMessagingService {


    private static final String TAG = MesssagingService.class.getSimpleName();
    public MesssagingService() {
    }

    @Override
    /*public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }*/

    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d("Message", "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d("Message", "Message data payload: " + remoteMessage.getData());

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            // Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG);

            Intent intent = new Intent();
            intent.putExtra("extra", remoteMessage.getNotification().getBody());
            intent.setAction("com.example.mcclaren.navdrawer.onMessageReceived");
            sendBroadcast(intent);
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.

    }
}
