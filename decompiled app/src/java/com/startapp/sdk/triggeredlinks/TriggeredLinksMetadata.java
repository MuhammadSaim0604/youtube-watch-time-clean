package com.startapp.sdk.triggeredlinks;

import com.startapp.common.parser.d;
import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class TriggeredLinksMetadata implements Serializable {
    private static final long serialVersionUID = 1082253451843108611L;
    @d(a = true, f = "AppEvents")
    private AppEventsMetadata appEvents;
    private int ief;
    @d(b = ArrayList.class, c = Integer.class, f = "ThrottlingPublisherIDs")
    private List<Integer> throttlingPublisherIDs;
    private boolean enabled = true;
    private int smartRedirectTimeoutInSec = 10;
    private boolean triggeredLinkInfoEvent = true;

    public final boolean a() {
        return this.enabled;
    }

    public final int b() {
        return this.smartRedirectTimeoutInSec;
    }

    public final boolean c() {
        return this.triggeredLinkInfoEvent;
    }

    public final AppEventsMetadata d() {
        return this.appEvents;
    }

    public final List<Integer> e() {
        return this.throttlingPublisherIDs;
    }

    public final int f() {
        return this.ief;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TriggeredLinksMetadata triggeredLinksMetadata = (TriggeredLinksMetadata) obj;
        return this.enabled == triggeredLinksMetadata.enabled && this.smartRedirectTimeoutInSec == triggeredLinksMetadata.smartRedirectTimeoutInSec && this.triggeredLinkInfoEvent == triggeredLinksMetadata.triggeredLinkInfoEvent && this.ief == triggeredLinksMetadata.ief && u.b(this.appEvents, triggeredLinksMetadata.appEvents) && u.b(this.throttlingPublisherIDs, triggeredLinksMetadata.throttlingPublisherIDs);
    }

    public int hashCode() {
        return u.a(Boolean.valueOf(this.enabled), Integer.valueOf(this.smartRedirectTimeoutInSec), Boolean.valueOf(this.triggeredLinkInfoEvent), this.appEvents, this.throttlingPublisherIDs, Integer.valueOf(this.ief));
    }
}
