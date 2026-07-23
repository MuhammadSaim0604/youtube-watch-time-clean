package com.startapp.sdk.adsbase.j;

import java.util.Comparator;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class d<T> implements Comparator<T> {
    private final Comparator<T> a;
    private final Comparator<T> b;

    public d(Comparator<T> comparator, Comparator<T> comparator2) {
        this.a = comparator;
        this.b = comparator2;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.a.compare(t, t2);
        int i = compare;
        if (compare == 0) {
            i = this.b.compare(t, t2);
        }
        return i;
    }
}
