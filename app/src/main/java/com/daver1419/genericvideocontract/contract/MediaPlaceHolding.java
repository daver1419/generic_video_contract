package com.daver1419.genericvideocontract.contract;


import android.graphics.drawable.Drawable;
import android.net.Uri;

public interface MediaPlaceHolding {

    void setPlaceHolder(String url);

    void setPlaceHolder(Uri uri);

    void setPlaceHolder(Drawable drawable);
}
