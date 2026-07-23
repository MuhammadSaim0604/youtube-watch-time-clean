package com.startapp.sdk.ads.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.startapp.common.b.b;
import com.startapp.sdk.ads.banner.banner3d.Banner3DSize;
import com.startapp.sdk.ads.video.VideoAdDetails;
import com.startapp.sdk.ads.video.c;
import com.startapp.sdk.ads.video.player.NativeVideoPlayer;
import com.startapp.sdk.ads.video.player.VideoPlayerInterface;
import com.startapp.sdk.ads.video.tracking.AbsoluteTrackingLink;
import com.startapp.sdk.ads.video.tracking.ActionTrackingLink;
import com.startapp.sdk.ads.video.tracking.FractionTrackingLink;
import com.startapp.sdk.ads.video.tracking.VideoClickedTrackingParams;
import com.startapp.sdk.ads.video.tracking.VideoPausedTrackingParams;
import com.startapp.sdk.ads.video.tracking.VideoProgressTrackingParams;
import com.startapp.sdk.ads.video.tracking.VideoTrackingLink;
import com.startapp.sdk.ads.video.tracking.VideoTrackingParams;
import com.startapp.sdk.ads.video.vast.model.VASTErrorCodes;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.VideoConfig;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.j.t;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class VideoMode extends com.startapp.sdk.ads.a.c implements b.a, VideoPlayerInterface.a, VideoPlayerInterface.b, VideoPlayerInterface.c, VideoPlayerInterface.d, VideoPlayerInterface.e, VideoPlayerInterface.f {
    private int O;
    private long T;
    private VideoClickedTrackingParams.ClickOrigin U;
    private long V;
    private Banner3DSize W;
    protected VideoPlayerInterface l;
    protected VideoView m;
    protected ProgressBar n;
    protected boolean q;
    private RelativeLayout y;
    private RelativeLayout z;
    protected boolean o = false;
    protected int p = 0;
    private int A = 0;
    private int B = 0;
    private boolean C = false;
    private boolean D = false;
    protected boolean r = false;
    protected boolean s = false;
    protected boolean t = false;
    private HashMap<Integer, Boolean> E = new HashMap<>();
    private HashMap<Integer, Boolean> F = new HashMap<>();
    private int G = 1;
    private boolean H = false;
    private boolean I = false;
    private int J = 0;
    protected boolean u = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private int N = 0;
    private String P = null;
    protected Handler v = new Handler();
    protected Handler w = new Handler();
    private Handler Q = new Handler();
    protected Handler x = new Handler();
    private Map<Integer, List<FractionTrackingLink>> R = new HashMap();
    private Map<Integer, List<AbsoluteTrackingLink>> S = new HashMap();
    private boolean X = false;
    private BroadcastReceiver Y = new BroadcastReceiver() { // from class: com.startapp.sdk.ads.video.VideoMode.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (!VideoMode.this.Y.isInitialStickyBroadcast() && VideoMode.this.o != VideoMode.this.Y()) {
                VideoMode.this.o = !VideoMode.this.o;
                VideoMode.this.R();
                VideoMode.this.a(VideoMode.this.o);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum HtmlMode {
        PLAYER,
        POST_ROLL
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum Sound {
        ON,
        OFF
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum VideoFinishedReason {
        COMPLETE,
        CLICKED,
        SKIPPED
    }

    static /* synthetic */ int g(VideoMode videoMode) {
        int i = videoMode.i;
        videoMode.i = i + 1;
        return i;
    }

    @Override // com.startapp.sdk.ads.a.c, com.startapp.sdk.ads.a.b
    public final void a(Bundle bundle) {
        super.a(bundle);
        try {
            this.T = System.currentTimeMillis();
            this.O = 100 / AdsCommonMetaData.a().I().j();
            if (h().equals("back")) {
                if (AdsCommonMetaData.a().I().a().equals(VideoConfig.BackMode.BOTH)) {
                    this.H = true;
                    this.I = true;
                } else if (AdsCommonMetaData.a().I().a().equals(VideoConfig.BackMode.SKIP)) {
                    this.H = true;
                    this.I = false;
                } else if (AdsCommonMetaData.a().I().a().equals(VideoConfig.BackMode.CLOSE)) {
                    this.H = false;
                    this.I = true;
                } else {
                    AdsCommonMetaData.a().I().a().equals(VideoConfig.BackMode.DISABLED);
                    this.H = false;
                    this.I = false;
                }
            }
            FractionTrackingLink[] a = P().h().a();
            if (a != null) {
                for (FractionTrackingLink fractionTrackingLink : a) {
                    List<FractionTrackingLink> list = this.R.get(Integer.valueOf(fractionTrackingLink.a()));
                    ArrayList arrayList = list;
                    if (list == null) {
                        arrayList = new ArrayList();
                        this.R.put(Integer.valueOf(fractionTrackingLink.a()), arrayList);
                    }
                    arrayList.add(fractionTrackingLink);
                }
            }
            AbsoluteTrackingLink[] b = P().h().b();
            if (b != null) {
                for (AbsoluteTrackingLink absoluteTrackingLink : b) {
                    List<AbsoluteTrackingLink> list2 = this.S.get(Integer.valueOf(absoluteTrackingLink.a()));
                    ArrayList arrayList2 = list2;
                    if (list2 == null) {
                        arrayList2 = new ArrayList();
                        this.S.put(Integer.valueOf(absoluteTrackingLink.a()), arrayList2);
                    }
                    arrayList2.add(absoluteTrackingLink);
                }
            }
            this.o = Y() || P().i() || AdsCommonMetaData.a().I().m().equals("muted");
            if (bundle != null && bundle.containsKey("currentPosition")) {
                this.p = bundle.getInt("currentPosition");
                this.A = bundle.getInt("latestPosition");
                this.E = (HashMap) bundle.getSerializable("fractionProgressImpressionsSent");
                this.F = (HashMap) bundle.getSerializable("absoluteProgressImpressionsSent");
                this.o = bundle.getBoolean("isMuted");
                this.q = bundle.getBoolean("shouldSetBg");
                this.G = bundle.getInt("pauseNum");
            }
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) c());
            am();
            p();
        }
    }

    @Override // com.startapp.sdk.ads.a.c
    public final void a(WebView webView) {
        super.a(webView);
        webView.setBackgroundColor(33554431);
        com.startapp.common.b.b.d(webView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.ads.a.c
    public final void a(View view) {
        this.C = true;
        if (this.D && an()) {
            I();
        } else if (ah()) {
            b((View) this.c);
        }
        if (ao()) {
            V();
        }
        if (ah()) {
            aa();
        }
        VideoAdDetails P = P();
        if (MetaData.E().Q() && this.d == null && P != null) {
            P.k();
            if (P.k().a() != null) {
                this.d = com.startapp.sdk.omsdk.a.a(this.c.getContext(), P().k());
                if (this.d != null) {
                    this.W = Banner3DSize.a(this.d);
                    View a = this.a.a();
                    if (a != null) {
                        this.d.b(a);
                    }
                    this.d.b(this.c);
                    this.d.b(this.z);
                    this.d.a(this.m);
                    this.d.a();
                    com.iab.omid.library.startapp.adsession.a.a(this.d).a();
                }
            }
        }
    }

    protected final void I() {
        if (this.r) {
            b(this.m);
            if (!ah()) {
                ab();
            }
        }
    }

    @Override // com.startapp.sdk.ads.a.c, com.startapp.sdk.ads.a.b
    public final void u() {
        super.u();
        c().registerReceiver(this.Y, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        this.X = true;
        if (!c().isFinishing()) {
            if (this.m == null) {
                Context applicationContext = c().getApplicationContext();
                this.V = SystemClock.uptimeMillis();
                this.z = (RelativeLayout) c().findViewById(1475346432);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                this.m = new VideoView(applicationContext);
                this.m.setId(100);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(13);
                this.n = new ProgressBar(applicationContext, null, 16843399);
                this.n.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(14);
                layoutParams3.addRule(15);
                this.y = new RelativeLayout(applicationContext);
                this.y.setId(1475346436);
                c().setContentView(this.y);
                this.y.addView(this.m, layoutParams2);
                this.y.addView(this.z, layoutParams);
                this.y.addView(this.n, layoutParams3);
                if (AdsConstants.a().booleanValue()) {
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams4.addRule(12);
                    layoutParams4.addRule(14);
                    RelativeLayout relativeLayout = this.y;
                    StringBuilder sb = new StringBuilder();
                    sb.append("url=" + P().a());
                    TextView textView = new TextView(applicationContext);
                    textView.setBackgroundColor(-16777216);
                    com.startapp.common.b.b.a(textView, 0.5f);
                    textView.setTextColor(-7829368);
                    textView.setSingleLine(false);
                    textView.setText(sb.toString());
                    relativeLayout.addView(textView, layoutParams4);
                }
                this.a.a().setVisibility(4);
            }
            if (this.l == null) {
                this.l = new NativeVideoPlayer(this.m);
            }
            this.D = false;
            this.y.setBackgroundColor(-16777216);
            J();
            if (ah()) {
                this.a.a().setVisibility(0);
                this.m.setVisibility(4);
            } else if (this.p != 0) {
                this.l.a(this.p);
                VideoPausedTrackingParams.PauseOrigin pauseOrigin = VideoPausedTrackingParams.PauseOrigin.EXTERNAL;
                new StringBuilder("Sending resume event with pause origin: ").append(pauseOrigin);
                a(P().h().h(), new VideoPausedTrackingParams(m(), h(this.A), this.i, this.G, pauseOrigin, this.P), this.A, "resumed");
                this.G++;
            }
            this.l.a((VideoPlayerInterface.f) this);
            this.l.a((VideoPlayerInterface.d) this);
            this.l.a((VideoPlayerInterface.e) this);
            this.l.a((VideoPlayerInterface.b) this);
            this.l.a((VideoPlayerInterface.c) this);
            this.l.a((VideoPlayerInterface.a) this);
            com.startapp.common.b.b.a(this.m, this);
        }
    }

    protected final void J() {
        boolean i = AdsCommonMetaData.a().I().i();
        String b = P().b();
        if (b != null) {
            this.l.a(b);
            if (i) {
                c unused = c.b.a;
                if (c.b(b)) {
                    this.u = true;
                    this.M = true;
                    this.J = AdsCommonMetaData.a().I().k();
                }
            }
        } else if (i) {
            String a = P().a();
            c.b.a.a(a);
            this.l.a(a);
            this.u = true;
            W();
        } else {
            a(VideoFinishedReason.SKIPPED);
        }
        if (this.P == null) {
            this.P = this.u ? "2" : "1";
        }
    }

    private void V() {
        this.L = true;
        ac();
        if (ah()) {
            this.l.b();
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.14
            @Override // java.lang.Runnable
            public final void run() {
                if (VideoMode.this.l != null) {
                    VideoMode.this.l.a();
                    if (VideoMode.this.W != null) {
                        VideoMode.this.W.a(VideoMode.this.l.e(), VideoMode.this.o ? 0.0f : 1.0f);
                    }
                    VideoMode.this.r = true;
                    VideoMode.this.K();
                    new Handler().post(new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.14.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            VideoMode.this.I();
                        }
                    });
                }
            }
        }, Z());
        if (this.p == 0) {
            this.v.postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (VideoMode.this.l != null) {
                            if (VideoMode.this.l.d() > 0) {
                                VideoMode.this.e(0);
                                VideoMode.this.f(0);
                                if (VideoMode.this.i == 0) {
                                    VideoMode.this.S();
                                    com.startapp.common.b.a(VideoMode.this.c()).a(new Intent("com.startapp.android.ShowDisplayBroadcastListener"));
                                }
                            } else if (!VideoMode.this.s) {
                                VideoMode.this.v.postDelayed(this, 100L);
                            }
                        }
                    } catch (Throwable th) {
                        new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) VideoMode.this.c());
                        VideoMode.this.p();
                    }
                }
            }, 100L);
        }
        ai();
        al();
        ad();
        ae();
        this.a.a().setVisibility(4);
        R();
    }

    private void W() {
        if (!X()) {
            this.t = false;
            this.x.postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        VideoMode.this.n.setVisibility(0);
                        if (VideoMode.this.W != null) {
                            VideoMode.this.W.f();
                        }
                        VideoMode.this.x.postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    VideoMode.this.K();
                                    VideoMode.this.t = true;
                                    VideoMode.this.a(new VideoPlayerInterface.g(VideoPlayerInterface.VideoPlayerErrorType.BUFFERING_TIMEOUT, "Buffering timeout reached", VideoMode.this.p));
                                } catch (Throwable th) {
                                    new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) VideoMode.this.c());
                                }
                            }
                        }, AdsCommonMetaData.a().I().g());
                    } catch (Throwable th) {
                        VideoMode.this.K();
                        new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) VideoMode.this.c());
                    }
                }
            }, AdsCommonMetaData.a().I().f());
        }
    }

    protected final void K() {
        this.x.removeCallbacksAndMessages(null);
        if (X()) {
            this.n.setVisibility(8);
            if (this.W != null) {
                this.W.g();
            }
        }
    }

    private boolean X() {
        return this.n != null && this.n.isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y() {
        AudioManager audioManager = (AudioManager) c().getSystemService("audio");
        return audioManager != null && (audioManager.getRingerMode() == 0 || audioManager.getRingerMode() == 1);
    }

    private long Z() {
        long currentTimeMillis = System.currentTimeMillis() - this.T;
        long j = 0;
        if (this.p == 0 && this.i == 0 && currentTimeMillis < 500) {
            j = Math.max(200L, 500 - currentTimeMillis);
        }
        return j;
    }

    private void aa() {
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.l != null);
        a("videoApi.setReplayEnabled", objArr);
        a("videoApi.setMode", HtmlMode.POST_ROLL + "_" + P().c());
        a("videoApi.setCloseable", Boolean.TRUE);
    }

    private void ab() {
        a("videoApi.setClickableVideo", Boolean.valueOf(P().g()));
        a("videoApi.setMode", HtmlMode.PLAYER.toString());
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(P().d() || this.I);
        a("videoApi.setCloseable", objArr);
        a("videoApi.setSkippable", Boolean.valueOf(ap()));
    }

    private void ac() {
        a("videoApi.setVideoDuration", Integer.valueOf(this.l.e() / 1000));
        M();
        af();
        a("videoApi.setVideoCurrentPosition", Integer.valueOf(this.p / 1000));
    }

    protected final void L() {
        a("videoApi.setVideoCurrentPosition", 0);
        a("videoApi.setSkipTimer", 0);
    }

    private void b(View view) {
        a("videoApi.setVideoFrame", Integer.valueOf(t.b(c(), view.getLeft())), Integer.valueOf(t.b(c(), view.getTop())), Integer.valueOf(t.b(c(), view.getWidth())), Integer.valueOf(t.b(c(), view.getHeight())));
    }

    private void ad() {
        this.w.post(new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.4
            @Override // java.lang.Runnable
            public final void run() {
                int M = VideoMode.this.M();
                if (M >= 1000) {
                    VideoMode.this.w.postDelayed(this, VideoMode.a(M) + 50);
                }
            }
        });
    }

    protected final int M() {
        int ag = ag();
        int i = ag / 1000;
        int i2 = i;
        if (i > 0 && ag % 1000 < 100) {
            i2--;
        }
        a("videoApi.setVideoRemainingTimer", Integer.valueOf(i2));
        return ag;
    }

    private void ae() {
        af();
        this.w.post(new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.5
            private boolean a;
            private final int b;

            {
                this.b = VideoMode.this.d(AdsCommonMetaData.a().I().d());
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    int c = VideoMode.this.c(VideoMode.this.l.d() + 50);
                    if (c >= 0 && !this.a) {
                        if (c != 0 && VideoMode.this.p < VideoMode.this.P().f() * 1000) {
                            VideoMode.this.a("videoApi.setSkipTimer", Integer.valueOf(c));
                        } else {
                            this.a = true;
                            VideoMode.this.a("videoApi.setSkipTimer", 0);
                        }
                    }
                    if (VideoMode.this.u && VideoMode.this.l.d() >= this.b) {
                        VideoMode.this.F();
                    }
                    int d = (VideoMode.this.l.d() + 50) / 1000;
                    VideoMode.this.a("videoApi.setVideoCurrentPosition", Integer.valueOf(d));
                    if (d < VideoMode.this.l.e() / 1000) {
                        VideoMode.this.w.postDelayed(this, VideoMode.this.N());
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    private void af() {
        a("videoApi.setSkipTimer", Integer.valueOf(c(this.p + 50)));
    }

    private int ag() {
        if (this.l.d() != this.l.e() || ah()) {
            return this.l.e() - this.l.d();
        }
        return this.l.e();
    }

    protected final long N() {
        return 1000 - (this.l.d() % 1000);
    }

    protected final int c(int i) {
        int f;
        if (!this.H && this.i <= 0 && (f = (P().f() * 1000) - i) > 0) {
            return (f / 1000) + 1;
        }
        return 0;
    }

    private void a(VideoFinishedReason videoFinishedReason) {
        if (videoFinishedReason == VideoFinishedReason.COMPLETE && this.W != null) {
            this.W.d();
        }
        if (videoFinishedReason == VideoFinishedReason.SKIPPED && this.W != null) {
            this.W.h();
        }
        if (videoFinishedReason != VideoFinishedReason.SKIPPED && videoFinishedReason != VideoFinishedReason.CLICKED) {
            this.A = this.B;
            F();
        } else {
            this.v.removeCallbacksAndMessages(null);
            this.Q.removeCallbacksAndMessages(null);
            if (this.l != null) {
                this.A = this.l.d();
                this.l.b();
            }
        }
        this.w.removeCallbacksAndMessages(null);
        this.E.clear();
        this.F.clear();
        if (videoFinishedReason == VideoFinishedReason.CLICKED) {
            this.p = -1;
            return;
        }
        if (P().c() != VideoAdDetails.PostRollType.NONE) {
            aa();
            this.a.a().setVisibility(0);
        }
        if (P().c() == VideoAdDetails.PostRollType.IMAGE) {
            new Handler().postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (!VideoMode.this.t) {
                        VideoMode.this.m.setVisibility(4);
                    }
                }
            }, 1000L);
        } else if (P().c() == VideoAdDetails.PostRollType.NONE) {
            p();
        }
        this.p = -1;
        if (P().c() != VideoAdDetails.PostRollType.NONE) {
            aq();
        }
    }

    protected final void O() {
        this.p = 0;
    }

    private boolean ah() {
        return this.p == -1;
    }

    private void ai() {
        this.B = this.l.e();
        aj();
        ak();
    }

    private void aj() {
        for (Integer num : this.R.keySet()) {
            final int intValue = num.intValue();
            a(d(intValue), this.v, new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.7
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        VideoMode.this.e(intValue);
                    } catch (Throwable th) {
                        new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) VideoMode.this.c());
                    }
                }
            });
        }
    }

    private void ak() {
        for (Integer num : this.S.keySet()) {
            final int intValue = num.intValue();
            a(intValue, this.v, new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.8
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        VideoMode.this.f(intValue);
                    } catch (Throwable th) {
                        new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) VideoMode.this.c());
                    }
                }
            });
        }
    }

    private void al() {
        if (!this.u) {
            a(d(AdsCommonMetaData.a().I().d()), this.Q, new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.9
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        VideoMode.this.F();
                    } catch (Throwable th) {
                        new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) VideoMode.this.c());
                    }
                }
            });
        }
    }

    private void a(int i, Handler handler, Runnable runnable) {
        if (this.p < i) {
            handler.postDelayed(runnable, i - this.p);
        }
    }

    protected final int d(int i) {
        return (this.B * i) / 100;
    }

    @Override // com.startapp.sdk.ads.a.c
    protected final boolean H() {
        return x().getType() == Ad.AdType.REWARDED_VIDEO;
    }

    @Override // com.startapp.sdk.ads.a.c, com.startapp.sdk.ads.a.b
    public final void b(Bundle bundle) {
        super.b(bundle);
        bundle.putInt("currentPosition", this.p);
        bundle.putInt("latestPosition", this.A);
        bundle.putSerializable("fractionProgressImpressionsSent", this.E);
        bundle.putSerializable("absoluteProgressImpressionsSent", this.F);
        bundle.putBoolean("isMuted", this.o);
        bundle.putBoolean("shouldSetBg", this.q);
        bundle.putInt("pauseNum", this.G);
    }

    protected final VideoAdDetails P() {
        return ((VideoEnabledAd) x()).g();
    }

    @Override // com.startapp.sdk.ads.a.c, com.startapp.sdk.ads.a.b
    public final void s() {
        if (!ah() && !c().isFinishing() && !this.I && !this.H) {
            VideoPausedTrackingParams.PauseOrigin pauseOrigin = VideoPausedTrackingParams.PauseOrigin.EXTERNAL;
            if (this.l != null) {
                int d = this.l.d();
                this.p = d;
                this.A = d;
                this.l.b();
                if (this.W != null) {
                    this.W.e();
                }
            }
            new StringBuilder("Sending pause event with origin: ").append(pauseOrigin);
            a(P().h().g(), new VideoPausedTrackingParams(m(), h(this.A), this.i, this.G, pauseOrigin, this.P), this.A, "paused");
        }
        if (this.l != null) {
            this.l.g();
            this.l = null;
        }
        this.v.removeCallbacksAndMessages(null);
        this.w.removeCallbacksAndMessages(null);
        this.Q.removeCallbacksAndMessages(null);
        K();
        this.q = true;
        if (this.X) {
            c().unregisterReceiver(this.Y);
            this.X = false;
        }
        super.s();
    }

    @Override // com.startapp.sdk.ads.a.c, com.startapp.sdk.ads.a.b
    public final void p() {
        super.p();
        if (this.M) {
            c unused = c.b.a;
            c.c(P().b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.ads.a.c
    public final void A() {
    }

    @Override // com.startapp.sdk.ads.a.c
    protected final com.startapp.sdk.d.b z() {
        return new f(c(), this.k, this.k, new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.12
            @Override // java.lang.Runnable
            public final void run() {
                if (VideoMode.this.l != null) {
                    VideoMode.g(VideoMode.this);
                    VideoMode.this.m.setVisibility(0);
                    VideoMode.this.q = false;
                    VideoMode.this.O();
                    VideoMode.this.L();
                    VideoMode.this.J();
                }
            }
        }, new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.11
            @Override // java.lang.Runnable
            public final void run() {
                if (VideoMode.this.l != null) {
                    VideoMode.this.Q();
                }
            }
        }, new Runnable() { // from class: com.startapp.sdk.ads.video.VideoMode.10
            @Override // java.lang.Runnable
            public final void run() {
                if (VideoMode.this.l != null) {
                    VideoMode.this.o = !VideoMode.this.o;
                    VideoMode.this.R();
                    VideoMode.this.a(VideoMode.this.o);
                }
            }
        }, new TrackingParams(m()), a(0));
    }

    protected final void Q() {
        if (X()) {
            K();
        }
        a(VideoFinishedReason.SKIPPED);
        a(P().h().i(), new VideoTrackingParams(m(), h(this.A), this.i, this.P), this.A, "skipped");
    }

    protected final void R() {
        if (this.l != null) {
            try {
                if (this.o) {
                    this.l.a(true);
                } else {
                    this.l.a(false);
                }
            } catch (IllegalStateException e) {
            }
        }
        Object[] objArr = new Object[1];
        objArr[0] = this.o ? Sound.OFF.toString() : Sound.ON.toString();
        a("videoApi.setSound", objArr);
    }

    protected final void a(VideoPlayerInterface.g gVar) {
        VASTErrorCodes vASTErrorCodes;
        int i;
        new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("Video player error: " + gVar.a()).g(gVar.b()).h(n()).a((Context) c());
        switch (gVar.a()) {
            case SERVER_DIED:
                vASTErrorCodes = VASTErrorCodes.GeneralLinearError;
                break;
            case BUFFERING_TIMEOUT:
                vASTErrorCodes = VASTErrorCodes.TimeoutMediaFileURI;
                break;
            case PLAYER_CREATION:
                vASTErrorCodes = VASTErrorCodes.MediaFileDisplayError;
                break;
            default:
                vASTErrorCodes = VASTErrorCodes.UndefinedError;
                break;
        }
        VideoUtil.a(c(), new com.startapp.sdk.ads.video.a.b(P().h().o(), new VideoTrackingParams(m(), h(this.A), this.i, this.P), P().a(), this.A).a(vASTErrorCodes).a("error").a());
        if (this.u) {
            i = this.l.d();
        } else {
            i = this.p;
        }
        if (i == 0) {
            com.startapp.sdk.adsbase.a.a(c(), i(), m(), this.i, AdDisplayListener.NotDisplayedReason.VIDEO_ERROR.toString());
            if (!this.u) {
                VideoUtil.b(c());
            } else if (!gVar.a().equals(VideoPlayerInterface.VideoPlayerErrorType.BUFFERING_TIMEOUT)) {
                VideoUtil.b(c());
            }
        }
        if ((H() && !this.h) || P().c() == VideoAdDetails.PostRollType.NONE) {
            am();
            p();
            return;
        }
        a(VideoFinishedReason.SKIPPED);
    }

    private void am() {
        Intent intent = new Intent("com.startapp.android.ShowFailedDisplayBroadcastListener");
        intent.putExtra("showFailedReason", AdDisplayListener.NotDisplayedReason.VIDEO_ERROR);
        com.startapp.common.b.a(c()).a(intent);
        this.s = true;
    }

    private boolean an() {
        return this.l != null && this.l.f();
    }

    private boolean ao() {
        return !this.u ? an() && this.C : this.J >= AdsCommonMetaData.a().I().k() && an() && this.C;
    }

    @Override // com.startapp.sdk.ads.a.c, com.startapp.sdk.ads.a.b
    public final boolean r() {
        if (ah()) {
            B();
            return false;
        } else if (this.l == null) {
            return false;
        } else {
            int c = c(this.l.d() + 50);
            if (ap() && c == 0) {
                Q();
                return true;
            } else if (P().d() || this.I) {
                B();
                return false;
            } else {
                return true;
            }
        }
    }

    private boolean ap() {
        return this.i > 0 || P().e() || this.H;
    }

    private int h(int i) {
        if (this.B > 0) {
            return (i * 100) / this.B;
        }
        return 0;
    }

    @Override // com.startapp.sdk.ads.a.b
    public final void q() {
        if (!this.s) {
            super.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.ads.a.c
    public final boolean a(String str, boolean z) {
        String str2 = str;
        boolean z2 = z;
        if (!TextUtils.isEmpty(P().j())) {
            str2 = P().j();
            z2 = true;
        }
        this.U = ah() ? VideoClickedTrackingParams.ClickOrigin.POSTROLL : VideoClickedTrackingParams.ClickOrigin.VIDEO;
        new StringBuilder("Video clicked from: ").append(this.U);
        if (this.U == VideoClickedTrackingParams.ClickOrigin.VIDEO) {
            a(VideoFinishedReason.CLICKED);
        }
        VideoClickedTrackingParams.ClickOrigin clickOrigin = this.U;
        new StringBuilder("Sending video clicked event with origin: ").append(clickOrigin.toString());
        a(P().h().n(), new VideoClickedTrackingParams(m(), h(this.A), this.i, clickOrigin, this.P), this.A, "clicked");
        return super.a(str2, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.ads.a.c
    public final void B() {
        if (!this.s) {
            if (ah() || this.m == null) {
                ar();
                super.B();
                return;
            }
            as();
        }
    }

    @Override // com.startapp.sdk.ads.a.c
    protected final long D() {
        return (SystemClock.uptimeMillis() - this.V) / 1000;
    }

    @Override // com.startapp.sdk.ads.a.c
    protected final TrackingParams C() {
        return new VideoTrackingParams(m(), 0, this.i, this.P);
    }

    @Override // com.startapp.sdk.ads.a.c
    protected final long E() {
        return o() != null ? TimeUnit.SECONDS.toMillis(o().longValue()) : TimeUnit.SECONDS.toMillis(MetaData.E().G());
    }

    protected final void S() {
        super.A();
        a(P().h().c(), new VideoTrackingParams(m(), 0, this.i, this.P), 0, "impression");
        a(P().h().e(), new VideoTrackingParams(m(), 0, this.i, this.P), 0, "creativeView");
    }

    protected final void e(int i) {
        if (this.E.get(Integer.valueOf(i)) == null) {
            if (this.R.containsKey(Integer.valueOf(i))) {
                List<FractionTrackingLink> list = this.R.get(Integer.valueOf(i));
                new StringBuilder("Sending fraction progress event with fraction: ").append(i).append(", total: ").append(list.size());
                a((VideoTrackingLink[]) list.toArray(new FractionTrackingLink[list.size()]), new VideoProgressTrackingParams(m(), i, this.i, this.P), d(i), "fraction");
                if (this.W != null) {
                    switch (i) {
                        case 25:
                            this.W.a();
                            break;
                        case 50:
                            this.W.b();
                            break;
                        case 75:
                            this.W.c();
                            break;
                    }
                }
            }
            this.E.put(Integer.valueOf(i), Boolean.TRUE);
        }
    }

    protected final void f(int i) {
        if (this.F.get(Integer.valueOf(i)) == null) {
            if (this.S.containsKey(Integer.valueOf(i))) {
                List<AbsoluteTrackingLink> list = this.S.get(Integer.valueOf(i));
                new StringBuilder("Sending absolute progress event with video progress: ").append(i).append(", total: ").append(list.size());
                a((VideoTrackingLink[]) list.toArray(new AbsoluteTrackingLink[list.size()]), new VideoProgressTrackingParams(m(), i, this.i, this.P), i, "absolute");
            }
            this.F.put(Integer.valueOf(i), Boolean.TRUE);
        }
    }

    private void aq() {
        a(P().h().k(), new VideoTrackingParams(m(), h(this.A), this.i, this.P), this.A, "postrollImression");
    }

    @Override // com.startapp.sdk.ads.a.c
    protected final void G() {
        a(P().h().m(), new VideoTrackingParams(m(), AdsCommonMetaData.a().I().d(), this.i, this.P), d(AdsCommonMetaData.a().I().d()), "rewarded");
    }

    protected final void a(boolean z) {
        ActionTrackingLink[] d;
        if (this.l != null) {
            if (z) {
                d = P().h().f();
            } else {
                d = P().h().d();
            }
            a(d, new VideoTrackingParams(m(), h(this.l.d()), this.i, this.P), this.l.d(), "sound");
            if (this.W != null) {
                this.W.a(z ? 0.0f : 1.0f);
            }
        }
    }

    private void ar() {
        a(P().h().l(), new VideoTrackingParams(m(), h(this.A), this.i, this.P), this.A, "postrollClosed");
    }

    private void as() {
        a(P().h().j(), new VideoTrackingParams(m(), h(this.l.d()), this.i, this.P), this.l.d(), "closed");
    }

    private void a(VideoTrackingLink[] videoTrackingLinkArr, VideoTrackingParams videoTrackingParams, int i, String str) {
        VideoUtil.a(c(), new com.startapp.sdk.ads.video.a.b(videoTrackingLinkArr, videoTrackingParams, P().a(), i).a(str).a());
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface.f
    public final void T() {
        this.K = true;
        if (this.C && this.D) {
            I();
        }
        if (ao()) {
            V();
        }
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface.d
    public final void U() {
        if (!ah()) {
            a(VideoFinishedReason.COMPLETE);
        }
        if (this.l != null) {
            this.l.c();
        }
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface.c
    public final void g(int i) {
        if (this.u && this.K && this.l != null && this.l.e() != 0) {
            new StringBuilder("buffered percent = [").append(i).append("]");
            this.J = i;
            int d = (this.l.d() * 100) / this.l.e();
            if (X()) {
                if (!this.L && ao()) {
                    V();
                } else if (this.J == 100 || this.J - d > AdsCommonMetaData.a().I().j()) {
                    new StringBuilder("progressive video resumed, buffered percent: [").append(Integer.toString(this.J)).append("]");
                    this.l.a();
                    K();
                }
            } else if (this.J < 100 && this.J - d <= AdsCommonMetaData.a().I().k()) {
                new StringBuilder("progressive video paused, buffered percent: [").append(Integer.toString(this.J)).append("]");
                this.l.b();
                W();
            }
        }
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface.e
    public final boolean b(VideoPlayerInterface.g gVar) {
        this.K = false;
        if (this.u && this.N <= this.O && gVar.c() > 0 && gVar.b().equals(NativeVideoPlayer.MediaErrorExtra.MEDIA_ERROR_IO.toString())) {
            this.N++;
            W();
            this.l.a(P().b());
            this.l.a(gVar.c());
        } else {
            a(gVar);
        }
        return true;
    }

    @Override // com.startapp.common.b.b.a
    public final void a() {
        this.D = true;
        if (this.C && an()) {
            I();
        }
    }
}
