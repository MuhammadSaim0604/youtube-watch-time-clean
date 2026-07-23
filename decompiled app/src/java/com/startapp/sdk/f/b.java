package com.startapp.sdk.f;

import android.util.Pair;
import com.startapp.sdk.f.a.e;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class b {
    private final com.startapp.sdk.a.a a;
    private final List<Pair<e, Boolean>> b;
    private final int c;
    private final int[] d;
    private final Integer e;
    private final int f;
    private final int g;

    public final com.startapp.sdk.a.a a() {
        return this.a;
    }

    public final int b() {
        return this.c;
    }

    public final int[] c() {
        return this.d;
    }

    public final Integer d() {
        return this.e;
    }

    public b(com.startapp.sdk.a.a aVar, List<Pair<e, Boolean>> list, int i, int[] iArr, Integer num, int i2, int i3) {
        this.a = aVar;
        this.b = list;
        this.c = i;
        this.d = iArr;
        this.e = num;
        this.f = i2;
        this.g = i3;
    }

    public final int a(Object obj) {
        for (Pair<e, Boolean> pair : this.b) {
            if (((e) pair.first).a(obj)) {
                return 1 | (((Boolean) pair.second).booleanValue() ? 2 : 0);
            }
        }
        return 0;
    }

    public final boolean a(int i) {
        return (this.f & i) != 0;
    }

    public final boolean b(int i) {
        return (this.g & i) != 0;
    }
}
