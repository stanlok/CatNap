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

public class CatNap extends AppCompatActivity {

    Button customize_button;
    Button statistics_button;
    Button credits_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_nap);

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

        statistics_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CatNap.this, Statistics.class));
            }
        });


        credits_button = findViewById(R.id.creditsNavButton);

        credits_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CatNap.this, Credits.class));
            }
        });
    }

}
