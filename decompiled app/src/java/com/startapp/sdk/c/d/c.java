package com.startapp.sdk.c.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class c extends com.startapp.sdk.c.a<a> {
    private static final Comparator<CellInfo> b = new Comparator<CellInfo>() { // from class: com.startapp.sdk.c.d.c.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(CellInfo cellInfo, CellInfo cellInfo2) {
            CellInfo cellInfo3 = cellInfo;
            CellInfo cellInfo4 = cellInfo2;
            if (cellInfo3 != null || cellInfo4 != null) {
                if (cellInfo3 == null) {
                    return -1;
                }
                if (cellInfo4 == null) {
                    return 1;
                }
                long timeStamp = cellInfo3.getTimeStamp();
                long timeStamp2 = cellInfo4.getTimeStamp();
                if (timeStamp < timeStamp2) {
                    return -1;
                }
                if (timeStamp > timeStamp2) {
                    return 1;
                }
            }
            return 0;
        }
    };

    @Override // com.startapp.sdk.c.a
    @SuppressLint({"MissingPermission"})
    protected final /* synthetic */ a a() {
        boolean z;
        CellIdentityWcdma cellIdentity;
        if (Build.VERSION.SDK_INT >= 23) {
            z = this.a.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 || this.a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
        } else {
            z = this.a.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 || this.a.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
        }
        if (!z) {
            return null;
        }
        Object systemService = this.a.getSystemService("phone");
        if (!(systemService instanceof TelephonyManager)) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        b bVar = new b();
        if (Build.VERSION.SDK_INT >= 17) {
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo != null) {
                Collections.sort(allCellInfo, b);
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo instanceof CellInfoCdma) {
                        CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                        if (cellIdentity2 != null) {
                            if (cellIdentity2.getLatitude() != Integer.MAX_VALUE) {
                                bVar.a(com.startapp.common.b.a.c(String.valueOf(cellIdentity2.getLatitude())));
                            }
                            if (cellIdentity2.getLongitude() != Integer.MAX_VALUE) {
                                bVar.b(com.startapp.common.b.a.c(String.valueOf(cellIdentity2.getLongitude())));
                            }
                        }
                    } else if (cellInfo instanceof CellInfoGsm) {
                        CellIdentityGsm cellIdentity3 = ((CellInfoGsm) cellInfo).getCellIdentity();
                        if (cellIdentity3 != null) {
                            if (cellIdentity3.getLac() != Integer.MAX_VALUE) {
                                bVar.c(com.startapp.common.b.a.c(String.valueOf(cellIdentity3.getLac())));
                            }
                            if (cellIdentity3.getCid() != Integer.MAX_VALUE) {
                                bVar.d(com.startapp.common.b.a.c(String.valueOf(cellIdentity3.getCid())));
                            }
                        }
                    } else if (cellInfo instanceof CellInfoLte) {
                        CellIdentityLte cellIdentity4 = ((CellInfoLte) cellInfo).getCellIdentity();
                        if (cellIdentity4 != null && cellIdentity4.getTac() != Integer.MAX_VALUE) {
                            bVar.e(com.startapp.common.b.a.c(String.valueOf(cellIdentity4.getTac())));
                        }
                    } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                        CellIdentity cellIdentity5 = ((CellInfoNr) cellInfo).getCellIdentity();
                        CellIdentityNr cellIdentityNr = cellIdentity5 instanceof CellIdentityNr ? (CellIdentityNr) cellIdentity5 : null;
                        if (cellIdentityNr != null && cellIdentityNr.getTac() != Integer.MAX_VALUE) {
                            bVar.e(com.startapp.common.b.a.c(String.valueOf(cellIdentityNr.getTac())));
                        }
                    } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoTdscdma)) {
                        CellIdentityTdscdma cellIdentity6 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                        if (cellIdentity6 != null) {
                            if (cellIdentity6.getLac() != Integer.MAX_VALUE) {
                                bVar.c(com.startapp.common.b.a.c(String.valueOf(cellIdentity6.getLac())));
                            }
                            if (cellIdentity6.getCid() != Integer.MAX_VALUE) {
                                bVar.d(com.startapp.common.b.a.c(String.valueOf(cellIdentity6.getCid())));
                            }
                        }
                    } else if (Build.VERSION.SDK_INT >= 18 && (cellInfo instanceof CellInfoWcdma) && (cellIdentity = ((CellInfoWcdma) cellInfo).getCellIdentity()) != null) {
                        if (cellIdentity.getLac() != Integer.MAX_VALUE) {
                            bVar.c(com.startapp.common.b.a.c(String.valueOf(cellIdentity.getLac())));
                        }
                        if (cellIdentity.getCid() != Integer.MAX_VALUE) {
                            bVar.d(com.startapp.common.b.a.c(String.valueOf(cellIdentity.getCid())));
                        }
                    }
                }
            }
        } else {
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (!(cellLocation instanceof GsmCellLocation)) {
                if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    bVar.a(com.startapp.common.b.a.c(String.valueOf(cdmaCellLocation.getBaseStationLatitude())));
                    bVar.b(com.startapp.common.b.a.c(String.valueOf(cdmaCellLocation.getBaseStationLongitude())));
                }
            } else {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                bVar.d(com.startapp.common.b.a.c(String.valueOf(gsmCellLocation.getCid())));
                bVar.c(com.startapp.common.b.a.c(String.valueOf(gsmCellLocation.getLac())));
            }
        }
        return bVar;
    }

    public c(Context context) {
        super(context, 120000L);
    }

    @Override // com.startapp.sdk.c.a
    protected final /* bridge */ /* synthetic */ a b() {
        return b.a;
    }
}
