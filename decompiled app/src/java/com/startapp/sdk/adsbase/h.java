package com.startapp.sdk.adsbase;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class h {
    private static final boolean a = MetaData.E().J();
    private long c;
    private Context d;
    private long f;
    private boolean g;
    private boolean h;
    private String[] i;
    private TrackingParams j;
    private a l;
    private Handler b = new Handler(Looper.getMainLooper());
    private long e = -1;
    private AtomicBoolean k = new AtomicBoolean(false);

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface a {
        void onSent();
    }

    public h(Context context, String[] strArr, TrackingParams trackingParams, long j) {
        this.d = context.getApplicationContext();
        this.i = strArr;
        this.j = trackingParams;
        this.c = j;
    }

    public final void a(a aVar) {
        this.l = aVar;
    }

    public final void a() {
        if (!this.k.get()) {
            if (a) {
                long j = this.c;
                if (this.h) {
                    return;
                }
                this.h = true;
                if (!this.g) {
                    this.g = true;
                }
                new StringBuilder("Scheduling timer to: ").append(j).append(" millis, Num urls = ").append(this.i.length);
                this.f = System.currentTimeMillis();
                this.b.postDelayed(new Runnable() { // from class: com.startapp.sdk.adsbase.h.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.this.b(true);
                    }
                }, j);
                return;
            }
            b(true);
        }
    }

    public final void b() {
        if (this.g && this.h) {
            this.b.removeCallbacksAndMessages(null);
            this.e = System.currentTimeMillis();
            this.c -= this.e - this.f;
            this.h = false;
        }
    }

    public final void a(boolean z) {
        new StringBuilder("cancel(").append(z).append(")");
        b(z);
        this.g = false;
        this.b.removeCallbacksAndMessages(null);
        this.h = false;
        this.e = -1L;
        this.f = 0L;
    }

    public final boolean c() {
        return this.k.get();
    }

    protected final void b(boolean z) {
        if (this.k.compareAndSet(false, true)) {
            if (z) {
                com.startapp.sdk.adsbase.a.a(this.d, this.i, this.j);
                if (this.l != null) {
                    this.l.onSent();
                    return;
                }
                return;
            }
            com.startapp.sdk.adsbase.a.a(this.d, this.i, this.j.f(), AdDisplayListener.NotDisplayedReason.AD_CLOSED_TOO_QUICKLY.toString());
        }
    }
}
