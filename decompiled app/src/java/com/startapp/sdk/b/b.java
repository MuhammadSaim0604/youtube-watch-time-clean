package com.startapp.sdk.b;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public abstract class b<T, A> {
    private volatile T a;

    protected abstract T a(A a);

    public final T b(A a) {
        T t = this.a;
        T t2 = t;
        if (t == null) {
            synchronized (this) {
                T t3 = this.a;
                t2 = t3;
                if (t3 == null) {
                    t2 = a(a);
                    this.a = t2;
                }
            }
        }
        return t2;
    }
}
