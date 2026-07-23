package com.startapp.sdk.adsbase.remoteconfig;

import android.content.Context;
import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class BluetoothConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private int timeoutInSec = 20;
    private boolean enabled = false;
    private int discoveryIntervalInMinutes = 1440;

    public final int a() {
        return this.timeoutInSec;
    }

    public final boolean a(Context context) {
        return this.enabled && com.startapp.sdk.b.c.a(context).f().g();
    }

    public final int b() {
        return this.discoveryIntervalInMinutes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BluetoothConfig bluetoothConfig = (BluetoothConfig) obj;
        return this.timeoutInSec == bluetoothConfig.timeoutInSec && this.enabled == bluetoothConfig.enabled && this.discoveryIntervalInMinutes == bluetoothConfig.discoveryIntervalInMinutes;
    }

    public int hashCode() {
        return u.a(Integer.valueOf(this.timeoutInSec), Boolean.valueOf(this.enabled), Integer.valueOf(this.discoveryIntervalInMinutes));
    }
}
