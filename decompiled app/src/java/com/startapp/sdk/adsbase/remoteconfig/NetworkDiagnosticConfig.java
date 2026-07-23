package com.startapp.sdk.adsbase.remoteconfig;

import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class NetworkDiagnosticConfig implements Serializable {
    private static final long serialVersionUID = 600844380854621516L;
    private boolean enabled;
    private int ief;
    private int sendingIntervalMinutes = 60;
    private int minCountToSend = 10;
    private int types = 1;

    public final boolean a() {
        return this.enabled;
    }

    public final int b() {
        return this.sendingIntervalMinutes;
    }

    public final int c() {
        return this.minCountToSend;
    }

    public final int d() {
        return this.types;
    }

    public final int e() {
        return this.ief;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NetworkDiagnosticConfig networkDiagnosticConfig = (NetworkDiagnosticConfig) obj;
        return this.enabled == networkDiagnosticConfig.enabled && this.sendingIntervalMinutes == networkDiagnosticConfig.sendingIntervalMinutes && this.minCountToSend == networkDiagnosticConfig.minCountToSend && this.types == networkDiagnosticConfig.types && this.ief == networkDiagnosticConfig.ief;
    }

    public int hashCode() {
        return u.a(Boolean.valueOf(this.enabled), Integer.valueOf(this.sendingIntervalMinutes), Integer.valueOf(this.minCountToSend), Integer.valueOf(this.types), Integer.valueOf(this.ief));
    }
}
