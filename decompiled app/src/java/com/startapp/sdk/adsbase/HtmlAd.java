package com.startapp.sdk.adsbase;

import android.content.Context;
import android.text.TextUtils;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.adsbase.adinformation.AdInformationPositions;
import com.startapp.sdk.adsbase.apppresence.AppPresenceDetails;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class HtmlAd extends Ad {
    private static String b = null;
    private static final long serialVersionUID = 1;
    private List<AppPresenceDetails> apps;
    private String[] closingUrl;
    private Boolean consentApc;
    private Long consentTimeStamp;
    private Integer consentType;
    private Long delayImpressionInSeconds;
    private int height;
    private String htmlUuid;
    public boolean[] inAppBrowserEnabled;
    private boolean isMraidAd;
    private int orientation;
    private String[] packageNames;
    private int rewardDuration;
    private boolean rewardedHideTimer;
    private Boolean[] sendRedirectHops;
    public boolean[] smartRedirect;
    private String[] trackingClickUrls;
    public String[] trackingUrls;
    private int width;

    static {
        HtmlAd.class.getSimpleName();
        b = null;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public Integer getConsentType() {
        return this.consentType;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public void setConsentType(Integer num) {
        this.consentType = num;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public Long getConsentTimestamp() {
        return this.consentTimeStamp;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public void setConsentTimestamp(Long l) {
        this.consentTimeStamp = l;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public Boolean getConsentApc() {
        return this.consentApc;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public void setConsentApc(Boolean bool) {
        this.consentApc = bool;
    }

    public final String j() {
        return com.startapp.sdk.adsbase.cache.a.a().a(this.htmlUuid);
    }

    public final String k() {
        return this.htmlUuid;
    }

    public final void b(int i) {
        this.width = i;
    }

    public final int l() {
        return this.width;
    }

    public final void c(int i) {
        this.height = i;
    }

    public final String[] m() {
        return this.closingUrl;
    }

    public final int n() {
        return this.height;
    }

    public final int o() {
        return this.rewardDuration;
    }

    public final boolean p() {
        return this.rewardedHideTimer;
    }

    public HtmlAd(Context context, AdPreferences.Placement placement) {
        super(context, placement);
        this.packageNames = new String[]{""};
        this.htmlUuid = "";
        this.orientation = 0;
        this.trackingClickUrls = new String[]{""};
        this.closingUrl = new String[]{""};
        this.sendRedirectHops = null;
        this.rewardDuration = 0;
        this.rewardedHideTimer = false;
        this.smartRedirect = new boolean[]{false};
        this.trackingUrls = new String[]{""};
        this.inAppBrowserEnabled = new boolean[]{true};
        this.isMraidAd = false;
        if (b != null) {
            return;
        }
        b = u.f(getContext());
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public String getAdId() {
        return u.a(j(), "@adId@", "@adId@");
    }

    private String d(String str) {
        try {
            return com.iab.omid.library.startapp.b.a(com.startapp.sdk.omsdk.b.a(), str);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(this.a);
            return str;
        }
    }

    public void b(String str) {
        String str2 = str;
        if (com.startapp.sdk.adsbase.mraid.c.a.b(str2)) {
            str2 = com.startapp.sdk.adsbase.mraid.c.a.a(str2);
            this.isMraidAd = true;
        }
        if (MetaData.E().Q()) {
            str2 = d(str2);
        }
        if (u.a(512L)) {
            this.htmlUuid = com.startapp.sdk.adsbase.cache.a.a().a(str2, UUID.randomUUID().toString());
        }
        String a = u.a(str2, "@smartRedirect@", "@smartRedirect@");
        if (a != null) {
            String[] split = a.split(",");
            this.smartRedirect = new boolean[split.length];
            for (int i = 0; i < split.length; i++) {
                if (split[i].compareTo("true") == 0) {
                    this.smartRedirect[i] = true;
                } else {
                    this.smartRedirect[i] = false;
                }
            }
        }
        String a2 = u.a(str2, "@trackingClickUrl@", "@trackingClickUrl@");
        if (a2 != null) {
            this.trackingClickUrls = a2.split(",");
        }
        String a3 = u.a(str2, "@closeUrl@", "@closeUrl@");
        if (a3 != null) {
            this.closingUrl = a3.split(",");
        }
        String a4 = u.a(str2, "@tracking@", "@tracking@");
        if (a4 != null) {
            this.trackingUrls = a4.split(",");
        }
        String a5 = u.a(str2, "@packageName@", "@packageName@");
        if (a5 != null) {
            this.packageNames = a5.split(",");
        }
        String a6 = u.a(str2, "@startappBrowserEnabled@", "@startappBrowserEnabled@");
        if (a6 != null) {
            String[] split2 = a6.split(",");
            this.inAppBrowserEnabled = new boolean[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                if (split2[i2].compareTo("false") == 0) {
                    this.inAppBrowserEnabled[i2] = false;
                } else {
                    this.inAppBrowserEnabled[i2] = true;
                }
            }
        }
        String a7 = u.a(str2, "@orientation@", "@orientation@");
        if (a7 != null && u.a(8L)) {
            a(SplashConfig.Orientation.getByName(a7));
        }
        String a8 = u.a(str2, "@adInfoEnable@", "@adInfoEnable@");
        if (a8 != null) {
            getAdInfoOverride().a(Boolean.parseBoolean(a8));
        }
        String a9 = u.a(str2, "@adInfoPosition@", "@adInfoPosition@");
        if (a9 != null) {
            getAdInfoOverride().a(AdInformationPositions.Position.getByName(a9));
        }
        String a10 = u.a(str2, "@ttl@", "@ttl@");
        if (a10 != null) {
            c(a10);
        }
        String a11 = u.a(str2, "@belowMinCPM@", "@belowMinCPM@");
        if (a11 != null) {
            if (Arrays.asList(a11.split(",")).contains("false")) {
                this.belowMinCPM = false;
            } else {
                this.belowMinCPM = true;
            }
        }
        String a12 = u.a(str2, "@delayImpressionInSeconds@", "@delayImpressionInSeconds@");
        if (a12 != null && a12 != null && !a12.equals("")) {
            try {
                this.delayImpressionInSeconds = Long.valueOf(Long.parseLong(a12));
            } catch (NumberFormatException e) {
            }
        }
        String a13 = u.a(str2, "@rewardDuration@", "@rewardDuration@");
        if (a13 != null) {
            try {
                this.rewardDuration = Integer.parseInt(a13);
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(this.a);
            }
        }
        String a14 = u.a(str2, "@rewardedHideTimer@", "@rewardedHideTimer@");
        if (a14 != null) {
            try {
                this.rewardedHideTimer = Boolean.parseBoolean(a14);
            } catch (Throwable th2) {
                new com.startapp.sdk.adsbase.infoevents.e(th2).a(this.a);
            }
        }
        String a15 = u.a(str2, "@sendRedirectHops@", "@sendRedirectHops@");
        if (a15 != null && a15 != null && !a15.equals("")) {
            String[] split3 = a15.split(",");
            this.sendRedirectHops = new Boolean[split3.length];
            for (int i3 = 0; i3 < split3.length; i3++) {
                if (split3[i3].compareTo("true") == 0) {
                    this.sendRedirectHops[i3] = Boolean.TRUE;
                } else if (split3[i3].compareTo("false") == 0) {
                    this.sendRedirectHops[i3] = Boolean.FALSE;
                } else {
                    this.sendRedirectHops[i3] = null;
                }
            }
        }
        String a16 = u.a(str2, "@ct@", "@ct@");
        String a17 = u.a(str2, "@tsc@", "@tsc@");
        String a18 = u.a(str2, "@apc@", "@apc@");
        try {
            if (!TextUtils.isEmpty(a16)) {
                this.consentType = Integer.valueOf(Integer.parseInt(a16));
            }
            if (!TextUtils.isEmpty(a17)) {
                this.consentTimeStamp = Long.valueOf(Long.parseLong(a17));
            }
            if (!TextUtils.isEmpty(a18)) {
                this.consentApc = Boolean.valueOf(Boolean.parseBoolean(a18));
            }
        } catch (Throwable th3) {
            new com.startapp.sdk.adsbase.infoevents.e(th3).a(this.a);
        }
        if (this.smartRedirect.length < this.trackingUrls.length) {
            boolean[] zArr = new boolean[this.trackingUrls.length];
            int i4 = 0;
            while (i4 < this.smartRedirect.length) {
                zArr[i4] = this.smartRedirect[i4];
                i4++;
            }
            while (i4 < this.trackingUrls.length) {
                zArr[i4] = false;
                i4++;
            }
            this.smartRedirect = zArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(SplashConfig.Orientation orientation) {
        this.orientation = 0;
        boolean a = u.a(8L);
        if (orientation != null) {
            if (a && orientation.equals(SplashConfig.Orientation.PORTRAIT)) {
                this.orientation = 1;
            } else if (a && orientation.equals(SplashConfig.Orientation.LANDSCAPE)) {
                this.orientation = 2;
            }
        }
    }

    public final boolean d(int i) {
        if (i >= 0 && i < this.smartRedirect.length) {
            return this.smartRedirect[i];
        }
        return false;
    }

    public final boolean e(int i) {
        if (this.inAppBrowserEnabled == null || i < 0 || i >= this.inAppBrowserEnabled.length) {
            return true;
        }
        return this.inAppBrowserEnabled[i];
    }

    public final String[] q() {
        return this.trackingClickUrls;
    }

    public final int r() {
        return this.orientation;
    }

    public final String[] s() {
        return this.packageNames;
    }

    public final void a(List<AppPresenceDetails> list) {
        this.apps = list;
    }

    public final void c(String str) {
        String[] split;
        Long l = null;
        for (String str2 : str.split(",")) {
            if (!str2.equals("")) {
                try {
                    long parseLong = Long.parseLong(str2);
                    if (parseLong > 0 && (l == null || parseLong < l.longValue())) {
                        l = Long.valueOf(parseLong);
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        if (l != null) {
            this.adCacheTtl = Long.valueOf(TimeUnit.SECONDS.toMillis(l.longValue()));
        }
    }

    public final Long t() {
        return this.delayImpressionInSeconds;
    }

    public final Boolean[] u() {
        return this.sendRedirectHops;
    }

    public final Boolean f(int i) {
        if (this.sendRedirectHops == null || i < 0 || i >= this.sendRedirectHops.length) {
            return null;
        }
        return this.sendRedirectHops[i];
    }

    public final boolean v() {
        return this.isMraidAd;
    }
}
