package com.owen.sharedpreference;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
        //step 2 . find the views form XML
        mConstraintLayout = findViewById(R.id.contraint_layout);
        mRadioGroup = findViewById(R.id.rGroup_view);

        //step 3 . Set oncheckedChange listeners
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //Step 4 .Check for the radio button selected by the user
                if (checkedId==R.id.rbtnBlue) {
                    mConstraintLayout.setBackgroundColor(Color.BLUE);
                }
                else if (checkedId==R.id.rbtnYellow)
                {
                    mConstraintLayout.setBackgroundColor(Color.YELLOW);
                }
                else if (checkedId==R.id.rbtnRed)
                {
                    mConstraintLayout.setBackgroundColor(Color.MAGENTA);
                }
            }
        });

    }
}