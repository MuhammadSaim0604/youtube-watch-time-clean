package com.startapp.networkTest.results;

import com.startapp.common.parser.d;
import com.startapp.networkTest.data.BatteryInfo;
import com.startapp.networkTest.data.IspInfo;
import com.startapp.networkTest.data.LocationInfo;
import com.startapp.networkTest.data.RadioInfo;
import com.startapp.networkTest.data.TimeInfo;
import com.startapp.networkTest.data.WifiInfo;
import com.startapp.networkTest.data.a;
import com.startapp.networkTest.data.b;
import com.startapp.networkTest.data.c;
import com.startapp.networkTest.data.e;
import com.startapp.networkTest.data.f;
import com.startapp.networkTest.data.radio.ApnInfo;
import com.startapp.networkTest.data.radio.CellInfo;
import com.startapp.networkTest.data.radio.NetworkRegistrationInfo;
import com.startapp.networkTest.enums.CtTestTypes;
import com.startapp.networkTest.enums.IdleStates;
import com.startapp.networkTest.enums.NetworkTypes;
import com.startapp.networkTest.enums.ScreenStates;
import com.startapp.networkTest.enums.voice.CallStates;
import java.util.ArrayList;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class ConnectivityTestResult extends BaseResult {
    public String AirportCode;
    public String AmazonId;
    @d(b = ArrayList.class, c = ApnInfo.class)
    public ArrayList<ApnInfo> ApnInfo;
    @d(a = true)
    public BatteryInfo BatteryInfo;
    public long BytesRead;
    public CallStates CallState;
    @d(b = ArrayList.class, c = CellInfo.class)
    public ArrayList<CellInfo> CellInfo;
    public String CtId;
    @d(a = true)
    public a DeviceInfo;
    public long DurationDNS;
    public long DurationHttpGetCommand;
    public long DurationHttpReceive;
    public long DurationOverall;
    public long DurationOverallNoSleep;
    public long DurationSSL;
    public long DurationTcpConnect;
    public String ErrorReason;
    public int HTTPStatus;
    public long HeaderBytesRead;
    public IdleStates IdleStateOnEnd;
    public IdleStates IdleStateOnStart;
    public boolean IsKeepAlive;
    @d(a = true)
    public IspInfo IspInfo;
    public boolean LocalhostPingSuccess;
    @d(a = true)
    public LocationInfo LocationInfo;
    @d(a = true)
    public b MemoryInfo;
    @d(b = ArrayList.class, c = c.class)
    public ArrayList<c> MultiCdnInfo;
    @d(b = ArrayList.class, c = NetworkRegistrationInfo.class)
    public ArrayList<NetworkRegistrationInfo> NetworkRegistrationInfo;
    @d(a = true)
    public RadioInfo RadioInfo;
    @d(a = true)
    public RadioInfo RadioInfoOnEnd;
    public ScreenStates ScreenState;
    public String ServerFilename;
    public String ServerHostname;
    public String ServerIp;
    public long ServerMultiSuccess;
    @d(a = true)
    public com.startapp.networkTest.data.a.b SimInfo;
    public String SslException;
    @d(a = true)
    public e StorageInfo;
    public boolean Success;
    public String TestTimestamp;
    public CtTestTypes TestType;
    @d(a = true)
    public TimeInfo TimeInfo;
    @d(a = true)
    public f TrafficInfo;
    public long TruststoreTimestamp;
    public NetworkTypes VoiceNetworkType;
    @d(a = true)
    public WifiInfo WifiInfo;

    public ConnectivityTestResult(String str, String str2) {
        super(str, str2);
        this.CtId = "";
        this.TestTimestamp = "";
        this.DurationDNS = -1L;
        this.DurationTcpConnect = -1L;
        this.DurationHttpGetCommand = -1L;
        this.DurationHttpReceive = -1L;
        this.DurationSSL = -1L;
        this.DurationOverall = -1L;
        this.DurationOverallNoSleep = -1L;
        this.ServerIp = "";
        this.Success = false;
        this.LocalhostPingSuccess = false;
        this.IsKeepAlive = false;
        this.ServerHostname = "";
        this.ServerFilename = "";
        this.BytesRead = -1L;
        this.HeaderBytesRead = -1L;
        this.HTTPStatus = -1;
        this.AmazonId = "";
        this.TestType = CtTestTypes.Unknown;
        this.ScreenState = ScreenStates.Unknown;
        this.IdleStateOnStart = IdleStates.Unknown;
        this.IdleStateOnEnd = IdleStates.Unknown;
        this.ErrorReason = "";
        this.SslException = "";
        this.CallState = CallStates.Unknown;
        this.VoiceNetworkType = NetworkTypes.Unknown;
        this.ServerMultiSuccess = -1L;
        this.AirportCode = "";
        this.BatteryInfo = new BatteryInfo();
        this.DeviceInfo = new a();
        this.LocationInfo = new LocationInfo();
        this.MemoryInfo = new b();
        this.RadioInfo = new RadioInfo();
        this.RadioInfoOnEnd = new RadioInfo();
        this.StorageInfo = new e();
        this.TrafficInfo = new f();
        this.WifiInfo = new WifiInfo();
        this.TimeInfo = new TimeInfo();
        this.IspInfo = new IspInfo();
        this.SimInfo = new com.startapp.networkTest.data.a.b();
        this.MultiCdnInfo = new ArrayList<>();
        this.CellInfo = new ArrayList<>();
        this.ApnInfo = new ArrayList<>();
        this.NetworkRegistrationInfo = new ArrayList<>();
    }
}
