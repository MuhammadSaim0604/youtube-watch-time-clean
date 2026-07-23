package com.startapp.networkTest.enums.wifi;

import android.net.NetworkInfo;
import android.os.Build;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public enum WifiDetailedStates {
    Unknown,
    IDLE,
    SCANNING,
    CONNECTING,
    AUTHENTICATING,
    OBTAINING_IPADDR,
    CONNECTED,
    SUSPENDED,
    DISCONNECTING,
    DISCONNECTED,
    FAILED,
    BLOCKED,
    VERIFYING_POOR_LINK,
    CAPTIVE_PORTAL_CHECK;

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.networkTest.enums.wifi.WifiDetailedStates$1  reason: invalid class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[NetworkInfo.DetailedState.values().length];

        static {
            try {
                a[NetworkInfo.DetailedState.AUTHENTICATING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[NetworkInfo.DetailedState.BLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[NetworkInfo.DetailedState.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[NetworkInfo.DetailedState.CONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[NetworkInfo.DetailedState.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[NetworkInfo.DetailedState.DISCONNECTING.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[NetworkInfo.DetailedState.FAILED.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[NetworkInfo.DetailedState.IDLE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[NetworkInfo.DetailedState.SCANNING.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[NetworkInfo.DetailedState.SUSPENDED.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    public static WifiDetailedStates a(NetworkInfo.DetailedState detailedState) {
        switch (AnonymousClass1.a[detailedState.ordinal()]) {
            case 1:
                return AUTHENTICATING;
            case 2:
                return BLOCKED;
            case 3:
                return CONNECTED;
            case 4:
                return CONNECTING;
            case 5:
                return DISCONNECTED;
            case 6:
                return DISCONNECTING;
            case 7:
                return FAILED;
            case 8:
                return IDLE;
            case 9:
                return OBTAINING_IPADDR;
            case 10:
                return SCANNING;
            case 11:
                return SUSPENDED;
            default:
                if (Build.VERSION.SDK_INT >= 17) {
                    if (detailedState.equals(VERIFYING_POOR_LINK)) {
                        return VERIFYING_POOR_LINK;
                    }
                    if (detailedState.equals(CAPTIVE_PORTAL_CHECK)) {
                        return CAPTIVE_PORTAL_CHECK;
                    }
                }
                return Unknown;
        }
    }
}
