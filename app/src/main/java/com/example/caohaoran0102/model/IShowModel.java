package com.example.caohaoran0102.model;

public interface IShowModel {
    void getData(String url,GetModelData getModelData);
    interface GetModelData{
        void succ(String data);
    }
}
