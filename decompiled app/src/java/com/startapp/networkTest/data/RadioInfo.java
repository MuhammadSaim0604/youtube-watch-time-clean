package com.startapp.networkTest.data;

import com.startapp.networkTest.data.radio.NeighboringCell;
import com.startapp.networkTest.enums.ConnectionTypes;
import com.startapp.networkTest.enums.DuplexMode;
import com.startapp.networkTest.enums.FlightModeStates;
import com.startapp.networkTest.enums.NetworkTypes;
import com.startapp.networkTest.enums.PreferredNetworkTypes;
import com.startapp.networkTest.enums.ServiceStates;
import com.startapp.networkTest.enums.ThreeState;
import com.startapp.networkTest.enums.ThreeStateShort;
import com.startapp.networkTest.enums.radio.DataConnectionStates;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class RadioInfo implements Serializable, Cloneable {
    public static final Integer INVALID = Integer.MAX_VALUE;
    private static final long serialVersionUID = 4817753379835440169L;
    public int RXLevel;
    public transient boolean IsDefaultDataSim = true;
    public transient boolean IsDefaultVoiceSim = true;
    public NetworkTypes NetworkType = NetworkTypes.Unknown;
    public ServiceStates ServiceState = ServiceStates.Unknown;
    public String GsmLAC = "";
    public String GsmCellId = "";
    public int GsmCellIdAge = -1;
    public String CdmaBaseStationId = "";
    public String CdmaBaseStationLatitude = "";
    public String CdmaBaseStationLongitude = "";
    public String CdmaSystemId = "";
    public String CdmaNetworkId = "";
    public int CdmaEcIo = INVALID.intValue();
    public int NativeDbm = INVALID.intValue();
    public int RXLevelAge = -1;
    public String MCC = "";
    public String MNC = "";
    public FlightModeStates FlightMode = FlightModeStates.Unknown;
    public ConnectionTypes ConnectionType = ConnectionTypes.Unknown;
    public String OperatorName = "";
    public int RSCP = INVALID.intValue();
    public int ARFCN = -1;
    public int EcN0 = 0;
    public String PrimaryScramblingCode = "";
    public int LteCqi = INVALID.intValue();
    public int LteRsrp = INVALID.intValue();
    public int LteRsrq = INVALID.intValue();
    public int LteRssnr = INVALID.intValue();
    public int LteRssi = INVALID.intValue();
    public int NrCsiRsrp = INVALID.intValue();
    public int NrCsiRsrq = INVALID.intValue();
    public int NrCsiSinr = INVALID.intValue();
    public int NrSsRsrp = INVALID.intValue();
    public int NrSsRsrq = INVALID.intValue();
    public int NrSsSinr = INVALID.intValue();
    public String NrState = "Unknown";
    public ThreeStateShort NrAvailable = ThreeStateShort.Unknown;
    public boolean IsRoaming = false;
    public ThreeStateShort IsMetered = ThreeStateShort.Unknown;
    public ThreeState MobileDataEnabled = ThreeState.Unknown;
    public DataConnectionStates MobileDataConnectionState = DataConnectionStates.Unknown;
    public boolean MissingPermission = false;
    public int SubscriptionId = -1;
    public PreferredNetworkTypes PreferredNetwork = PreferredNetworkTypes.Unknown;
    public DuplexMode DuplexMode = DuplexMode.Unknown;
    public ThreeStateShort ManualSelection = ThreeStateShort.Unknown;
    public ThreeStateShort CarrierAggregation = ThreeStateShort.Unknown;
    public int ServiceStateAge = -1;
    public int IsVpn = -1;
    @com.startapp.common.parser.d(b = ArrayList.class, c = NeighboringCell.class)
    public ArrayList<NeighboringCell> NeighboringCells = new ArrayList<>();

    public Object clone() throws CloneNotSupportedException {
        RadioInfo radioInfo = (RadioInfo) super.clone();
        radioInfo.NeighboringCells = new ArrayList<>();
        Iterator<NeighboringCell> it = this.NeighboringCells.iterator();
        while (it.hasNext()) {
            radioInfo.NeighboringCells.add((NeighboringCell) it.next().clone());
        }
        return radioInfo;
    }
}
