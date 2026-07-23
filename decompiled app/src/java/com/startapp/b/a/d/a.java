package com.startapp.b.a.d;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a implements c {
    private final c a;

    public a(c cVar) {
        this.a = cVar;
    }

    @Override // com.startapp.b.a.d.c
    public final String a(String str) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream = gZIPOutputStream2;
            gZIPOutputStream2.write(str.getBytes());
            com.startapp.b.a.c.d.a(gZIPOutputStream);
            String a = this.a.a(com.startapp.b.a.c.a.a(byteArrayOutputStream.toByteArray()));
            com.startapp.b.a.c.d.a(gZIPOutputStream);
            return a;
        } catch (Exception e) {
            com.startapp.b.a.c.d.a(gZIPOutputStream);
            return "";
        } catch (Throwable th) {
            com.startapp.b.a.c.d.a(gZIPOutputStream);
            throw th;
        }
    }
}
