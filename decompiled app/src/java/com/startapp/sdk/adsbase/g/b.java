package com.startapp.sdk.adsbase.g;

import android.os.Bundle;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b {
    private final Bundle a;

    public b(Bundle bundle) {
        this.a = bundle;
    }

    public final String a() {
        return this.a.getString("install_referrer");
    }

    public final long b() {
        return this.a.getLong("referrer_click_timestamp_seconds");
    }

    public final long c() {
        return this.a.getLong("install_begin_timestamp_seconds");
    }
}
