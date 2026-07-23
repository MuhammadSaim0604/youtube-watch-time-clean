package com.startapp.sdk.adsbase.infoevents;

import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AnalyticsConfig implements Serializable {
    private static final String a = "https://infoevent.startappservice.com/tracking/infoEvent";
    private static final long serialVersionUID = 1;
    public String hostSecured = a;
    public String hostPeriodic = a;
    public boolean dns = false;
    private int retryNum = 3;
    private int retryTime = 10;
    private float succeededSmartRedirectInfoProbability = 0.01f;
    private boolean sendHopsOnFirstSucceededSmartRedirect = false;

    public final String a() {
        return this.hostPeriodic != null ? this.hostPeriodic : a;
    }

    public final int b() {
        return this.retryNum;
    }

    public final long c() {
        return TimeUnit.SECONDS.toMillis(this.retryTime);
    }

    public final float d() {
        return this.succeededSmartRedirectInfoProbability;
    }

    public final boolean e() {
        return this.sendHopsOnFirstSucceededSmartRedirect;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AnalyticsConfig analyticsConfig = (AnalyticsConfig) obj;
        return this.dns == analyticsConfig.dns && this.retryNum == analyticsConfig.retryNum && this.retryTime == analyticsConfig.retryTime && Float.compare(analyticsConfig.succeededSmartRedirectInfoProbability, this.succeededSmartRedirectInfoProbability) == 0 && this.sendHopsOnFirstSucceededSmartRedirect == analyticsConfig.sendHopsOnFirstSucceededSmartRedirect && u.b(this.hostSecured, analyticsConfig.hostSecured) && u.b(this.hostPeriodic, analyticsConfig.hostPeriodic);
    }

    public int hashCode() {
        return u.a(this.hostSecured, this.hostPeriodic, Boolean.valueOf(this.dns), Integer.valueOf(this.retryNum), Integer.valueOf(this.retryTime), Float.valueOf(this.succeededSmartRedirectInfoProbability), Boolean.valueOf(this.sendHopsOnFirstSucceededSmartRedirect));
    }
}
