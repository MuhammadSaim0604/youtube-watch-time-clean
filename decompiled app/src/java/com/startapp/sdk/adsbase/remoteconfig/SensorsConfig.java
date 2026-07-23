package com.startapp.sdk.adsbase.remoteconfig;

import android.content.Context;
import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class SensorsConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private int timeoutInSec = 10;
    private boolean enabled = false;
    @com.startapp.common.parser.d(a = true)
    private BaseSensorConfig ambientTemperatureSensor = new BaseSensorConfig(14);
    @com.startapp.common.parser.d(a = true)
    private BaseSensorConfig gravitySensor = new BaseSensorConfig(9);
    @com.startapp.common.parser.d(a = true)
    private BaseSensorConfig lightSensor = new BaseSensorConfig(3);
    @com.startapp.common.parser.d(a = true)
    private BaseSensorConfig linearAccelerationSensor = new BaseSensorConfig(9);
    @com.startapp.common.parser.d(a = true)
    private BaseSensorConfig magneticFieldSensor = new BaseSensorConfig(3);
    @com.startapp.common.parser.d(a = true)
    private BaseSensorConfig pressureSensor = new BaseSensorConfig(9);
    @com.startapp.common.parser.d(a = true)
    private BaseSensorConfig relativeHumiditySensor = new BaseSensorConfig(14);
    @com.startapp.common.parser.d(a = true)
    private BaseSensorConfig rotationVectorSensor = new BaseSensorConfig(9);
    @com.startapp.common.parser.d(a = true)
    private BaseSensorConfig gyroscopeUncalibratedSensor = new BaseSensorConfig(18);

    public final int a() {
        return this.timeoutInSec;
    }

    public final boolean a(Context context) {
        return this.enabled && com.startapp.sdk.b.c.a(context).f().g();
    }

    public final BaseSensorConfig b() {
        return this.ambientTemperatureSensor;
    }

    public final BaseSensorConfig c() {
        return this.gravitySensor;
    }

    public final BaseSensorConfig d() {
        return this.lightSensor;
    }

    public final BaseSensorConfig e() {
        return this.linearAccelerationSensor;
    }

    public final BaseSensorConfig f() {
        return this.magneticFieldSensor;
    }

    public final BaseSensorConfig g() {
        return this.pressureSensor;
    }

    public final BaseSensorConfig h() {
        return this.relativeHumiditySensor;
    }

    public final BaseSensorConfig i() {
        return this.rotationVectorSensor;
    }

    public final BaseSensorConfig j() {
        return this.gyroscopeUncalibratedSensor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SensorsConfig sensorsConfig = (SensorsConfig) obj;
        return this.timeoutInSec == sensorsConfig.timeoutInSec && this.enabled == sensorsConfig.enabled && u.b(this.ambientTemperatureSensor, sensorsConfig.ambientTemperatureSensor) && u.b(this.gravitySensor, sensorsConfig.gravitySensor) && u.b(this.lightSensor, sensorsConfig.lightSensor) && u.b(this.linearAccelerationSensor, sensorsConfig.linearAccelerationSensor) && u.b(this.magneticFieldSensor, sensorsConfig.magneticFieldSensor) && u.b(this.pressureSensor, sensorsConfig.pressureSensor) && u.b(this.relativeHumiditySensor, sensorsConfig.relativeHumiditySensor) && u.b(this.rotationVectorSensor, sensorsConfig.rotationVectorSensor) && u.b(this.gyroscopeUncalibratedSensor, sensorsConfig.gyroscopeUncalibratedSensor);
    }

    public int hashCode() {
        return u.a(Integer.valueOf(this.timeoutInSec), Boolean.valueOf(this.enabled), this.ambientTemperatureSensor, this.gravitySensor, this.lightSensor, this.linearAccelerationSensor, this.magneticFieldSensor, this.pressureSensor, this.relativeHumiditySensor, this.rotationVectorSensor, this.gyroscopeUncalibratedSensor);
    }
}
