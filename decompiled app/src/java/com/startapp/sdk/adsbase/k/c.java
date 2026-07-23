package com.startapp.sdk.adsbase.k;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class c {
    private final Handler a = new Handler(Looper.getMainLooper());
    private final WeakReference<View> b;
    private final int c;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface a {
        boolean onUpdate(boolean z);
    }

    static /* synthetic */ boolean a(c cVar) {
        return com.startapp.sdk.adsbase.k.a.a(cVar.b.get(), cVar.c);
    }

    public c(View view, int i, final a aVar) {
        this.b = new WeakReference<>(view);
        this.c = i;
        this.a.postDelayed(new Runnable() { // from class: com.startapp.sdk.adsbase.k.c.1
            @Override // java.lang.Runnable
            public final void run() {
                if (aVar.onUpdate(c.a(c.this))) {
                    c.this.a.postDelayed(this, 100L);
                }
            }
        }, 100L);
    }

    public final void a() {
        this.a.removeCallbacksAndMessages(null);
    }
}
