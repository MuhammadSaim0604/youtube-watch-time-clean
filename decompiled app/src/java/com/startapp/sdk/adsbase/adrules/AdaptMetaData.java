package com.startapp.sdk.adsbase.adrules;

import com.startapp.common.parser.d;
import com.startapp.sdk.adsbase.AdsConstants;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AdaptMetaData implements Serializable {
    private static transient AdaptMetaData a = new AdaptMetaData();
    @d(a = true)
    private AdRules adRules = new AdRules();
    private String adaptMetaDataUpdateVersion = AdsConstants.c;

    private AdaptMetaData() {
    }

    public static AdaptMetaData a() {
        return a;
    }

    public final AdRules b() {
        return this.adRules;
    }
}
