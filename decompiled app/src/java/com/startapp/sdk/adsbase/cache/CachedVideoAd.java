package com.startapp.sdk.adsbase.cache;

import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class CachedVideoAd implements Serializable {
    private static final long serialVersionUID = 1;
    private String filename;
    private long lastUseTimestamp;
    private String videoLocation;

    public CachedVideoAd(String str) {
        this.filename = str;
    }

    public final String a() {
        return this.filename;
    }

    public final String b() {
        return this.videoLocation;
    }

    public final void a(String str) {
        this.videoLocation = str;
    }

    public final void a(long j) {
        this.lastUseTimestamp = j;
    }

    public int hashCode() {
        return 31 + (this.filename == null ? 0 : this.filename.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CachedVideoAd cachedVideoAd = (CachedVideoAd) obj;
            if (this.filename == null) {
                if (cachedVideoAd.filename != null) {
                    return false;
                }
            } else if (!this.filename.equals(cachedVideoAd.filename)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
