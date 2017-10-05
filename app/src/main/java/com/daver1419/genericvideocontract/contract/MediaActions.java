package com.daver1419.genericvideocontract.contract;


public interface MediaActions {

    void prepare(String dataSource);

    void play();

    void pause();

    void stop();

    void togglePlay();

    void reset();
}
