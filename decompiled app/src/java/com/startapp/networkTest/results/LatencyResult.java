package com.startapp.networkTest.results;

import com.iab.omid.library.startapp.b;
import com.startapp.common.parser.d;
import com.startapp.networkTest.enums.ScreenStates;
import com.startapp.networkTest.results.speedtest.MeasurementPointLatency;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class LatencyResult extends P3TestResult {
    public String AirportCode;
    public long DurationOverall;
    public long DurationOverallNoSleep;
    public double Jitter;
    public String LtrId;
    @d(b = ArrayList.class, c = MeasurementPointLatency.class)
    public ArrayList<MeasurementPointLatency> MeasurementPoints;
    public int Pause;
    public int Pings;
    public ScreenStates ScreenStateOnEnd;
    public ScreenStates ScreenStateOnStart;
    public int SuccessfulPings;

    public LatencyResult(String str, String str2) {
        super(str, str2);
        this.LtrId = "";
        this.DurationOverall = -1L;
        this.DurationOverallNoSleep = -1L;
        this.ScreenStateOnStart = ScreenStates.Unknown;
        this.ScreenStateOnEnd = ScreenStates.Unknown;
        this.AirportCode = "";
        this.MeasurementPoints = new ArrayList<>();
    }

    public final void a(ArrayList<MeasurementPointLatency> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).Rtt != -1) {
                arrayList2.add(Integer.valueOf(arrayList.get(i).Rtt));
            }
        }
        this.MinValue = b.e(arrayList2);
        this.MaxValue = b.f(arrayList2);
        this.AvgValue = b.d(arrayList2);
        this.MedValue = b.c(arrayList2);
        this.Jitter = b.b((List<Integer>) arrayList2);
        this.MeasurementPoints = arrayList;
    }
}
