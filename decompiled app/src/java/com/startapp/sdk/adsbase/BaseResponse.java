package com.startapp.sdk.adsbase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class BaseResponse implements Serializable {
    private static final long serialVersionUID = 1;
    protected Map<String, String> parameters = new HashMap();
    private boolean validResponse = true;
    private String errorMessage = null;

    public final boolean a() {
        return this.validResponse;
    }

    public final String b() {
        return this.errorMessage;
    }

    public String toString() {
        return "BaseResponse [parameters=" + this.parameters + ", validResponse=" + this.validResponse + ", errorMessage=" + this.errorMessage + "]";
    }
}
