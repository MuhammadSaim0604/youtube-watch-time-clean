package com.startapp.common.b;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    private static final String a = b.a(a.class);
    private static final byte[] b = {10, 30, 84, 95, 101, 20, 0, 14, 15, 80, 36, 84, 64, 82, 84, 64, 80, 80, 65, 78, 84, 73, 70, 82, 65, 85, 68, 75, 69, 89, 1, 2, 3, 8, 15, 42, 10, 51, 44, 32};
    private static final String c = "ts";
    private static final String d = "tsh";
    private static final String e = "afh";
    private static final String f = "MD5";
    private static final String g = "UTF-8";
    private static final byte[] h = {12, 31, 86, 96, 103, 10, 28, 15, 17, 28, 36, 84, 64, 82, 84, 64, 80, 80, 69, 78, 67, 82, 89, 80, 84, 73, 79, 78, 75, 69, 89, 4, 32, 18, 16, 18, 11, 53, 45, 34};

    public static String a() {
        return c;
    }

    public static String b() {
        return d;
    }

    public static String c() {
        return e;
    }

    public static String a(String str) {
        String str2;
        if (str != null) {
            try {
                str2 = URLDecoder.decode(str, g);
            } catch (UnsupportedEncodingException e2) {
            }
            String d2 = d();
            return "&" + c + "=" + d2 + "&" + e + "=" + b(str2 + d2);
        }
        str2 = "";
        String d22 = d();
        return "&" + c + "=" + d22 + "&" + e + "=" + b(str2 + d22);
    }

    public static String d() {
        b.hashCode();
        System.currentTimeMillis();
        return new Long(System.currentTimeMillis()).toString();
    }

    public static String b(String str) {
        str.getBytes();
        byte[] bytes = str.getBytes();
        byte b2 = b[5];
        byte[] bArr = new byte[Math.min(bytes.length, (int) b2)];
        for (int i = 0; i < bytes.length; i++) {
            int i2 = i % b2;
            bArr[i2] = (byte) (bArr[i2] ^ bytes[i]);
        }
        try {
            return URLEncoder.encode(Base64.encodeToString(MessageDigest.getInstance(f).digest(a(bArr, new String(b).substring(b[0], b[1]).getBytes())), 3), g);
        } catch (Exception e2) {
            Log.e(a, "error", e2);
            return "";
        }
    }

    public static String c(String str) {
        return Base64.encodeToString(a(str.getBytes()), 2);
    }

    public static byte[] a(byte[] bArr) {
        h.hashCode();
        bArr.hashCode();
        return a(a(bArr, new String(h).substring(h[5], h[33]).getBytes()), new String(h).substring(h[35], h[1]).getBytes());
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }
}
