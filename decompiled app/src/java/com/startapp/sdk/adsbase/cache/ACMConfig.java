package com.startapp.sdk.adsbase.cache;

import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class ACMConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private long adCacheTTL = 3600;
    private long returnAdCacheTTL = 3600;
    @com.startapp.common.parser.d(b = EnumSet.class, c = StartAppAd.AdMode.class)
    private Set<StartAppAd.AdMode> autoLoad = EnumSet.of(StartAppAd.AdMode.FULLPAGE);
    private boolean localCache = true;
    private boolean returnAdShouldLoadInBg = true;
    @com.startapp.common.parser.d(a = true)
    private FailuresHandler failuresHandler = new FailuresHandler();
    private int maxCacheSize = 7;

    public final long a() {
        return TimeUnit.SECONDS.toMillis(this.adCacheTTL);
    }

    public final long b() {
        return TimeUnit.SECONDS.toMillis(this.returnAdCacheTTL);
    }

    public final Set<StartAppAd.AdMode> c() {
        return this.autoLoad;
    }

    public final boolean d() {
        return this.localCache;
    }

    public final boolean e() {
        return this.returnAdShouldLoadInBg;
    }

    public final FailuresHandler f() {
        return this.failuresHandler;
    }

    public final int g() {
        return this.maxCacheSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ACMConfig aCMConfig = (ACMConfig) obj;
        return this.adCacheTTL == aCMConfig.adCacheTTL && this.returnAdCacheTTL == aCMConfig.returnAdCacheTTL && this.localCache == aCMConfig.localCache && this.returnAdShouldLoadInBg == aCMConfig.returnAdShouldLoadInBg && this.maxCacheSize == aCMConfig.maxCacheSize && u.b(this.autoLoad, aCMConfig.autoLoad) && u.b(this.failuresHandler, aCMConfig.failuresHandler);
    }

    public int hashCode() {
        return u.a(Long.valueOf(this.adCacheTTL), Long.valueOf(this.returnAdCacheTTL), this.autoLoad, Boolean.valueOf(this.localCache), Boolean.valueOf(this.returnAdShouldLoadInBg), this.failuresHandler, Integer.valueOf(this.maxCacheSize));
    }
}
