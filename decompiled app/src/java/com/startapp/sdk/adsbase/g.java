package com.startapp.sdk.adsbase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.startapp.sdk.adsbase.StartAppInitProvider;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class g implements StartAppInitProvider.a {
    private static String a = g.class.getSimpleName();
    private static String b = "com.startapp.sdk.APPLICATION_ID";
    private static String c = "com.startapp.sdk.RETURN_ADS_ENABLED";
    private String d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context) {
        this.e = true;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo.metaData != null) {
                    if (applicationInfo.metaData.containsKey(b)) {
                        int i = applicationInfo.metaData.getInt(b);
                        this.d = i != 0 ? String.valueOf(i) : applicationInfo.metaData.getString(b);
                        Log.i(a, "appId is " + this.d);
                        if (applicationInfo.metaData.containsKey(c)) {
                            this.e = applicationInfo.metaData.getBoolean(c);
                            Log.i(a, "returnAds enabled: " + this.e);
                        }
                        return;
                    }
                    Log.i(a, "appId hasn't been provided in the Manifest");
                }
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
            }
        }
    }

    @Override // com.startapp.sdk.adsbase.StartAppInitProvider.a
    public final String a() {
        return this.d;
    }

    @Override // com.startapp.sdk.adsbase.StartAppInitProvider.a
    public final boolean b() {
        return this.e;
    }
}
