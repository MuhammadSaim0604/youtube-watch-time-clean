package com.startapp.sdk.adsbase.h;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    private HashMap<Integer, SensorEvent> a = new HashMap<>();

    public final int a(SensorEvent sensorEvent) {
        int size;
        synchronized (this) {
            int type = sensorEvent.sensor.getType();
            SensorEvent sensorEvent2 = this.a.get(Integer.valueOf(type));
            if (sensorEvent2 == null || sensorEvent2.accuracy <= sensorEvent.accuracy) {
                this.a.put(Integer.valueOf(type), sensorEvent);
            }
            size = this.a.size();
        }
        return size;
    }

    public final JSONArray a() throws JSONException {
        float[] fArr;
        JSONArray jSONArray = new JSONArray();
        for (SensorEvent sensorEvent : this.a.values()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            Sensor sensor = sensorEvent.sensor;
            jSONObject2.put("name", sensor.getName());
            jSONObject2.put("vendor", sensor.getVendor());
            jSONObject2.put("version", sensor.getVersion());
            jSONObject2.put("maximum range", sensor.getMaximumRange());
            jSONObject2.put("power", sensor.getPower());
            jSONObject2.put("resolution", sensor.getResolution());
            jSONObject2.put("accuracy", sensorEvent.accuracy);
            jSONObject2.put("timestamp", sensorEvent.timestamp);
            JSONArray jSONArray2 = new JSONArray();
            int length = sensorEvent.values.length;
            for (int i = 0; i < length; i++) {
                jSONArray2.put(fArr[i]);
            }
            jSONObject2.put("values", jSONArray2);
            jSONObject.put(String.valueOf(sensor.getType()), jSONObject2);
            jSONArray.put(jSONObject);
        }
        if (jSONArray.length() > 0) {
            return jSONArray;
        }
        return null;
    }
}
