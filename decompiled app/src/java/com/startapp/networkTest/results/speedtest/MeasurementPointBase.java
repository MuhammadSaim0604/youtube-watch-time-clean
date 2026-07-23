package com.startapp.networkTest.results.speedtest;

import com.startapp.networkTest.enums.ConnectionTypes;
import com.startapp.networkTest.enums.NetworkTypes;
import com.startapp.networkTest.enums.ThreeStateShort;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class MeasurementPointBase implements Cloneable {
    public long Delta;
    public int RxLev;
    public ConnectionTypes ConnectionType = ConnectionTypes.Unknown;
    public NetworkTypes NetworkType = NetworkTypes.Unknown;
    public String NrState = "Unknown";
    public ThreeStateShort NrAvailable = ThreeStateShort.Unknown;

    /* JADX INFO: Access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
