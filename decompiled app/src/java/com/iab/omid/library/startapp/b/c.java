package com.iab.omid.library.startapp.b;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class c {
    @SuppressLint({"StaticFieldLeak"})
    private static c a = new c();
    private Context b;

    private c() {
    }

    public static c a() {
        return a;
    }

    public final void a(Context context) {
        this.b = context != null ? context.getApplicationContext() : null;
    }

    public final Context b() {
        return this.b;
    }
}
