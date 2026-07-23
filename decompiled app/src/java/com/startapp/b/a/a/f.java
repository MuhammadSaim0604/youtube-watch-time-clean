package com.startapp.b.a.a;

import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class f implements Serializable {
    private static /* synthetic */ boolean a;
    private final long[][] d;
    private int e;
    private final int f;

    static {
        a = !f.class.desiredAssertionStatus();
    }

    public f(long j) {
        this.e = b(j);
        int i = this.e % 4096;
        int i2 = this.e / 4096;
        this.f = i2 + (i == 0 ? 0 : 1);
        if (this.f > 100) {
            throw new RuntimeException("HighPageCountException pageCount = " + this.f);
        }
        this.d = new long[this.f];
        for (int i3 = 0; i3 < i2; i3++) {
            this.d[i3] = new long[4096];
        }
        if (i != 0) {
            this.d[this.d.length - 1] = new long[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a() {
        return this.e << 6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j) {
        int i = (int) (j >> 6);
        if (i >= this.e) {
            int b = b(j + 1);
            if (!a && b > this.e) {
                throw new AssertionError("Growing of paged bitset is not supported");
            }
            this.e = i + 1;
        }
        long[] jArr = this.d[i / 4096];
        int i2 = i % 4096;
        jArr[i2] = jArr[i2] | (1 << (((int) j) & 63));
    }

    private static int b(long j) {
        return (int) (((j - 1) >>> 6) + 1);
    }

    public final int b() {
        return this.e;
    }

    public final int c() {
        return this.f;
    }

    public final long[] a(int i) {
        return this.d[i];
    }
}
