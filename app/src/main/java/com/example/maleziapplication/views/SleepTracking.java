package com.example.maleziapplication.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.maleziapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SleepTracking extends AppCompatActivity {

    private EditText pickStartTime, pickEndTime;
    private String amPm;
    int currentHour, currentMinute;
    Calendar calendar;
    String sample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_tracking);

        pickStartTime = findViewById(R.id.et_sleep_tracking1);
        pickStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(SleepTracking.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        pickStartTime.setText(String.format("%02d:%02d", hourOfDay, minute) +amPm);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });
        pickEndTime = findViewById(R.id.et_sleep_tracking2);
        pickEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog2 = new TimePickerDialog(SleepTracking.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        pickEndTime.setText(String.format("%02d:%02d", hourOfDay, minute) +amPm);
                    }
                },0,0,false);
                timePickerDialog2.show();
            }
        });

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm a");
//        Date date1 = simpleDateFormat.parse(pickStartTime);
    }
}
