package com.startapp.sdk.c;

import android.content.Context;
import android.os.SystemClock;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public abstract class a<T> {
    protected final Context a;
    private volatile T b;
    private volatile long c;
    private final long d;

    protected abstract T a();

    protected abstract T b();

    public a(Context context) {
        this(context, 900000L);
    }

    public a(Context context, long j) {
        this.a = context;
        this.d = j;
    }

    private boolean d() {
        return this.c + this.d < SystemClock.uptimeMillis();
    }

    public final T c() {
        T t = this.b;
        T t2 = t;
        if (t == null || d()) {
            synchronized (this) {
                T t3 = this.b;
                t2 = t3;
                if (t3 == null || d()) {
                    t2 = a();
                    if (t2 != null) {
                        this.b = t2;
                        this.c = SystemClock.uptimeMillis();
                    }
                }
            }
        }
        return t2 != null ? t2 : b();
    }
}
