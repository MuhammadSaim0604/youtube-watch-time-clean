package com.startapp.sdk.adsbase.j;

import android.os.Build;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class s implements Iterator<Throwable> {
    private Throwable a;
    private Throwable[] b;
    private int c;
    private boolean d;

    public final boolean a() {
        return this.d;
    }

    public s(Throwable th) {
        this.a = th;
        if (Build.VERSION.SDK_INT >= 19) {
            this.b = th.getSuppressed();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a != null || (this.b != null && this.c < this.b.length);
    }

    @Override // java.util.Iterator
    /* renamed from: b */
    public final Throwable next() {
        Throwable th = this.a;
        this.d = false;
        if (th != null) {
            this.a = th.getCause();
        } else if (this.b != null && this.c < this.b.length) {
            this.d = this.c == 0;
            Throwable[] thArr = this.b;
            int i = this.c;
            this.c = i + 1;
            th = thArr[i];
        }
        if (th == null) {
            throw new NoSuchElementException();
        }
        return th;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
