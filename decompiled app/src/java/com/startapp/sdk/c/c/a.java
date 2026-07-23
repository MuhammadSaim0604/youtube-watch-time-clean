package com.startapp.sdk.c.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.SparseArray;
import com.startapp.common.b.b;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.g;
import com.startapp.sdk.adsbase.remoteconfig.LocationConfig;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class a extends com.startapp.sdk.c.a<Collection<Location>> {
    private final g<LocationConfig> b;
    private final LocationManager c;

    @Override // com.startapp.sdk.c.a
    protected final /* synthetic */ Collection<Location> a() {
        LocationConfig a;
        SparseArray sparseArray;
        Location b;
        String str;
        if (this.c != null && (a = this.b.a()) != null) {
            if (a.a() && b.a(this.a, "android.permission.ACCESS_FINE_LOCATION")) {
                SparseArray sparseArray2 = new SparseArray(3);
                sparseArray = sparseArray2;
                sparseArray2.put(1048576, "passive");
                sparseArray.put(2097152, "network");
                sparseArray.put(4194304, "gps");
            } else if (a.b() && b.a(this.a, "android.permission.ACCESS_COARSE_LOCATION")) {
                SparseArray sparseArray3 = new SparseArray(1);
                sparseArray = sparseArray3;
                sparseArray3.put(2097152, "network");
            } else {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(3);
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                String str2 = (String) sparseArray.valueAt(i);
                int keyAt = sparseArray.keyAt(i);
                if (a(str2, keyAt) && (b = b(str2, keyAt)) != null) {
                    if (b.getProvider() != null) {
                        str = b.getProvider();
                    } else {
                        str = str2;
                    }
                    linkedHashMap.put(str, b);
                }
            }
            return Collections.unmodifiableCollection(linkedHashMap.values());
        }
        return null;
    }

    public a(Context context, g<LocationConfig> gVar) {
        super(context, 120000L);
        this.b = gVar;
        this.c = a(context);
        if (a(1)) {
            new e(InfoEventCategory.GENERAL).f("7336e5f982b43e78").g(String.valueOf(d())).a(context);
        }
    }

    private boolean a(int i) {
        LocationConfig a = this.b.a();
        return a != null && (a.c() & i) == i;
    }

    private LocationManager a(Context context) {
        LocationManager locationManager = null;
        try {
            LocationManager locationManager2 = (LocationManager) context.getSystemService("location");
            locationManager = locationManager2;
            if (locationManager2 == null && a(4)) {
                new e(InfoEventCategory.ERROR).f("531467b658bff412").a(context);
            }
        } catch (Throwable th) {
            if (a(2)) {
                new e(th).a(context);
            }
        }
        return locationManager;
    }

    private List<String> d() {
        if (this.c == null) {
            return null;
        }
        try {
            return this.c.getAllProviders();
        } catch (Throwable th) {
            if (a(8)) {
                new e(th).a(this.a);
            }
            return null;
        }
    }

    private boolean a(String str, int i) {
        if (this.c == null) {
            return false;
        }
        boolean z = false;
        try {
            boolean isProviderEnabled = this.c.isProviderEnabled(str);
            z = isProviderEnabled;
            if (!isProviderEnabled && a(32 | i)) {
                new e(InfoEventCategory.ERROR).f("90f6b8edddc1d7fc").g(str).a(this.a);
            }
        } catch (Throwable th) {
            if (a(16 | i)) {
                new e(th).a(this.a);
            }
        }
        return z;
    }

    @SuppressLint({"MissingPermission"})
    private Location b(String str, int i) {
        if (this.c == null) {
            return null;
        }
        try {
            return this.c.getLastKnownLocation(str);
        } catch (Throwable th) {
            if (a(64 | i)) {
                new e(th).a(this.a);
            }
            return null;
        }
    }

    public static String a(Collection<Location> collection) {
        StringBuilder sb = new StringBuilder();
        for (Location location : collection) {
            if (sb.length() > 0) {
                sb.append(';');
            }
            sb.append(location.getLongitude()).append(",");
            sb.append(location.getLatitude()).append(",");
            sb.append(location.getAccuracy()).append(",");
            sb.append(location.getProvider()).append(",");
            sb.append(location.getTime());
        }
        return sb.toString();
    }

    @Override // com.startapp.sdk.c.a
    protected final /* synthetic */ Collection<Location> b() {
        return Collections.emptySet();
    }
}
