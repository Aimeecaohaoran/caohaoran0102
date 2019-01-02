package com.example.caohaoran0102.presenter;

import android.util.Log;

import com.example.caohaoran0102.MainActivity;
import com.example.caohaoran0102.model.IShowModel;
import com.example.caohaoran0102.model.ShowModel;

public class ShowPresenter implements IShowPresenter{
    //初始化Model和Activity
    private final ShowModel showModel;
    MainActivity mainActivity;

    public ShowPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        showModel=new ShowModel();
    }

    @Override
    public void GetDData(String url) {
        showModel.getData(url, new IShowModel.GetModelData() {
            @Override
            public void succ(String data) {
                mainActivity.getPresenterData(data);
            }
        });

    }
}
