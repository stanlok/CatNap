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

        customize_button = findViewById(R.id.customizeNavButton);

        customize_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CatNap.this, Customize.class));
            }
        });


        statistics_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CatNap.this, Statistics.class));
            }
        });


        credits_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CatNap.this, Credits.class));
            }
        });
    }

}
