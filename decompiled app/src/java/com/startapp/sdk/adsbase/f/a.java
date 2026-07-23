package com.startapp.sdk.adsbase.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.common.ThreadManager;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class a implements com.startapp.common.d {
    protected final Context a;
    protected com.startapp.sdk.adsbase.infoevents.a b;
    private Runnable c;
    private Handler d = new Handler(Looper.getMainLooper());

    protected abstract void b();

    public a(Context context, Runnable runnable, com.startapp.sdk.adsbase.infoevents.a aVar) {
        this.a = context;
        this.c = runnable;
        this.b = aVar;
    }

    public final void a() {
        ThreadManager.a(ThreadManager.Priority.DEFAULT, new Runnable() { // from class: com.startapp.sdk.adsbase.f.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Runnable runnable, long j) {
        this.d.postDelayed(runnable, j);
    }

    @Override // com.startapp.common.d
    public void a(Object obj) {
        if (this.d != null) {
            this.d.removeCallbacksAndMessages(null);
        }
        this.c.run();
    }
}
