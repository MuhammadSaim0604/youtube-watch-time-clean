package com.startapp.networkTest.c.a;

import java.nio.ByteBuffer;
import java.util.Random;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
final class b {
    private final byte a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(byte b) {
        this.a = b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ByteBuffer a(short s, short s2, byte[] bArr) {
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            bArr2 = new byte[0];
        } else if (bArr2.length > 65507) {
            bArr2 = a(65507);
        }
        byte[] bArr3 = new byte[8 + bArr2.length];
        ByteBuffer wrap = ByteBuffer.wrap(bArr3);
        wrap.put(this.a);
        wrap.put((byte) 0);
        int position = wrap.position();
        wrap.position(position + 2);
        wrap.putShort(s2);
        wrap.putShort(s);
        wrap.put(bArr2);
        int length = bArr3.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 2) {
            int i3 = i + ((bArr3[i2] & 255) << 8);
            i = (i3 & 65535) + (i3 >> 16);
        }
        for (int i4 = 1; i4 < length; i4 += 2) {
            int i5 = i + (bArr3[i4] & 255);
            i = (i5 & 65535) + (i5 >> 16);
        }
        wrap.putShort(position, (short) (((i & 65535) + (i >> 16)) ^ 65535));
        wrap.flip();
        return wrap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        new Random().nextBytes(bArr);
        return bArr;
    }
}
