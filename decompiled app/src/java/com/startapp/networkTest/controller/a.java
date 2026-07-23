package com.startapp.networkTest.controller;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.util.Log;
import com.startapp.networkTest.data.BatteryInfo;
import com.startapp.networkTest.enums.BatteryChargePlugTypes;
import com.startapp.networkTest.enums.BatteryHealthStates;
import com.startapp.networkTest.enums.BatteryStatusStates;
import com.startapp.networkTest.utils.h;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    private static final String a = a.class.getSimpleName();
    private BatteryManager b;
    private Context c;

    public a(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b = (BatteryManager) context.getSystemService("batterymanager");
        }
        this.c = context;
    }

    public final BatteryInfo a() {
        BatteryChargePlugTypes batteryChargePlugTypes;
        BatteryHealthStates batteryHealthStates;
        Intent intent = null;
        try {
            intent = this.c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.e(a, e.getMessage(), e);
        }
        BatteryInfo batteryInfo = new BatteryInfo();
        if (intent == null) {
            batteryInfo.MissingPermission = true;
            return batteryInfo;
        }
        int intExtra = intent.getIntExtra("status", 1);
        BatteryStatusStates batteryStatusStates = BatteryStatusStates.Unknown;
        switch (intExtra) {
            case 1:
                batteryStatusStates = BatteryStatusStates.Unknown;
                break;
            case 2:
                batteryStatusStates = BatteryStatusStates.Charging;
                break;
            case 3:
                batteryStatusStates = BatteryStatusStates.Discharging;
                break;
            case 4:
                batteryStatusStates = BatteryStatusStates.NotCharging;
                break;
            case 5:
                batteryStatusStates = BatteryStatusStates.Full;
                break;
        }
        batteryInfo.BatteryStatus = batteryStatusStates;
        switch (intent.getIntExtra("plugged", -1)) {
            case 1:
                batteryChargePlugTypes = BatteryChargePlugTypes.AC;
                break;
            case 2:
                batteryChargePlugTypes = BatteryChargePlugTypes.USB;
                break;
            case 3:
            default:
                batteryChargePlugTypes = BatteryChargePlugTypes.Unknown;
                break;
            case 4:
                batteryChargePlugTypes = BatteryChargePlugTypes.Wireless;
                break;
        }
        batteryInfo.BatteryChargePlug = batteryChargePlugTypes;
        batteryInfo.BatteryLevel = (intent.getIntExtra("level", -1) / intent.getIntExtra("scale", -1)) * 100.0f;
        switch (intent.getIntExtra("health", -1)) {
            case 2:
                batteryHealthStates = BatteryHealthStates.Good;
                break;
            case 3:
                batteryHealthStates = BatteryHealthStates.Overheat;
                break;
            case 4:
                batteryHealthStates = BatteryHealthStates.Dead;
                break;
            case 5:
                batteryHealthStates = BatteryHealthStates.OverVoltage;
                break;
            case 6:
            default:
                batteryHealthStates = BatteryHealthStates.Unknown;
                break;
            case 7:
                batteryHealthStates = BatteryHealthStates.Cold;
                break;
        }
        batteryInfo.BatteryHealth = batteryHealthStates;
        int intExtra2 = intent.getIntExtra("temperature", -1);
        if (intExtra2 >= 0) {
            batteryInfo.BatteryTemp = new StringBuilder().append(intExtra2 / 10.0f).toString();
        }
        int intExtra3 = intent.getIntExtra("voltage", -1);
        if (intExtra3 >= 0) {
            batteryInfo.BatteryVoltage = intExtra3;
        }
        batteryInfo.BatteryTechnology = h.a(intent.getStringExtra("technology"));
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                if (this.b != null) {
                    int intProperty = this.b.getIntProperty(1);
                    if (intProperty != Integer.MIN_VALUE) {
                        batteryInfo.BatteryCapacity = intProperty;
                    }
                    int intProperty2 = this.b.getIntProperty(2);
                    if (intProperty2 != Integer.MIN_VALUE) {
                        batteryInfo.BatteryCurrent = intProperty2;
                    }
                    long longProperty = this.b.getLongProperty(5);
                    if (longProperty != Long.MIN_VALUE) {
                        batteryInfo.BatteryRemainingEnergy = longProperty;
                    }
                }
            } catch (Exception e2) {
                Log.e(a, e2.toString());
            }
        }
        return batteryInfo;
    }
}
