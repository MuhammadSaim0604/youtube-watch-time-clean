package com.startapp.sdk.adsbase;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Pair;
import com.startapp.common.ThreadManager;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class d {
    protected final Context a;
    protected final Ad b;
    protected final AdPreferences c;
    protected final com.startapp.sdk.adsbase.adlisteners.b d;
    protected AdPreferences.Placement e;
    protected String f = null;

    protected abstract boolean a(Object obj);

    protected abstract Object e();

    public d(Context context, Ad ad, AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar, AdPreferences.Placement placement) {
        this.a = context;
        this.b = ad;
        this.c = adPreferences;
        this.d = bVar;
        this.e = placement;
    }

    public final void c() {
        ThreadManager.a(ThreadManager.Priority.HIGH, new Runnable() { // from class: com.startapp.sdk.adsbase.d.1
            @Override // java.lang.Runnable
            public final void run() {
                Process.setThreadPriority(10);
                final Boolean d = d.this.d();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.adsbase.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.a(d);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Boolean d() {
        return Boolean.valueOf(a(e()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Boolean bool) {
        b(bool);
        if (!bool.booleanValue()) {
            this.b.setErrorMessage(this.f);
            this.d.b(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Boolean bool) {
        this.b.setState(bool.booleanValue() ? Ad.AdState.READY : Ad.AdState.UN_INITIALIZED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GetAdRequest a() {
        GetAdRequest b = b(new GetAdRequest());
        if (b != null) {
            b.a(this.a);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final GetAdRequest b(GetAdRequest getAdRequest) {
        Pair<String, String> d = SimpleTokenUtils.d(this.a);
        try {
            getAdRequest.a(this.a, this.c, this.e, d);
            getAdRequest.a(this.b.getConsentType(), this.b.getConsentTimestamp(), this.b.getConsentApc());
            if (!AdsCommonMetaData.a().E() && a.a(this.a, this.e)) {
                getAdRequest.h();
            }
            try {
                getAdRequest.a(this.a, this.c);
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(this.a);
            }
            return getAdRequest;
        } catch (Throwable th2) {
            new com.startapp.sdk.adsbase.infoevents.e(th2).a(this.a);
            SimpleTokenUtils.a(d);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AdPreferences.Placement f() {
        return this.e;
    }
}
