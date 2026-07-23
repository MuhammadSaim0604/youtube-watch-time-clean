package com.startapp.sdk.f.a;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
class d extends e {
    protected final String a;
    private final Map<String, String> b;

    public d(String str, Map<String, String> map) {
        this.a = str;
        this.b = map;
    }

    @Override // com.startapp.sdk.f.a.e
    public final boolean a(Object obj) {
        if ((obj instanceof Pair) && ((Pair) obj).first == this && (((Pair) obj).second instanceof Intent)) {
            Intent intent = (Intent) ((Pair) obj).second;
            if (!this.a.equals(intent.getAction())) {
                return false;
            }
            Bundle extras = intent.getExtras();
            Bundle bundle = extras;
            if (extras == null) {
                bundle = Bundle.EMPTY;
            }
            for (Map.Entry<String, String> entry : this.b.entrySet()) {
                if (!entry.getValue().equals(String.valueOf(bundle.get(entry.getKey())))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
