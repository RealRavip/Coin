package com.example.btc.models;

import android.content.Context;
import android.util.Log;

import com.example.btc.Controller.MainController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoadData {
    CoinAPI coinAPI;
    String Key = "coinrankingf2d916767feb50f9741bb3aac68242136e2d0d9d73476dee";
    ArrayList<CoinData> coin_list = new ArrayList<>();
    private MainController controller;

    public LoadData(MainController mainController) {
        this.controller = mainController;
    }

    public void getData(Context context){
        coinAPI = new CoinAPI(context, Key);
        coinAPI.getCoins(response -> {
            JSONObject data;
            JSONArray coins = null;
            try {
                data = response.getJSONObject("data");
                coins = data.getJSONArray("coins");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //set data to arraylist and set Adapter
            parseArray(coins);
        }, error -> Log.e("Coin", error.toString()));
    }

    private void parseArray(JSONArray coins) {
        for (int i = 0; i < coins.length(); i++) {
            try {
                JSONObject coin = coins.getJSONObject(i);
                String name = coin.getString("name");
                String symbol = coin.getString("symbol");
                String icon = coin.getString("iconUrl");
                String url = coin.getString("coinrankingUrl");
                if( (i%5 == 4)){
                    CoinData data5 = new CoinData(name,symbol
                            ,icon.replace(".svg",".png")
                            ,url,1);
                    coin_list.add(data5);
                }
                else{
                    CoinData data1 = new CoinData(name,symbol
                            ,icon.replace(".svg",".png")
                            ,url,0);
                    coin_list.add(data1);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        controller.setUi(coin_list);
    }

}
