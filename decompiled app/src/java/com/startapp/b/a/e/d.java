package com.startapp.b.a.e;

import com.startapp.b.a.a.f;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public abstract class d {
    private final c a = new c();

    protected abstract f a(DataInput dataInput) throws IOException;

    public final f a(String str) {
        try {
            byte[] a = c.a(str);
            if (a == null) {
                return null;
            }
            return a(a(a));
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().contains("HighPageCountException")) {
                System.err.println("HighPageCountException (PLM-2573) " + e.getMessage() + ", bad bloom token: " + str);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(DataInput dataInput, f fVar, long j) throws IOException {
        long j2 = j;
        int c = fVar.c();
        for (int i = 0; i < c; i++) {
            long[] a = fVar.a(i);
            for (int i2 = 0; i2 < 4096; i2++) {
                long j3 = j2;
                j2 = j3 - 1;
                if (j3 > 0) {
                    a[i2] = dataInput.readLong();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DataInput a(byte[] bArr) {
        return new DataInputStream(new ByteArrayInputStream(bArr));
    }
}
