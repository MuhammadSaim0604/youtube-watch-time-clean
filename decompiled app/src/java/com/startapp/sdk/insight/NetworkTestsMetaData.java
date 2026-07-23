package com.startapp.sdk.insight;

import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class NetworkTestsMetaData implements Serializable {
    private static final long serialVersionUID = 1;
    private String hostCt;
    private String hostLt;
    private String hostNir;
    private int numberOfRecordsMin = 5000;
    private int numberOfRecordsMax = 10000;
    private boolean enabled = false;
    private String projectId = "20050";
    private String connectivityTestHostname = "d2to8y50b3n6dq.cloudfront.net";
    private String connectivityTestFilename = "/favicon.ico";
    private boolean connectivityTestEnabled = true;
    private boolean nirCollectCellinfoEnabled = true;
    private boolean ctCollectCellinfoEnabled = true;
    private String connectivityTestCdnconfigUrl = "https://d2to8y50b3n6dq.cloudfront.net/truststores/[PROJECTID]/cdnconfig.zip";
    private String geoipUrl = "https://geoip.api.p3insight.de/geoip/";
    private long ctltIntervalMilli = 900000;
    private long sendIntervalMilli = 7200000;
    private long guardDiffMilli = 120000;
    private long ttl = 86400000;

    public final boolean a() {
        return this.enabled;
    }

    public final String b() {
        return this.projectId;
    }

    public final String c() {
        return this.connectivityTestHostname;
    }

    public final String d() {
        return this.connectivityTestFilename;
    }

    public final boolean e() {
        return this.connectivityTestEnabled;
    }

    public final boolean f() {
        return this.nirCollectCellinfoEnabled;
    }

    public final boolean g() {
        return this.ctCollectCellinfoEnabled;
    }

    public final String h() {
        return this.connectivityTestCdnconfigUrl;
    }

    public final String i() {
        return this.geoipUrl;
    }

    public final long j() {
        return this.ctltIntervalMilli;
    }

    public final long k() {
        return this.sendIntervalMilli;
    }

    public final long l() {
        return this.guardDiffMilli;
    }

    public final long m() {
        return this.ttl;
    }

    public final String n() {
        return this.hostCt;
    }

    public final String o() {
        return this.hostLt;
    }

    public final String p() {
        return this.hostNir;
    }

    public final int q() {
        return this.numberOfRecordsMin;
    }

    public final int r() {
        return this.numberOfRecordsMax;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NetworkTestsMetaData networkTestsMetaData = (NetworkTestsMetaData) obj;
        if (this.numberOfRecordsMin == networkTestsMetaData.numberOfRecordsMin && this.numberOfRecordsMax == networkTestsMetaData.numberOfRecordsMax && this.enabled == networkTestsMetaData.enabled && this.connectivityTestEnabled == networkTestsMetaData.connectivityTestEnabled && this.nirCollectCellinfoEnabled == networkTestsMetaData.nirCollectCellinfoEnabled && this.ctCollectCellinfoEnabled == networkTestsMetaData.ctCollectCellinfoEnabled && this.ctltIntervalMilli == networkTestsMetaData.ctltIntervalMilli && this.sendIntervalMilli == networkTestsMetaData.sendIntervalMilli && this.ttl == networkTestsMetaData.ttl) {
            if (this.hostCt == null ? networkTestsMetaData.hostCt != null : !this.hostCt.equals(networkTestsMetaData.hostCt)) {
                return false;
            }
            if (this.hostLt == null ? networkTestsMetaData.hostLt != null : !this.hostLt.equals(networkTestsMetaData.hostLt)) {
                return false;
            }
            if (this.hostNir == null ? networkTestsMetaData.hostNir != null : !this.hostNir.equals(networkTestsMetaData.hostNir)) {
                return false;
            }
            if (this.projectId == null ? networkTestsMetaData.projectId != null : !this.projectId.equals(networkTestsMetaData.projectId)) {
                return false;
            }
            if (this.connectivityTestHostname == null ? networkTestsMetaData.connectivityTestHostname != null : !this.connectivityTestHostname.equals(networkTestsMetaData.connectivityTestHostname)) {
                return false;
            }
            if (this.connectivityTestFilename == null ? networkTestsMetaData.connectivityTestFilename != null : !this.connectivityTestFilename.equals(networkTestsMetaData.connectivityTestFilename)) {
                return false;
            }
            if (this.connectivityTestCdnconfigUrl == null ? networkTestsMetaData.connectivityTestCdnconfigUrl != null : !this.connectivityTestCdnconfigUrl.equals(networkTestsMetaData.connectivityTestCdnconfigUrl)) {
                return false;
            }
            if (this.geoipUrl != null) {
                return this.geoipUrl.equals(networkTestsMetaData.geoipUrl);
            }
            return networkTestsMetaData.geoipUrl == null;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int hashCode = (this.hostCt != null ? this.hostCt.hashCode() : 0) * 31;
        if (this.hostLt != null) {
            i = this.hostLt.hashCode();
        } else {
            i = 0;
        }
        int i8 = (hashCode + i) * 31;
        if (this.hostNir != null) {
            i2 = this.hostNir.hashCode();
        } else {
            i2 = 0;
        }
        int i9 = (((((((i8 + i2) * 31) + this.numberOfRecordsMin) * 31) + this.numberOfRecordsMax) * 31) + (this.enabled ? 1 : 0)) * 31;
        if (this.projectId != null) {
            i3 = this.projectId.hashCode();
        } else {
            i3 = 0;
        }
        int i10 = (i9 + i3) * 31;
        if (this.connectivityTestHostname != null) {
            i4 = this.connectivityTestHostname.hashCode();
        } else {
            i4 = 0;
        }
        int i11 = (i10 + i4) * 31;
        if (this.connectivityTestFilename != null) {
            i5 = this.connectivityTestFilename.hashCode();
        } else {
            i5 = 0;
        }
        int i12 = (((((((i11 + i5) * 31) + (this.connectivityTestEnabled ? 1 : 0)) * 31) + (this.nirCollectCellinfoEnabled ? 1 : 0)) * 31) + (this.ctCollectCellinfoEnabled ? 1 : 0)) * 31;
        if (this.connectivityTestCdnconfigUrl != null) {
            i6 = this.connectivityTestCdnconfigUrl.hashCode();
        } else {
            i6 = 0;
        }
        int i13 = (i12 + i6) * 31;
        if (this.geoipUrl != null) {
            i7 = this.geoipUrl.hashCode();
        } else {
            i7 = 0;
        }
        return ((((((i13 + i7) * 31) + ((int) (this.ctltIntervalMilli ^ (this.ctltIntervalMilli >>> 32)))) * 31) + ((int) (this.sendIntervalMilli ^ (this.sendIntervalMilli >>> 32)))) * 31) + ((int) (this.ttl ^ (this.ttl >>> 32)));
    }
}
