package com.startapp.networkTest.data.radio;

import com.startapp.networkTest.enums.NetworkTypes;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class NeighboringCell implements Serializable, Cloneable {
    private static final long serialVersionUID = 341410194515647516L;
    public int RXLevel;
    public NetworkTypes NetworkType = NetworkTypes.Unknown;
    public String GsmLAC = "";
    public String GsmCellId = "";
    public String PrimaryScramblingCode = "";
    public int ARFCN = -1;
    public int EcN0 = 0;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
