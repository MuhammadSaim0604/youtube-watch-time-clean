package com.startapp.sdk.adsbase.j;

import com.startapp.common.SDKException;
import java.util.Collection;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class i extends m {
    private JSONObject a;

    public i() {
        this.a = null;
        this.a = new JSONObject();
    }

    @Override // com.startapp.sdk.adsbase.j.m
    public final void a(String str, Object obj, boolean z, boolean z2) throws SDKException {
        if (z && obj == null) {
            throw new SDKException("Required key: [" + str + "] is missing", null);
        }
        if (obj != null && !obj.toString().equals("")) {
            try {
                this.a.put(str, obj);
            } catch (JSONException e) {
                if (z) {
                    throw new SDKException("failed converting to json object value: [" + obj + "]", e);
                }
            }
        }
    }

    @Override // com.startapp.sdk.adsbase.j.m
    public final void a(String str, Set<String> set) throws SDKException {
        if (set != null && set.size() > 0) {
            try {
                this.a.put(str, new JSONArray((Collection) set));
            } catch (JSONException e) {
            }
        }
    }

    public final String toString() {
        return this.a.toString();
    }
}
