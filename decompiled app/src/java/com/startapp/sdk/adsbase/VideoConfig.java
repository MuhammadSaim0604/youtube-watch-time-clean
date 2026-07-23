package com.startapp.sdk.adsbase;

import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class VideoConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private int maxCachedVideos = 3;
    private long minAvailableStorageRequired = 20;
    private int rewardGrantPercentage = 100;
    private int videoErrorsThreshold = 2;
    @com.startapp.common.parser.d(b = BackMode.class)
    private BackMode backMode = BackMode.DISABLED;
    private int nativePlayerProbability = 100;
    private int minTimeForCachingIndicator = 1;
    private int maxTimeForCachingIndicator = 10;
    private boolean videoFallback = false;
    private boolean progressive = false;
    private int progressiveBufferInPercentage = 20;
    private int progressiveInitialBufferInPercentage = 5;
    private int progressiveMinBufferToPlayFromCache = 30;
    private String soundMode = "default";
    private int maxVastLevels = 7;
    private int vastTimeout = 30000;
    private int vastRetryTimeout = 60000;
    private int maxVastCampaignExclude = 10;
    private int vastMediaPicker = 0;
    private int vastPreferredBitrate = 0;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum BackMode {
        DISABLED,
        SKIP,
        CLOSE,
        BOTH
    }

    public final BackMode a() {
        return this.backMode;
    }

    public final int b() {
        return this.maxCachedVideos;
    }

    public final long c() {
        return this.minAvailableStorageRequired;
    }

    public final int d() {
        return this.rewardGrantPercentage;
    }

    public final int e() {
        return this.videoErrorsThreshold;
    }

    public final long f() {
        return TimeUnit.SECONDS.toMillis(this.minTimeForCachingIndicator);
    }

    public final long g() {
        return TimeUnit.SECONDS.toMillis(this.maxTimeForCachingIndicator);
    }

    public final boolean h() {
        return this.videoFallback;
    }

    public final boolean i() {
        return this.progressive;
    }

    public final int j() {
        return this.progressiveBufferInPercentage;
    }

    public final int k() {
        return this.progressiveInitialBufferInPercentage;
    }

    public final int l() {
        return this.progressiveMinBufferToPlayFromCache;
    }

    public final String m() {
        return this.soundMode;
    }

    public final int n() {
        return this.maxVastLevels;
    }

    public final int o() {
        return this.vastTimeout;
    }

    public final int p() {
        return this.vastRetryTimeout;
    }

    public final int q() {
        return this.maxVastCampaignExclude;
    }

    public final int r() {
        return this.vastMediaPicker;
    }

    public final int s() {
        return this.vastPreferredBitrate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VideoConfig videoConfig = (VideoConfig) obj;
        return this.maxCachedVideos == videoConfig.maxCachedVideos && this.minAvailableStorageRequired == videoConfig.minAvailableStorageRequired && this.rewardGrantPercentage == videoConfig.rewardGrantPercentage && this.videoErrorsThreshold == videoConfig.videoErrorsThreshold && this.nativePlayerProbability == videoConfig.nativePlayerProbability && this.minTimeForCachingIndicator == videoConfig.minTimeForCachingIndicator && this.maxTimeForCachingIndicator == videoConfig.maxTimeForCachingIndicator && this.videoFallback == videoConfig.videoFallback && this.progressive == videoConfig.progressive && this.progressiveBufferInPercentage == videoConfig.progressiveBufferInPercentage && this.progressiveInitialBufferInPercentage == videoConfig.progressiveInitialBufferInPercentage && this.progressiveMinBufferToPlayFromCache == videoConfig.progressiveMinBufferToPlayFromCache && this.maxVastLevels == videoConfig.maxVastLevels && this.vastTimeout == videoConfig.vastTimeout && this.vastRetryTimeout == videoConfig.vastRetryTimeout && this.maxVastCampaignExclude == videoConfig.maxVastCampaignExclude && this.vastMediaPicker == videoConfig.vastMediaPicker && this.vastPreferredBitrate == videoConfig.vastPreferredBitrate && this.backMode == videoConfig.backMode && u.b(this.soundMode, videoConfig.soundMode);
    }

    public int hashCode() {
        return u.a(Integer.valueOf(this.maxCachedVideos), Long.valueOf(this.minAvailableStorageRequired), Integer.valueOf(this.rewardGrantPercentage), Integer.valueOf(this.videoErrorsThreshold), this.backMode, Integer.valueOf(this.nativePlayerProbability), Integer.valueOf(this.minTimeForCachingIndicator), Integer.valueOf(this.maxTimeForCachingIndicator), Boolean.valueOf(this.videoFallback), Boolean.valueOf(this.progressive), Integer.valueOf(this.progressiveBufferInPercentage), Integer.valueOf(this.progressiveInitialBufferInPercentage), Integer.valueOf(this.progressiveMinBufferToPlayFromCache), this.soundMode, Integer.valueOf(this.maxVastLevels), Integer.valueOf(this.vastTimeout), Integer.valueOf(this.vastRetryTimeout), Integer.valueOf(this.maxVastCampaignExclude), Integer.valueOf(this.vastMediaPicker), Integer.valueOf(this.vastPreferredBitrate));
    }
}
