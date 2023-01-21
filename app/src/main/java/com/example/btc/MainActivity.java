package com.example.btc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;

import com.example.btc.Controller.MainController;
import com.example.btc.adapter.MutiCoin_Adapter;
import com.example.btc.models.CoinAPI;
import com.example.btc.models.CoinData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{
    public RecyclerView recyclerView;
    MainController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assign variable
        recyclerView = findViewById(R.id.ReView);
        controller = new MainController(this);
        controller.getData();
        initRecyclerView();


        //create ToolBar
        Toolbar toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
    }

    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
    }

}