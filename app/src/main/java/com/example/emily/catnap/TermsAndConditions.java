package com.example.emily.catnap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by Austin on 11/4/2017.
 *
 * This class shows the Terms and Conditions activity page, which shows
 * the user the terms and conditions, to which they must click 'agree' to
 * continue onto the Customize page for the app's full features.
 */

public class TermsAndConditions extends AppCompatActivity {

    /**
     * declineButton - The button switches the activity to display the CatNap (home)
     *                 activity page
     *
     * agreeButton   - The button switches the activity to display the Customize
     *                 activity page
     *
     * dont_show     - The checkbox allows the user to skip having to agree to the
     *                 terms and conditions every time they wish to access the Customize
     *                 page
     */
    Button declineButton;
    Button agreeButton;
    CheckBox dont_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        /**
         * Instantiation of the global variables for use and updating for future
         * activities
         */
        final GlobalVars globalVariable = (GlobalVars) getApplicationContext();

        /**
         * Instantiation of the dont_show CheckBox
         */
        dont_show = findViewById(R.id.doNotShowCheckbox);

        /**
         * Instantiation of the declineButton Button, which switches the user back to the
         * home page, indicating that they declined the specified terms and conditions
         */
        declineButton = findViewById(R.id.declineTnCButton);

        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TermsAndConditions.this, CatNap.class));
            }
        });

        /**
         * Instantiation of the agreeButton Button, which switches the user to the Customize
         * page. Additionally, if the user ticked the dont_show checkbox, then this activity page
         * will never be shown again when the user wants to access the customize page
         */
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
