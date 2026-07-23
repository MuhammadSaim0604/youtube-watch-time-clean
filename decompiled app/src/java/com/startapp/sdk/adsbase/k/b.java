package com.startapp.sdk.adsbase.k;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.startapp.sdk.adsbase.h;
import java.lang.ref.WeakReference;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class b implements Runnable {
    private a a;
    private WeakReference<View> c;
    private final h d;
    private final int e;
    private Handler b = new Handler(Looper.getMainLooper());
    private boolean f = true;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface a {
        void a();
    }

    static {
        b.class.getSimpleName();
    }

    public b(View view, h hVar, int i) {
        this.c = new WeakReference<>(view);
        this.d = hVar;
        this.e = i;
    }

    public b(WeakReference<View> weakReference, h hVar, int i) {
        this.c = weakReference;
        this.d = hVar;
        this.e = i;
    }

    public final void a(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        if (c()) {
            run();
        }
    }

    public final void b() {
        try {
            if (this.d != null) {
                this.d.a(false);
            }
            if (this.b != null) {
                this.b.removeCallbacksAndMessages(null);
            }
        } catch (Exception e) {
            new StringBuilder("ViewabilityRunner - clearVisibilityHandler failed ").append(e.getMessage());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!c()) {
                b();
                return;
            }
            boolean a2 = com.startapp.sdk.adsbase.k.a.a(this.c.get(), this.e);
            if (a2 && this.f) {
                this.f = false;
                this.d.a();
                if (this.a != null) {
                }
            } else if (!a2 && !this.f) {
                this.f = true;
                this.d.b();
                if (this.a != null) {
                    this.a.a();
                }
            }
            this.b.postDelayed(this, 100L);
        } catch (Exception e) {
            new StringBuilder("ViewabilityRunner.run - runnable error ").append(e.getMessage());
            b();
        }
    }

    private boolean c() {
        return (this.d == null || this.d.c() || this.c.get() == null) ? false : true;
    }
}
