package com.startapp.common.jobrunner;

import java.util.HashMap;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class RunnerRequest {
    private final a a;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public enum NetworkType {
        NONE,
        ANY,
        WIFI
    }

    /* synthetic */ RunnerRequest(a aVar, byte b) {
        this(aVar);
    }

    private RunnerRequest(a aVar) {
        this.a = aVar;
    }

    public final int a() {
        return this.a.a;
    }

    public final Map<String, String> b() {
        return this.a.b;
    }

    public final long c() {
        return this.a.c;
    }

    public final long d() {
        return this.a.d;
    }

    public final boolean e() {
        return this.a.e;
    }

    public final NetworkType f() {
        return this.a.g;
    }

    public final boolean g() {
        return this.a.f;
    }

    public final String toString() {
        return "RunnerRequest: " + this.a.a + " " + this.a.c + " " + this.a.e + " " + this.a.d + " " + this.a.b;
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public static class a {
        private int a;
        private long c;
        private Map<String, String> b = new HashMap();
        private long d = 100;
        private boolean e = false;
        private boolean f = false;
        private NetworkType g = NetworkType.NONE;

        public a(int i) {
            this.a = i;
        }

        public final a a(Map<String, String> map) {
            if (map != null) {
                this.b.putAll(map);
            }
            return this;
        }

        public final a a(long j) {
            this.c = j;
            return this;
        }

        public final a a(boolean z) {
            this.e = z;
            return this;
        }

        public final a a(NetworkType networkType) {
            this.g = networkType;
            return this;
        }

        public final a a() {
            this.f = true;
            return this;
        }

        public final RunnerRequest b() {
            return new RunnerRequest(this, (byte) 0);
        }
    }
}
