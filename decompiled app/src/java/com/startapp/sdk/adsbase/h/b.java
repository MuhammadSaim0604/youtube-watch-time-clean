package com.startapp.sdk.adsbase.h;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.startapp.common.d;
import com.startapp.sdk.adsbase.remoteconfig.BaseSensorConfig;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.SensorsConfig;
import java.util.HashMap;
import org.json.JSONArray;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b {
    protected d b;
    private HashMap<Integer, a> c;
    private SensorManager d;
    private SensorEventListener f = new SensorEventListener() { // from class: com.startapp.sdk.adsbase.h.b.1
        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (b.this.a.a(sensorEvent) == b.this.e) {
                b.this.b();
                if (b.this.b != null) {
                    b.this.b.a(b.this.c());
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    protected com.startapp.sdk.adsbase.h.a a = new com.startapp.sdk.adsbase.h.a();
    private int e = 0;

    public b(Context context, d dVar) {
        this.c = null;
        this.d = (SensorManager) context.getSystemService("sensor");
        this.b = dVar;
        this.c = new HashMap<>();
        SensorsConfig A = MetaData.E().A();
        a(13, A.b());
        a(9, A.c());
        a(5, A.d());
        a(10, A.e());
        a(2, A.f());
        a(6, A.g());
        a(12, A.h());
        a(11, A.i());
        a(16, A.j());
    }

    public final void a() {
        Sensor defaultSensor;
        for (Integer num : this.c.keySet()) {
            int intValue = num.intValue();
            a aVar = this.c.get(Integer.valueOf(intValue));
            if (Build.VERSION.SDK_INT >= aVar.a() && (defaultSensor = this.d.getDefaultSensor(intValue)) != null) {
                this.d.registerListener(this.f, defaultSensor, aVar.b());
                this.e++;
            }
        }
    }

    public final void b() {
        this.d.unregisterListener(this.f);
    }

    public final JSONArray c() {
        try {
            return this.a.a();
        } catch (Exception e) {
            return null;
        }
    }

    private void a(int i, BaseSensorConfig baseSensorConfig) {
        if (baseSensorConfig.c()) {
            this.c.put(Integer.valueOf(i), new a(baseSensorConfig.b(), baseSensorConfig.a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public class a {
        private int a;
        private int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }
    }
}
