package com.startapp.sdk.ads.video;

import android.content.Context;
import com.startapp.common.ThreadManager;
import com.startapp.common.b.e;
import com.startapp.sdk.ads.video.VideoUtil;
import com.startapp.sdk.ads.video.c;
import com.startapp.sdk.ads.video.g;
import com.startapp.sdk.ads.video.tracking.ActionTrackingLink;
import com.startapp.sdk.ads.video.tracking.VideoTrackingLink;
import com.startapp.sdk.ads.video.tracking.VideoTrackingParams;
import com.startapp.sdk.ads.video.vast.model.VASTErrorCodes;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import java.util.ArrayList;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b extends com.startapp.sdk.d.a {
    private long i;
    private volatile CacheKey j;
    private com.startapp.sdk.ads.video.vast.model.a k;
    private int l;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v9, types: [com.startapp.sdk.ads.video.vast.model.a] */
    public b(Context context, Ad ad, AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        super(context, ad, adPreferences, bVar, AdPreferences.Placement.INAPP_OVERLAY, true);
        com.startapp.sdk.ads.video.vast.model.b bVar2;
        this.i = System.currentTimeMillis();
        this.l = 0;
        if (AdsCommonMetaData.a().I().r() == 0) {
            bVar2 = r6;
            ?? aVar = new com.startapp.sdk.ads.video.vast.model.a(context);
        } else {
            bVar2 = r6;
            com.startapp.sdk.ads.video.vast.model.b bVar3 = new com.startapp.sdk.ads.video.vast.model.b(context, AdsCommonMetaData.a().I().s());
        }
        this.k = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.d.a, com.startapp.sdk.adsbase.d
    public final boolean a(Object obj) {
        String str;
        boolean z;
        boolean a;
        e.a aVar = (e.a) obj;
        if (aVar != null && aVar.b().toLowerCase().contains("json")) {
            if (AdsCommonMetaData.a().I().h() && !this.h.i()) {
                b(true);
            }
            try {
                d dVar = (d) com.startapp.common.parser.b.a(aVar.a(), d.class);
                if (dVar != null && dVar.getVastTag() != null) {
                    com.startapp.sdk.ads.video.vast.a.a aVar2 = new com.startapp.sdk.ads.video.vast.a.a(AdsCommonMetaData.a().I().n(), AdsCommonMetaData.a().I().o());
                    VASTErrorCodes a2 = aVar2.a(this.a, dVar.getVastTag(), this.k);
                    ((VideoEnabledAd) this.b).a(aVar2.a(), this.b.getType() != Ad.AdType.REWARDED_VIDEO);
                    if (dVar.getTtlSec() != null) {
                        ((VideoEnabledAd) this.b).c(dVar.getTtlSec());
                    }
                    if (a2 == VASTErrorCodes.ErrorNone) {
                        a(VASTErrorCodes.SAProcessSuccess);
                        aVar.a(dVar.getAdmTag());
                        aVar.b("text/html");
                        a = super.a(aVar);
                    } else {
                        a(a2);
                        if (dVar.getCampaignId() != null) {
                            this.g.add(dVar.getCampaignId());
                        }
                        this.l++;
                        ((VideoEnabledAd) this.b).h();
                        if (System.currentTimeMillis() - this.i < AdsCommonMetaData.a().I().p() && this.l <= AdsCommonMetaData.a().I().q()) {
                            a = d().booleanValue();
                        }
                    }
                    return a;
                }
                a = a((Throwable) null);
                return a;
            } catch (Exception e) {
                return a(e);
            }
        }
        if (aVar != null) {
            str = aVar.a();
        } else {
            str = null;
        }
        String str2 = str;
        if (AdsCommonMetaData.a().I().h()) {
            if (u.a(str2, "@videoJson@", "@videoJson@") != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                b(false);
            }
        }
        return super.a(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.d.a, com.startapp.sdk.adsbase.d
    public final void a(final Boolean bool) {
        super.a(bool);
        if (bool.booleanValue() && g()) {
            if (AdsCommonMetaData.a().I().i()) {
                super.b(bool);
            }
            b().a(this.c.isVideoMuted());
            final g.a aVar = new g.a() { // from class: com.startapp.sdk.ads.video.b.1
                @Override // com.startapp.sdk.ads.video.g.a
                public final void a(String str) {
                    if (str == null) {
                        b.this.a(false);
                        b.this.d.b(b.this.b);
                        b.this.a(VASTErrorCodes.FileNotFound);
                        return;
                    }
                    if (!str.equals("downloadInterrupted")) {
                        b.super.b(bool);
                        b.this.b().a(str);
                    }
                    b.this.a(bool.booleanValue());
                }
            };
            final c.a aVar2 = new c.a() { // from class: com.startapp.sdk.ads.video.b.2
                @Override // com.startapp.sdk.ads.video.c.a
                public final void a(String str) {
                    b.this.b().a(str);
                }
            };
            final e a = e.a();
            final Context applicationContext = this.a.getApplicationContext();
            final String a2 = b().a();
            ThreadManager.a(ThreadManager.Priority.HIGH, new Runnable() { // from class: com.startapp.sdk.ads.video.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.a(a, applicationContext, a2, aVar, aVar2);
                }
            });
            return;
        }
        a(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.d.a
    public final boolean a(GetAdRequest getAdRequest) {
        VideoUtil.VideoEligibility a;
        if (super.a(getAdRequest)) {
            if (getAdRequest.j() && (a = VideoUtil.a(this.a)) != VideoUtil.VideoEligibility.ELIGIBLE) {
                this.f = a.a();
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.adsbase.d
    public final GetAdRequest a() {
        GetAdRequest b = b(new a());
        if (b != null) {
            b.a(this.a);
        }
        return b;
    }

    private boolean g() {
        return b() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.d.a, com.startapp.sdk.adsbase.d
    public final void b(Boolean bool) {
        if (!g()) {
            super.b(bool);
        }
    }

    final VideoAdDetails b() {
        return ((VideoEnabledAd) this.b).g();
    }

    private void b(boolean z) {
        AdPreferences adPreferences;
        if ((this.b.getType() != Ad.AdType.REWARDED_VIDEO && this.b.getType() != Ad.AdType.VIDEO) || z) {
            if (this.c == null) {
                adPreferences = new AdPreferences();
            } else {
                adPreferences = new AdPreferences(this.c);
            }
            adPreferences.setType((this.b.getType() == Ad.AdType.REWARDED_VIDEO || this.b.getType() == Ad.AdType.VIDEO) ? Ad.AdType.VIDEO_NO_VAST : Ad.AdType.NON_VIDEO);
            CacheKey a = com.startapp.sdk.adsbase.cache.a.a().a(this.a, (StartAppAd) null, this.e, adPreferences, (com.startapp.sdk.adsbase.adlisteners.b) null);
            if (z) {
                this.j = a;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v22, types: [com.startapp.sdk.ads.video.tracking.VideoTrackingLink[]] */
    public void a(VASTErrorCodes vASTErrorCodes) {
        ActionTrackingLink[] actionTrackingLinkArr;
        ActionTrackingLink[] actionTrackingLinkArr2 = null;
        try {
            if (b() != null && b().h() != null) {
                actionTrackingLinkArr2 = b().h().o();
            }
            if (actionTrackingLinkArr2 != null && actionTrackingLinkArr2.length > 0) {
                if (vASTErrorCodes == VASTErrorCodes.SAShowBeforeVast || vASTErrorCodes == VASTErrorCodes.SAProcessSuccess) {
                    ArrayList arrayList = new ArrayList();
                    for (ActionTrackingLink actionTrackingLink : actionTrackingLinkArr2) {
                        if (u.b(actionTrackingLink.b())) {
                            arrayList.add(actionTrackingLink);
                        }
                    }
                    if (arrayList.size() > 0) {
                        actionTrackingLinkArr2 = (VideoTrackingLink[]) arrayList.toArray(new VideoTrackingLink[arrayList.size()]);
                    } else {
                        return;
                    }
                }
                VideoUtil.a(this.a, new com.startapp.sdk.ads.video.a.b(actionTrackingLinkArr2, new VideoTrackingParams("", 0, 0, "1"), b().a(), 0).a("error").a(vASTErrorCodes).a());
            }
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(this.a);
        }
    }

    private boolean a(Throwable th) {
        new com.startapp.sdk.adsbase.infoevents.e(th).a(this.a);
        com.startapp.sdk.adsbase.f a = com.startapp.sdk.adsbase.cache.a.a().a(this.j);
        if (!(a instanceof HtmlAd)) {
            this.b.setErrorMessage(this.f);
            return false;
        }
        e.a aVar = new e.a();
        aVar.b("text/html");
        aVar.a(((HtmlAd) a).j());
        return super.a(aVar);
    }
}
