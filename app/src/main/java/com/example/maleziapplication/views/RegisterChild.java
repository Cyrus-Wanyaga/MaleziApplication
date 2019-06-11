package com.example.maleziapplication.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.maleziapplication.R;

public class RegisterChild extends Activity {

    private Button btnRegisterChild;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_child);

        Spinner spinner = (Spinner) findViewById(R.id.caregiver);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.caregiver, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        btnRegisterChild = (Button) findViewById(R.id.register_child);

        btnRegisterChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do something
            }
        });
    }

}

