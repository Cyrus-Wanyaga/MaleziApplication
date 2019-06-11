package com.example.maleziapplication.views;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.maleziapplication.MainActivity;
import com.example.maleziapplication.R;
import com.example.maleziapplication.app.AppConfig;
import com.example.maleziapplication.app.AppController;
import com.example.maleziapplication.helper.SQLiteHandler;
import com.example.maleziapplication.helper.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends Activity {
    private static final String TAG = Register.class.getSimpleName();

    //@BindView(R.id.register_username) EditText userName;
    //@BindView(R.id.register_email) EditText etEmail;
    //@BindView(R.id.register_password) EditText etPassword;
    //@BindView(R.id.register_btn) EditText btnReg;
    //@BindView(R.id.register_login_btn) EditText btnLogin;
    private Button btnRegister;
    private Button btnLinkToLogin;
    private EditText userName;
    private EditText etEmail;
    private EditText etPassword;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//      ButterKnife.bind(this);

        userName = (EditText) findViewById(R.id.register_username);
        etEmail = (EditText) findViewById(R.id.register_email);
        etPassword = (EditText) findViewById(R.id.register_password);
        btnRegister = (Button) findViewById(R.id.register_btn);
        btnLinkToLogin = (Button) findViewById(R.id.register_login_btn);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        //session manager
        session = new SessionManager(getApplicationContext());

        //SQLite database handler
        db = new SQLiteHandler(getApplicationContext());

        //Check if user is logged in or not
        if (session.isLoggedIn()) {
            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                    transmitCreds(name, email, password);
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter your details.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLinkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void transmitCreds( final String name, final String email, final String password) {

        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");
        hideDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_REG, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        //if (jObj.getString("msg").equals("Success")){
                            //String uid = jObj.getString("uid");

                            //JSONObject user = jObj.getJSONObject("user");
                            //String name = user.getString("name");
                            //String email = user.getString("email");
                            //String created_at = user.getString("created_at");

                            //Insert rows in users table
                            //db.addUser(name, email, uid, created_at);

                            Toast.makeText(getApplicationContext(), "User successfully registered. Try login now!",
                                    Toast.LENGTH_LONG).show();

                            //Launch Login Activity
                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                            finish();
                    } else {
                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();

                params.put("name", name);
                params.put("email", email);
                params.put("password",password);
                Log.d(TAG ,"imeisSent" +params);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
