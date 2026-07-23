package com.startapp.sdk.adsbase.j;

import java.util.Comparator;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class h implements Comparator<JSONObject> {
    private final String a;

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(JSONObject jSONObject, JSONObject jSONObject2) {
        Object opt = jSONObject.opt(this.a);
        Object opt2 = jSONObject2.opt(this.a);
        if ((opt instanceof Comparable) && (opt2 instanceof Comparable)) {
            if (opt.getClass() == opt2.getClass()) {
                return ((Comparable) opt).compareTo(opt2);
            }
            if ((opt instanceof Number) && (opt2 instanceof Number)) {
                return Double.compare(((Number) opt).doubleValue(), ((Number) opt2).doubleValue());
            }
        }
        if (opt == JSONObject.NULL) {
            opt = null;
        }
        if (opt2 == JSONObject.NULL) {
            opt2 = null;
        }
        if (opt != null && opt2 != null) {
            return opt.toString().compareTo(opt2.toString());
        }
        if (opt != null) {
            return 1;
        }
        if (opt2 != null) {
            return -1;
        }
        return 0;
    }

    public h(String str) {
        this.a = str;
    }
}
