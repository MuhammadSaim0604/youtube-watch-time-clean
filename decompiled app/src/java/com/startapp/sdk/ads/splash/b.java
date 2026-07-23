package com.startapp.sdk.ads.splash;

import android.content.Context;
import android.webkit.JavascriptInterface;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b {
    private boolean a = false;
    private Runnable b;
    private Context c;

    public b(Context context, Runnable runnable) {
        this.b = null;
        this.b = runnable;
        this.c = context;
    }

    @JavascriptInterface
    public final void closeSplash() {
        if (!this.a) {
            this.a = true;
            this.b.run();
        }
    }
}
