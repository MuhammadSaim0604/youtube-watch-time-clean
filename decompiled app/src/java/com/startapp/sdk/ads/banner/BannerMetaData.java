package com.startapp.sdk.ads.banner;

import android.content.Context;
import com.startapp.common.parser.d;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class BannerMetaData implements Serializable {
    private static Object a = new Object();
    private static volatile BannerMetaData b = new BannerMetaData();
    private static final long serialVersionUID = 1;
    @d(a = true)
    private BannerOptions BannerOptions = new BannerOptions();
    private String bannerMetadataUpdateVersion = AdsConstants.c;

    public static BannerMetaData a() {
        return b;
    }

    public final BannerOptions b() {
        return this.BannerOptions;
    }

    public final BannerOptions c() {
        return new BannerOptions(this.BannerOptions);
    }

    public static void a(Context context, BannerMetaData bannerMetaData) {
        synchronized (a) {
            bannerMetaData.bannerMetadataUpdateVersion = AdsConstants.c;
            b = bannerMetaData;
            com.startapp.common.b.d.a(context, "StartappBannerMetadata", bannerMetaData);
        }
    }

    public static void a(Context context) {
        BannerMetaData bannerMetaData = (BannerMetaData) com.startapp.common.b.d.a(context, "StartappBannerMetadata");
        BannerMetaData bannerMetaData2 = new BannerMetaData();
        if (bannerMetaData != null) {
            boolean a2 = u.a(bannerMetaData, bannerMetaData2);
            if (!(!AdsConstants.c.equals(bannerMetaData.bannerMetadataUpdateVersion)) && a2) {
                new e(InfoEventCategory.ERROR).f("metadata_null").a(context);
            }
            b = bannerMetaData;
            return;
        }
        b = bannerMetaData2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BannerMetaData bannerMetaData = (BannerMetaData) obj;
        return u.b(this.BannerOptions, bannerMetaData.BannerOptions) && u.b(this.bannerMetadataUpdateVersion, bannerMetaData.bannerMetadataUpdateVersion);
    }

    public int hashCode() {
        return u.a(this.BannerOptions, this.bannerMetadataUpdateVersion);
    }
}
