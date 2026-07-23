package com.startapp.sdk.triggeredlinks;

import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class PeriodicAppEventMetadata implements Serializable {
    private static final long serialVersionUID = -3371103410620683752L;
    private int intervalInSeconds;
    private String url;

    public final String a() {
        return this.url;
    }

    public final int b() {
        return this.intervalInSeconds;
    }

    public String toString() {
        return super.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PeriodicAppEventMetadata periodicAppEventMetadata = (PeriodicAppEventMetadata) obj;
        if (this.intervalInSeconds != periodicAppEventMetadata.intervalInSeconds) {
            return false;
        }
        if (this.url != null) {
            return this.url.equals(periodicAppEventMetadata.url);
        }
        return periodicAppEventMetadata.url == null;
    }

    public int hashCode() {
        return ((this.url != null ? this.url.hashCode() : 0) * 31) + this.intervalInSeconds;
    }
}
