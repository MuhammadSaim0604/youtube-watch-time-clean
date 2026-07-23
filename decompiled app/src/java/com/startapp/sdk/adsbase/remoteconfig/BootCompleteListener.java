package com.startapp.sdk.adsbase.remoteconfig;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.startapp.sdk.adsbase.k;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class BootCompleteListener extends BroadcastReceiver {
    static {
        BootCompleteListener.class.getSimpleName();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime() + 60000;
            com.startapp.sdk.adsbase.j.e.a(context);
            com.startapp.sdk.adsbase.j.e.a(context, Long.valueOf(elapsedRealtime));
            com.startapp.sdk.adsbase.j.e.a(context, elapsedRealtime);
            k.a(context.getApplicationContext());
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
    }
}
