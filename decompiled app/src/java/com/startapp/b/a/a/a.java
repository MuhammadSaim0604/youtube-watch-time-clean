package com.startapp.b.a.a;

import com.startapp.b.a.c.c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a {
    private final int a;
    private final int b;

    public a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final f a(List<String> list) {
        f fVar = new f(this.a * this.b);
        for (String str : list) {
            ByteBuffer wrap = ByteBuffer.wrap(str.getBytes());
            long a = fVar.a();
            long[] jArr = new long[this.a];
            long j = a / this.a;
            long a2 = a(wrap, wrap.position(), wrap.remaining(), 0L);
            long a3 = a(wrap, wrap.position(), wrap.remaining(), a2);
            for (int i = 0; i < this.a; i++) {
                int i2 = i;
                jArr[i2] = (i2 * j) + Math.abs((a2 + (i * a3)) % j);
            }
            for (long j2 : jArr) {
                fVar.a(j2);
            }
        }
        return fVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static long a(ByteBuffer byteBuffer, int i, int i2, long j) {
        int i3;
        long j2 = (j & 4294967295L) ^ ((-4132994306676758123L) * i2);
        for (int i4 = 0; i4 < (i2 >> 3); i4++) {
            int i5 = i4 << 3;
            long j3 = ((byteBuffer.get(i + i5) & 255) + ((byteBuffer.get((i + i5) + 1) & 255) << 8) + ((byteBuffer.get((i + i5) + 2) & 255) << 16) + ((byteBuffer.get((i + i5) + 3) & 255) << 24) + ((byteBuffer.get((i + i5) + 4) & 255) << 32) + ((byteBuffer.get((i + i5) + 5) & 255) << 40) + ((byteBuffer.get((i + i5) + 6) & 255) << 48) + ((byteBuffer.get((i + i5) + 7) & 255) << 56)) * (-4132994306676758123L);
            j2 = (j2 ^ ((j3 ^ (j3 >>> 47)) * (-4132994306676758123L))) * (-4132994306676758123L);
        }
        switch (i2 & 7) {
            case 1:
                j2 = (j2 ^ byteBuffer.get((i + i2) - i3)) * (-4132994306676758123L);
                break;
            case 2:
                j2 ^= byteBuffer.get(((i + i2) - i3) + 1) << 8;
                j2 = (j2 ^ byteBuffer.get((i + i2) - i3)) * (-4132994306676758123L);
                break;
            case 3:
                j2 ^= byteBuffer.get(((i + i2) - i3) + 2) << 16;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 1) << 8;
                j2 = (j2 ^ byteBuffer.get((i + i2) - i3)) * (-4132994306676758123L);
                break;
            case 4:
                j2 ^= byteBuffer.get(((i + i2) - i3) + 3) << 24;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 2) << 16;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 1) << 8;
                j2 = (j2 ^ byteBuffer.get((i + i2) - i3)) * (-4132994306676758123L);
                break;
            case 5:
                j2 ^= byteBuffer.get(((i + i2) - i3) + 4) << 32;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 3) << 24;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 2) << 16;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 1) << 8;
                j2 = (j2 ^ byteBuffer.get((i + i2) - i3)) * (-4132994306676758123L);
                break;
            case 6:
                j2 ^= byteBuffer.get(((i + i2) - i3) + 5) << 40;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 4) << 32;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 3) << 24;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 2) << 16;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 1) << 8;
                j2 = (j2 ^ byteBuffer.get((i + i2) - i3)) * (-4132994306676758123L);
                break;
            case 7:
                j2 ^= byteBuffer.get(((i + i2) - i3) + 6) << 48;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 5) << 40;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 4) << 32;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 3) << 24;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 2) << 16;
                j2 ^= byteBuffer.get(((i + i2) - i3) + 1) << 8;
                j2 = (j2 ^ byteBuffer.get((i + i2) - i3)) * (-4132994306676758123L);
                break;
        }
        long j4 = j2;
        long j5 = (j4 ^ (j4 >>> 47)) * (-4132994306676758123L);
        return j5 ^ (j5 >>> 47);
    }

    public static String a(byte[] bArr) {
        Charset charset = c.a;
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }
}
