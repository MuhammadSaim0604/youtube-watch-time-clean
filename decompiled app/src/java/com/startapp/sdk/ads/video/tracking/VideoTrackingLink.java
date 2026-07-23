package com.startapp.sdk.ads.video.tracking;

import com.startapp.common.parser.d;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class VideoTrackingLink implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean appendReplayParameter;
    private String replayParameter;
    @d(b = TrackingSource.class)
    private TrackingSource trackingSource;
    private String trackingUrl;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum TrackingSource {
        STARTAPP,
        EXTERNAL
    }

    public final String b() {
        return this.trackingUrl;
    }

    public final void a(String str) {
        this.trackingUrl = str;
    }

    public final boolean c() {
        return this.appendReplayParameter;
    }

    public final void d() {
        this.appendReplayParameter = true;
    }

    public final String e() {
        return this.replayParameter;
    }

    public final void b(String str) {
        this.replayParameter = str;
    }

    public final TrackingSource f() {
        return this.trackingSource;
    }

    public String toString() {
        return "trackingSource=" + this.trackingSource + ", trackingUrl=" + this.trackingUrl + ", replayParameter=" + this.replayParameter + ", appendReplayParameter=" + this.appendReplayParameter;
    }
}
