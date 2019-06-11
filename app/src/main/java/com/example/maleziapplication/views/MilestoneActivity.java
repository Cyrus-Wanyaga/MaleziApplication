package com.example.maleziapplication.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maleziapplication.R;

public class MilestoneActivity extends Activity {

    private Button btnMilestone1;
    private Button btnMilestone2;
    private Button btnMilestone3;
    private Button btnMilestone4;
    private Button btnMilestone5;
    private Button btnMilestone6;
    private Button btnMilestone7;
    private Button btnMilestone8;
    private Button btnMilestone9;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestones);

        btnMilestone1 = findViewById(R.id.milestone1_btn);
        btnMilestone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent milestone1_Intent = new Intent(MilestoneActivity.this, Milestone1.class);
                startActivity(milestone1_Intent);
                finish();
            }
        });
    }
}
