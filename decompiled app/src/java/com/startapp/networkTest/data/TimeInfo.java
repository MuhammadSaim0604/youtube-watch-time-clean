package com.startapp.networkTest.data;

import com.startapp.networkTest.enums.TimeSources;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class TimeInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 3793653153982296400L;
    public long DeviceDriftMillis;
    public boolean IsSynced;
    public long MillisSinceLastSync;
    public long TimestampMillis;
    public double TimestampOffset;
    public transient int day;
    public transient int hour;
    public transient int millisecond;
    public transient int minute;
    public transient int month;
    public transient int second;
    public transient int year;
    public String TimestampTableau = "";
    public String TimestampDateTime = "";
    public TimeSources TimeSource = TimeSources.Unknown;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
