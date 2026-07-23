package com.startapp.sdk.adsbase.infoevents;

import android.content.Context;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class b {
    protected com.startapp.common.d a;
    private Context b;
    private ArrayList<com.startapp.sdk.adsbase.f.a> c;
    private final com.startapp.sdk.adsbase.infoevents.a d = new com.startapp.sdk.adsbase.infoevents.a(InfoEventCategory.PERIODIC);
    private final AtomicBoolean e = new AtomicBoolean(false);
    private int f;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public static class a {
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.f - 1;
        bVar.f = i;
        return i;
    }

    static {
        b.class.getSimpleName();
    }

    public b(Context context, boolean z, com.startapp.common.d dVar) {
        int i;
        this.b = context;
        this.a = dVar;
        this.d.a(z);
        this.d.e(AdsConstants.e);
        Runnable runnable = new Runnable() { // from class: com.startapp.sdk.adsbase.infoevents.b.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (b.this) {
                    if (b.a(b.this) == 0) {
                        b.this.b();
                    }
                }
            }
        };
        if (MetaData.E().A().a(context)) {
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
            this.c.add(new com.startapp.sdk.adsbase.f.c(context, runnable, this.d));
        }
        if (MetaData.E().B().a(context)) {
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
            this.c.add(new com.startapp.sdk.adsbase.f.b(context, runnable, this.d));
        }
        if (this.c != null) {
            i = this.c.size();
        } else {
            i = 0;
        }
        this.f = i;
    }

    public final synchronized void a() {
        if (this.f > 0 && this.e.compareAndSet(false, true)) {
            for (int i = 0; i < this.f; i++) {
                if (this.c != null) {
                    this.c.get(i).a();
                }
            }
        } else {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.d.a(this.b, new c() { // from class: com.startapp.sdk.adsbase.infoevents.b.2
            private Boolean a;

            @Override // com.startapp.sdk.adsbase.infoevents.c
            public final void a(e eVar, boolean z) {
                if (this.a == null) {
                    this.a = Boolean.valueOf(z);
                    return;
                }
                throw new IllegalStateException();
            }

            @Override // com.startapp.sdk.adsbase.infoevents.c
            public final void a() {
                if (b.this.a != null) {
                    b.this.a.a(this.a);
                }
            }
        });
        this.e.set(false);
    }
}
