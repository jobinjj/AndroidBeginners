package com.techpakka.androidbeginners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParseActivity extends AppCompatActivity {
    private Button send_request,btn_parse;
    private TextView txt_response;
    private String url = "https://shedule.000webhostapp.com/testjson.php";
    private RequestQueue requestQueue;
    private String str_response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parse);
        send_request = findViewById(R.id.send_request);
        btn_parse = findViewById(R.id.parse);
        txt_response = findViewById(R.id.txt_response);
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        final Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache,network);
        requestQueue.start();

        send_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                txt_response.setText(response);
                                str_response = response;
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                requestQueue.add(stringRequest);
            }
        });

        btn_parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject jsonObject = new JSONObject(str_response);
                    String username = jsonObject.getString("username");
                    String phone = jsonObject.getString("phone");
                    String password = jsonObject.getString("password");
                    txt_response.setText("username=" + username + " ," + "phone=" + phone + " ," + "password=" + password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
