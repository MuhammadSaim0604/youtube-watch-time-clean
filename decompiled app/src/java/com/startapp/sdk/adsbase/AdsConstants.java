package com.startapp.sdk.adsbase;

import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class AdsConstants {
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String[] f;
    public static final String[] g;
    private static String h = "get";
    private static String i = h + "ads";
    private static String j = h + "htmlad";
    private static String k = "trackdownload";
    private static String l = h + "adsmetadata";
    public static final String a = "https://imp.startappservice.com/tracking/adImpression";
    public static final Boolean b = Boolean.FALSE;
    private static Boolean m = Boolean.FALSE;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum AdApiType {
        HTML,
        JSON
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum ServiceApiType {
        METADATA,
        DOWNLOAD
    }

    static {
        Boolean bool = Boolean.FALSE;
        c = u.b();
        d = u.c();
        e = u.d();
        f = new String[]{"back_", "back_dark", "browser_icon_dark", "forward_", "forward_dark", "x_dark"};
        g = new String[]{"empty_star", "filled_star", "half_star"};
    }

    public static String a(ServiceApiType serviceApiType) {
        String q;
        String str = null;
        String str2 = null;
        switch (serviceApiType) {
            case METADATA:
                str = l;
                q = MetaData.E().metaDataHostSecured;
                break;
            case DOWNLOAD:
                str = k;
                MetaData E = MetaData.E();
                if (E.trackDownloadHost != null) {
                    q = E.trackDownloadHost;
                    break;
                } else {
                    q = E.q();
                    break;
                }
            default:
                return str2 + str;
        }
        str2 = q;
        return str2 + str;
    }

    public static String a(AdApiType adApiType, AdPreferences.Placement placement) {
        String str = null;
        String str2 = null;
        switch (adApiType) {
            case HTML:
                str = j;
                str2 = MetaData.E().a(placement);
                break;
            case JSON:
                str = i;
                str2 = MetaData.E().a(placement);
                break;
        }
        return str2 + str;
    }

    public static Boolean a() {
        return m;
    }
}
