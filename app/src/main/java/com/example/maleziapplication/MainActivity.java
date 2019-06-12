package com.example.maleziapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import com.example.maleziapplication.views.Login;
import com.example.maleziapplication.views.MilestoneActivity;
import com.example.maleziapplication.views.SleepTracking;


public class MainActivity extends AppCompatActivity {

    private Button btnGrowthChart;
    private Button btnMilestone;
    private Button btnDiet;
    private Button btnSleep;
    private Button btnArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGrowthChart = (Button) findViewById(R.id.button1);
        btnMilestone = (Button) findViewById(R.id.button2);
        btnDiet = (Button) findViewById(R.id.button3);
        btnSleep = (Button) findViewById(R.id.button4);
        btnArticles = (Button) findViewById(R.id.button5);

        btnGrowthChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do something
            }
        });

        btnMilestone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMilestoneActivity();
            }
        });

        btnDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do something
            }
        });

        btnSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openSleepActivity();
            }
        });

        btnArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do something
            }
        });
    }

    public void openMilestoneActivity(){
        Intent intent = new Intent(this, MilestoneActivity.class);
        startActivity(intent);
    }

    public void openSleepActivity(){
        Intent sleep = new Intent(this, SleepTracking.class);
        startActivity(sleep);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.three_dot_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.logout){
            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
