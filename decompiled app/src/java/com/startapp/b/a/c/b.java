package com.startapp.b.a.c;

import java.util.Arrays;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public abstract class b {
    private byte a = 61;
    private final int b = 3;
    private final int c = 4;
    private int d = 0;
    private final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(byte[] bArr, int i, int i2, a aVar);

    protected abstract boolean a(byte b);

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    static class a {
        int a;
        byte[] b;
        int c;
        int d;
        boolean e;
        int f;
        int g;

        public final String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.b), Integer.valueOf(this.f), Boolean.valueOf(this.e), Integer.valueOf(this.a), 0L, Integer.valueOf(this.g), Integer.valueOf(this.c), Integer.valueOf(this.d));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] a(a aVar) {
        if (aVar.b != null && aVar.b.length >= aVar.c + 4) {
            return aVar.b;
        }
        if (aVar.b == null) {
            aVar.b = new byte[8192];
            aVar.c = 0;
            aVar.d = 0;
        } else {
            byte[] bArr = new byte[aVar.b.length << 1];
            System.arraycopy(aVar.b, 0, bArr, 0, aVar.b.length);
            aVar.b = bArr;
        }
        return aVar.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (61 == b || a(b)) {
                return true;
            }
        }
        return false;
    }
}
