package com.startapp.sdk.adsbase.adinformation;

import android.content.Context;
import com.startapp.common.parser.d;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AdInformationMetaData implements Serializable {
    private static volatile AdInformationMetaData a = new AdInformationMetaData();
    private static Object b = new Object();
    private static final long serialVersionUID = 1;
    @d(a = true)
    private AdInformationConfig AdInformation = AdInformationConfig.a();
    private String adInformationMetadataUpdateVersion = AdsConstants.c;

    public AdInformationMetaData() {
        this.AdInformation.f();
    }

    public final AdInformationConfig a() {
        return this.AdInformation;
    }

    public static void a(Context context) {
        AdInformationMetaData adInformationMetaData = (AdInformationMetaData) com.startapp.common.b.d.a(context, "StartappAdInfoMetadata");
        AdInformationMetaData adInformationMetaData2 = new AdInformationMetaData();
        if (adInformationMetaData != null) {
            boolean a2 = u.a(adInformationMetaData, adInformationMetaData2);
            if (!(!AdsConstants.c.equals(adInformationMetaData.adInformationMetadataUpdateVersion)) && a2) {
                new e(InfoEventCategory.ERROR).f("metadata_null").a(context);
            }
            adInformationMetaData.AdInformation.g();
            a = adInformationMetaData;
        } else {
            a = adInformationMetaData2;
        }
        a.AdInformation.f();
    }

    public static AdInformationMetaData b() {
        return a;
    }

    public static void a(Context context, AdInformationMetaData adInformationMetaData) {
        synchronized (b) {
            adInformationMetaData.adInformationMetadataUpdateVersion = AdsConstants.c;
            a = adInformationMetaData;
            AdInformationConfig.a(adInformationMetaData.AdInformation);
            a.AdInformation.f();
            com.startapp.common.b.d.a(context, "StartappAdInfoMetadata", adInformationMetaData);
        }
    }

    public final String c() {
        return this.AdInformation.b();
    }

    public final String d() {
        return this.AdInformation.c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdInformationMetaData adInformationMetaData = (AdInformationMetaData) obj;
        return u.b(this.AdInformation, adInformationMetaData.AdInformation) && u.b(this.adInformationMetadataUpdateVersion, adInformationMetaData.adInformationMetadataUpdateVersion);
    }

    public int hashCode() {
        return u.a(this.AdInformation, this.adInformationMetadataUpdateVersion);
    }
}
