package com.startapp.sdk.omsdk;

import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class VerificationDetails implements Serializable {
    private static final long serialVersionUID = 1;
    private String javascriptResourceUrl;
    private String vendorKey;
    private String verificationParameters;

    public VerificationDetails() {
    }

    public VerificationDetails(String str, String str2, String str3) {
        this.vendorKey = str;
        this.javascriptResourceUrl = str2;
        this.verificationParameters = str3;
    }

    public final String a() {
        return this.vendorKey;
    }

    public final String b() {
        return this.javascriptResourceUrl;
    }

    public final String c() {
        return this.verificationParameters;
    }
}
