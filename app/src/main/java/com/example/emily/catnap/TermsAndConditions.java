package com.example.emily.catnap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class TermsAndConditions extends AppCompatActivity {

    Button declineButton;
    Button agreeButton;
    CheckBox dont_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        final GlobalVars globalVariable = (GlobalVars) getApplicationContext();
        dont_show = findViewById(R.id.doNotShowCheckbox);

        declineButton = findViewById(R.id.declineTnCButton);

        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TermsAndConditions.this, CatNap.class));
            }
        });

        agreeButton = findViewById(R.id.agreeTnCButton);

        agreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dont_show.isChecked())
                    globalVariable.set_do_not_show(true);

                startActivity(new Intent(TermsAndConditions.this, Customize.class));
            }
        });

    }
}
