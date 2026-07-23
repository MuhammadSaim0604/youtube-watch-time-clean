package com.startapp.sdk.ads.splash;

import android.content.Context;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class SplashMetaData implements Serializable {
    private static volatile SplashMetaData a = new SplashMetaData();
    private static Object b = new Object();
    private static final long serialVersionUID = 1;
    @com.startapp.common.parser.d(a = true)
    private SplashConfig SplashConfig = new SplashConfig();
    private String splashMetadataUpdateVersion = AdsConstants.c;

    public final SplashConfig a() {
        return this.SplashConfig;
    }

    public static SplashMetaData b() {
        return a;
    }

    public static void a(Context context, SplashMetaData splashMetaData) {
        synchronized (b) {
            splashMetaData.splashMetadataUpdateVersion = AdsConstants.c;
            a = splashMetaData;
            com.startapp.common.b.d.a(context, "StartappSplashMetadata", splashMetaData);
        }
    }

    public static void a(Context context) {
        SplashMetaData splashMetaData = (SplashMetaData) com.startapp.common.b.d.a(context, "StartappSplashMetadata");
        SplashMetaData splashMetaData2 = new SplashMetaData();
        if (splashMetaData != null) {
            boolean a2 = u.a(splashMetaData, splashMetaData2);
            if (!(!AdsConstants.c.equals(splashMetaData.splashMetadataUpdateVersion)) && a2) {
                new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("metadata_null").a(context);
            }
            a = splashMetaData;
            return;
        }
        a = splashMetaData2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SplashMetaData splashMetaData = (SplashMetaData) obj;
        return u.b(this.SplashConfig, splashMetaData.SplashConfig) && u.b(this.splashMetadataUpdateVersion, splashMetaData.splashMetadataUpdateVersion);
    }

    public int hashCode() {
        return u.a(this.SplashConfig, this.splashMetadataUpdateVersion);
    }
}
