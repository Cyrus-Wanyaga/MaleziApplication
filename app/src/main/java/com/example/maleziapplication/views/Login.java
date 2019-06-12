package com.example.maleziapplication.views;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class Login extends Activity {
    private static final String TAG = Login.class.getSimpleName();

    private Button btnLogin;
    private Button btnLinkToRegister;
    private EditText tvEmail;
    private EditText tvPassword;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvEmail = (EditText) findViewById(R.id.et_email);
        tvPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.login_btn);
        btnLinkToRegister = findViewById(R.id.login_register_btn);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        //SQLite db handler
        db = new SQLiteHandler(getApplicationContext());

        //Session manager
        session = new SessionManager(getApplicationContext());

        if (session.isLoggedIn()) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = tvEmail.getText().toString().trim();
                String password = tvPassword.getText().toString().trim();

                if(!email.isEmpty() && !password.isEmpty()){
                    transmitDetails(email,password);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        Register.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void transmitDetails (final String email, final String password){
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                //for logging when debugging
                Log.d(TAG, "C " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    //Json error
                    if (!error) {
                        //User successfully logged in
                        //Create login session
                        //if (jObj.getString("msg").equals("Welcome")) {
                            //String id = jObj.getString("id");
//                            JSONObject user = jObj.getJSONObject("user");
//                            String name = user.getString("name");
//                            String email = user.getString("email");
//                            String created_at = user.getString("created_at");

//                          INSERT ROWS IN USERS TABLE
                            //db.addUser(name, email, created_at);


                            //OPEN MAIN ACTIVITY
                            //session.setLogin(true);

                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                            finish();
//                        }
                    } else {
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "JSON error: " +
                            e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

           @Override
           protected Map<String, String> getParams() {
               // Posting parameters to login url
               Map<String, String> params = new HashMap<String, String>();

               params.put("email", email);
               params.put("password",password);
               Log.d(TAG ,"imeisSent" +params);

               return params;
           }
        };

        //Add request to request to queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog(){
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
