package com.example.caohaoran0102.model;

import com.example.caohaoran0102.okhttp.OkHttp3;

public class ShowModel implements IShowModel{
    @Override
    public void getData(String url, final GetModelData getModelData) {
        OkHttp3.okHttpGet(url, new OkHttp3.GetBackGet() {
            @Override
            public void getTrue(String succ) {
                getModelData.succ(succ);
            }
        });
    }
}
