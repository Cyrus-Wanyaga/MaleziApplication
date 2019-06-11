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

        btnMilestone2 = findViewById(R.id.milestone2_btn);
        btnMilestone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent milestone2_Intent = new Intent(MilestoneActivity.this, Milestone2.class);
                startActivity(milestone2_Intent);
                finish();
            }
        });

        btnMilestone3 = findViewById(R.id.milestone3_btn);
        btnMilestone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent milestone2_Intent = new Intent(MilestoneActivity.this, Milestone3.class);
                startActivity(milestone2_Intent);
                finish();
            }
        });

        btnMilestone4 = findViewById(R.id.milestone4_btn);
        btnMilestone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent milestone2_Intent = new Intent(MilestoneActivity.this, Milestone4.class);
                startActivity(milestone2_Intent);
                finish();
            }
        });

        btnMilestone5 = findViewById(R.id.milestone5_btn);
        btnMilestone5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent milestone2_Intent = new Intent(MilestoneActivity.this, Milestone5.class);
                startActivity(milestone2_Intent);
                finish();
            }
        });

        btnMilestone6 = findViewById(R.id.milestone6_btn);
        btnMilestone6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent milestone2_Intent = new Intent(MilestoneActivity.this, Milestone6.class);
                startActivity(milestone2_Intent);
                finish();
            }
        });
    }
}
