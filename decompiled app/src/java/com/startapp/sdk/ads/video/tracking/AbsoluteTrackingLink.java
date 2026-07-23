package com.startapp.sdk.ads.video.tracking;

import com.startapp.common.parser.c;
import java.io.Serializable;

/* compiled from: StartAppSDK */
@c(c = true)
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AbsoluteTrackingLink extends VideoTrackingLink implements Serializable {
    private static final long serialVersionUID = 1;
    private int videoOffsetMillis;

    public final int a() {
        return this.videoOffsetMillis;
    }

    public final void a(int i) {
        this.videoOffsetMillis = i;
    }

    @Override // com.startapp.sdk.ads.video.tracking.VideoTrackingLink
    public String toString() {
        return super.toString() + ", videoOffsetMillis=" + this.videoOffsetMillis;
    }
}
