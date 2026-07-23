package com.startapp.networkTest.data.radio;

import com.startapp.networkTest.enums.ThreeStateShort;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class NetworkRegistrationInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 9179460790954950419L;
    public String TransportType = "";
    public String Domain = "";
    public String RegState = "";
    public String NetworkTechnology = "";
    public String ReasonForDenial = "";
    public boolean EmergencyEnabled = false;
    public ThreeStateShort CarrierAggregation = ThreeStateShort.Unknown;
    public String CellTechnology = "";
    public String CellId = "";
    public String Tac = "";
    public String Pci = "";
    public int Arfcn = -1;
    public int Bandwidth = -1;
    public String Mcc = "";
    public String Mnc = "";
    public String OperatorLong = "";
    public String OperatorShort = "";
    public int MaxDataCalls = -1;
    public String AvailableServices = "";
    public String NrState = "Unknown";
    public ThreeStateShort DcNrRestricted = ThreeStateShort.Unknown;
    public ThreeStateShort NrAvailable = ThreeStateShort.Unknown;
    public ThreeStateShort EnDcAvailable = ThreeStateShort.Unknown;
    public int Age = -1;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
