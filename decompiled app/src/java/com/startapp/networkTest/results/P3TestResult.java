package com.startapp.networkTest.results;

import com.startapp.common.parser.d;
import com.startapp.networkTest.controller.c;
import com.startapp.networkTest.data.BatteryInfo;
import com.startapp.networkTest.data.LocationInfo;
import com.startapp.networkTest.data.RadioInfo;
import com.startapp.networkTest.data.TimeInfo;
import com.startapp.networkTest.data.WifiInfo;
import com.startapp.networkTest.data.a;
import com.startapp.networkTest.data.b;
import com.startapp.networkTest.data.f;
import com.startapp.networkTest.enums.ConnectionTypes;
import com.startapp.networkTest.enums.IpVersions;
import com.startapp.networkTest.enums.MeasurementTypes;
import com.startapp.networkTest.enums.NetworkGenerations;
import com.startapp.networkTest.enums.SpeedtestEndStates;
import com.startapp.networkTest.results.speedtest.MeasurementPointBase;
import com.startapp.networkTest.speedtest.SpeedtestEngineError;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class P3TestResult extends BaseResult {
    public int AvgValue;
    @d(a = true)
    public BatteryInfo BatteryInfoOnEnd;
    @d(a = true)
    public BatteryInfo BatteryInfoOnStart;
    public String CampaignId;
    public long ConnectingTimeControlServer;
    public long ConnectingTimeTestServerControl;
    public long ConnectingTimeTestServerSockets;
    public String CustomerID;
    @d(a = true)
    public a DeviceInfo;
    public String IMEI;
    public String IMSI;
    public IpVersions IpVersion;
    @d(a = true)
    public LocationInfo LocationInfoOnEnd;
    @d(a = true)
    public LocationInfo LocationInfoOnStart;
    public int MaxValue;
    public MeasurementTypes MeasurementType;
    public int MedValue;
    @d(a = true)
    public b MemoryInfoOnEnd;
    @d(a = true)
    public b MemoryInfoOnStart;
    public String Meta;
    public int MinValue;
    @d(b = ArrayList.class, c = com.startapp.networkTest.data.d.class)
    public ArrayList<com.startapp.networkTest.data.d> QuestionAnswerList;
    public String QuestionnaireName;
    @d(a = true)
    public RadioInfo RadioInfoOnEnd;
    @d(a = true)
    public RadioInfo RadioInfoOnStart;
    public double RatShare2G;
    public double RatShare3G;
    public double RatShare4G;
    public double RatShare5G;
    public double RatShareUnknown;
    public double RatShareWiFi;
    public String SequenceID;
    public String Server;
    public boolean Success;
    public SpeedtestEndStates TestEndState;
    public SpeedtestEngineError TestErrorReason;
    @d(a = true)
    public TimeInfo TimeInfoOnEnd;
    @d(a = true)
    public TimeInfo TimeInfoOnStart;
    @d(a = true)
    public f TrafficInfoOnEnd;
    @d(a = true)
    public f TrafficInfoOnStart;
    @d(a = true)
    public WifiInfo WifiInfoOnEnd;
    @d(a = true)
    public WifiInfo WifiInfoOnStart;

    public P3TestResult(String str, String str2) {
        super(str, str2);
        this.Server = "";
        this.IpVersion = IpVersions.Unknown;
        this.MeasurementType = MeasurementTypes.Unknown;
        this.QuestionnaireName = "";
        this.TestEndState = SpeedtestEndStates.Unknown;
        this.TestErrorReason = SpeedtestEngineError.OK;
        this.ConnectingTimeControlServer = -1L;
        this.ConnectingTimeTestServerControl = -1L;
        this.ConnectingTimeTestServerSockets = -1L;
        this.IMSI = "";
        this.IMEI = "";
        this.Meta = "";
        this.CampaignId = "";
        this.CustomerID = "";
        this.SequenceID = "";
        this.TimeInfoOnStart = new TimeInfo();
        this.TimeInfoOnEnd = new TimeInfo();
        this.QuestionAnswerList = new ArrayList<>();
        this.BatteryInfoOnEnd = new BatteryInfo();
        this.BatteryInfoOnStart = new BatteryInfo();
        this.LocationInfoOnEnd = new LocationInfo();
        this.LocationInfoOnStart = new LocationInfo();
        this.MemoryInfoOnEnd = new b();
        this.MemoryInfoOnStart = new b();
        this.RadioInfoOnEnd = new RadioInfo();
        this.RadioInfoOnStart = new RadioInfo();
        this.TrafficInfoOnEnd = new f();
        this.TrafficInfoOnStart = new f();
        this.WifiInfoOnEnd = new WifiInfo();
        this.WifiInfoOnStart = new WifiInfo();
        this.DeviceInfo = new a();
    }

    public final void b(ArrayList<? extends MeasurementPointBase> arrayList) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        Iterator<? extends MeasurementPointBase> it = arrayList.iterator();
        while (it.hasNext()) {
            MeasurementPointBase next = it.next();
            if (next.ConnectionType == ConnectionTypes.Unknown) {
                i++;
            } else if (next.ConnectionType == ConnectionTypes.Mobile) {
                NetworkGenerations a = c.a(next.NetworkType);
                if (next.NrState.equals("CONNECTED")) {
                    a = NetworkGenerations.Gen5;
                }
                switch (a) {
                    case Gen2:
                        i2++;
                        continue;
                    case Gen3:
                        i3++;
                        continue;
                    case Gen4:
                        i4++;
                        continue;
                    case Gen5:
                        i5++;
                        continue;
                    default:
                        i++;
                        continue;
                }
            } else {
                i6++;
            }
            i7++;
        }
        if (i7 > 0) {
            this.RatShare2G = i2 / i7;
            this.RatShare3G = i3 / i7;
            this.RatShare4G = i4 / i7;
            this.RatShare5G = i5 / i7;
            this.RatShareWiFi = i6 / i7;
            this.RatShareUnknown = i / i7;
        }
    }
}
