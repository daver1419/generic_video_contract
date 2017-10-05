package com.daver1419.genericvideocontract.contract;


public interface MediaStatus {

    boolean isPlaying();

    boolean isPreparing();

    boolean isPrepared();

    void setAutoPlay(boolean autoPlay);
}
