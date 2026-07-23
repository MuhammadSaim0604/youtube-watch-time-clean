package com.startapp.common;

import android.net.Uri;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class SDKException extends Exception {
    private String b;
    private Uri c;
    private int d;
    private boolean e;

    public final Uri a() {
        return this.c;
    }

    public final int b() {
        return this.d;
    }

    public final boolean c() {
        return this.e;
    }

    public SDKException(String str, Uri uri, int i, boolean z) {
        this(str, uri, i, z, null);
    }

    public SDKException(String str, Uri uri, int i, boolean z, Throwable th) {
        super(str + ' ' + uri + (i != 0 ? ", status ".concat(String.valueOf(i)) : "") + (z ? ", retry" : ""), th);
        this.b = str;
        this.c = uri;
        this.d = i;
        this.e = z;
    }

    public SDKException() {
    }

    public SDKException(String str, Throwable th) {
        super(str, th);
    }
}
