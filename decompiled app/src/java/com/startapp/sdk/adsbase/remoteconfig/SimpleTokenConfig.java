package com.startapp.sdk.adsbase.remoteconfig;

import android.content.Context;
import com.startapp.sdk.adsbase.j;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class SimpleTokenConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean enabled = false;

    public final boolean a(Context context) {
        return !j.a(context, "userDisabledSimpleToken", Boolean.FALSE).booleanValue() && this.enabled && com.startapp.sdk.b.c.a(context).f().g();
    }

    public static void a(Context context, boolean z) {
        j.b(context, "userDisabledSimpleToken", Boolean.valueOf(!z));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.enabled == ((SimpleTokenConfig) obj).enabled;
    }

    public int hashCode() {
        return Boolean.valueOf(this.enabled).hashCode();
    }
}
