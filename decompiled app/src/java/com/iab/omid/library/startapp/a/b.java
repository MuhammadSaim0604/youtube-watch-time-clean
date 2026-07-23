package com.iab.omid.library.startapp.a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b extends ContentObserver {
    private final Context a;
    private final AudioManager b;
    private final com.iab.omid.library.startapp.d.a c;
    private final a d;
    private float e;

    public b(Handler handler, Context context, com.iab.omid.library.startapp.d.a aVar, a aVar2) {
        super(handler);
        this.a = context;
        this.b = (AudioManager) context.getSystemService("audio");
        this.c = aVar;
        this.d = aVar2;
    }

    private float c() {
        return com.iab.omid.library.startapp.d.a.a(this.b.getStreamVolume(3), this.b.getStreamMaxVolume(3));
    }

    private void d() {
        this.d.a(this.e);
    }

    public final void a() {
        this.e = c();
        d();
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void b() {
        this.a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        float c = c();
        if (c != this.e) {
            this.e = c;
            d();
        }
    }
}
