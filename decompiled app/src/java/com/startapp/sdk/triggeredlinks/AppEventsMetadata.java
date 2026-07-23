package com.startapp.sdk.triggeredlinks;

import com.startapp.common.parser.d;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class AppEventsMetadata implements Serializable {
    private static final long serialVersionUID = -5670027899854165615L;
    @d(b = HashMap.class)
    private Map<String, String> active;
    @d(b = HashMap.class)
    private Map<String, String> inactive;
    @d(b = HashMap.class)
    private Map<String, String> launch;
    @d(b = HashMap.class, c = PeriodicAppEventMetadata.class)
    private Map<String, PeriodicAppEventMetadata> periodic;

    public final Map<String, String> a() {
        return this.launch;
    }

    public final Map<String, String> b() {
        return this.active;
    }

    public final Map<String, String> c() {
        return this.inactive;
    }

    public final Map<String, PeriodicAppEventMetadata> d() {
        return this.periodic;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppEventsMetadata appEventsMetadata = (AppEventsMetadata) obj;
        if (this.launch == null ? appEventsMetadata.launch != null : !this.launch.equals(appEventsMetadata.launch)) {
            return false;
        }
        if (this.active == null ? appEventsMetadata.active != null : !this.active.equals(appEventsMetadata.active)) {
            return false;
        }
        if (this.inactive == null ? appEventsMetadata.inactive != null : !this.inactive.equals(appEventsMetadata.inactive)) {
            return false;
        }
        if (this.periodic != null) {
            return this.periodic.equals(appEventsMetadata.periodic);
        }
        return appEventsMetadata.periodic == null;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int hashCode = (this.launch != null ? this.launch.hashCode() : 0) * 31;
        if (this.active != null) {
            i = this.active.hashCode();
        } else {
            i = 0;
        }
        int i4 = (hashCode + i) * 31;
        if (this.inactive != null) {
            i2 = this.inactive.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (i4 + i2) * 31;
        if (this.periodic != null) {
            i3 = this.periodic.hashCode();
        } else {
            i3 = 0;
        }
        return i5 + i3;
    }
}
