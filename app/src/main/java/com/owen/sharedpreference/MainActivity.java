package com.owen.sharedpreference;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    //step 1
    //get the elements and views used.
    ConstraintLayout mConstraintLayout;
    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //step 5 . instantiate the sharedpreference
        SharedPreferences sharedPreferences = getSharedPreferences("background", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        //step 8 . check if the preference contains a color ID
        if (sharedPreferences.contains("colorID"))
           mConstraintLayout.setBackgroundColor(sharedPreferences.getInt("colorID",0));

        //step 2 . find the views form XML
        mConstraintLayout = findViewById(R.id.contraint_layout);
        mRadioGroup = findViewById(R.id.rGroup_view);

        //step 3 . Set oncheckedChange listeners
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //step 6 . Add variable to hold the color codes.
                int colorCodeID = 0;
                //Step 4 .Check for the radio button selected by the user
                switch (checkedId) {
                    case R.id.rbtnBlue:
                        colorCodeID = Color.BLUE;
                        break;
                    case R.id.rbtnYellow:
                        colorCodeID = Color.YELLOW;
                        break;
                    case R.id.rbtnRed:
                        colorCodeID = Color.MAGENTA;
                        break;
                }
                //step 7 .setbackground color to the colorCodeId
                mConstraintLayout.setBackgroundColor(colorCodeID);
                editor.putInt("colorID",colorCodeID);
                editor.apply();
            }
        });

    }
}