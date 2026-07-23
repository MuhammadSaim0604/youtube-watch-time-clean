package com.startapp.sdk.adsbase.commontracking;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class CloseTrackingParams extends TrackingParams {
    private static final long serialVersionUID = 1;
    private final long duration;

    public CloseTrackingParams(long j, String str) {
        super(str);
        this.duration = j;
    }

    @Override // com.startapp.sdk.adsbase.commontracking.TrackingParams
    public final String a() {
        return super.a() + "&displayDuration=" + Math.max(0L, this.duration);
    }
}
