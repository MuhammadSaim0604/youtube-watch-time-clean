package com.startapp.sdk.adsbase.infoevents;

import android.content.Context;
import android.util.Pair;
import com.startapp.common.SDKException;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.j.i;
import com.startapp.sdk.adsbase.j.m;
import com.startapp.sdk.adsbase.j.u;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.json.JSONArray;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class e extends com.startapp.sdk.adsbase.c {
    private final InfoEventCategory b;
    private String c;
    private String d;
    private boolean e;
    private String f;
    private String g;
    private String h;
    private String i;
    private Long j;
    private String k;
    private String l;
    private Object m;
    private File n;
    private String o;
    private e p;
    private Object q;
    private Throwable r;

    static {
        e.class.getSimpleName();
    }

    public final InfoEventCategory g() {
        return this.b;
    }

    public final e f(String str) {
        if (this.b != InfoEventCategory.EXCEPTION) {
            this.c = str;
        }
        return this;
    }

    public final e g(String str) {
        this.d = str;
        return this;
    }

    public final e h() {
        this.e = false;
        return this;
    }

    public final e h(String str) {
        this.f = str;
        return this;
    }

    public final e i(String str) {
        this.g = str;
        return this;
    }

    public final e j(String str) {
        this.h = str;
        return this;
    }

    public final e k(String str) {
        this.i = str;
        return this;
    }

    public final void a(long j) {
        this.j = Long.valueOf(j);
    }

    public final void l(String str) {
        this.k = str;
    }

    public final e m(String str) {
        this.l = str;
        return this;
    }

    public final e a(JSONArray jSONArray) {
        this.m = jSONArray;
        return this;
    }

    public final File i() {
        return this.n;
    }

    public final e a(File file) {
        this.n = file;
        return this;
    }

    public final String j() {
        return this.o;
    }

    public final e n(String str) {
        this.o = str;
        return this;
    }

    public final e k() {
        return this.p;
    }

    public final e a(e eVar) {
        this.p = eVar;
        return this;
    }

    public final Object l() {
        return this.q;
    }

    public final void a(Object obj) {
        this.q = obj;
    }

    public e(InfoEventCategory infoEventCategory) {
        super(8);
        this.e = true;
        if (infoEventCategory != InfoEventCategory.EXCEPTION) {
            this.b = infoEventCategory;
        } else {
            this.b = InfoEventCategory.ERROR;
        }
        if (this.b == InfoEventCategory.ERROR || this.b == InfoEventCategory.GENERAL) {
            this.k = u.a(u.f());
        }
    }

    public e(Throwable th) {
        super(8);
        this.e = true;
        this.b = InfoEventCategory.EXCEPTION;
        this.d = a(th);
        this.c = u.a(com.startapp.sdk.adsbase.c.b.a(th));
        this.k = u.a(u.f());
        this.r = th;
    }

    private static String a(Throwable th) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintWriter printWriter = new PrintWriter(u.a((OutputStream) byteArrayOutputStream));
            com.startapp.sdk.adsbase.c.b.a(th, printWriter);
            printWriter.close();
            return byteArrayOutputStream.toString();
        } catch (Throwable th2) {
            try {
                return th.toString();
            } catch (Throwable th3) {
                return th.getMessage();
            }
        }
    }

    public final void a(Context context) {
        Context l = u.l(context);
        if (l != null) {
            new d(l, this, null).a();
        }
    }

    public final void a(Context context, c cVar) {
        Context l = u.l(context);
        if (l != null) {
            new d(l, this, cVar).a();
        } else {
            cVar.a();
        }
    }

    @Override // com.startapp.sdk.adsbase.c
    public m f() throws SDKException {
        m f = super.f();
        i iVar = f;
        if (f == null) {
            iVar = new i();
        }
        m mVar = iVar;
        String l = this.j != null ? this.j.toString() : com.startapp.common.b.a.d();
        mVar.a(com.startapp.common.b.a.a(), l, true);
        mVar.a(com.startapp.common.b.a.b(), com.startapp.common.b.a.b(l), true);
        mVar.a("category", this.b.a(), true);
        mVar.a("value", this.c, false);
        mVar.a("d", this.f, false);
        mVar.a("orientation", this.g, false);
        mVar.a("usedRam", this.h, false);
        mVar.a("freeRam", this.i, false);
        mVar.a("sessionTime", null, false);
        mVar.a("appActivity", this.k, false);
        mVar.a("details", this.d, false, this.e);
        mVar.a("details_json", this.m, false);
        mVar.a("cellScanRes", this.l, false);
        Pair<String, String> c = SimpleTokenUtils.c();
        Pair<String, String> d = SimpleTokenUtils.d();
        mVar.a((String) c.first, c.second, false);
        mVar.a((String) d.first, d.second, false);
        return iVar;
    }

    @Override // com.startapp.sdk.adsbase.c
    public String toString() {
        return super.toString();
    }
}
