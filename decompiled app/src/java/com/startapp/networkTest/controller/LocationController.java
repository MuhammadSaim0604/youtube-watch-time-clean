package com.startapp.networkTest.controller;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.startapp.networkTest.data.LocationInfo;
import com.startapp.networkTest.enums.LocationProviders;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class LocationController {
    private static final String a = LocationController.class.getSimpleName();
    private LocationManager b;
    private long c;
    private LocationInfo d;
    private Location e;
    private long f;
    private boolean i;
    private b j;
    private long h = 4000;
    private a g = new a(this, (byte) 0);

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public enum ProviderMode {
        Passive,
        Network,
        Gps,
        GpsAndNetwork,
        RailNet
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public interface b {
        void a(LocationInfo locationInfo);
    }

    public LocationController(Context context) {
        this.b = (LocationManager) context.getSystemService("location");
    }

    public final void a(ProviderMode providerMode) {
        if (providerMode != null && this.b != null) {
            this.i = true;
            List<String> allProviders = this.b.getAllProviders();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            if (allProviders != null) {
                for (String str : allProviders) {
                    boolean z4 = true;
                    switch (str.hashCode()) {
                        case -792039641:
                            if (str.equals("passive")) {
                                z4 = true;
                                break;
                            }
                            break;
                        case 102570:
                            if (str.equals("gps")) {
                                z4 = false;
                                break;
                            }
                            break;
                        case 1843485230:
                            if (str.equals("network")) {
                                z4 = true;
                                break;
                            }
                            break;
                    }
                    switch (z4) {
                        case false:
                            z = true;
                            break;
                        case true:
                            z2 = true;
                            break;
                        case true:
                            z3 = true;
                            break;
                    }
                }
            }
            try {
                switch (providerMode) {
                    case Gps:
                        if (z) {
                            this.b.requestLocationUpdates("gps", 500L, 5.0f, this.g);
                            return;
                        }
                        break;
                    case GpsAndNetwork:
                        if (z) {
                            this.b.requestLocationUpdates("gps", 500L, 5.0f, this.g);
                        }
                        if (z2) {
                            this.b.requestLocationUpdates("network", 0L, 0.0f, this.g);
                            return;
                        }
                        break;
                    case Network:
                        if (z2) {
                            this.b.requestLocationUpdates("network", 0L, 0.0f, this.g);
                            return;
                        }
                        break;
                    case Passive:
                        if (z3) {
                            this.b.requestLocationUpdates("passive", 0L, 0.0f, this.g);
                            break;
                        }
                        break;
                }
            } catch (Exception e) {
                new StringBuilder("startListening: ").append(e.toString());
            }
        }
    }

    public final void a() {
        if (this.b != null && this.g != null) {
            try {
                this.b.removeUpdates(this.g);
            } catch (Exception e) {
                new StringBuilder("stopListening: ").append(e.toString());
            }
        }
        this.i = false;
    }

    public final LocationInfo b() {
        if (this.d == null) {
            List<String> allProviders = this.b.getAllProviders();
            Location location = null;
            if (allProviders != null && allProviders.size() > 0) {
                for (int i = 0; i < allProviders.size(); i++) {
                    Location location2 = null;
                    try {
                        location2 = this.b.getLastKnownLocation(allProviders.get(i));
                    } catch (SecurityException e) {
                        new StringBuilder("getNewestCachedLocationFromDevice: ").append(e.toString());
                    }
                    if (location2 != null) {
                        if (location == null) {
                            location = location2;
                        } else if (location2.getTime() > location.getTime()) {
                            location = location2;
                        }
                    }
                }
            }
            if (location != null) {
                this.e = location;
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f = location.getElapsedRealtimeNanos() / 1000000;
                } else {
                    this.f = SystemClock.elapsedRealtime() + (System.currentTimeMillis() - location.getTime());
                }
                this.d = b(location);
            }
        }
        if (this.d == null) {
            this.d = new LocationInfo();
            this.d.LocationProvider = LocationProviders.Unknown;
        }
        if (this.d.LocationProvider != LocationProviders.Unknown) {
            this.d.LocationAge = SystemClock.elapsedRealtime() - this.f;
        }
        try {
            return (LocationInfo) this.d.clone();
        } catch (CloneNotSupportedException e2) {
            Log.e(a, "getLastLocationInfo", e2);
            return this.d;
        }
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    class a implements LocationListener {
        private a() {
        }

        /* synthetic */ a(LocationController locationController, byte b) {
            this();
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            if (location != null && location.getProvider() != null) {
                if (LocationController.this.e == null || location.getProvider().equals("gps") || LocationController.this.e.getProvider() == null || !LocationController.this.e.getProvider().equals("gps") || SystemClock.elapsedRealtime() - LocationController.this.c >= 5000) {
                    LocationController.this.e = location;
                    LocationController.this.f = SystemClock.elapsedRealtime();
                    LocationController.this.d = LocationController.b(location);
                    LocationController.this.d.LocationAge = 0L;
                    LocationController.this.c = SystemClock.elapsedRealtime();
                    if (LocationController.this.j != null) {
                        LocationController.this.j.a(LocationController.this.d);
                    }
                    if (location.getProvider().equals("gps")) {
                        com.startapp.networkTest.c.b().a(location);
                    }
                }
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LocationInfo b(Location location) {
        LocationInfo locationInfo = new LocationInfo();
        locationInfo.LocationAccuracyHorizontal = location.getAccuracy();
        if (Build.VERSION.SDK_INT >= 26 && location.hasVerticalAccuracy()) {
            locationInfo.LocationAccuracyVertical = location.getVerticalAccuracyMeters();
        } else {
            locationInfo.LocationAccuracyVertical = location.getAccuracy();
        }
        locationInfo.locationTimestampMillis = com.startapp.networkTest.e.b.b();
        locationInfo.LocationTimestamp = com.iab.omid.library.startapp.b.a(locationInfo.locationTimestampMillis);
        locationInfo.LocationAltitude = location.getAltitude();
        locationInfo.LocationBearing = location.getBearing();
        locationInfo.LocationLatitude = location.getLatitude();
        locationInfo.LocationLongitude = location.getLongitude();
        if (Build.VERSION.SDK_INT >= 18) {
            locationInfo.IsMocked = location.isFromMockProvider() ? 1 : 0;
        }
        if (location.getProvider() != null) {
            if (location.getProvider().equals("gps")) {
                locationInfo.LocationProvider = LocationProviders.Gps;
            } else if (location.getProvider().equals("network")) {
                locationInfo.LocationProvider = LocationProviders.Network;
            } else if (location.getProvider().equals("fused")) {
                locationInfo.LocationProvider = LocationProviders.Fused;
            }
            locationInfo.LocationSpeed = location.getSpeed();
            return locationInfo;
        }
        locationInfo.LocationProvider = LocationProviders.Unknown;
        locationInfo.LocationSpeed = location.getSpeed();
        return locationInfo;
    }

    public final void a(b bVar) {
        this.j = bVar;
    }
}
