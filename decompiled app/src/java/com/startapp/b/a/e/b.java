package com.startapp.b.a.e;

import com.startapp.b.a.a.f;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b {
    private final c a = new c();

    public static String a(f fVar) {
        int b = fVar.b();
        int c = fVar.c();
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                for (int i = 0; i < c; i++) {
                    long[] a = fVar.a(i);
                    for (int i2 = 0; i2 < 4096; i2++) {
                        int i3 = b;
                        b--;
                        if (i3 > 0) {
                            dataOutputStream.writeLong(a[i2]);
                        }
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
                return c.a(byteArrayOutputStream.toByteArray());
            } catch (Exception e2) {
                throw new RuntimeException("problem serializing bitSet", e2);
            }
        } catch (Throwable th) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
            }
            throw th;
        }
    }
}
