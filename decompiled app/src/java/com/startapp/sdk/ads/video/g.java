package com.startapp.sdk.ads.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.ads.video.c;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import java.net.URL;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class g {
    protected a a;
    private Context b;
    private URL c;
    private String d;
    private c.a e;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface a {
        void a(String str);
    }

    public g(Context context, URL url, String str, a aVar, c.a aVar2) {
        this.b = context;
        this.c = url;
        this.d = str;
        this.a = aVar;
        this.e = aVar2;
    }

    public final void a() {
        String str;
        try {
            str = AdsCommonMetaData.a().I().i() ? c.b.a.a(this.b, this.c, this.d, this.e) : VideoUtil.a(this.b, this.c, this.d);
        } catch (Exception e) {
            str = null;
        }
        final String str2 = str;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.ads.video.g.1
            @Override // java.lang.Runnable
            public final void run() {
                if (g.this.a != null) {
                    g.this.a.a(str2);
                }
            }
        });
    }
}
