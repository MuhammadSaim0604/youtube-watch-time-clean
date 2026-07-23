package com.startapp.sdk.ads.nativead;

import android.content.Context;
import com.startapp.sdk.ads.nativead.NativeAdDetails;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adinformation.AdInformationMetaData;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.adrules.AdaptMetaData;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class StartAppNativeAd extends Ad implements NativeAdDetails.a {
    private static final long serialVersionUID = 1;
    private a adEventDelegate;
    boolean isLoading;
    private List<NativeAdDetails> listNativeAds;
    private NativeAd nativeAd;
    private NativeAdPreferences preferences;
    private int totalObjectsLoaded;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum CampaignAction {
        LAUNCH_APP,
        OPEN_MARKET
    }

    public StartAppNativeAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_NATIVE);
        this.totalObjectsLoaded = 0;
        this.listNativeAds = new ArrayList();
        this.isLoading = false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n===== StartAppNativeAd =====\n");
        for (int i = 0; i < getNumberOfAds(); i++) {
            stringBuffer.append(this.listNativeAds.get(i));
        }
        stringBuffer.append("===== End StartAppNativeAd =====");
        return stringBuffer.toString();
    }

    final void a() {
        this.totalObjectsLoaded = 0;
        if (this.listNativeAds == null) {
            this.listNativeAds = new ArrayList();
        }
        this.listNativeAds.clear();
        if (this.nativeAd != null && this.nativeAd.g() != null) {
            for (int i = 0; i < this.nativeAd.g().size(); i++) {
                this.listNativeAds.add(new NativeAdDetails(this.nativeAd.g().get(i), this.preferences, i, this));
            }
        }
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdDetails.a
    public void onNativeAdDetailsLoaded(int i) {
        com.startapp.sdk.adsbase.adlisteners.b a2;
        this.totalObjectsLoaded++;
        if (this.nativeAd.g() != null && this.totalObjectsLoaded == this.nativeAd.g().size()) {
            this.isLoading = false;
            setErrorMessage(null);
            if (this.adEventDelegate == null || (a2 = this.adEventDelegate.a()) == null) {
                return;
            }
            a2.a(this);
        }
    }

    public int getNumberOfAds() {
        if (this.listNativeAds != null) {
            return this.listNativeAds.size();
        }
        return 0;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public boolean isBelowMinCPM() {
        return this.nativeAd.isBelowMinCPM();
    }

    public boolean loadAd() {
        return loadAd(new NativeAdPreferences(), null);
    }

    public boolean loadAd(AdEventListener adEventListener) {
        return loadAd(new NativeAdPreferences(), adEventListener);
    }

    public boolean loadAd(NativeAdPreferences nativeAdPreferences) {
        return loadAd(nativeAdPreferences, null);
    }

    public boolean loadAd(NativeAdPreferences nativeAdPreferences, AdEventListener adEventListener) {
        this.adEventDelegate = new a(com.startapp.sdk.adsbase.adlisteners.b.a(this.a, adEventListener));
        this.preferences = nativeAdPreferences;
        if (this.isLoading) {
            setErrorMessage("Ad is currently being loaded");
            return false;
        }
        this.isLoading = true;
        this.nativeAd = new NativeAd(this.a, this.preferences);
        return this.nativeAd.load(nativeAdPreferences, this.adEventDelegate, true);
    }

    @Override // com.startapp.sdk.adsbase.Ad
    protected final void a(AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
    }

    public ArrayList<NativeAdDetails> getNativeAds() {
        return getNativeAds(null);
    }

    public ArrayList<NativeAdDetails> getNativeAds(String str) {
        ArrayList<NativeAdDetails> arrayList = new ArrayList<>();
        AdRulesResult a2 = AdaptMetaData.a().b().a(AdPreferences.Placement.INAPP_NATIVE, str);
        if (!a2.a()) {
            com.startapp.sdk.adsbase.a.a(this.a, com.startapp.sdk.adsbase.a.a(g()), str, a2.c());
        } else if (this.listNativeAds != null) {
            for (NativeAdDetails nativeAdDetails : this.listNativeAds) {
                nativeAdDetails.a(str);
                arrayList.add(nativeAdDetails);
            }
            com.startapp.sdk.adsbase.adrules.b.a().a(new com.startapp.sdk.adsbase.adrules.a(AdPreferences.Placement.INAPP_NATIVE, str));
        }
        return arrayList;
    }

    private List<AdDetails> g() {
        ArrayList arrayList = new ArrayList();
        if (this.listNativeAds != null) {
            for (NativeAdDetails nativeAdDetails : this.listNativeAds) {
                arrayList.add(nativeAdDetails.a());
            }
        }
        return arrayList;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public String getAdId() {
        NativeAdDetails nativeAdDetails;
        if (this.listNativeAds == null || this.listNativeAds.size() <= 0 || (nativeAdDetails = this.listNativeAds.get(0)) == null || nativeAdDetails.a() == null) {
            return null;
        }
        return nativeAdDetails.a().a();
    }

    public static String getPrivacyURL() {
        if (AdInformationMetaData.b().c() == null) {
            return "";
        }
        String c = AdInformationMetaData.b().c();
        if (c.contains("http://") || c.contains("https://")) {
            return AdInformationMetaData.b().c();
        }
        return "https://" + AdInformationMetaData.b().c();
    }

    public static String getPrivacyImageUrl() {
        return AdInformationMetaData.b().d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public class a extends com.startapp.sdk.adsbase.adlisteners.b {
        private com.startapp.sdk.adsbase.adlisteners.b a;

        public a(com.startapp.sdk.adsbase.adlisteners.b bVar) {
            this.a = bVar;
        }

        @Override // com.startapp.sdk.adsbase.adlisteners.b
        public final void a(Ad ad) {
            StartAppNativeAd.this.a();
        }

        @Override // com.startapp.sdk.adsbase.adlisteners.b
        public final void b(Ad ad) {
            StartAppNativeAd.this.setErrorMessage(ad.getErrorMessage());
            if (this.a != null) {
                this.a.b(StartAppNativeAd.this);
                this.a = null;
            }
            StartAppNativeAd.this.isLoading = false;
            StartAppNativeAd.this.a();
        }

        public final com.startapp.sdk.adsbase.adlisteners.b a() {
            return this.a;
        }
    }
}
