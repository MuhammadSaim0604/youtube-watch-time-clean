package com.startapp.sdk.adsbase.apppresence;

import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AppPresenceDetails implements Serializable {
    private static final long serialVersionUID = 1;
    private int adAttempt;
    private int minAppVersion;
    private String packageName;
    private String trackingUrl;
    private boolean isShown = true;
    private boolean appPresence = false;

    public AppPresenceDetails(String str, String str2, int i, int i2) {
        this.adAttempt = 0;
        this.minAppVersion = 0;
        this.trackingUrl = str;
        this.packageName = str2;
        this.adAttempt = i;
        this.minAppVersion = i2;
    }

    public final String a() {
        return this.trackingUrl;
    }

    public final void a(String str) {
        this.trackingUrl = str;
    }

    public final String b() {
        return this.packageName;
    }

    public final boolean c() {
        return this.isShown;
    }

    public final void a(boolean z) {
        this.isShown = z;
    }

    public final boolean d() {
        return this.appPresence;
    }

    public final void b(boolean z) {
        this.appPresence = z;
    }

    public final int e() {
        return this.minAppVersion;
    }
}
