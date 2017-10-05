package com.daver1419.genericvideocontract.contract;


import android.net.Uri;

public interface MediaPlaceHolding {

    void setPlaceHolder(String url);

    void setPlaceHolder(Uri uri);
}
