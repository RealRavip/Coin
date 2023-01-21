package com.example.btc.Controller;

import com.example.btc.MainActivity;
import com.example.btc.adapter.MutiCoin_Adapter;
import com.example.btc.models.LoadData;

import java.util.ArrayList;

public class MainController{
    private MainActivity mainActivity;
    private LoadData dataModel;

    public MainController(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        dataModel = new LoadData(this);
    }

    public void getData(){
        dataModel.getData(this.mainActivity);
    }

    public void setUi(ArrayList coin){
        this.mainActivity.recyclerView.setAdapter(new MutiCoin_Adapter(coin,this.mainActivity));
    }
}
