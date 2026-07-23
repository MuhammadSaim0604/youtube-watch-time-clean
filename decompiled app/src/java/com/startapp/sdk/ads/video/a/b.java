package com.startapp.sdk.ads.video.a;

import android.text.TextUtils;
import com.startapp.sdk.ads.video.tracking.VideoTrackingLink;
import com.startapp.sdk.ads.video.tracking.VideoTrackingParams;
import com.startapp.sdk.ads.video.vast.model.VASTErrorCodes;
import com.startapp.sdk.adsbase.j.u;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b {
    private VideoTrackingLink[] a;
    private VideoTrackingParams b;
    private String c;
    private int d;
    private String e = "";
    private VASTErrorCodes f;

    public b(VideoTrackingLink[] videoTrackingLinkArr, VideoTrackingParams videoTrackingParams, String str, int i) {
        this.a = videoTrackingLinkArr;
        this.b = videoTrackingParams;
        this.c = str;
        this.d = i;
    }

    public final b a(VASTErrorCodes vASTErrorCodes) {
        this.f = vASTErrorCodes;
        return this;
    }

    public final b a(String str) {
        this.e = str;
        return this;
    }

    public final a a() {
        VideoTrackingLink[] videoTrackingLinkArr;
        int i;
        String format;
        if (!((this.a == null || this.b == null) ? false : true)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (VideoTrackingLink videoTrackingLink : this.a) {
            if (videoTrackingLink.b() == null) {
                new StringBuilder("Ignoring tracking link - tracking url is null: tracking link = ").append(videoTrackingLink);
            } else if (this.b.h() > 0 && !videoTrackingLink.c()) {
                new StringBuilder("Ignoring tracking link - external replay event: tracking link = ").append(videoTrackingLink);
            } else {
                StringBuilder sb = new StringBuilder();
                VideoTrackingLink.TrackingSource f = videoTrackingLink.f();
                VideoTrackingLink.TrackingSource trackingSource = f;
                if (f == null) {
                    trackingSource = u.b(videoTrackingLink.b()) ? VideoTrackingLink.TrackingSource.STARTAPP : VideoTrackingLink.TrackingSource.EXTERNAL;
                }
                VideoTrackingParams a = this.b.b(trackingSource == VideoTrackingLink.TrackingSource.STARTAPP).a(videoTrackingLink.c()).a(videoTrackingLink.e());
                String b = videoTrackingLink.b();
                String replace = b.replace("[ASSETURI]", this.c != null ? TextUtils.htmlEncode(this.c) : "");
                long convert = TimeUnit.SECONDS.convert(this.d, TimeUnit.MILLISECONDS);
                String replace2 = replace.replace("[CONTENTPLAYHEAD]", TextUtils.htmlEncode(String.format(Locale.US, "%02d:%02d:%02d.%03d", Long.valueOf(convert / 3600), Long.valueOf((convert % 3600) / 60), Long.valueOf(convert % 60), Long.valueOf(i % 1000)))).replace("[CACHEBUSTING]", TextUtils.htmlEncode(String.valueOf(10000000 + new SecureRandom().nextInt(90000000))));
                int length = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(new Date()).length() - 2;
                String replace3 = replace2.replace("[TIMESTAMP]", TextUtils.htmlEncode(format.substring(0, length) + ":" + format.substring(length)));
                sb.append(this.f != null ? replace3.replace("[ERRORCODE]", String.valueOf(this.f.a())) : replace3).append(a.a());
                if (a.c()) {
                    sb.append(com.startapp.common.b.a.a(com.startapp.sdk.adsbase.a.a(b, (String) null)));
                }
                arrayList.add(sb.toString());
            }
        }
        return new a(arrayList, this.e);
    }
}
