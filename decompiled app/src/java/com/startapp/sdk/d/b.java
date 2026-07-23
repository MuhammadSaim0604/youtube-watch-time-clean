package com.startapp.sdk.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.u;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class b {
    protected boolean a;
    private boolean b;
    private Runnable c;
    private Runnable d;
    private Runnable e;
    private Context f;
    private TrackingParams g;

    static {
        b.class.getSimpleName();
    }

    public b(Context context, Runnable runnable, TrackingParams trackingParams, boolean z) {
        this(context, runnable, trackingParams);
        this.a = z;
    }

    private b(Context context, Runnable runnable, TrackingParams trackingParams) {
        this.b = false;
        this.a = true;
        this.c = null;
        this.d = null;
        this.e = null;
        this.c = runnable;
        this.f = context;
        this.g = trackingParams;
    }

    public b(Context context, Runnable runnable, Runnable runnable2, Runnable runnable3, TrackingParams trackingParams, boolean z) {
        this(context, runnable, trackingParams, z);
        this.d = runnable2;
        this.e = runnable3;
    }

    public b(Context context, Runnable runnable, Runnable runnable2, TrackingParams trackingParams) {
        this(context, runnable, trackingParams);
        this.d = runnable2;
    }

    @JavascriptInterface
    public void closeAd() {
        if (!this.b) {
            this.b = true;
            this.c.run();
        }
    }

    @JavascriptInterface
    public void openApp(String str, String str2, String str3) {
        if (str != null && !TextUtils.isEmpty(str)) {
            com.startapp.sdk.adsbase.a.b(this.f, str, this.g);
        }
        Intent launchIntentForPackage = this.f.getPackageManager().getLaunchIntentForPackage(str2);
        if (str3 != null) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    launchIntentForPackage.putExtra(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException e) {
            }
        }
        try {
            this.f.startActivity(launchIntentForPackage);
        } catch (Throwable th) {
            new e(th).a(this.f);
        }
        if (this.d != null) {
            this.d.run();
        }
    }

    @JavascriptInterface
    public void externalLinks(String str) {
        if (this.a && u.a(256L)) {
            com.startapp.sdk.adsbase.a.a(this.f, str, (String) null);
        } else {
            com.startapp.sdk.adsbase.a.c(this.f, str);
        }
    }

    @JavascriptInterface
    public void enableScroll(String str) {
        if (this.e != null) {
            this.e.run();
        }
    }
}
