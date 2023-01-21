package com.example.btc.models;

import android.content.Context;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CoinAPI{
    Context context;
    String url = "https://api.coinranking.com/v2/coins";
    String Key;
    public CoinAPI (Context context,String key){
        this.context = context;
        this.Key = key;
    }
    public void getCoins(Response.Listener<JSONObject> callback, Response.ErrorListener errorCallback) {

        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, callback, errorCallback) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String>  params = new HashMap<>();
                params.put("x-access-token", Key);
                return params;
            }
        };
        queue.add(jsonObjectRequest);

    }
}
