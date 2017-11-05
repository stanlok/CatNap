package com.example.emily.catnap;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class Customize extends AppCompatActivity {

    TimePicker start_time;
    TimePicker end_time;
    Button confirmTime;
    Button cancelTime;
    Button toggleSnooze;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        final GlobalVars globalVariable = (GlobalVars) getApplicationContext();

        start_time = findViewById(R.id.startTimePicker);
        end_time = findViewById(R.id.endTimePicker);

        confirmTime = findViewById(R.id.customizeConfirmButton);

        final Calendar cal = Calendar.getInstance();

        confirmTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal.set(Calendar.HOUR_OF_DAY, start_time.getHour());
                cal.set(Calendar.MINUTE, start_time.getMinute());
                globalVariable.set_startTime(cal);

                cal.set(Calendar.HOUR_OF_DAY, end_time.getHour());
                cal.set(Calendar.MINUTE, end_time.getMinute());
                globalVariable.set_endTime(cal);
            }
        });


        cancelTime = findViewById(R.id.customizeCancelButton);

        cancelTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Customize.this, CatNap.class));
            }
        });


        toggleSnooze = findViewById(R.id.customizeToggleButton);

        if (globalVariable.get_snoozed() == false) {
            set_toggle_snooze_text("On");
        }

        toggleSnooze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (globalVariable.get_snoozed() == true) {
                    set_toggle_snooze_text("On");
                    globalVariable.set_snoozed(false);
//                    while(Calendar.getInstance().getTimeInMillis() + 300000 > globalVariable.get_startTime().getTimeInMillis()) {}
                    //generateNotification(Customize.this, "Your phone will lock in 5 minutes!");

                    startAlarm(20000,10000);

//                    while (Calendar.getInstance().getTimeInMillis() + 60000 > globalVariable.get_startTime().getTimeInMillis()) {}
                    //generateNotification(Customize.this, "Your phone will lock in 1 minutes!");

//                    if (Calendar.getInstance().getTimeInMillis() + 300000 == globalVariable.get_startTime().getTimeInMillis())
//                            generateNotification(Customize.this, "Your phone will lock in 5 minutes!");
//                        if (Calendar.getInstance().getTimeInMillis() + 60000 == globalVariable.get_startTime().getTimeInMillis())
//                            generateNotification(Customize.this, "Your phone will lock in 1 minutes!");
//                    }

                }
                else {
                    set_toggle_snooze_text("Off");
                    globalVariable.set_snoozed(true);
                }
            }
        });


    }

    private void set_toggle_snooze_text(String newText){
        toggleSnooze.setText(newText);
    }

    private void startAlarm(int delay, int interval){
        final GlobalVars globalVariable = (GlobalVars) getApplicationContext();
        AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent myIntent;
        PendingIntent pendingIntent;

        myIntent = new Intent(Customize.this, AlarmReceiver.class );
        pendingIntent = PendingIntent.getBroadcast(this,0,myIntent,0);

        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + delay ,interval, pendingIntent);
    }


    private void generateNotification(Context context, String message) {
        int icon = R.mipmap.ic_launcher;
        long when = System.currentTimeMillis();
        String appname = "CatNap";
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        Notification notification;
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, CatNap.class), 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        notification = builder.setContentIntent(contentIntent)
                .setSmallIcon(icon)
                .setTicker(appname)
                .setWhen(when)
                .setAutoCancel(true)
                .setContentTitle(appname)
                .setContentText(message)
                .setSubText("Turn off your phone (╯°□°）╯︵ ┻━┻")
                .setColor(Color.BLUE)
                .build();

        notificationManager.notify((int) when, notification);
    }
}
