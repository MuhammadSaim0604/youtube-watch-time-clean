package com.startapp.sdk.ads.video.tracking;

import com.startapp.common.parser.d;
import com.startapp.sdk.ads.video.vast.model.VASTEventType;
import com.startapp.sdk.ads.video.vast.model.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class VideoTrackingDetails implements Serializable {
    private static final long serialVersionUID = 1;
    @d(b = AbsoluteTrackingLink.class)
    private AbsoluteTrackingLink[] absoluteTrackingUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] creativeViewUrls;
    @d(b = FractionTrackingLink.class)
    private FractionTrackingLink[] fractionTrackingUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] impressionUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] inlineErrorTrackingUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] soundMuteUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] soundUnmuteUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] videoClickTrackingUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] videoClosedUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] videoPausedUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] videoPostRollClosedUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] videoPostRollImpressionUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] videoResumedUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] videoRewardedUrls;
    @d(b = ActionTrackingLink.class)
    private ActionTrackingLink[] videoSkippedUrls;

    public VideoTrackingDetails() {
    }

    public VideoTrackingDetails(c cVar) {
        if (cVar != null) {
            HashMap<VASTEventType, List<com.startapp.sdk.ads.video.vast.model.a.c>> a = cVar.a();
            ArrayList arrayList = new ArrayList();
            a(a.get(VASTEventType.start), 0, arrayList);
            a(a.get(VASTEventType.firstQuartile), 25, arrayList);
            a(a.get(VASTEventType.midpoint), 50, arrayList);
            a(a.get(VASTEventType.thirdQuartile), 75, arrayList);
            a(a.get(VASTEventType.complete), 100, arrayList);
            this.fractionTrackingUrls = (FractionTrackingLink[]) arrayList.toArray(new FractionTrackingLink[arrayList.size()]);
            this.impressionUrls = b(cVar.c());
            this.soundMuteUrls = a(a.get(VASTEventType.mute));
            this.soundUnmuteUrls = a(a.get(VASTEventType.unmute));
            this.videoPausedUrls = a(a.get(VASTEventType.pause));
            this.videoResumedUrls = a(a.get(VASTEventType.resume));
            this.videoSkippedUrls = a(a.get(VASTEventType.skip));
            this.videoPausedUrls = a(a.get(VASTEventType.pause));
            this.videoClosedUrls = a(a.get(VASTEventType.close));
            this.inlineErrorTrackingUrls = b(cVar.d());
            this.videoClickTrackingUrls = b(cVar.b().b());
            this.absoluteTrackingUrls = c(a.get(VASTEventType.progress));
        }
    }

    public final FractionTrackingLink[] a() {
        return this.fractionTrackingUrls;
    }

    public final AbsoluteTrackingLink[] b() {
        return this.absoluteTrackingUrls;
    }

    public final ActionTrackingLink[] c() {
        return this.impressionUrls;
    }

    public final ActionTrackingLink[] d() {
        return this.soundUnmuteUrls;
    }

    public final ActionTrackingLink[] e() {
        return this.creativeViewUrls;
    }

    public final ActionTrackingLink[] f() {
        return this.soundMuteUrls;
    }

    public final ActionTrackingLink[] g() {
        return this.videoPausedUrls;
    }

    public final ActionTrackingLink[] h() {
        return this.videoResumedUrls;
    }

    public final ActionTrackingLink[] i() {
        return this.videoSkippedUrls;
    }

    public final ActionTrackingLink[] j() {
        return this.videoClosedUrls;
    }

    public final ActionTrackingLink[] k() {
        return this.videoPostRollImpressionUrls;
    }

    public final ActionTrackingLink[] l() {
        return this.videoPostRollClosedUrls;
    }

    public final ActionTrackingLink[] m() {
        return this.videoRewardedUrls;
    }

    public final ActionTrackingLink[] n() {
        return this.videoClickTrackingUrls;
    }

    public final ActionTrackingLink[] o() {
        return this.inlineErrorTrackingUrls;
    }

    public String toString() {
        return "VideoTrackingDetails [fractionTrackingUrls=" + a(this.fractionTrackingUrls) + ", absoluteTrackingUrls=" + a(this.absoluteTrackingUrls) + ", impressionUrls=" + a(this.impressionUrls) + ", creativeViewUrls=" + a(this.creativeViewUrls) + ", soundMuteUrls=" + a(this.soundMuteUrls) + ", soundUnmuteUrls=" + a(this.soundUnmuteUrls) + ", videoPausedUrls=" + a(this.videoPausedUrls) + ", videoResumedUrls=" + a(this.videoResumedUrls) + ", videoSkippedUrls=" + a(this.videoSkippedUrls) + ", videoClosedUrls=" + a(this.videoClosedUrls) + ", videoPostRollImpressionUrls=" + a(this.videoPostRollImpressionUrls) + ", videoPostRollClosedUrls=" + a(this.videoPostRollClosedUrls) + ", videoRewardedUrls=" + a(this.videoRewardedUrls) + ", videoClickTrackingUrls=" + a(this.videoClickTrackingUrls) + ", inlineErrorTrackingUrls=" + a(this.inlineErrorTrackingUrls) + "]";
    }

    private static String a(VideoTrackingLink[] videoTrackingLinkArr) {
        return videoTrackingLinkArr != null ? Arrays.toString(videoTrackingLinkArr) : "";
    }

    private static void a(List<com.startapp.sdk.ads.video.vast.model.a.c> list, int i, List<FractionTrackingLink> list2) {
        if (list != null) {
            for (com.startapp.sdk.ads.video.vast.model.a.c cVar : list) {
                FractionTrackingLink fractionTrackingLink = new FractionTrackingLink();
                fractionTrackingLink.a(cVar.a());
                fractionTrackingLink.a(i);
                fractionTrackingLink.d();
                fractionTrackingLink.b("");
                list2.add(fractionTrackingLink);
            }
        }
    }

    private static ActionTrackingLink[] a(List<com.startapp.sdk.ads.video.vast.model.a.c> list) {
        ActionTrackingLink[] actionTrackingLinkArr;
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (com.startapp.sdk.ads.video.vast.model.a.c cVar : list) {
                ActionTrackingLink actionTrackingLink = new ActionTrackingLink();
                actionTrackingLink.a(cVar.a());
                actionTrackingLink.d();
                actionTrackingLink.b("");
                arrayList.add(actionTrackingLink);
            }
            actionTrackingLinkArr = (ActionTrackingLink[]) arrayList.toArray(new ActionTrackingLink[arrayList.size()]);
        } else {
            actionTrackingLinkArr = new ActionTrackingLink[0];
        }
        return actionTrackingLinkArr;
    }

    private static ActionTrackingLink[] b(List<String> list) {
        ActionTrackingLink[] actionTrackingLinkArr;
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                ActionTrackingLink actionTrackingLink = new ActionTrackingLink();
                actionTrackingLink.a(str);
                actionTrackingLink.d();
                actionTrackingLink.b("");
                arrayList.add(actionTrackingLink);
            }
            actionTrackingLinkArr = (ActionTrackingLink[]) arrayList.toArray(new ActionTrackingLink[arrayList.size()]);
        } else {
            actionTrackingLinkArr = new ActionTrackingLink[0];
        }
        return actionTrackingLinkArr;
    }

    private static AbsoluteTrackingLink[] c(List<com.startapp.sdk.ads.video.vast.model.a.c> list) {
        AbsoluteTrackingLink[] absoluteTrackingLinkArr;
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (com.startapp.sdk.ads.video.vast.model.a.c cVar : list) {
                AbsoluteTrackingLink absoluteTrackingLink = new AbsoluteTrackingLink();
                absoluteTrackingLink.a(cVar.a());
                if (cVar.b() != -1) {
                    absoluteTrackingLink.a(cVar.b());
                }
                absoluteTrackingLink.d();
                absoluteTrackingLink.b("");
                arrayList.add(absoluteTrackingLink);
            }
            absoluteTrackingLinkArr = (AbsoluteTrackingLink[]) arrayList.toArray(new AbsoluteTrackingLink[arrayList.size()]);
        } else {
            absoluteTrackingLinkArr = new AbsoluteTrackingLink[0];
        }
        return absoluteTrackingLinkArr;
    }
}
