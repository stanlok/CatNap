package com.example.emily.catnap;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;

/**
 * Created by emily on 11/4/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent ){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification;
        notification = builder.setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentTitle("CatNap")
                .setContentText("Sleep Time")
                .setSubText("Turn off your phone (╯°□°）╯︵ ┻━┻")
                .setColor(Color.BLUE)
                .build();
        notificationManager.notify(1, notification);
    }
}
