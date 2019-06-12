package com.example.maleziapplication.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.maleziapplication.R;
import com.google.android.material.snackbar.Snackbar;


import androidx.appcompat.app.AppCompatActivity;

public class Milestone1 extends AppCompatActivity {

    private int rb1_1, rb1_2, rb1_3, rb1_5, rb1_9;
    private Button btnRecommendations;
    private TextView tvRecommendations;
    String normal, abnormal;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestone1);

        normal = "Baby growth is normal";
        abnormal = "Baby growth is abnornmal. Please seek physician help";
        btnRecommendations = findViewById(R.id.btn_milestone1_result);
        tvRecommendations = findViewById(R.id.tv_milestone1_result);


        //React on Button Click
        btnRecommendations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb1_1 == 1 && rb1_2 == 1 && rb1_3 == 1 && rb1_5 == 1 && rb1_9 == 1){ //Logic
                    //Display string if growth is normal
                    tvRecommendations.setText(normal);
//                    final View coordinatorLayoutView = findViewById(R.id.snackbarPosition);
//                    Snackbar snackbar = Snackbar.make(coordinatorLayoutView, normal, Snackbar.LENGTH_LONG);
//                    snackbar.show();
                } else {
                    //Display string when growth is abnormal
                    tvRecommendations.setText(abnormal);
//                    final View coordinatorLayoutView = findViewById(R.id.snackbarPosition);
//                    Snackbar snackbar = Snackbar.make(coordinatorLayoutView, normal, Snackbar.LENGTH_LONG);
//                    snackbar.show();
                }
            }
        });

    }

    public void onRadioButtonClicked (View view){

        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.rb_milestone1_1_yes:
                if(checked)
                    rb1_1 = 1;
                break;
            case R.id.rb_milestone1_1_delayed:
                if (checked)
                    rb1_1 = 0;
                break;
        }

        boolean checked2 = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.rb_milestone1_2_yes:
                if(checked2)
                    rb1_2 = 1;
                break;
            case R.id.rb_milestone1_2_delayed:
                if (checked2)
                    rb1_2 = 0;
                break;
        }

        boolean checked3 = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.rb_milestone1_3_yes:
                if(checked3)
                    rb1_3 = 1;
                break;
            case R.id.rb_milestone1_3_delayed:
                if (checked3)
                    rb1_3 = 0;
                break;
        }

        boolean checked4 = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.rb_milestone1_5_yes:
                if(checked4)
                    rb1_5 = 1;
                break;
            case R.id.rb_milestone1_5_delayed:
                if (checked4)
                    rb1_5 = 0;
                break;
        }

        boolean checked5 = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.rb_milestone1_9_yes:
                if(checked5)
                    rb1_9 = 1;
                break;
            case R.id.rb_milestone1_9_delayed:
                if (checked5)
                    rb1_9 = 0;
                break;
        }
    }

}
