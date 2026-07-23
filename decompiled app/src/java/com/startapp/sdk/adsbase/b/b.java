package com.startapp.sdk.adsbase.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.startapp.common.d;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b {
    protected d a;
    protected a b = new a();
    private Context c;
    private BluetoothAdapter d;
    private BroadcastReceiver e;

    public b(Context context, d dVar) {
        BluetoothAdapter bluetoothAdapter;
        this.c = context;
        this.a = dVar;
        if (com.startapp.common.b.b.a(this.c, "android.permission.BLUETOOTH")) {
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        } else {
            bluetoothAdapter = null;
        }
        this.d = bluetoothAdapter;
    }

    public final void a(boolean z) {
        if (this.d != null && this.d.isEnabled()) {
            this.b.a(c());
            if (!z || !com.startapp.common.b.b.a(this.c, "android.permission.BLUETOOTH_ADMIN")) {
                this.a.a(b());
                return;
            }
            IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.FOUND");
            this.e = new BroadcastReceiver() { // from class: com.startapp.sdk.adsbase.b.b.1
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    if ("android.bluetooth.device.action.FOUND".equals(action)) {
                        b.this.b.a((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"));
                    } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                        b.this.a();
                        b.this.a.a(b.this.b());
                    }
                }
            };
            try {
                this.c.registerReceiver(this.e, intentFilter);
                this.d.startDiscovery();
                return;
            } catch (Exception e) {
                new StringBuilder("BluetoothManager - start() ").append(e.getMessage());
                this.d.cancelDiscovery();
                this.a.a(b());
                return;
            }
        }
        this.a.a(null);
    }

    public final void a() {
        if (com.startapp.common.b.b.a(this.c, "android.permission.BLUETOOTH_ADMIN") && this.e != null && this.d != null) {
            this.d.cancelDiscovery();
            try {
                this.c.unregisterReceiver(this.e);
            } catch (Exception e) {
                new StringBuilder("BluetoothManager - stop() ").append(e.getMessage());
            }
            this.e = null;
        }
    }

    private Set<BluetoothDevice> c() {
        HashSet hashSet = new HashSet();
        try {
            if (com.startapp.common.b.b.a(this.c, "android.permission.BLUETOOTH") && this.d.isEnabled()) {
                return this.d.getBondedDevices();
            }
        } catch (Exception e) {
            new StringBuilder("Unable to get devices ").append(e.getMessage());
        }
        return hashSet;
    }

    public final JSONObject b() {
        try {
            return this.b.a();
        } catch (Exception e) {
            return null;
        }
    }
}
