package com.example.emily.catnap;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import java.util.Calendar;

public class CatNap extends AppCompatActivity implements View.OnContextClickListener{

    Button customize_button;
    Button statistics_button;
    Button credits_button;
    public static final int RESULT_ENABLE = 1;
    DevicePolicyManager devicePolicyManager;
    ActivityManager activityManager;
    ComponentName componentName;
    Calendar currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_nap);
        devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        componentName = new ComponentName(this, MyAdmin.class);
        currentTime = Calendar.getInstance().getTimeInMillis();


        final GlobalVars globalVariable = (GlobalVars) getApplicationContext();

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

        statistics_button = findViewById(R.id.statisticsNavButton);

        statistics_button = findViewById(R.id.statisticsNavButton);

        statistics_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CatNap.this, Statistics.class));
            }
        });

        credits_button = findViewById(R.id.creditsNavButton);

        credits_button = findViewById(R.id.creditsNavButton);

        credits_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CatNap.this, Credits.class));
            }
        });

    }
        @Override
    protected void onResume() {
            super.onResume();
            boolean isActive = devicePolicyManager.isAdminActive(componentName);
        }
        @Override
    public void
        }

}
