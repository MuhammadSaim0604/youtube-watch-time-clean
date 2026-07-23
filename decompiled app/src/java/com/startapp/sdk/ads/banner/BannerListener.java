package com.startapp.sdk.ads.banner;

import android.view.View;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public interface BannerListener {
    void onClick(View view);

    void onFailedToReceiveAd(View view);

    void onImpression(View view);

    void onReceiveAd(View view);
}
