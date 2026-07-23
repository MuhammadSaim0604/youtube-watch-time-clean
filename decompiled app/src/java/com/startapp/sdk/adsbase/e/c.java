package com.startapp.sdk.adsbase.e;

import android.os.Build;
import android.os.SystemClock;
import com.startapp.common.SDKException;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class c {
    private final a a;
    private final long b = a();

    public c(a aVar) {
        this.a = aVar;
    }

    public final void a(String str, String str2, SDKException sDKException) {
        this.a.a(str, str2, sDKException, a() - this.b);
    }

    private static long a() {
        return Build.VERSION.SDK_INT < 17 ? SystemClock.elapsedRealtime() * 1000000 : SystemClock.elapsedRealtimeNanos();
    }
}
