package com.startapp.sdk.adsbase.b;

import android.bluetooth.BluetoothDevice;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    private Set<BluetoothDevice> a;
    private Set<BluetoothDevice> b;

    public final void a(BluetoothDevice bluetoothDevice) {
        if (this.b == null) {
            this.b = new HashSet();
        }
        this.b.add(bluetoothDevice);
    }

    public final void a(Set<BluetoothDevice> set) {
        this.a = set;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.a != null && this.a.size() > 0) {
                jSONObject.put("paired", b(this.a));
            }
            if (this.b != null && this.b.size() > 0) {
                jSONObject.put("available", b(this.b));
            }
        } catch (Exception e) {
        }
        if (jSONObject.length() > 0) {
            return jSONObject;
        }
        return null;
    }

    private static JSONArray b(Set<BluetoothDevice> set) {
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray();
            for (BluetoothDevice bluetoothDevice : set) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bluetoothClass", bluetoothDevice.getBluetoothClass().getDeviceClass());
                jSONObject.put("name", bluetoothDevice.getName());
                jSONObject.put("mac", bluetoothDevice.getAddress());
                jSONObject.put("bondState", bluetoothDevice.getBondState());
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
            jSONArray = null;
        }
        return jSONArray;
    }
}
