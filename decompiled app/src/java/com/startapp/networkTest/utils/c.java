package com.startapp.networkTest.utils;

import com.startapp.networkTest.enums.ThreeStateShort;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class c {
    private static final char[] a = "0123456789abcdef".toCharArray();

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i << 1] = a[i2 >>> 4];
            cArr[(i << 1) + 1] = a[i2 & 15];
        }
        return new String(cArr);
    }

    public static int a(ThreeStateShort threeStateShort) {
        switch (threeStateShort) {
            case Yes:
                return 1;
            case No:
                return 0;
            default:
                return -1;
        }
    }
}
