package com.startapp.sdk.ads.video;

import com.startapp.sdk.ads.video.tracking.VideoTrackingDetails;
import com.startapp.sdk.omsdk.AdVerification;
import com.startapp.sdk.omsdk.VerificationDetails;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class VideoAdDetails implements Serializable {
    private static final long serialVersionUID = 1;
    @com.startapp.common.parser.d(b = VerificationDetails.class, f = "adVerifications")
    private VerificationDetails[] adVerifications;
    private String clickUrl;
    private boolean clickable;
    private boolean closeable;
    private boolean isVideoMuted;
    private String localVideoPath;
    @com.startapp.common.parser.d(b = PostRollType.class)
    private PostRollType postRoll;
    private boolean skippable;
    private int skippableAfter;
    @com.startapp.common.parser.d(a = true)
    private VideoTrackingDetails videoTrackingDetails;
    private String videoUrl;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum PostRollType {
        IMAGE,
        LAST_FRAME,
        NONE
    }

    public VideoAdDetails() {
    }

    public VideoAdDetails(com.startapp.sdk.ads.video.vast.model.c cVar, boolean z) {
        if (cVar != null) {
            this.videoTrackingDetails = new VideoTrackingDetails(cVar);
            if (cVar.f() != null) {
                this.videoUrl = cVar.f().a();
            }
            if (z) {
                this.skippableAfter = cVar.e();
                this.skippable = this.skippableAfter != Integer.MAX_VALUE;
            } else {
                this.skippable = false;
            }
            this.clickUrl = cVar.b().a();
            this.clickable = this.clickUrl != null;
            this.postRoll = PostRollType.NONE;
            AdVerification g = cVar.g();
            if (g == null || g.a() == null) {
                return;
            }
            this.adVerifications = (VerificationDetails[]) g.a().toArray(new VerificationDetails[g.a().size()]);
        }
    }

    public final String a() {
        return this.videoUrl;
    }

    public final String b() {
        return this.localVideoPath;
    }

    public final void a(String str) {
        this.localVideoPath = str;
    }

    public final PostRollType c() {
        return this.postRoll;
    }

    public final boolean d() {
        return this.closeable;
    }

    public final boolean e() {
        return this.skippable;
    }

    public final int f() {
        return this.skippableAfter;
    }

    public final boolean g() {
        return this.clickable;
    }

    public final VideoTrackingDetails h() {
        return this.videoTrackingDetails;
    }

    public final boolean i() {
        return this.isVideoMuted;
    }

    public final void a(boolean z) {
        this.isVideoMuted = z;
    }

    public final String j() {
        return this.clickUrl;
    }

    public final AdVerification k() {
        return new AdVerification(this.adVerifications);
    }

    public String toString() {
        return "VideoAdDetails [videoUrl=" + this.videoUrl + ", localVideoPath=" + this.localVideoPath + ", postRoll=" + this.postRoll + ", closeable=" + this.closeable + ", skippable=" + this.skippable + ", skippableAfter=" + this.skippableAfter + ", videoTrackingDetails= " + this.videoTrackingDetails + ", isVideoMuted= " + this.isVideoMuted + "]";
    }
}
