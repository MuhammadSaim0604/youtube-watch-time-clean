package com.startapp.sdk.adsbase.j;

import android.content.Context;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import java.util.UUID;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class p {
    private static p a = new p();
    private String b = "";
    private long c = 0;
    private MetaDataRequest.RequestReason d = MetaDataRequest.RequestReason.LAUNCH;

    public final String a() {
        return this.b;
    }

    public final long b() {
        return this.c;
    }

    public final MetaDataRequest.RequestReason c() {
        return this.d;
    }

    public final synchronized void a(Context context, MetaDataRequest.RequestReason requestReason) {
        this.b = UUID.randomUUID().toString();
        this.c = System.currentTimeMillis();
        this.d = requestReason;
        new StringBuilder("Starting new session: reason=").append(requestReason).append(" sessionId=").append(this.b);
        if (!u.a()) {
            com.startapp.sdk.adsbase.adrules.b.a().b();
        }
        MetaData.E().a(context, new AdPreferences(), requestReason, false, null, true);
    }

    public static p d() {
        return a;
    }
}
