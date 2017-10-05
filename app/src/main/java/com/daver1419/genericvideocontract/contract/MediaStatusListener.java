package com.daver1419.genericvideocontract.contract;


public interface MediaStatusListener {

    void onPlaying();

    void onPreparing();

    void onPrepared();

    void onFinish();
}
