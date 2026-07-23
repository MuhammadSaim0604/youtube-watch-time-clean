package com.startapp.sdk.adsbase.remoteconfig;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.common.ThreadManager;
import com.startapp.common.b.e;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.splash.SplashMetaData;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.adinformation.AdInformationMetaData;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class a {
    private final Context b;
    private final AdPreferences c;
    private MetaDataRequest.RequestReason d;
    private MetaData e = null;
    private BannerMetaData f = null;
    private SplashMetaData g = null;
    private CacheMetaData h = null;
    private AdInformationMetaData i = null;
    private AdsCommonMetaData j = null;
    private boolean k = false;
    protected boolean a = false;

    static {
        a.class.getSimpleName();
    }

    public a(Context context, AdPreferences adPreferences, MetaDataRequest.RequestReason requestReason) {
        this.b = context;
        this.c = adPreferences;
        this.d = requestReason;
    }

    public final void a() {
        ThreadManager.a(ThreadManager.Priority.HIGH, new Runnable() { // from class: com.startapp.sdk.adsbase.remoteconfig.a.1
            @Override // java.lang.Runnable
            public final void run() {
                final Boolean c = a.this.c();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.adsbase.remoteconfig.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a(c);
                    }
                });
            }
        });
    }

    public final void b() {
        this.k = true;
    }

    protected Boolean c() {
        MetaDataRequest metaDataRequest = new MetaDataRequest(this.b, this.d);
        try {
            metaDataRequest.a(this.b, this.c);
            e.a a = com.startapp.sdk.b.c.a(this.b).m().a(AdsConstants.a(AdsConstants.ServiceApiType.METADATA)).a(metaDataRequest).a();
            if (a == null) {
                return Boolean.FALSE;
            }
            String a2 = a.a();
            if (a2 == null) {
                return Boolean.FALSE;
            }
            this.e = (MetaData) u.a(a2, (Class<Object>) MetaData.class);
            if (!u.a()) {
                this.j = (AdsCommonMetaData) u.a(a2, (Class<Object>) AdsCommonMetaData.class);
                if (u.a(16L) || u.a(32L)) {
                    this.f = (BannerMetaData) u.a(a2, (Class<Object>) BannerMetaData.class);
                }
                if (u.a(8L)) {
                    this.g = (SplashMetaData) u.a(a2, (Class<Object>) SplashMetaData.class);
                }
                if (u.a(512L)) {
                    this.h = (CacheMetaData) u.a(a2, (Class<Object>) CacheMetaData.class);
                }
                if (u.e()) {
                    this.i = (AdInformationMetaData) u.a(a2, (Class<Object>) AdInformationMetaData.class);
                }
            }
            synchronized (MetaData.h()) {
                if (!this.k && this.e != null && this.b != null) {
                    if (!u.a()) {
                        if (!u.b(AdsCommonMetaData.a(), this.j)) {
                            this.a = true;
                            AdsCommonMetaData.a(this.b, this.j);
                        }
                        if ((u.a(16L) || u.a(32L)) && !u.b(BannerMetaData.a(), this.f)) {
                            this.a = true;
                            BannerMetaData.a(this.b, this.f);
                        }
                        if (u.a(8L)) {
                            this.g.a().setDefaults(this.b);
                            if (!u.b(SplashMetaData.b(), this.g)) {
                                this.a = true;
                                SplashMetaData.a(this.b, this.g);
                            }
                        }
                        if (u.a(512L) && !u.b(CacheMetaData.a(), this.h)) {
                            this.a = true;
                            CacheMetaData.a(this.b, this.h);
                        }
                        if (u.e() && !u.b(AdInformationMetaData.b(), this.i)) {
                            this.a = true;
                            AdInformationMetaData.a(this.b, this.i);
                        }
                    }
                    try {
                        MetaData.a(this.b, this.e.k());
                    } catch (Exception e) {
                    }
                }
            }
            return Boolean.TRUE;
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(this.b);
            return Boolean.FALSE;
        }
    }

    protected void a(Boolean bool) {
        synchronized (MetaData.h()) {
            if (!this.k) {
                if (bool.booleanValue() && this.e != null && this.b != null) {
                    MetaData.a(this.b, this.e, this.d, this.a);
                } else {
                    MetaData.g();
                }
            }
        }
    }
}
