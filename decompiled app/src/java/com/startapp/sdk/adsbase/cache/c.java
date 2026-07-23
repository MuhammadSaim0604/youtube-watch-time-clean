package com.startapp.sdk.adsbase.cache;

import android.os.Handler;
import android.os.Looper;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class c {
    protected e a;
    private Handler b = null;
    private Long c = null;
    private boolean d = false;

    protected abstract boolean c();

    protected abstract long d();

    public c(e eVar) {
        this.a = eVar;
    }

    public final void f() {
        if (!this.d) {
            if (this.c == null) {
                this.c = Long.valueOf(System.currentTimeMillis());
            }
            if (c()) {
                if (this.b == null) {
                    Looper myLooper = Looper.myLooper();
                    this.b = new Handler(myLooper != null ? myLooper : Looper.getMainLooper());
                }
                long d = d();
                if (d >= 0) {
                    this.d = true;
                    e();
                    new StringBuilder("Started for ").append(this.a.c()).append(" - scheduled to: ").append(d);
                    this.b.postDelayed(new Runnable() { // from class: com.startapp.sdk.adsbase.cache.c.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.this.b();
                        }
                    }, d);
                    return;
                }
                e();
                return;
            }
            e();
        }
    }

    public final void g() {
        j();
        k();
    }

    public final void h() {
        j();
        this.d = false;
    }

    public void a() {
        e();
        new StringBuilder("Resetting for ").append(this.a.c());
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        e();
        new StringBuilder("Time reached, reloading ").append(this.a.c());
        k();
        this.a.i();
    }

    protected String e() {
        return "CacheScheduledTask";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Long i() {
        return this.c;
    }

    private void j() {
        if (this.b != null) {
            this.b.removeCallbacksAndMessages(null);
        }
    }

    private void k() {
        this.c = null;
        this.d = false;
    }
}
