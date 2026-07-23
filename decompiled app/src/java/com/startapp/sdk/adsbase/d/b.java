package com.startapp.sdk.adsbase.d;

import android.content.Context;
import com.startapp.common.SDKException;
import com.startapp.common.a.d;
import com.startapp.common.b.e;
import com.startapp.sdk.adsbase.j;
import com.startapp.sdk.adsbase.j.g;
import com.startapp.sdk.adsbase.j.m;
import com.startapp.sdk.adsbase.j.q;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class b {
    protected final Context a;
    private final d b;
    private final com.startapp.sdk.c.b.b c;
    private final com.startapp.sdk.adsbase.e.a d;
    private g<c> e;

    static {
        b.class.getSimpleName();
    }

    public b(Context context, d dVar, com.startapp.sdk.c.b.b bVar, com.startapp.sdk.adsbase.e.a aVar, g<c> gVar) {
        this.a = context;
        this.b = dVar;
        this.c = bVar;
        this.d = aVar;
        this.e = gVar;
    }

    private c a() {
        c a = this.e.a();
        return a != null ? a : c.b;
    }

    public final a a(String str) {
        return new a(this, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e.a a(a aVar) {
        try {
            return a(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(this.a);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b(a aVar) {
        try {
            return b(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(this.a);
            return null;
        }
    }

    private e.a a(String str, com.startapp.sdk.adsbase.c cVar, q<String> qVar, int i, long j) {
        boolean z;
        String str2 = str;
        Map<String, String> b = b();
        int i2 = 1;
        while (true) {
            if (cVar != null) {
                if (i2 > 1) {
                    cVar.b(i2 - 1);
                }
                try {
                    str2 = str + cVar.a().toString();
                } catch (SDKException e) {
                    new com.startapp.sdk.adsbase.infoevents.e(e).a(this.a);
                    return null;
                }
            }
            com.startapp.sdk.adsbase.e.c a = this.d.a();
            try {
                e.a a2 = e.a(str2, b, j.a(this.a, "User-Agent", "-1"), a().a());
                a.a("GET", str2, null);
                return a2;
            } catch (SDKException e2) {
                a.a("GET", str2, e2);
                if (!e2.c() || i2 >= i) {
                    break;
                }
                if (e2.b() != 0) {
                    Set<Integer> c = a().c();
                    z = c == null || !c.contains(Integer.valueOf(e2.b()));
                } else {
                    z = true;
                }
                if (!z) {
                    break;
                }
                i2++;
                if (j > 0) {
                    try {
                        Thread.sleep(j);
                    } catch (InterruptedException e3) {
                        new com.startapp.sdk.adsbase.infoevents.e(e3).a(this.a);
                        return null;
                    }
                }
                a(qVar, e2);
                return null;
            }
        }
        a(qVar, e2);
        return null;
    }

    private String b(String str, com.startapp.sdk.adsbase.c cVar, q<String> qVar, int i, long j) {
        byte[] bArr = null;
        boolean z = false;
        if (cVar != null) {
            try {
                m f = cVar.f();
                if (f != null) {
                    bArr = f.toString().getBytes();
                    if (a().a()) {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(bArr);
                            gZIPOutputStream.flush();
                            gZIPOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                            z = true;
                        } catch (IOException e) {
                            new com.startapp.sdk.adsbase.infoevents.e(e).a(this.a);
                        }
                    }
                }
            } catch (SDKException e2) {
                new com.startapp.sdk.adsbase.infoevents.e(e2).a(this.a);
                return null;
            }
        }
        Map<String, String> b = b();
        int i2 = 1;
        while (true) {
            com.startapp.sdk.adsbase.e.c a = this.d.a();
            try {
                String a2 = e.a(str, bArr, b, j.a(this.a, "User-Agent", "-1"), z, "application/json");
                a.a("POST", str, null);
                if (a2 != null) {
                    return a2;
                }
                return "";
            } catch (SDKException e3) {
                a.a("POST", str, e3);
                if (e3.c() && i2 < i) {
                    i2++;
                    if (j > 0) {
                        try {
                            Thread.sleep(j);
                        } catch (InterruptedException e4) {
                            new com.startapp.sdk.adsbase.infoevents.e(e4).a(this.a);
                            return null;
                        }
                    }
                } else {
                    a(qVar, e3);
                    return null;
                }
            }
        }
        a(qVar, e3);
        return null;
    }

    private void a(q<String> qVar, Throwable th) {
        if (qVar != null) {
            try {
                qVar.a(th.getMessage());
            } catch (Throwable th2) {
                new com.startapp.sdk.adsbase.infoevents.e(th2).a(this.a);
            }
        }
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        if (!a().b()) {
            String str = null;
            try {
                String a = this.b.b().a();
                str = a;
                str = URLEncoder.encode(a, "UTF-8");
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(this.a);
            }
            hashMap.put("device-id", str);
        }
        hashMap.put("Accept-Language", this.c.c().c());
        return hashMap;
    }
}
