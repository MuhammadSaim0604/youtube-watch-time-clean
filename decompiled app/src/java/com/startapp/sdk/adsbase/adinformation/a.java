package com.startapp.sdk.adsbase.adinformation;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.startapp.sdk.b.c;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    private Context a;
    private boolean b = false;
    private Runnable c;
    private Runnable d;
    private Runnable e;

    public a(Context context, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = context;
        this.d = runnable;
        this.c = runnable2;
        this.e = runnable3;
    }

    @JavascriptInterface
    public final void decline() {
        if (!this.b) {
            this.b = true;
            this.c.run();
        }
    }

    @JavascriptInterface
    public final void accept() {
        if (!this.b) {
            this.b = true;
            this.d.run();
        }
    }

    @JavascriptInterface
    public final void fullPrivacyPolicy() {
        if (!this.b) {
            this.b = true;
            this.e.run();
        }
    }

    @JavascriptInterface
    public final String getAppId() {
        if (this.a != null) {
            try {
                String b = c.a(this.a).k().b();
                if (b == null) {
                    return null;
                }
                return String.valueOf(121212121 ^ Long.parseLong(b));
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
