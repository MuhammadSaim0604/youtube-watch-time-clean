package com.startapp.sdk.adsbase.cache;

import android.content.Context;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class CacheMetaData implements Serializable {
    private static volatile CacheMetaData a = new CacheMetaData();
    private static final long serialVersionUID = 1;
    @com.startapp.common.parser.d(a = true)
    private ACMConfig ACM = new ACMConfig();
    private float sendCacheSizeProb = 20.0f;
    private String cacheMetaDataUpdateVersion = AdsConstants.c;

    public static CacheMetaData a() {
        return a;
    }

    public final ACMConfig b() {
        return this.ACM;
    }

    public static void a(Context context, CacheMetaData cacheMetaData) {
        cacheMetaData.cacheMetaDataUpdateVersion = AdsConstants.c;
        a = cacheMetaData;
        com.startapp.common.b.d.a(context, "StartappCacheMetadata", cacheMetaData);
    }

    public static void a(Context context) {
        CacheMetaData cacheMetaData = (CacheMetaData) com.startapp.common.b.d.a(context, "StartappCacheMetadata");
        CacheMetaData cacheMetaData2 = new CacheMetaData();
        if (cacheMetaData != null) {
            boolean a2 = u.a(cacheMetaData, cacheMetaData2);
            if (!(!AdsConstants.c.equals(cacheMetaData.cacheMetaDataUpdateVersion)) && a2) {
                new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("metadata_null").a(context);
            }
            a = cacheMetaData;
            return;
        }
        a = cacheMetaData2;
    }

    public final float c() {
        return this.sendCacheSizeProb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CacheMetaData cacheMetaData = (CacheMetaData) obj;
        return Float.compare(cacheMetaData.sendCacheSizeProb, this.sendCacheSizeProb) == 0 && u.b(this.ACM, cacheMetaData.ACM) && u.b(this.cacheMetaDataUpdateVersion, cacheMetaData.cacheMetaDataUpdateVersion);
    }

    public int hashCode() {
        return u.a(this.ACM, Float.valueOf(this.sendCacheSizeProb), this.cacheMetaDataUpdateVersion);
    }
}
