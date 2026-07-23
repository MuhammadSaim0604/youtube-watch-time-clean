package com.startapp.sdk.adsbase;

import android.content.Context;
import com.startapp.sdk.adsbase.adrules.AdRules;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataStyle;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AdsCommonMetaData implements Serializable {
    private static transient Object a = new Object();
    private static Integer b = 18;
    private static Integer c = -1;
    private static Set<String> d = new HashSet(Arrays.asList("BOLD"));
    private static Integer e = -16777216;
    private static Integer f = -14803426;
    private static Integer g = -1;
    private static AdsCommonMetaData h = new AdsCommonMetaData();
    private static final long serialVersionUID = 1;
    private Long explicitLoadIntervalMillis;
    private String acMetadataUpdateVersion = AdsConstants.c;
    private Integer probability3D = 0;
    private Integer homeProbability3D = 80;
    private Integer fullpageOfferWallProbability = 100;
    private Integer fullpageOverlayProbability = 0;
    private Integer backgroundGradientTop = -14606047;
    private Integer backgroundGradientBottom = -14606047;
    private Integer maxAds = 10;
    private Integer titleBackgroundColor = -14803426;
    private String titleContent = "Recommended for you";
    private Integer titleTextSize = b;
    private Integer titleTextColor = c;
    @com.startapp.common.parser.d(b = HashSet.class)
    private Set<String> titleTextDecoration = d;
    private Integer titleLineColor = e;
    private Integer itemGradientTop = -14014151;
    private Integer itemGradientBottom = -8750199;
    private Integer itemTitleTextSize = MetaDataStyle.a;
    private Integer itemTitleTextColor = MetaDataStyle.b;
    @com.startapp.common.parser.d(b = HashSet.class)
    private Set<String> itemTitleTextDecoration = MetaDataStyle.c;
    private Integer itemDescriptionTextSize = MetaDataStyle.d;
    private Integer itemDescriptionTextColor = MetaDataStyle.e;
    @com.startapp.common.parser.d(b = HashSet.class)
    private Set<String> itemDescriptionTextDecoration = MetaDataStyle.f;
    @com.startapp.common.parser.d(b = HashMap.class, c = MetaDataStyle.class)
    private HashMap<String, MetaDataStyle> templates = new HashMap<>();
    @com.startapp.common.parser.d(a = true)
    private AdRules adRules = new AdRules();
    private Integer poweredByBackgroundColor = f;
    private Integer poweredByTextColor = g;
    private long returnAdMinBackgroundTime = 300;
    private boolean disableReturnAd = false;
    private boolean disableSplashAd = false;
    private int smartRedirectTimeout = 5;
    private long smartRedirectLoadedTimeout = 1000;
    private boolean enableSmartRedirect = true;
    private boolean autoInterstitialEnabled = true;
    private int defaultActivitiesBetweenAds = 1;
    private int defaultSecondsBetweenAds = 0;
    private boolean disableTwoClicks = false;
    private boolean appPresence = true;
    private boolean disableInAppStore = false;
    @com.startapp.common.parser.d(a = true)
    private VideoConfig video = new VideoConfig();
    private int forceExternalBrowserDaysInterval = 7;
    private boolean enableForceExternalBrowser = false;
    private boolean enforceForeground = false;

    public static AdsCommonMetaData a() {
        return h;
    }

    public static void a(Context context) {
        AdsCommonMetaData adsCommonMetaData = (AdsCommonMetaData) com.startapp.common.b.d.a(context, "StartappAdsMetadata");
        AdsCommonMetaData adsCommonMetaData2 = new AdsCommonMetaData();
        if (adsCommonMetaData != null) {
            boolean a2 = u.a(adsCommonMetaData, adsCommonMetaData2);
            if (!(!AdsConstants.c.equals(adsCommonMetaData.acMetadataUpdateVersion)) && a2) {
                new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("metadata_null").a(context);
            }
            adsCommonMetaData.adRules.b();
            h = adsCommonMetaData;
            return;
        }
        h = adsCommonMetaData2;
    }

    public final int b() {
        return this.fullpageOfferWallProbability.intValue();
    }

    public final int c() {
        return this.fullpageOverlayProbability.intValue();
    }

    public final int d() {
        return this.probability3D.intValue();
    }

    public final int e() {
        return this.backgroundGradientTop.intValue();
    }

    public final MetaDataStyle a(String str) {
        return this.templates.get(str);
    }

    public final int f() {
        return this.backgroundGradientBottom.intValue();
    }

    public final int g() {
        return this.maxAds.intValue();
    }

    public final Long h() {
        return this.explicitLoadIntervalMillis;
    }

    public final Integer i() {
        return this.titleBackgroundColor;
    }

    public final String j() {
        return this.titleContent;
    }

    public final Integer k() {
        return this.titleTextSize;
    }

    public final Integer l() {
        return this.titleTextColor;
    }

    public final Set<String> m() {
        return this.titleTextDecoration;
    }

    public final Integer n() {
        return this.titleLineColor;
    }

    public final int o() {
        return this.itemGradientTop.intValue();
    }

    public final int p() {
        return this.itemGradientBottom.intValue();
    }

    public final Integer q() {
        return this.itemTitleTextSize;
    }

    public final Integer r() {
        return this.itemTitleTextColor;
    }

    public final Set<String> s() {
        return this.itemTitleTextDecoration;
    }

    public final Integer t() {
        return this.itemDescriptionTextSize;
    }

    public final Integer u() {
        return this.itemDescriptionTextColor;
    }

    public final Set<String> v() {
        return this.itemDescriptionTextDecoration;
    }

    public final Integer w() {
        return this.poweredByBackgroundColor;
    }

    public final Integer x() {
        return this.poweredByTextColor;
    }

    public final long y() {
        return TimeUnit.SECONDS.toMillis(this.returnAdMinBackgroundTime);
    }

    public final boolean z() {
        return this.disableReturnAd;
    }

    public final boolean A() {
        return this.disableSplashAd;
    }

    public final long B() {
        return TimeUnit.SECONDS.toMillis(this.smartRedirectTimeout);
    }

    public final long C() {
        return this.smartRedirectLoadedTimeout;
    }

    public final boolean D() {
        return this.enableSmartRedirect;
    }

    public final boolean E() {
        return this.disableTwoClicks;
    }

    public final boolean F() {
        return this.appPresence;
    }

    public final AdRules G() {
        return this.adRules;
    }

    public final boolean H() {
        return this.disableInAppStore;
    }

    public final VideoConfig I() {
        return this.video;
    }

    public final boolean J() {
        return this.autoInterstitialEnabled;
    }

    public final int K() {
        return this.defaultActivitiesBetweenAds;
    }

    public final int L() {
        return this.defaultSecondsBetweenAds;
    }

    public final int M() {
        return this.forceExternalBrowserDaysInterval;
    }

    public final boolean N() {
        return this.enableForceExternalBrowser;
    }

    public final boolean O() {
        return this.enforceForeground;
    }

    public static void a(Context context, AdsCommonMetaData adsCommonMetaData) {
        synchronized (a) {
            adsCommonMetaData.acMetadataUpdateVersion = AdsConstants.c;
            h = adsCommonMetaData;
            com.startapp.common.b.d.a(context, "StartappAdsMetadata", adsCommonMetaData);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdsCommonMetaData adsCommonMetaData = (AdsCommonMetaData) obj;
        return this.returnAdMinBackgroundTime == adsCommonMetaData.returnAdMinBackgroundTime && this.disableReturnAd == adsCommonMetaData.disableReturnAd && this.disableSplashAd == adsCommonMetaData.disableSplashAd && this.smartRedirectTimeout == adsCommonMetaData.smartRedirectTimeout && this.smartRedirectLoadedTimeout == adsCommonMetaData.smartRedirectLoadedTimeout && this.enableSmartRedirect == adsCommonMetaData.enableSmartRedirect && this.autoInterstitialEnabled == adsCommonMetaData.autoInterstitialEnabled && this.defaultActivitiesBetweenAds == adsCommonMetaData.defaultActivitiesBetweenAds && this.defaultSecondsBetweenAds == adsCommonMetaData.defaultSecondsBetweenAds && this.disableTwoClicks == adsCommonMetaData.disableTwoClicks && this.appPresence == adsCommonMetaData.appPresence && this.disableInAppStore == adsCommonMetaData.disableInAppStore && this.forceExternalBrowserDaysInterval == adsCommonMetaData.forceExternalBrowserDaysInterval && this.enableForceExternalBrowser == adsCommonMetaData.enableForceExternalBrowser && this.enforceForeground == adsCommonMetaData.enforceForeground && u.b(this.acMetadataUpdateVersion, adsCommonMetaData.acMetadataUpdateVersion) && u.b(this.probability3D, adsCommonMetaData.probability3D) && u.b(this.homeProbability3D, adsCommonMetaData.homeProbability3D) && u.b(this.fullpageOfferWallProbability, adsCommonMetaData.fullpageOfferWallProbability) && u.b(this.fullpageOverlayProbability, adsCommonMetaData.fullpageOverlayProbability) && u.b(this.backgroundGradientTop, adsCommonMetaData.backgroundGradientTop) && u.b(this.backgroundGradientBottom, adsCommonMetaData.backgroundGradientBottom) && u.b(this.maxAds, adsCommonMetaData.maxAds) && u.b(this.explicitLoadIntervalMillis, adsCommonMetaData.explicitLoadIntervalMillis) && u.b(this.titleBackgroundColor, adsCommonMetaData.titleBackgroundColor) && u.b(this.titleContent, adsCommonMetaData.titleContent) && u.b(this.titleTextSize, adsCommonMetaData.titleTextSize) && u.b(this.titleTextColor, adsCommonMetaData.titleTextColor) && u.b(this.titleTextDecoration, adsCommonMetaData.titleTextDecoration) && u.b(this.titleLineColor, adsCommonMetaData.titleLineColor) && u.b(this.itemGradientTop, adsCommonMetaData.itemGradientTop) && u.b(this.itemGradientBottom, adsCommonMetaData.itemGradientBottom) && u.b(this.itemTitleTextSize, adsCommonMetaData.itemTitleTextSize) && u.b(this.itemTitleTextColor, adsCommonMetaData.itemTitleTextColor) && u.b(this.itemTitleTextDecoration, adsCommonMetaData.itemTitleTextDecoration) && u.b(this.itemDescriptionTextSize, adsCommonMetaData.itemDescriptionTextSize) && u.b(this.itemDescriptionTextColor, adsCommonMetaData.itemDescriptionTextColor) && u.b(this.itemDescriptionTextDecoration, adsCommonMetaData.itemDescriptionTextDecoration) && u.b(this.templates, adsCommonMetaData.templates) && u.b(this.adRules, adsCommonMetaData.adRules) && u.b(this.poweredByBackgroundColor, adsCommonMetaData.poweredByBackgroundColor) && u.b(this.poweredByTextColor, adsCommonMetaData.poweredByTextColor) && u.b(this.video, adsCommonMetaData.video);
    }

    public int hashCode() {
        return u.a(this.acMetadataUpdateVersion, this.probability3D, this.homeProbability3D, this.fullpageOfferWallProbability, this.fullpageOverlayProbability, this.backgroundGradientTop, this.backgroundGradientBottom, this.maxAds, this.explicitLoadIntervalMillis, this.titleBackgroundColor, this.titleContent, this.titleTextSize, this.titleTextColor, this.titleTextDecoration, this.titleLineColor, this.itemGradientTop, this.itemGradientBottom, this.itemTitleTextSize, this.itemTitleTextColor, this.itemTitleTextDecoration, this.itemDescriptionTextSize, this.itemDescriptionTextColor, this.itemDescriptionTextDecoration, this.templates, this.adRules, this.poweredByBackgroundColor, this.poweredByTextColor, Long.valueOf(this.returnAdMinBackgroundTime), Boolean.valueOf(this.disableReturnAd), Boolean.valueOf(this.disableSplashAd), Integer.valueOf(this.smartRedirectTimeout), Long.valueOf(this.smartRedirectLoadedTimeout), Boolean.valueOf(this.enableSmartRedirect), Boolean.valueOf(this.autoInterstitialEnabled), Integer.valueOf(this.defaultActivitiesBetweenAds), Integer.valueOf(this.defaultSecondsBetweenAds), Boolean.valueOf(this.disableTwoClicks), Boolean.valueOf(this.appPresence), Boolean.valueOf(this.disableInAppStore), this.video, Integer.valueOf(this.forceExternalBrowserDaysInterval), Boolean.valueOf(this.enableForceExternalBrowser), Boolean.valueOf(this.enforceForeground));
    }
}
