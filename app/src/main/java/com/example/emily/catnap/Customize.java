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

/**
 * Created by Stanley on 11/4/2017.
 *
 * This class allows the user to input the specific times when they
 * are supposed to be off their phones and sleeping. Once they confirm
 * their inputted times, the user can toggle the app on (turn snooze off),
 * and subsequently will receive notifications telling them to go to sleep
 * if they are still on their phones.
 *
 */

public class Customize extends AppCompatActivity {

    /**
     * start_time   - The part of the UI that allows the user to input a starting
     *                time for when they wish to be off their phones and asleep
     *
     * end_time     - The part of the UI that allows the user to input an ending
     *                time for the time interval; in other words, specifies the time
     *                when they will stop receiving notifications for using their phone
     *
     * confirmTime  - This button allows users to confirm the times that they entered
     *                (start_time and end_time), which will be saved into GlobalVars class
     *                for use and persistence throughout the entire session
     *
     * cancelTime   - This button returns the user to the home (CatNap) activity page and
     *                does not save the changes made to start_time and end_time TimePickers
     *
     * toggleSnooze - This button toggles whether or not the user will receive notifications
     *                at the user-specified time interval; they will continue to receive
     *                notifications until it passes the end_time or when the button is toggled off
     */
    TimePicker start_time;
    TimePicker end_time;
    Button confirmTime;
    Button cancelTime;
    Button toggleSnooze;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        /**
         * Instantiation of the global variables for use and updating for future
         * activities
         */
        final GlobalVars globalVariable = (GlobalVars) getApplicationContext();

        /**
         * Instantiation of the start and end time TimePicker objects, allowing
         * the user to input their own time intervals for the app functionality
         */
        start_time = findViewById(R.id.startTimePicker);
        end_time = findViewById(R.id.endTimePicker);

        /**
         * Instantiation of the confirmTime button, allowing them to save their
         * user-inputted time intervals into global variables that will persist
         * across the session
         */
        confirmTime = findViewById(R.id.customizeConfirmButton);

        /**
         * A Calendar object that will be used to store the user-inputted time
         * intervals into GlobalVars.java
         */
        final Calendar cal = Calendar.getInstance();

        /**
         * An OnClickListener function that will update the startTime and endTime
         * Calendar values in GlobalVars.java with the user-inputted TimePicker values
         * of this Customize activity
         */
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

        /**
         * Instantiation of the cancelTime Button and functionality, which will
         * leave the user-inputted time intervals unsaved and navigate the user
         * back to the home page
         */
        cancelTime = findViewById(R.id.customizeCancelButton);

        cancelTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Customize.this, CatNap.class));
            }
        });

        /**
         * Instantiation of the toggleSnooze ToggleButton, allowing users to turn
         * notifications during the time interval on or off
         */
        toggleSnooze = findViewById(R.id.customizeToggleButton);

        /**
         * Updates display on the UI based on the value stored in GlobalVars.java
         */
        if (globalVariable.get_snoozed() == false) {
            set_toggle_snooze_text("On");
        }

        /**
         * An OnClickListener function that turns the receipt of notifications on
         * and off. Notifications are set to be sent at 1 minute intervals when the user
         * is on their phone within the interval (when snooze is off)
         */
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

    /**
     * Used to update the text on the toggleSnooze button
     * @param newText
     *          Either "ON" or "OFF" depending on the state when it was clicked
     */
    private void set_toggle_snooze_text(String newText){
        toggleSnooze.setText(newText);
    }

    /**
     * Sets a repeating alarm that sends a notification within the user-specified time
     * interval when snooze is toggled off. An AlarmManager object is used to set notifications
     * to go off after a delay and to repeat at certain intervals until the current time
     * exceeds the user-specified end_time
     *
     * @param delay
     *      The delay used to specify when to begin firing notifications
     * @param interval
     *      The interval between each subsequent notification up until the end_time
     */
    private void startAlarm(int delay, int interval){
        final GlobalVars globalVariable = (GlobalVars) getApplicationContext();
        AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent myIntent;
        PendingIntent pendingIntent;

        myIntent = new Intent(Customize.this, AlarmReceiver.class );
        pendingIntent = PendingIntent.getBroadcast(this,0,myIntent,0);

        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + delay ,interval, pendingIntent);
    }

    /**
     * Generates the notification which will be sent to the user's phone when they are
     * using it during the user-specified time interval. The NotificationManager and
     * NotificationCompat.Builder objects are used to customize the notification and to
     * fire off notifications when called
     *
     * *(functionality has been moved to the onReceive() method in AlarmReceiver.java)
     *
     * @param context
     *      The current context of the application
     * @param message
     *      The message to be displayed in the notification
     */
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
