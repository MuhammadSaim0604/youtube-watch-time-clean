package com.startapp.sdk.adsbase.infoevents;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public enum InfoEventCategory {
    GENERAL("general", 33),
    ERROR("error", 33),
    EXCEPTION("exception", 33),
    EXCEPTION_FATAL("exception_fatal", 33),
    NETWORK_DIAGNOSTIC("netdiag", 33),
    PERIODIC("periodic", -1),
    SUCCESS_SMART_REDIRECT_HOP_INFO("success_smart_redirect_hop_info", 32),
    TRIGGERED_LINK("triggeredLink", 32),
    INSIGHT_CORE_CT("ct", 32),
    INSIGHT_CORE_LT("lt", 32),
    INSIGHT_CORE_NIR("nir", 32);
    
    private final int flags;
    private final String value;

    InfoEventCategory(String str, int i) {
        this.value = str;
        this.flags = i;
    }

    public final String a() {
        return this.value;
    }

    public final boolean b() {
        return (this.flags & 1) != 0;
    }

    public final boolean c() {
        return (this.flags & 2) != 0;
    }

    public final boolean d() {
        return (this.flags & 4) != 0;
    }

    public final boolean e() {
        return (this.flags & 8) != 0;
    }

    public final boolean f() {
        return (this.flags & 16) != 0;
    }

    public final boolean g() {
        return (this.flags & 32) != 0;
    }

    public final boolean h() {
        return (this.flags & 64) != 0;
    }

    public static InfoEventCategory a(String str) {
        InfoEventCategory[] values;
        for (InfoEventCategory infoEventCategory : values()) {
            if (infoEventCategory.value.equals(str)) {
                return infoEventCategory;
            }
        }
        return null;
    }
}
