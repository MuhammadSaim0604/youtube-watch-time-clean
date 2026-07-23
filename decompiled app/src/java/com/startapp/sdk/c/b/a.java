package com.startapp.sdk.c.b;

import java.util.Collection;
import java.util.Locale;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class a {
    protected static final a a = new a();
    private final String b;
    private final String c;
    private final String d;

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public a(Locale locale, Collection<Locale> collection) {
        this.b = locale.toString();
        this.c = a(null, collection, ';');
        this.d = a(locale, collection, ',');
    }

    private a() {
        this.b = null;
        this.c = null;
        this.d = null;
    }

    private static String a(Locale locale, Iterable<Locale> iterable, char c) {
        StringBuilder sb = null;
        boolean z = false;
        if (locale != null) {
            StringBuilder sb2 = new StringBuilder();
            sb = sb2;
            sb2.append(locale);
            z = true;
        }
        if (iterable != null) {
            for (Locale locale2 : iterable) {
                if (locale2 != null) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    if (z) {
                        sb.append(c);
                    }
                    sb.append(locale2);
                    z = true;
                }
            }
        }
        if (sb != null) {
            return sb.toString();
        }
        return null;
    }
}
