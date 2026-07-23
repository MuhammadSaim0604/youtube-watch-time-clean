package com.startapp.sdk.adsbase.adrules;

import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AdRulesResult implements Serializable {
    private static final long serialVersionUID = 1;
    private String reason;
    private boolean shouldDisplayAd;

    public AdRulesResult(boolean z, String str) {
        this.shouldDisplayAd = z;
        this.reason = str;
    }

    public AdRulesResult() {
        this(true, "");
    }

    public final boolean a() {
        return this.shouldDisplayAd;
    }

    public final String b() {
        return this.reason;
    }

    public final String c() {
        return this.reason != null ? this.reason.split(" ")[0] : "";
    }
}
