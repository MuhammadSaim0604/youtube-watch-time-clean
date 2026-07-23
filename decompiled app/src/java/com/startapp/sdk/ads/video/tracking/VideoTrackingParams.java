package com.startapp.sdk.ads.video.tracking;

import com.startapp.sdk.adsbase.commontracking.TrackingParams;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class VideoTrackingParams extends TrackingParams {
    private static final long serialVersionUID = 1;
    private int completed;
    protected boolean internalParamsIndicator;
    private String replayParameter;
    private boolean shouldAppendOffset;
    private String videoPlayingMode;

    public VideoTrackingParams(String str, int i, int i2, String str2) {
        super(str);
        a(i2);
        this.completed = i;
        this.videoPlayingMode = str2;
    }

    public final boolean c() {
        return this.internalParamsIndicator;
    }

    public final VideoTrackingParams a(boolean z) {
        this.shouldAppendOffset = z;
        return this;
    }

    public final VideoTrackingParams a(String str) {
        this.replayParameter = str;
        return this;
    }

    public final VideoTrackingParams b(boolean z) {
        this.internalParamsIndicator = z;
        return this;
    }

    @Override // com.startapp.sdk.adsbase.commontracking.TrackingParams
    public String a() {
        return b(b() + e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.adsbase.commontracking.TrackingParams
    public final String d() {
        if (this.shouldAppendOffset) {
            if (this.replayParameter != null) {
                return this.replayParameter.replace("%startapp_replay_count%", new Integer(h()).toString());
            }
            return super.d();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        return "&cp=" + this.completed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String e() {
        return "&vpm=" + this.videoPlayingMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b(String str) {
        return this.internalParamsIndicator ? super.a() + str : d();
    }
}
