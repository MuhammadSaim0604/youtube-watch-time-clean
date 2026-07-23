package com.startapp.b.a.e;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
final class c {
    private static final char[] a = "0123456789abcdef".toCharArray();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(String str) {
        if (str.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        int length = str.length();
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(byte[] bArr) {
        char[] cArr = new char[2 * bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            cArr[2 * i] = a[(bArr[i] & 240) >>> 4];
            cArr[(2 * i) + 1] = a[bArr[i] & 15];
        }
        return new String(cArr);
    }
}
