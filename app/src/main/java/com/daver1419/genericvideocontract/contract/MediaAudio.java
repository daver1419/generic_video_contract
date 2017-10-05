package com.daver1419.genericvideocontract.contract;


public interface MediaAudio {

    /**
     * Set the volume to media player
     *
     * @param volume between 0 and 1.
     */
    void setVolume(float volume); //

    void mute();
}
