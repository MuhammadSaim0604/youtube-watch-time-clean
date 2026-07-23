package com.startapp.sdk.adsbase.remoteconfig;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import com.startapp.common.Constants;
import com.startapp.common.a;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.consent.ConsentConfig;
import com.startapp.sdk.adsbase.infoevents.AnalyticsConfig;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.j;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.insight.NetworkTestsMetaData;
import com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class MetaData implements Serializable {
    private static final Object a;
    private static Set<String> b = null;
    private static String c = null;
    private static String d = null;
    private static int[] e = null;
    private static Set<String> f = null;
    private static volatile MetaData g = null;
    private static com.startapp.sdk.adsbase.remoteconfig.a j = null;
    private static final long serialVersionUID = 1;
    private String adPlatformBannerHostSecured;
    private String adPlatformNativeHostSecured;
    private String adPlatformOverlayHostSecured;
    private String adPlatformReturnHostSecured;
    private String adPlatformSplashHostSecured;
    @com.startapp.common.parser.d(a = true)
    private ConsentConfig consentDetails;
    @com.startapp.common.parser.d(a = true)
    private NetworkDiagnosticConfig netDiag;
    @com.startapp.common.parser.d(a = true)
    private RscMetadata rsc;
    @com.startapp.common.parser.d(a = true)
    private TriggeredLinksMetadata triggeredLinks;
    @com.startapp.common.parser.d(a = true)
    private SimpleTokenConfig SimpleToken = new SimpleTokenConfig();
    public String metaDataHostSecured = c;
    public String adPlatformHostSecured = d;
    public String trackDownloadHost = d;
    private int sessionMaxBackgroundTime = 1800;
    private String profileId = null;
    @com.startapp.common.parser.d(b = HashSet.class)
    private Set<String> installersList = b;
    @com.startapp.common.parser.d(b = HashSet.class)
    private Set<String> preInstalledPackages = f;
    private boolean simpleToken2 = true;
    private boolean alwaysSendToken = true;
    private boolean isToken1Mandatory = true;
    private boolean compressionEnabled = false;
    private boolean periodicMetaDataEnabled = false;
    private int periodicMetaDataIntervalInMinutes = 360;
    private boolean periodicInfoEventEnabled = false;
    private int[] periodicEventIntMin = e;
    private int periodicThresholdMin = 5;
    private boolean inAppBrowser = true;
    private boolean SupportIABViewability = true;
    private long IABDisplayImpressionDelayInSeconds = serialVersionUID;
    private long IABVideoImpressionDelayInSeconds = 2;
    private long userAgentDelayInSeconds = 5;
    private boolean userAgentEnabled = true;
    @com.startapp.common.parser.d(a = true)
    private SensorsConfig sensorsConfig = new SensorsConfig();
    @com.startapp.common.parser.d(a = true)
    private BluetoothConfig btConfig = new BluetoothConfig();
    private String assetsBaseUrlSecured = "";
    @com.startapp.common.parser.d(b = HashSet.class)
    private Set<Integer> invalidForRetry = com.startapp.sdk.adsbase.d.c.a;
    private int notVisibleBannerReloadInterval = 3600;
    @com.startapp.common.parser.d(a = true)
    public AnalyticsConfig analytics = new AnalyticsConfig();
    @com.startapp.common.parser.d(a = true)
    private LocationConfig location = new LocationConfig();
    private transient boolean h = false;
    private transient boolean i = false;
    private transient List<b> k = new ArrayList();
    private String metadataUpdateVersion = AdsConstants.c;
    private boolean dns = false;
    private int stopAutoLoadAmount = 3;
    private int stopAutoLoadPreCacheAmount = 3;
    private boolean trueNetEnabled = false;
    private boolean webViewSecured = true;
    private boolean omSdkEnabled = false;
    private boolean chromeCustomeTabsInternal = true;
    private boolean chromeCustomeTabsExternal = true;
    private boolean disableSendAdvertisingId = false;
    @com.startapp.common.parser.d(a = true)
    private NetworkTestsMetaData networkTests = new NetworkTestsMetaData();

    static {
        MetaData.class.getSimpleName();
        a = new Object();
        b = new HashSet(Arrays.asList(Constants.a));
        c = "https://adsmetadata.startappservice.com/1.5/";
        d = "https://req.startappservice.com/1.5/";
        e = new int[]{60, 60, 240};
        f = new HashSet(Arrays.asList("com.facebook.katana", "com.yandex.browser"));
        g = new MetaData();
    }

    public final NetworkDiagnosticConfig a() {
        return this.netDiag;
    }

    public final RscMetadata b() {
        return this.rsc;
    }

    public final NetworkTestsMetaData c() {
        return this.networkTests;
    }

    public final TriggeredLinksMetadata d() {
        return this.triggeredLinks;
    }

    public final SimpleTokenConfig e() {
        return this.SimpleToken;
    }

    public final ConsentConfig f() {
        return this.consentDetails;
    }

    public static void a(Context context) {
        MetaData metaData = (MetaData) com.startapp.common.b.d.a(context, "StartappMetadata");
        MetaData metaData2 = new MetaData();
        if (metaData != null) {
            boolean a2 = u.a(metaData, metaData2);
            if (!(!AdsConstants.c.equals(metaData.metadataUpdateVersion)) && a2) {
                new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("metadata_null").a(context);
            }
            metaData.h = false;
            metaData.i = false;
            metaData.k = new ArrayList();
            g = metaData;
        } else {
            g = metaData2;
        }
        g.R();
    }

    public static void a(Context context, MetaData metaData, MetaDataRequest.RequestReason requestReason, boolean z) {
        boolean z2 = z;
        ArrayList<b> arrayList = null;
        synchronized (a) {
            if (g.k != null) {
                arrayList = new ArrayList(g.k);
                g.k.clear();
            }
            metaData.k = g.k;
            metaData.R();
            metaData.metadataUpdateVersion = AdsConstants.c;
            com.startapp.common.b.d.b(context, "StartappMetadata", metaData);
            metaData.h = false;
            metaData.i = true;
            if (!u.b(g, metaData)) {
                z2 = true;
            }
            g = metaData;
            if (u.h(context)) {
                j.b(context, "totalSessions", Integer.valueOf(j.a(context, "totalSessions", (Integer) 0).intValue() + 1));
            }
            j = null;
        }
        if (arrayList != null) {
            for (b bVar : arrayList) {
                bVar.a(requestReason, z2);
            }
        }
    }

    public static void g() {
        ArrayList<b> arrayList = null;
        synchronized (a) {
            if (g.k != null) {
                arrayList = new ArrayList(g.k);
                g.k.clear();
            }
            g.h = false;
        }
        if (arrayList != null) {
            for (b bVar : arrayList) {
                bVar.a();
            }
        }
    }

    public static boolean b(Context context) {
        return context.getFileStreamPath("StartappMetadata").exists();
    }

    public final void a(Context context, AdPreferences adPreferences, MetaDataRequest.RequestReason requestReason, boolean z, b bVar, boolean z2) {
        if (!z && bVar != null) {
            bVar.a(requestReason, false);
        }
        synchronized (a) {
            if (!g.i || z2) {
                if (!g.h || z2) {
                    this.h = true;
                    this.i = false;
                    if (j != null) {
                        j.b();
                    }
                    com.startapp.sdk.adsbase.remoteconfig.a aVar = new com.startapp.sdk.adsbase.remoteconfig.a(context, adPreferences, requestReason);
                    j = aVar;
                    aVar.a();
                }
                if (z && bVar != null) {
                    g.a(bVar);
                }
            } else if (z && bVar != null) {
                bVar.a(requestReason, false);
            }
        }
    }

    public final void a(b bVar) {
        synchronized (a) {
            this.k.add(bVar);
        }
    }

    public static Object h() {
        return a;
    }

    public final boolean i() {
        return this.i;
    }

    public final void j() {
        this.i = true;
    }

    public final String k() {
        return this.assetsBaseUrlSecured != null ? this.assetsBaseUrlSecured : "";
    }

    public final boolean l() {
        return this.periodicMetaDataEnabled;
    }

    public final int m() {
        return this.periodicMetaDataIntervalInMinutes;
    }

    public final boolean n() {
        return this.periodicInfoEventEnabled;
    }

    public final int c(Context context) {
        int i;
        if (this.periodicEventIntMin == null || this.periodicEventIntMin.length < 3) {
            this.periodicEventIntMin = e;
        }
        if (com.startapp.common.b.b.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            int i2 = this.periodicEventIntMin[0];
            i = i2;
            if (i2 <= 0) {
                i = e[0];
            }
        } else if (com.startapp.common.b.b.a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            int i3 = this.periodicEventIntMin[1];
            i = i3;
            if (i3 <= 0) {
                i = e[1];
            }
        } else {
            i = this.periodicEventIntMin[2];
        }
        return i;
    }

    public final int o() {
        return this.periodicThresholdMin;
    }

    public final Set<Integer> p() {
        return this.invalidForRetry;
    }

    public final String q() {
        return this.adPlatformHostSecured != null ? this.adPlatformHostSecured : d;
    }

    public final String a(AdPreferences.Placement placement) {
        switch (placement) {
            case INAPP_BANNER:
                return this.adPlatformBannerHostSecured != null ? this.adPlatformBannerHostSecured : q();
            case INAPP_OVERLAY:
                return this.adPlatformOverlayHostSecured != null ? this.adPlatformOverlayHostSecured : q();
            case INAPP_NATIVE:
                return this.adPlatformNativeHostSecured != null ? this.adPlatformNativeHostSecured : q();
            case INAPP_RETURN:
                return this.adPlatformReturnHostSecured != null ? this.adPlatformReturnHostSecured : q();
            case INAPP_SPLASH:
                return this.adPlatformSplashHostSecured != null ? this.adPlatformSplashHostSecured : q();
            default:
                return q();
        }
    }

    public final long s() {
        return TimeUnit.SECONDS.toMillis(this.sessionMaxBackgroundTime);
    }

    public final Set<String> t() {
        return this.installersList;
    }

    public final Set<String> u() {
        Set<String> set = this.preInstalledPackages;
        Set<String> set2 = set;
        if (set == null) {
            set2 = f;
        }
        return Collections.unmodifiableSet(set2);
    }

    public final boolean v() {
        return this.alwaysSendToken;
    }

    public final boolean w() {
        return this.isToken1Mandatory;
    }

    public final boolean x() {
        return this.compressionEnabled;
    }

    public final boolean y() {
        return u.a(256L) && this.inAppBrowser;
    }

    public final String z() {
        return this.profileId;
    }

    public final SensorsConfig A() {
        return this.sensorsConfig;
    }

    public final BluetoothConfig B() {
        return this.btConfig;
    }

    public final LocationConfig C() {
        return this.location;
    }

    public final int D() {
        return this.notVisibleBannerReloadInterval;
    }

    public static MetaData E() {
        return g;
    }

    public final long F() {
        return this.IABDisplayImpressionDelayInSeconds;
    }

    public final long G() {
        return this.IABVideoImpressionDelayInSeconds;
    }

    public final long H() {
        return this.userAgentDelayInSeconds;
    }

    public final boolean I() {
        return this.userAgentEnabled;
    }

    public final boolean J() {
        return this.SupportIABViewability;
    }

    private void R() {
        this.adPlatformHostSecured = a(this.adPlatformHostSecured, d);
        this.metaDataHostSecured = a(this.metaDataHostSecured, c);
        this.adPlatformBannerHostSecured = a(this.adPlatformBannerHostSecured, (String) null);
        this.adPlatformSplashHostSecured = a(this.adPlatformSplashHostSecured, (String) null);
        this.adPlatformReturnHostSecured = a(this.adPlatformReturnHostSecured, (String) null);
        this.adPlatformOverlayHostSecured = a(this.adPlatformOverlayHostSecured, (String) null);
        this.adPlatformNativeHostSecured = a(this.adPlatformNativeHostSecured, (String) null);
    }

    public final boolean K() {
        return !this.dns;
    }

    public final int L() {
        return this.stopAutoLoadAmount;
    }

    public final int M() {
        return this.stopAutoLoadPreCacheAmount;
    }

    public final boolean N() {
        return this.chromeCustomeTabsInternal;
    }

    public final boolean O() {
        return this.chromeCustomeTabsExternal;
    }

    public final boolean P() {
        return this.disableSendAdvertisingId;
    }

    private static String a(String str, String str2) {
        return str != null ? str.replace("%AdPlatformProtocol%", "1.5") : str2;
    }

    public static void a(Context context, String str) {
        if (str != null && !str.equals("")) {
            if (!com.startapp.sdk.adsbase.j.a.a(context, "close_button", ".png") && !u.a()) {
                new com.startapp.common.a(str + "close_button.png", new a(context, "close_button"), 0).a();
            }
            if (u.a(256L)) {
                String[] strArr = AdsConstants.f;
                for (int i = 0; i < 6; i++) {
                    String str2 = strArr[i];
                    if (!com.startapp.sdk.adsbase.j.a.a(context, str2, ".png")) {
                        new com.startapp.common.a(str + str2 + ".png", new a(context, str2), 0).a();
                    }
                }
            }
            if (u.a(64L)) {
                String[] strArr2 = AdsConstants.g;
                for (int i2 = 0; i2 < 3; i2++) {
                    String str3 = strArr2[i2];
                    if (!com.startapp.sdk.adsbase.j.a.a(context, str3, ".png")) {
                        new com.startapp.common.a(str + str3 + ".png", new a(context, str3), 0).a();
                    }
                }
                if (!com.startapp.sdk.adsbase.j.a.a(context, "logo", ".png")) {
                    new com.startapp.common.a(str + "logo.png", new a(context, "logo"), 0).a();
                }
            } else if (u.a(32L)) {
                String[] strArr3 = AdsConstants.g;
                for (int i3 = 0; i3 < 3; i3++) {
                    String str4 = strArr3[i3];
                    if (!com.startapp.sdk.adsbase.j.a.a(context, str4, ".png")) {
                        new com.startapp.common.a(str + str4 + ".png", new a(context, str4), 0).a();
                    }
                }
            }
        }
    }

    public final boolean Q() {
        return this.omSdkEnabled;
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
    public static class a implements a.InterfaceC0015a {
        private Context a;
        private String b;

        public a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // com.startapp.common.a.InterfaceC0015a
        public final void a(Bitmap bitmap, int i) {
            if (bitmap != null) {
                com.startapp.sdk.adsbase.j.a.a(this.a, bitmap, this.b, ".png");
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MetaData metaData = (MetaData) obj;
        return this.sessionMaxBackgroundTime == metaData.sessionMaxBackgroundTime && this.simpleToken2 == metaData.simpleToken2 && this.alwaysSendToken == metaData.alwaysSendToken && this.isToken1Mandatory == metaData.isToken1Mandatory && this.compressionEnabled == metaData.compressionEnabled && this.periodicMetaDataEnabled == metaData.periodicMetaDataEnabled && this.periodicMetaDataIntervalInMinutes == metaData.periodicMetaDataIntervalInMinutes && this.periodicInfoEventEnabled == metaData.periodicInfoEventEnabled && this.periodicThresholdMin == metaData.periodicThresholdMin && this.inAppBrowser == metaData.inAppBrowser && this.SupportIABViewability == metaData.SupportIABViewability && this.IABDisplayImpressionDelayInSeconds == metaData.IABDisplayImpressionDelayInSeconds && this.IABVideoImpressionDelayInSeconds == metaData.IABVideoImpressionDelayInSeconds && this.userAgentDelayInSeconds == metaData.userAgentDelayInSeconds && this.userAgentEnabled == metaData.userAgentEnabled && this.notVisibleBannerReloadInterval == metaData.notVisibleBannerReloadInterval && this.dns == metaData.dns && this.stopAutoLoadAmount == metaData.stopAutoLoadAmount && this.stopAutoLoadPreCacheAmount == metaData.stopAutoLoadPreCacheAmount && this.trueNetEnabled == metaData.trueNetEnabled && this.webViewSecured == metaData.webViewSecured && this.omSdkEnabled == metaData.omSdkEnabled && this.chromeCustomeTabsInternal == metaData.chromeCustomeTabsInternal && this.chromeCustomeTabsExternal == metaData.chromeCustomeTabsExternal && this.disableSendAdvertisingId == metaData.disableSendAdvertisingId && u.b(this.SimpleToken, metaData.SimpleToken) && u.b(this.consentDetails, metaData.consentDetails) && u.b(this.metaDataHostSecured, metaData.metaDataHostSecured) && u.b(this.adPlatformHostSecured, metaData.adPlatformHostSecured) && u.b(this.trackDownloadHost, metaData.trackDownloadHost) && u.b(this.adPlatformBannerHostSecured, metaData.adPlatformBannerHostSecured) && u.b(this.adPlatformSplashHostSecured, metaData.adPlatformSplashHostSecured) && u.b(this.adPlatformReturnHostSecured, metaData.adPlatformReturnHostSecured) && u.b(this.adPlatformOverlayHostSecured, metaData.adPlatformOverlayHostSecured) && u.b(this.adPlatformNativeHostSecured, metaData.adPlatformNativeHostSecured) && u.b(this.profileId, metaData.profileId) && u.b(this.installersList, metaData.installersList) && u.b(this.preInstalledPackages, metaData.preInstalledPackages) && Arrays.equals(this.periodicEventIntMin, metaData.periodicEventIntMin) && u.b(this.sensorsConfig, metaData.sensorsConfig) && u.b(this.btConfig, metaData.btConfig) && u.b(this.assetsBaseUrlSecured, metaData.assetsBaseUrlSecured) && u.b(this.invalidForRetry, metaData.invalidForRetry) && u.b(this.analytics, metaData.analytics) && u.b(this.location, metaData.location) && u.b(this.metadataUpdateVersion, metaData.metadataUpdateVersion) && u.b(this.networkTests, metaData.networkTests) && u.b(this.triggeredLinks, metaData.triggeredLinks) && u.b(this.rsc, metaData.rsc) && u.b(this.netDiag, metaData.netDiag);
    }

    public int hashCode() {
        return u.a(this.SimpleToken, this.consentDetails, this.metaDataHostSecured, this.adPlatformHostSecured, this.trackDownloadHost, this.adPlatformBannerHostSecured, this.adPlatformSplashHostSecured, this.adPlatformReturnHostSecured, this.adPlatformOverlayHostSecured, this.adPlatformNativeHostSecured, Integer.valueOf(this.sessionMaxBackgroundTime), this.profileId, this.installersList, this.preInstalledPackages, Boolean.valueOf(this.simpleToken2), Boolean.valueOf(this.alwaysSendToken), Boolean.valueOf(this.isToken1Mandatory), Boolean.valueOf(this.compressionEnabled), Boolean.valueOf(this.periodicMetaDataEnabled), Integer.valueOf(this.periodicMetaDataIntervalInMinutes), Boolean.valueOf(this.periodicInfoEventEnabled), this.periodicEventIntMin, Integer.valueOf(this.periodicThresholdMin), Boolean.valueOf(this.inAppBrowser), Boolean.valueOf(this.SupportIABViewability), Long.valueOf(this.IABDisplayImpressionDelayInSeconds), Long.valueOf(this.IABVideoImpressionDelayInSeconds), Long.valueOf(this.userAgentDelayInSeconds), Boolean.valueOf(this.userAgentEnabled), this.sensorsConfig, this.btConfig, this.assetsBaseUrlSecured, this.invalidForRetry, Integer.valueOf(this.notVisibleBannerReloadInterval), this.analytics, this.location, this.metadataUpdateVersion, Boolean.valueOf(this.dns), Integer.valueOf(this.stopAutoLoadAmount), Integer.valueOf(this.stopAutoLoadPreCacheAmount), Boolean.valueOf(this.trueNetEnabled), Boolean.valueOf(this.webViewSecured), Boolean.valueOf(this.omSdkEnabled), Boolean.valueOf(this.chromeCustomeTabsInternal), Boolean.valueOf(this.chromeCustomeTabsExternal), Boolean.valueOf(this.disableSendAdvertisingId), this.networkTests, this.triggeredLinks, this.rsc, this.netDiag);
    }

    public final String r() {
        String str;
        int indexOf;
        String q = g.q();
        int i = Build.VERSION.SDK_INT;
        boolean z = this.webViewSecured;
        String str2 = q;
        if (i > 26 || z) {
            str = "https";
        } else {
            str = "http";
        }
        if (!str2.startsWith(str + "://") && (indexOf = str2.indexOf(58)) != -1) {
            str2 = str + str2.substring(indexOf);
        }
        return str2;
    }
}
