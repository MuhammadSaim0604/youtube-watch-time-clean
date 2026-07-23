package com.startapp.networkTest.data;

import com.startapp.networkTest.enums.Os;
import com.startapp.networkTest.enums.PhoneTypes;
import com.startapp.networkTest.enums.SimStates;
import com.startapp.networkTest.enums.ThreeState;
import com.startapp.sdk.adsbase.j.j;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a implements Cloneable {
    public long DeviceUpTime;
    public boolean IsRooted;
    public String DeviceManufacturer = "";
    public String DeviceName = "";
    public String SimOperator = "";
    public String SimOperatorName = "";
    public SimStates SimState = SimStates.Unknown;
    public Os OS = Os.Android;
    public String OSVersion = "";
    public String TAC = "";
    public String BuildFingerprint = "";
    public String OsSystemVersion = "";
    public String UserLocal = "";
    public int PhoneCount = -1;
    public ThreeState PowerSaveMode = ThreeState.Unknown;
    public PhoneTypes PhoneType = PhoneTypes.Unknown;
    @com.startapp.common.parser.d(a = true)
    public com.startapp.sdk.adsbase.g.a BluetoothInfo$3e5b9058 = new com.startapp.sdk.adsbase.g.a();
    @com.startapp.common.parser.d(a = true)
    public com.startapp.networkTest.data.a.a MultiSimInfo = new com.startapp.networkTest.data.a.a();
    @com.startapp.common.parser.d(a = true)
    public j HostAppInfo$41202ccd = new j();

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
