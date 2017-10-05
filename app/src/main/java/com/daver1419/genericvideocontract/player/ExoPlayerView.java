package com.daver1419.genericvideocontract.player;


import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.daver1419.genericvideocontract.contract.MediaActions;
import com.daver1419.genericvideocontract.contract.MediaStatus;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class ExoPlayerView extends FrameLayout implements MediaStatus, MediaActions{

    SimpleExoPlayer simpleExoPlayer;
    private boolean canAutoPlay;

    public ExoPlayerView(@NonNull Context context) {
        super(context);
        init();
    }


    public ExoPlayerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ExoPlayerView(@NonNull Context context, @Nullable AttributeSet attrs,
                         @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ExoPlayerView(@NonNull Context context, @Nullable AttributeSet attrs,
                         @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {

    }

    @Override
    public boolean isPlaying() {
        return (simpleExoPlayer != null) && simpleExoPlayer.getPlayWhenReady();
    }

    @Override
    public boolean isPreparing() {
        return (simpleExoPlayer != null) && simpleExoPlayer.isLoading();
    }

    @Override
    public boolean isPrepared() {
        return (simpleExoPlayer != null) && simpleExoPlayer.getPlayWhenReady();
    }

    @Override
    public void setAutoPlay(boolean autoPlay) {
        this.canAutoPlay = autoPlay;
    }

    @Override
    public boolean canAutoPlay() {
        return canAutoPlay;
    }

    @Override
    public void prepare(final String dataSource) {

        Handler mainHandler = new Handler();
        DefaultLoadControl loadControl = new DefaultLoadControl();
        DefaultTrackSelector trackSelector = new DefaultTrackSelector();

        RenderersFactory renders = new DefaultRenderersFactory(getContext());
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(renders, trackSelector, loadControl);

        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getContext(),
                Util.getUserAgent(getContext(), "ExoPlayerUserAgent"));
        Uri videoUri = Uri.parse(dataSource);
        MediaSource mediaSource = new HlsMediaSource(videoUri, dataSourceFactory, mainHandler, null);
        simpleExoPlayer.prepare(mediaSource, true, true);
    }

    @Override
    public void play() {
        simpleExoPlayer.setPlayWhenReady(true);
    }

    @Override
    public void pause() {
        simpleExoPlayer.setPlayWhenReady(false);
    }

    @Override
    public void stop() {
        simpleExoPlayer.stop();
    }

    @Override
    public void togglePlay() {
        if(isPlaying()){
            pause();
        }else{
            play();
        }
    }

    @Override
    public void reset() {

    }
}
