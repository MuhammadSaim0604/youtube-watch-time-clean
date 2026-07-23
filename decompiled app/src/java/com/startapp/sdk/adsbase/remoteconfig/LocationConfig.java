package com.startapp.sdk.adsbase.remoteconfig;

import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class LocationConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean fiEnabled = false;
    private boolean coEnabled = false;
    private int ief = 0;

    public final boolean a() {
        return this.fiEnabled;
    }

    public final boolean b() {
        return this.coEnabled;
    }

    public final int c() {
        return this.ief;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocationConfig locationConfig = (LocationConfig) obj;
        return this.fiEnabled == locationConfig.fiEnabled && this.coEnabled == locationConfig.coEnabled && this.ief == locationConfig.ief;
    }

    public int hashCode() {
        return u.a(Boolean.valueOf(this.fiEnabled), Boolean.valueOf(this.coEnabled), Integer.valueOf(this.ief));
    }
}
