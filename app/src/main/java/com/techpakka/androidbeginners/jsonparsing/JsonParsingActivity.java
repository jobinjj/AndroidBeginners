package com.techpakka.androidbeginners.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
import com.google.gson.JsonObject;
import com.techpakka.androidbeginners.R;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParsingActivity extends AppCompatActivity {
    private Button sendRequest, parseResponse;
    private TextView textResponse;
    private String url = "https://shedule.000webhostapp.com/testjson.php";
    private RequestQueue requestQueue;
    private String responseString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parsing);
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        final Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        sendRequest = findViewById(R.id.send_request);
        parseResponse = findViewById(R.id.parse);
        textResponse = findViewById(R.id.response);

        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url
                        , new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            responseString = response;
                            textResponse.setText(responseString);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                requestQueue.add(stringRequest);
            }
        });

        parseResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject jsonObject = new JSONObject(responseString);
                    String username = jsonObject.getString("username");
                    String phone = jsonObject.getString("phone");
                    String password = jsonObject.getString("password");
                    textResponse.setText("username = "  + username + ", " + "phone = " + phone + ", " + "password = " + password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
