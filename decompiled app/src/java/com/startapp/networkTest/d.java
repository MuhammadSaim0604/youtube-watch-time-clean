package com.startapp.networkTest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import java.util.Set;
import java.util.UUID;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class d {
    private SharedPreferences a;

    public d(Context context) {
        this.a = context.getSharedPreferences("p3inspreferences", 0);
    }

    public final String a() {
        String string = this.a.getString("p3ins_pfk_guid", "");
        boolean z = false;
        if (string == null || string.length() == 0) {
            string = p();
            z = true;
        } else {
            long b = com.startapp.networkTest.e.b.b();
            long j = this.a.getLong("P3INS_PFK_GUID_TIMESTAMP", 0L);
            long p = c.d().p();
            if (p != -1 && b - j > p) {
                string = p();
                z = true;
            }
        }
        if (z) {
            final String str = string;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.networkTest.d.1
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
            if (this.a.getBoolean("P3INS_PFK_SEND_REGISTRATION_TIMESTAMP_ENABLED", c.d().q())) {
                this.a.getBoolean("P3INS_PFK_IS_ALREADY_REGISTERED", false);
            }
        }
        return string;
    }

    @SuppressLint({"ApplySharedPref"})
    private String p() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString("p3ins_pfk_guid", replace);
        edit.putLong("P3INS_PFK_GUID_TIMESTAMP", com.startapp.networkTest.e.b.b());
        edit.commit();
        return replace;
    }

    public final boolean b() {
        return this.a.getBoolean("P3INS_PFK_CONNECTIVITY_TEST_ENABLED", c.d().b());
    }

    public final boolean c() {
        return this.a.getBoolean("P3INS_PFK_CONNECTIVITY_KEEPALIVE_ENABLED", c.d().c());
    }

    @SuppressLint({"ApplySharedPref"})
    public final void a(long j) {
        this.a.edit().putLong("P3INS_PFK_CONNECTIVITY_TEST_TIMESTAMP", j).commit();
    }

    public final long d() {
        return this.a.getLong("P3INS_PFK_CONNECTIVITY_TEST_TRUSTSTORE_LAST_CHECK", 0L);
    }

    @SuppressLint({"ApplySharedPref"})
    public final void b(long j) {
        this.a.edit().putLong("P3INS_PFK_CONNECTIVITY_TEST_TRUSTSTORE_LAST_CHECK", j).commit();
    }

    public final long e() {
        return this.a.getLong("P3INS_PFK_CONNECTIVITY_TEST_TRUSTSTORE_LAST_MODIFIED", 0L);
    }

    @SuppressLint({"ApplySharedPref"})
    public final void c(long j) {
        this.a.edit().putLong("P3INS_PFK_CONNECTIVITY_TEST_TRUSTSTORE_LAST_MODIFIED", j).commit();
    }

    public final Set<String> f() {
        return this.a.getStringSet("P3INS_PFK_CT_CRITERIA_SERVER_LIST", null);
    }

    public final void a(Set<String> set) {
        this.a.edit().putStringSet("P3INS_PFK_CT_CRITERIA_SERVER_LIST", set).commit();
    }

    public final Set<String> g() {
        return this.a.getStringSet("P3INS_PFK_LTR_CRITERIA_SERVER_LIST", null);
    }

    public final void b(Set<String> set) {
        this.a.edit().putStringSet("P3INS_PFK_LTR_CRITERIA_SERVER_LIST", set).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public final void d(long j) {
        this.a.edit().putLong("P3INS_PFK_CONNECTIVITY_TEST_CDNCONFIG_LAST_MODIFIED", j).commit();
    }

    public final long h() {
        return this.a.getLong("P3INS_PFK_CONNECTIVITY_TEST_CDNCONFIG_LAST_MODIFIED", 0L);
    }

    public final long i() {
        return this.a.getLong("P3INS_PFK_CONNECTIVITY_TEST_CDNCONFIG_LAST_CHECK", 0L);
    }

    @SuppressLint({"ApplySharedPref"})
    public final void e(long j) {
        this.a.edit().putLong("P3INS_PFK_CONNECTIVITY_TEST_CDNCONFIG_LAST_CHECK", j).commit();
    }

    public final void c(Set<String> set) {
        this.a.edit().putStringSet("P3INS_PFK_CDN_CT_SERVER_LIST", set).commit();
    }

    public final String[] j() {
        Set<String> stringSet = this.a.getStringSet("P3INS_PFK_CDN_CT_SERVER_LIST", null);
        return (stringSet == null || stringSet.isEmpty()) ? c.d().C() : (String[]) stringSet.toArray(new String[stringSet.size()]);
    }

    public final void k() {
        this.a.edit().putString("P3INS_PFK_CDN_CT_CRITERIA", null).commit();
    }

    public final String l() {
        return this.a.getString("P3INS_PFK_CDN_CT_CRITERIA", c.d().D().name());
    }

    public final void d(Set<String> set) {
        this.a.edit().putStringSet("P3INS_PFK_CDN_LTR_SERVER_LIST", set).commit();
    }

    public final String[] m() {
        Set<String> stringSet = this.a.getStringSet("P3INS_PFK_CDN_LTR_SERVER_LIST", null);
        return (stringSet == null || stringSet.isEmpty()) ? c.d().E() : (String[]) stringSet.toArray(new String[stringSet.size()]);
    }

    public final void n() {
        this.a.edit().putString("P3INS_PFK_CDN_LTR_CRITERIA", null).commit();
    }

    public final String o() {
        return this.a.getString("P3INS_PFK_CDN_LTR_CRITERIA", c.d().F().name());
    }
}
