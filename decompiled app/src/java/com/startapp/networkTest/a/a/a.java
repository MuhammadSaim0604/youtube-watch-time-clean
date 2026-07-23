package com.startapp.networkTest.a.a;

import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    private static final String a = a.class.getSimpleName();

    public static byte[] a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            Log.e(a, "hash: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
