package com.iab.omid.library.startapp.b;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b {
    @SuppressLint({"StaticFieldLeak"})
    private static b a = new b();
    private Context b;
    private BroadcastReceiver c;
    private boolean d;
    private boolean e;
    private a f;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public interface a {
        void a(boolean z);
    }

    private b() {
    }

    public static b a() {
        return a;
    }

    private void e() {
        boolean z = !this.e;
        for (com.iab.omid.library.startapp.adsession.b bVar : com.iab.omid.library.startapp.b.a.a().b()) {
            bVar.e().a(z);
        }
    }

    public final void a(@NonNull Context context) {
        this.b = context.getApplicationContext();
    }

    public final void a(a aVar) {
        this.f = aVar;
    }

    public final boolean d() {
        return !this.e;
    }

    public final void b() {
        this.c = new BroadcastReceiver() { // from class: com.iab.omid.library.startapp.b.b.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                KeyguardManager keyguardManager;
                if (intent == null) {
                    return;
                }
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    b.a(b.this, true);
                } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                    b.a(b.this, false);
                } else if (!"android.intent.action.SCREEN_ON".equals(intent.getAction()) || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null || keyguardManager.inKeyguardRestrictedInputMode()) {
                } else {
                    b.a(b.this, false);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.b.registerReceiver(this.c, intentFilter);
        this.d = true;
        e();
    }

    public final void c() {
        if (this.b != null && this.c != null) {
            this.b.unregisterReceiver(this.c);
            this.c = null;
        }
        this.d = false;
        this.e = false;
        this.f = null;
    }

    static /* synthetic */ void a(b bVar, boolean z) {
        if (bVar.e != z) {
            bVar.e = z;
            if (bVar.d) {
                bVar.e();
                if (bVar.f != null) {
                    bVar.f.a(bVar.d());
                }
            }
        }
    }
}
