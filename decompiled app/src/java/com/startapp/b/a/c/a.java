package com.startapp.b.a.c;

import com.startapp.b.a.c.b;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a extends b {
    private static byte[] a = {13, 10};
    private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private final byte[] d;
    private final byte[] e;
    private final byte[] f;
    private final int g;
    private final int h;

    public a() {
        this((byte) 0);
    }

    private a(byte b2) {
        this(a);
    }

    private a(byte[] bArr) {
        this(bArr, (byte) 0);
    }

    private a(byte[] bArr, byte b2) {
        super(bArr == null ? 0 : bArr.length);
        this.e = c;
        if (bArr != null) {
            if (b(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + com.startapp.b.a.a.a.a(bArr) + "]");
            }
            this.h = 4;
            this.f = null;
        } else {
            this.h = 4;
            this.f = null;
        }
        this.g = 3;
        this.d = b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.startapp.b.a.c.b
    public final void a(byte[] bArr, int i, int i2, b.a aVar) {
        int i3 = i;
        if (!aVar.e) {
            if (i2 < 0) {
                aVar.e = true;
                if (aVar.g != 0) {
                    byte[] a2 = a(aVar);
                    int i4 = aVar.c;
                    switch (aVar.g) {
                        case 0:
                            break;
                        case 1:
                            int i5 = aVar.c;
                            aVar.c = i5 + 1;
                            a2[i5] = this.d[(aVar.a >> 2) & 63];
                            int i6 = aVar.c;
                            aVar.c = i6 + 1;
                            a2[i6] = this.d[(aVar.a << 4) & 63];
                            if (this.d == b) {
                                int i7 = aVar.c;
                                aVar.c = i7 + 1;
                                a2[i7] = 61;
                                int i8 = aVar.c;
                                aVar.c = i8 + 1;
                                a2[i8] = 61;
                                break;
                            }
                            break;
                        case 2:
                            int i9 = aVar.c;
                            aVar.c = i9 + 1;
                            a2[i9] = this.d[(aVar.a >> 10) & 63];
                            int i10 = aVar.c;
                            aVar.c = i10 + 1;
                            a2[i10] = this.d[(aVar.a >> 4) & 63];
                            int i11 = aVar.c;
                            aVar.c = i11 + 1;
                            a2[i11] = this.d[(aVar.a << 2) & 63];
                            if (this.d == b) {
                                int i12 = aVar.c;
                                aVar.c = i12 + 1;
                                a2[i12] = 61;
                                break;
                            }
                            break;
                        default:
                            throw new IllegalStateException("Impossible modulus " + aVar.g);
                    }
                    aVar.f += aVar.c - i4;
                    return;
                }
                return;
            }
            for (int i13 = 0; i13 < i2; i13++) {
                byte[] a3 = a(aVar);
                aVar.g = (aVar.g + 1) % 3;
                int i14 = i3;
                i3++;
                byte b2 = bArr[i14];
                int i15 = b2;
                if (b2 < 0) {
                    i15 += 256;
                }
                aVar.a = (aVar.a << 8) + i15;
                if (aVar.g == 0) {
                    int i16 = aVar.c;
                    aVar.c = i16 + 1;
                    a3[i16] = this.d[(aVar.a >> 18) & 63];
                    int i17 = aVar.c;
                    aVar.c = i17 + 1;
                    a3[i17] = this.d[(aVar.a >> 12) & 63];
                    int i18 = aVar.c;
                    aVar.c = i18 + 1;
                    a3[i18] = this.d[(aVar.a >> 6) & 63];
                    int i19 = aVar.c;
                    aVar.c = i19 + 1;
                    a3[i19] = this.d[aVar.a & 63];
                    aVar.f += 4;
                }
            }
        }
    }

    public static String a(byte[] bArr) {
        byte[] bArr2;
        if (bArr == null || bArr.length == 0) {
            bArr2 = bArr;
        } else {
            a aVar = new a(a, (byte) 0);
            long length = (((bArr.length + 3) - 1) / 3) << 2;
            if (length > 2147483647L) {
                throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + length + ") than the specified maximum size of 2147483647");
            }
            if (bArr == null || bArr.length == 0) {
                bArr2 = bArr;
            } else {
                b.a aVar2 = new b.a();
                aVar.a(bArr, 0, bArr.length, aVar2);
                aVar.a(bArr, 0, -1, aVar2);
                byte[] bArr3 = new byte[aVar2.c - aVar2.d];
                int length2 = bArr3.length;
                if (aVar2.b != null) {
                    int min = Math.min(aVar2.b != null ? aVar2.c - aVar2.d : 0, length2);
                    System.arraycopy(aVar2.b, aVar2.d, bArr3, 0, min);
                    aVar2.d += min;
                    if (aVar2.d >= aVar2.c) {
                        aVar2.b = null;
                    }
                }
                bArr2 = bArr3;
            }
        }
        return com.startapp.b.a.a.a.a(bArr2);
    }

    @Override // com.startapp.b.a.c.b
    protected final boolean a(byte b2) {
        return b2 >= 0 && b2 < this.e.length && this.e[b2] != -1;
    }
}
