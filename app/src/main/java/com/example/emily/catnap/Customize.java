package com.example.emily.catnap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class Customize extends AppCompatActivity {

    TimePicker start_time;
    TimePicker end_time;
    Button confirmTime;
    Button cancelTime;
    Button toggleSnooze;

    boolean snoozed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        start_time = findViewById(R.id.startTimePicker);
        end_time = findViewById(R.id.endTimePicker);

        confirmTime = findViewById(R.id.customizeConfirmButton);

        confirmTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

        toggleSnooze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (snoozed == true) {
                    set_toggle_snooze_text("On");
                    snoozed = false;
                }
                else {
                    set_toggle_snooze_text("Off");
                    snoozed = true;
                }
            }
        });
    }

    private void set_toggle_snooze_text(String newText){
        toggleSnooze.setText(newText);
    }
}
