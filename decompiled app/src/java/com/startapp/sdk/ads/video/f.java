package com.startapp.sdk.ads.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class f extends com.startapp.sdk.d.b {
    private Runnable b;
    private Runnable c;
    private Runnable d;

    public f(Context context, Runnable runnable, Runnable runnable2, Runnable runnable3, Runnable runnable4, Runnable runnable5, TrackingParams trackingParams, boolean z) {
        super(context, runnable, runnable2, trackingParams);
        this.b = null;
        this.c = null;
        this.d = null;
        this.b = runnable3;
        this.c = runnable4;
        this.d = runnable5;
        this.a = z;
    }

    @JavascriptInterface
    public final void replayVideo() {
        if (this.b != null) {
            new Handler(Looper.getMainLooper()).post(this.b);
        }
    }

    @JavascriptInterface
    public final void skipVideo() {
        if (this.c != null) {
            new Handler(Looper.getMainLooper()).post(this.c);
        }
    }

    @JavascriptInterface
    public final void toggleSound() {
        if (this.d != null) {
            new Handler(Looper.getMainLooper()).post(this.d);
        }
    }
}
