package com.startapp.common.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b implements CookieStore {
    private final CookieStore a = new CookieManager().getCookieStore();
    private final SharedPreferences b;

    public b(Context context) {
        HttpCookie httpCookie;
        this.b = context.getApplicationContext().getSharedPreferences("com.startapp.android.publish.CookiePrefsFile", 0);
        String string = this.b.getString("names", null);
        if (string != null) {
            for (String str : TextUtils.split(string, ";")) {
                String string2 = this.b.getString("cookie_".concat(String.valueOf(str)), null);
                if (string2 != null && (httpCookie = (HttpCookie) com.startapp.common.parser.b.a(string2, HttpCookie.class)) != null) {
                    if (!httpCookie.hasExpired()) {
                        this.a.add(URI.create(httpCookie.getDomain()), httpCookie);
                    } else {
                        a(httpCookie);
                        a();
                    }
                }
            }
        }
    }

    @Override // java.net.CookieStore
    public final void add(URI uri, HttpCookie httpCookie) {
        String b = b(httpCookie);
        this.a.add(uri, httpCookie);
        SharedPreferences.Editor edit = this.b.edit();
        edit.putString("cookie_".concat(String.valueOf(b)), com.startapp.common.parser.b.a(httpCookie));
        edit.commit();
        a();
    }

    @Override // java.net.CookieStore
    public final List<HttpCookie> get(URI uri) {
        return this.a.get(uri);
    }

    @Override // java.net.CookieStore
    public final List<HttpCookie> getCookies() {
        return this.a.getCookies();
    }

    @Override // java.net.CookieStore
    public final List<URI> getURIs() {
        return this.a.getURIs();
    }

    @Override // java.net.CookieStore
    public final boolean remove(URI uri, HttpCookie httpCookie) {
        if (this.a.remove(uri, httpCookie)) {
            a(httpCookie);
            a();
            return true;
        }
        return false;
    }

    @Override // java.net.CookieStore
    public final boolean removeAll() {
        if (this.a.removeAll()) {
            SharedPreferences.Editor edit = this.b.edit();
            edit.clear();
            edit.commit();
            a();
            return true;
        }
        return false;
    }

    private void a(HttpCookie httpCookie) {
        SharedPreferences.Editor edit = this.b.edit();
        edit.remove("cookie_" + b(httpCookie));
        edit.commit();
    }

    private void a() {
        SharedPreferences.Editor edit = this.b.edit();
        edit.putString("names", TextUtils.join(";", b()));
        edit.commit();
    }

    private static String b(HttpCookie httpCookie) {
        return httpCookie.getDomain() + "_" + httpCookie.getName();
    }

    private Set<String> b() {
        HashSet hashSet = new HashSet();
        for (HttpCookie httpCookie : this.a.getCookies()) {
            hashSet.add(b(httpCookie));
        }
        return hashSet;
    }
}
