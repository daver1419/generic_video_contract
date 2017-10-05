package com.daver1419.genericvideocontract.contract;


public interface MediaTime {

    int getCurrentTime();

    int getTotalTime();

    void seekTo(int timeInMillis);
}
