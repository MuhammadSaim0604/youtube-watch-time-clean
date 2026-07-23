package com.startapp.sdk.adsbase;

import android.content.Context;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public interface f {
    void a(boolean z);

    boolean a(String str);

    Long b();

    Long c();

    boolean e();

    boolean e_();

    Ad.AdState getState();

    boolean isBelowMinCPM();

    boolean isReady();

    boolean load(AdPreferences adPreferences, AdEventListener adEventListener);

    void setActivityExtra(ActivityExtra activityExtra);

    void setContext(Context context);
}
