package com.startapp.networkTest.data;

import com.startapp.networkTest.enums.bluetooth.BluetoothBondStates;
import com.startapp.networkTest.enums.bluetooth.BluetoothDeviceClasses;
import com.startapp.networkTest.enums.bluetooth.BluetoothMajorDeviceClasses;
import com.startapp.networkTest.enums.bluetooth.BluetoothTypes;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class d {
    public String Answer;
    public int Index;
    public String Name = "";
    public BluetoothTypes Type = BluetoothTypes.Unknown;
    public BluetoothDeviceClasses DeviceClass = BluetoothDeviceClasses.Unknown;
    public BluetoothMajorDeviceClasses MajorDeviceClass = BluetoothMajorDeviceClasses.Unknown;
    public BluetoothBondStates BondState = BluetoothBondStates.Unknown;

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
