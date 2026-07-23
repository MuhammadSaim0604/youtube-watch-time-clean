package com.startapp.sdk.adsbase.remoteconfig;

import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class BaseSensorConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private int delay;
    private boolean enabled;
    private int minApiLevel;

    public BaseSensorConfig() {
        this.delay = 3;
        this.minApiLevel = 18;
        this.enabled = true;
    }

    public BaseSensorConfig(int i) {
        this.delay = 3;
        this.minApiLevel = 18;
        this.enabled = true;
        this.minApiLevel = i;
    }

    public final int a() {
        return this.delay;
    }

    public final int b() {
        return this.minApiLevel;
    }

    public final boolean c() {
        return this.enabled;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseSensorConfig baseSensorConfig = (BaseSensorConfig) obj;
        return this.delay == baseSensorConfig.delay && this.minApiLevel == baseSensorConfig.minApiLevel && this.enabled == baseSensorConfig.enabled;
    }

    public int hashCode() {
        return u.a(Integer.valueOf(this.delay), Integer.valueOf(this.minApiLevel), Boolean.valueOf(this.enabled));
    }
}
