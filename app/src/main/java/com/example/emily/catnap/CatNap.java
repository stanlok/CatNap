package com.example.emily.catnap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created on 11/4/2017.
 *
 * The main purpose of this project is to create an application
 * that will help reduce the amount of time that people spend on
 * their phones at night right before they are about to sleep.
 * Such habits are detrimental to one's health, and CatNap aims to
 * help people who wish to change their nightly habits by providing
 * a constant stream of notifications to deter them from staying on
 * their phones as well as a statistics to track their sleeping-phone
 * habits.
 *
 * This class acts as the home page activity of the application.
 * The UI includes the title of the app (CatNap) as well as 3
 * buttons used to navigate to the various activity pages of the
 * app.
 */

public class CatNap extends AppCompatActivity {

    /**
     * customize_button   - This button switches the activity to the Customize activity page.
     *                      Initially, this button navigates the user to a Terms and Conditions
     *                      page, where they must click 'agree' to proceed to the Customize page.
     *                      The customize page lets the user specify the time intervals when they
     *                      should be off their phones and asleep.
     *
     * statistics_button  - This button switches the activity to the Statistics activity page,
     *                      which shows information about the user's sleeping habits tracked
     *                      over time while using the application.
     *
     * credits_button     - This button switches to the Credits activity page, which shows
     *                      information about the creators of the application.
     */
    Button customize_button;
    Button statistics_button;
    Button credits_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_nap);

        /**
         * Instantiation of the global variables for use and updating for future
         * activities
         */
        final GlobalVars globalVariable = (GlobalVars) getApplicationContext();

        /**
         * Instantiation of the customize_button Button and functionality when the
         * user clicks on the button, which navigates to the Terms and Conditions
         * activity if the user did not select the "Do not show again" option
         * previously. Otherwise, navigates the user to the Customize activity
         */
        customize_button = findViewById(R.id.customizeNavButton);

        customize_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (globalVariable.get_do_not_show() == false)
                    startActivity(new Intent(CatNap.this, TermsAndConditions.class));
                else
                    startActivity(new Intent(CatNap.this, Customize.class));
            }
        });

        /**
         * Instantiation of the statistics_button Button and functionality when
         * the user clicks on the button, which navigates the user to the Statistics
         * activity.
         */
        statistics_button = findViewById(R.id.statisticsNavButton);

        statistics_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CatNap.this, Statistics.class));
            }
        });

        /**
         * Instantiation of the credits_button Button and functionality when the user
         * clicks on the button, which navigates the user to the Credits activity.
         */
        credits_button = findViewById(R.id.creditsNavButton);

        credits_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CatNap.this, Credits.class));
            }
        });
    }

}
