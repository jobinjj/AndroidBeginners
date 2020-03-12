package com.allianzetechnologies.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    String str_email,str_password;
    Button btn_login;
    String url = "https://shedule.000webhostapp.com/Login%20Register/login.php?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_email = email.getText().toString();
                str_password = password.getText().toString();
                if (str_email.equals("") || !str_email.contains("@")){
                    email.setError("Email not valid");
                    return;
                }else if (str_password.equals("")){
                    password.setError("Password not valid");
                    return;
                }
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url + "email=" + str_email + "&password=" + str_password,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                Volley.newRequestQueue(LoginActivity.this).add(stringRequest);

            }
        });

    }
}
