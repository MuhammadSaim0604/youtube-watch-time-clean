package com.startapp.sdk.ads.banner.bannerstandard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.startapp.sdk.ads.banner.BannerBase;
import com.startapp.sdk.ads.banner.BannerInterface;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.ads.banner.bannerstandard.CloseableLayout;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.h;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.t;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.k.c;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.mraid.bridge.MraidState;
import com.startapp.sdk.adsbase.mraid.bridge.a;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class BannerStandard extends BannerBase implements BannerInterface, AdEventListener {
    private c A;
    private MraidBannerController B;
    private MraidBannerController C;
    private ViewGroup D;
    protected BannerStandardAd g;
    protected boolean h;
    protected boolean i;
    protected BannerListener j;
    private boolean k;
    private boolean l;
    private boolean m;
    private final Handler n;
    private long o;
    private BannerOptions p;
    private AdPreferences q;
    private final com.startapp.sdk.ads.banner.c r;
    private boolean s;
    private AdInformationObject t;
    public WebView twoPartWebView;
    private RelativeLayout u;
    private RelativeLayout v;
    private CloseableLayout w;
    public WebView webView;
    private h x;
    private com.iab.omid.library.startapp.adsession.b y;
    private c z;

    static /* synthetic */ void a(BannerStandard bannerStandard) {
        if (bannerStandard.B.getState() == MraidState.LOADING || bannerStandard.B.getState() == MraidState.HIDDEN) {
            return;
        }
        if (bannerStandard.B.getState() == MraidState.RESIZED || bannerStandard.B.getState() == MraidState.EXPANDED) {
            if (bannerStandard.C == null) {
                bannerStandard.w.removeView(bannerStandard.webView);
                bannerStandard.a((View) bannerStandard.webView);
                bannerStandard.u();
            } else {
                bannerStandard.w.removeView(bannerStandard.twoPartWebView);
                bannerStandard.A.a();
                bannerStandard.A = null;
                bannerStandard.C = null;
                bannerStandard.twoPartWebView.stopLoading();
                bannerStandard.twoPartWebView = null;
            }
            CloseableLayout closeableLayout = bannerStandard.w;
            if (closeableLayout != null && closeableLayout.getParent() != null && (closeableLayout.getParent() instanceof ViewGroup)) {
                ((ViewGroup) closeableLayout.getParent()).removeView(closeableLayout);
            }
            bannerStandard.B.setState(MraidState.DEFAULT);
        } else if (bannerStandard.B.getState() == MraidState.DEFAULT) {
            bannerStandard.t();
            bannerStandard.B.setState(MraidState.HIDDEN);
        }
        bannerStandard.p();
    }

    static /* synthetic */ void a(BannerStandard bannerStandard, boolean z) {
        if (z == (!bannerStandard.w.a())) {
            return;
        }
        bannerStandard.w.setCloseVisible(!z);
    }

    static /* synthetic */ void b(BannerStandard bannerStandard, String str) {
        bannerStandard.q();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        boolean z = (str == null || TextUtils.isEmpty(str)) ? false : true;
        if (z) {
            bannerStandard.h = false;
            if (bannerStandard.twoPartWebView == null) {
                bannerStandard.twoPartWebView = new WebView(bannerStandard.getContext());
            }
            bannerStandard.C = new MraidBannerController(bannerStandard.twoPartWebView, new a.InterfaceC0043a() { // from class: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.10
                @Override // com.startapp.sdk.adsbase.mraid.bridge.a.InterfaceC0043a
                public boolean onClickEvent(String str2) {
                    if (!BannerStandard.this.h) {
                        new e(InfoEventCategory.ERROR).f("fake_click").h(com.startapp.sdk.adsbase.a.a(str2, (String) null)).g("jsTag=" + BannerStandard.this.i).a(BannerStandard.this.getContext());
                    }
                    if ((!BannerStandard.this.i || BannerStandard.this.h) && str2 != null) {
                        return BannerStandard.this.b(str2);
                    }
                    return false;
                }
            });
            bannerStandard.A = new c(bannerStandard.twoPartWebView, n(), new c.a() { // from class: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.11
                @Override // com.startapp.sdk.adsbase.k.c.a
                public boolean onUpdate(boolean z2) {
                    BannerStandard.this.B.fireViewableChangeEvent(z2);
                    BannerStandard.this.C.fireViewableChangeEvent(z2);
                    return BannerStandard.this.g.v();
                }
            });
            bannerStandard.twoPartWebView.setId(159868226);
            bannerStandard.b(bannerStandard.twoPartWebView);
            bannerStandard.twoPartWebView.loadUrl(str);
        }
        if (bannerStandard.B.getState() == MraidState.DEFAULT) {
            if (z) {
                bannerStandard.w.addView(bannerStandard.twoPartWebView, layoutParams);
            } else {
                if (bannerStandard.v != null) {
                    bannerStandard.v.removeView(bannerStandard.webView);
                    bannerStandard.v.setVisibility(4);
                }
                bannerStandard.w.addView(bannerStandard.webView, layoutParams);
            }
            bannerStandard.B().addView(bannerStandard.w, new FrameLayout.LayoutParams(-1, -1));
        } else if (bannerStandard.B.getState() == MraidState.RESIZED && z) {
            bannerStandard.w.removeView(bannerStandard.webView);
            if (bannerStandard.v != null) {
                bannerStandard.v.addView(bannerStandard.webView, layoutParams);
                bannerStandard.v.setVisibility(4);
            }
            bannerStandard.w.addView(bannerStandard.twoPartWebView, layoutParams);
        }
        bannerStandard.w.setLayoutParams(layoutParams);
        bannerStandard.B.setState(MraidState.EXPANDED);
    }

    static /* synthetic */ void h(BannerStandard bannerStandard) {
        com.startapp.sdk.adsbase.mraid.b.b resizeProperties = bannerStandard.B.getResizeProperties();
        if (resizeProperties == null) {
            com.iab.omid.library.startapp.b.a(bannerStandard.webView, "requires: setResizeProperties first", "resize");
            return;
        }
        bannerStandard.q();
        if (bannerStandard.B.getState() != MraidState.LOADING && bannerStandard.B.getState() != MraidState.HIDDEN) {
            if (bannerStandard.B.getState() == MraidState.EXPANDED) {
                com.iab.omid.library.startapp.b.a(bannerStandard.webView, "Not allowed to resize from an already expanded ad", "resize");
                return;
            }
            int i = resizeProperties.a;
            int i2 = resizeProperties.b;
            int i3 = resizeProperties.c;
            int i4 = resizeProperties.d;
            int[] iArr = new int[2];
            bannerStandard.webView.getLocationOnScreen(iArr);
            Context context = bannerStandard.getContext();
            int b = t.b(context, iArr[0]) + i3;
            int b2 = t.b(context, iArr[1]) + i4;
            Rect rect = new Rect(b, b2, b + i, b2 + i2);
            ViewGroup A = bannerStandard.A();
            int b3 = t.b(context, A.getWidth());
            int b4 = t.b(context, A.getHeight());
            int[] iArr2 = new int[2];
            A.getLocationOnScreen(iArr2);
            int b5 = t.b(context, iArr2[0]);
            int b6 = t.b(context, iArr2[1]);
            if (!resizeProperties.f) {
                if (rect.width() > b3 || rect.height() > b4) {
                    com.iab.omid.library.startapp.b.a(bannerStandard.webView, "Not enough room for the ad", "resize");
                    return;
                }
                rect.offsetTo(a(b5, rect.left, (b5 + b3) - rect.width()), a(b6, rect.top, (b6 + b4) - rect.height()));
            }
            Rect rect2 = new Rect();
            try {
                CloseableLayout.ClosePosition a = CloseableLayout.ClosePosition.a(resizeProperties.e, CloseableLayout.ClosePosition.TOP_RIGHT);
                bannerStandard.w.a(a, rect, rect2);
                if (!new Rect(b5, b6, b5 + b3, b6 + b4).contains(rect2)) {
                    com.iab.omid.library.startapp.b.a(bannerStandard.webView, "The close region to appear within the max allowed size", "resize");
                } else if (!rect.contains(rect2)) {
                    com.iab.omid.library.startapp.b.a(bannerStandard.webView, "The close region to appear within the max allowed size", "resize");
                } else {
                    bannerStandard.w.setCloseVisible(false);
                    bannerStandard.w.setClosePosition(a);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
                    layoutParams.leftMargin = rect.left - b5;
                    layoutParams.topMargin = rect.top - b6;
                    if (bannerStandard.B.getState() == MraidState.DEFAULT) {
                        if (bannerStandard.v != null) {
                            bannerStandard.v.removeView(bannerStandard.webView);
                            bannerStandard.v.setVisibility(4);
                        }
                        bannerStandard.w.addView(bannerStandard.webView, new FrameLayout.LayoutParams(-1, -1));
                        bannerStandard.B().addView(bannerStandard.w, layoutParams);
                    } else if (bannerStandard.B.getState() == MraidState.RESIZED) {
                        bannerStandard.w.setLayoutParams(layoutParams);
                    }
                    bannerStandard.w.setClosePosition(a);
                    bannerStandard.B.setState(MraidState.RESIZED);
                }
            } catch (Exception e) {
                com.iab.omid.library.startapp.b.a(bannerStandard.webView, e.getMessage(), "resize");
            }
        }
    }

    public BannerStandard(Activity activity) {
        this((Context) activity);
    }

    public BannerStandard(Activity activity, AdPreferences adPreferences) {
        this((Context) activity, adPreferences);
    }

    public BannerStandard(Activity activity, BannerListener bannerListener) {
        this((Context) activity, bannerListener);
    }

    public BannerStandard(Activity activity, AdPreferences adPreferences, BannerListener bannerListener) {
        this((Context) activity, adPreferences, bannerListener);
    }

    public BannerStandard(Activity activity, boolean z) {
        this((Context) activity, z);
    }

    public BannerStandard(Activity activity, boolean z, AdPreferences adPreferences) {
        this((Context) activity, z, adPreferences);
    }

    public BannerStandard(Activity activity, AttributeSet attributeSet) {
        this((Context) activity, attributeSet);
    }

    public BannerStandard(Activity activity, AttributeSet attributeSet, int i) {
        this((Context) activity, attributeSet, i);
    }

    @Deprecated
    public BannerStandard(Context context) {
        this(context, true, (AdPreferences) null);
    }

    @Deprecated
    public BannerStandard(Context context, AdPreferences adPreferences) {
        this(context, true, adPreferences);
    }

    @Deprecated
    public BannerStandard(Context context, BannerListener bannerListener) {
        this(context, true, (AdPreferences) null);
        setBannerListener(bannerListener);
    }

    @Deprecated
    public BannerStandard(Context context, AdPreferences adPreferences, BannerListener bannerListener) {
        this(context, true, adPreferences);
        setBannerListener(bannerListener);
    }

    @Deprecated
    public BannerStandard(Context context, boolean z) {
        this(context, z, (AdPreferences) null);
    }

    @Deprecated
    public BannerStandard(Context context, boolean z, AdPreferences adPreferences) {
        super(context);
        this.k = false;
        this.h = true;
        this.i = false;
        this.l = true;
        this.m = true;
        this.n = new Handler(Looper.getMainLooper());
        this.r = new com.startapp.sdk.ads.banner.c(300, c());
        this.s = false;
        this.t = null;
        this.u = null;
        try {
            this.l = z;
            this.q = adPreferences;
            a();
        } catch (Throwable th) {
            new e(th).a(context);
        }
    }

    @Deprecated
    public BannerStandard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public BannerStandard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = false;
        this.h = true;
        this.i = false;
        this.l = true;
        this.m = true;
        this.n = new Handler(Looper.getMainLooper());
        this.r = new com.startapp.sdk.ads.banner.c(300, c());
        this.s = false;
        this.t = null;
        this.u = null;
        try {
            a();
        } catch (Throwable th) {
            new e(th).a(context);
        }
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase, com.startapp.sdk.ads.banner.BannerInterface
    public void hideBanner() {
        this.m = false;
        t();
    }

    private void t() {
        if (this.v != null) {
            this.v.setVisibility(4);
        }
    }

    @Override // com.startapp.sdk.ads.banner.BannerInterface
    public void showBanner() {
        this.m = true;
        u();
    }

    private void u() {
        if (this.v != null) {
            this.v.setVisibility(0);
        }
        if (this.g != null) {
            com.startapp.sdk.b.c.a(getContext()).h().a(AdPreferences.Placement.INAPP_BANNER, s(), this.g.getAdId());
        }
    }

    private void b(WebView webView) {
        webView.setBackgroundColor(0);
        webView.setHorizontalScrollBarEnabled(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BannerStandard.this.h = true;
                return motionEvent.getAction() == 2;
            }
        });
        webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        webView.setLongClickable(false);
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final void b() {
        try {
            Context context = getContext();
            this.w = new CloseableLayout(context);
            this.w.setOnCloseListener(new CloseableLayout.a() { // from class: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.3
                @Override // com.startapp.sdk.ads.banner.bannerstandard.CloseableLayout.a
                public void onClose() {
                    BannerStandard.a(BannerStandard.this);
                }
            });
            this.webView = new WebView(context);
            this.B = new MraidBannerController(this.webView, new a.InterfaceC0043a() { // from class: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.4
                @Override // com.startapp.sdk.adsbase.mraid.bridge.a.InterfaceC0043a
                public boolean onClickEvent(String str) {
                    if (!BannerStandard.this.h) {
                        new e(InfoEventCategory.ERROR).f("fake_click").h(com.startapp.sdk.adsbase.a.a(str, (String) null)).g("jsTag=" + BannerStandard.this.i).a(BannerStandard.this.getContext());
                    }
                    if ((!BannerStandard.this.i || BannerStandard.this.h) && str != null) {
                        return BannerStandard.this.b(str);
                    }
                    return false;
                }
            });
            this.p = new BannerOptions();
            this.g = new BannerStandardAd(context, g());
            if (this.q == null) {
                this.q = new AdPreferences();
            }
            if (getId() == -1) {
                setId(this.e);
            }
            this.webView.setId(159868225);
            b(this.webView);
            this.p = BannerMetaData.a().c();
            a(this.q);
            setMinimumWidth(t.a(getContext(), this.r.a()));
            setMinimumHeight(t.a(getContext(), this.r.b()));
            this.webView.addJavascriptInterface(new com.startapp.sdk.d.b(getContext(), new Runnable() { // from class: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.5
                @Override // java.lang.Runnable
                public void run() {
                }
            }, new TrackingParams(j()), this.g.e(0)), "startappwall");
            this.v = new RelativeLayout(getContext());
            a(this.webView);
            t();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            addView(this.v, layoutParams);
            if (this.l) {
                getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.6
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        com.startapp.common.b.b.a(BannerStandard.this.getViewTreeObserver(), this);
                        if (!BannerStandard.this.k) {
                            BannerStandard.this.k();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            new e(th).a(getContext());
            hideBanner();
            a("BannerStandard.init - webview failed");
        }
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected int c() {
        return 50;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected String d() {
        return "StartApp Banner";
    }

    protected int s() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.ads.banner.BannerBase
    public final View o() {
        if (this.v == null) {
            return super.o();
        }
        return this.v;
    }

    private void a(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.a(getContext(), this.r.a()), t.a(getContext(), this.r.b()));
        layoutParams.addRule(13);
        this.v.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.ads.banner.BannerBase
    public final void p() {
        if (this.x != null && this.x.c()) {
            super.p();
        }
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final void e() {
        Point v;
        if (this.y != null) {
            this.y.b();
            this.y = null;
        }
        if (this.q == null) {
            this.q = new AdPreferences();
        }
        if (this.b != null) {
            v = this.b;
        } else {
            v = v();
        }
        Point point = v;
        BannerStandardAd bannerStandardAd = this.g;
        int i = point.x;
        int i2 = point.y;
        bannerStandardAd.b(i);
        bannerStandardAd.c(i2);
        this.g.setState(Ad.AdState.UN_INITIALIZED);
        this.g.a(s());
        this.g.load(this.q, this);
    }

    private Point v() {
        View view;
        View view2;
        Point point = new Point();
        if (getLayoutParams() != null && getLayoutParams().width > 0) {
            point.x = t.b(getContext(), getLayoutParams().width + 1);
        }
        if (getLayoutParams() != null && getLayoutParams().height > 0) {
            point.y = t.b(getContext(), getLayoutParams().height + 1);
        }
        if (getLayoutParams() != null && getLayoutParams().width > 0 && getLayoutParams().height > 0) {
            this.g.c_();
        }
        if (getLayoutParams() == null || getLayoutParams().width <= 0 || getLayoutParams().height <= 0) {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            try {
                if (getParent() instanceof View) {
                    view = (View) getParent();
                } else {
                    view = null;
                }
                while (true) {
                    view2 = view;
                    if (view2 == null || (view2.getMeasuredWidth() > 0 && view2.getMeasuredHeight() > 0)) {
                        break;
                    }
                    if (view2.getMeasuredWidth() > 0) {
                        a(point, t.b(getContext(), (view2.getMeasuredWidth() - view2.getPaddingLeft()) - view2.getPaddingRight()));
                    }
                    if (view2.getMeasuredHeight() > 0) {
                        b(point, t.b(getContext(), (view2.getMeasuredHeight() - view2.getPaddingBottom()) - view2.getPaddingTop()));
                    }
                    if (view2.getParent() instanceof View) {
                        view = (View) view2.getParent();
                    } else {
                        view = null;
                    }
                }
                if (view2 == null) {
                    a(point, displayMetrics);
                } else {
                    a(point, t.b(getContext(), (view2.getMeasuredWidth() - view2.getPaddingLeft()) - view2.getPaddingRight()));
                    b(point, t.b(getContext(), (view2.getMeasuredHeight() - view2.getPaddingBottom()) - view2.getPaddingTop()));
                }
            } catch (Throwable th) {
                new e(th).a(getContext());
                a(point, displayMetrics);
            }
        }
        return point;
    }

    private void a(Point point, DisplayMetrics displayMetrics) {
        a(point, t.b(getContext(), displayMetrics.widthPixels));
        b(point, t.b(getContext(), displayMetrics.heightPixels));
    }

    private static void a(Point point, int i) {
        if (point.x <= 0) {
            point.x = i;
        }
    }

    private static void b(Point point, int i) {
        if (point.y <= 0) {
            point.y = i;
        }
    }

    @Override // com.startapp.sdk.adsbase.adlisteners.AdEventListener
    public void onReceiveAd(Ad ad) {
        boolean z;
        long millis;
        this.h = false;
        removeView(this.u);
        if (this.g != null && this.g.j() != null && this.g.j().compareTo("") != 0) {
            this.i = "true".equals(u.a(this.g.j(), "@jsTag@", "@jsTag@"));
            loadHtml();
            String a = u.a(this.g.j(), "@width@", "@width@");
            String a2 = u.a(this.g.j(), "@height@", "@height@");
            try {
                try {
                    int parseInt = Integer.parseInt(a);
                    int parseInt2 = Integer.parseInt(a2);
                    Point v = v();
                    if (v.x >= parseInt && v.y >= parseInt2) {
                        this.r.a(parseInt, parseInt2);
                        int a3 = t.a(getContext(), this.r.a());
                        int a4 = t.a(getContext(), this.r.b());
                        this.v.setMinimumWidth(a3);
                        this.v.setMinimumHeight(a4);
                        ViewGroup.LayoutParams layoutParams = this.webView.getLayoutParams();
                        RelativeLayout.LayoutParams layoutParams2 = layoutParams;
                        if (layoutParams == null) {
                            layoutParams2 = new RelativeLayout.LayoutParams(a3, a4);
                        } else {
                            layoutParams2.width = a3;
                            layoutParams2.height = a4;
                        }
                        this.webView.setLayoutParams(layoutParams2);
                        z = true;
                    } else {
                        Point point = new Point(0, 0);
                        ViewGroup.LayoutParams layoutParams3 = this.webView.getLayoutParams();
                        RelativeLayout.LayoutParams layoutParams4 = layoutParams3;
                        if (layoutParams3 == null) {
                            layoutParams4 = new RelativeLayout.LayoutParams(point.x, point.y);
                        } else {
                            layoutParams4.width = point.x;
                            layoutParams4.height = point.y;
                        }
                        this.webView.setLayoutParams(layoutParams4);
                        z = false;
                    }
                    if (z) {
                        this.k = true;
                        if (this.t == null && this.u == null) {
                            this.u = new RelativeLayout(getContext());
                            this.t = new AdInformationObject(getContext(), AdInformationObject.Size.SMALL, AdPreferences.Placement.INAPP_BANNER, this.g.getAdInfoOverride());
                            this.t.a(this.u);
                        }
                        try {
                            ViewGroup viewGroup = (ViewGroup) this.u.getParent();
                            if (viewGroup != null) {
                                viewGroup.removeView(this.u);
                            }
                        } catch (Exception e) {
                        }
                        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams5.addRule(13);
                        this.webView.addView(this.u, layoutParams5);
                        Context context = getContext();
                        String[] strArr = this.g.trackingUrls;
                        TrackingParams trackingParams = new TrackingParams(j());
                        if (this.g.t() != null) {
                            millis = TimeUnit.SECONDS.toMillis(this.g.t().longValue());
                        } else {
                            millis = TimeUnit.SECONDS.toMillis(MetaData.E().F());
                        }
                        this.x = new h(context, strArr, trackingParams, millis);
                        this.x.a(new h.a() { // from class: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.9
                            @Override // com.startapp.sdk.adsbase.h.a
                            public void onSent() {
                                if (BannerStandard.this.j != null) {
                                    BannerStandard.this.j.onImpression(BannerStandard.this);
                                }
                                BannerStandard.this.o = System.currentTimeMillis() - BannerStandard.this.o;
                                BannerStandard.this.p();
                            }
                        });
                        a(this.x);
                        r();
                        if (this.g != null && this.g.v()) {
                            this.z = new c(this.webView, n(), new c.a() { // from class: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.8
                                @Override // com.startapp.sdk.adsbase.k.c.a
                                public boolean onUpdate(boolean z2) {
                                    BannerStandard.this.B.fireViewableChangeEvent(z2);
                                    return BannerStandard.this.g.v();
                                }
                            });
                        }
                        if (this.m) {
                            u();
                        }
                        if (this.j != null && !this.s) {
                            this.s = true;
                            this.j.onReceiveAd(this);
                            return;
                        }
                        return;
                    }
                    a("Banner cannot be displayed (not enough room)");
                    return;
                } catch (Throwable th) {
                    new e(th).a(getContext());
                    a(th.getMessage());
                    return;
                }
            } catch (NumberFormatException e2) {
                a("Error Casting width & height from HTML");
                return;
            }
        }
        a("No Banner received");
    }

    private void a(String str) {
        setErrorMessage(str);
        if (this.j != null && !this.s) {
            this.s = true;
            this.j.onFailedToReceiveAd(this);
        }
    }

    public void loadHtml() {
        if (this.g != null) {
            String j = this.g.j();
            String str = j;
            if (j != null) {
                if (j() != null && j().length() > 0) {
                    str = str.replaceAll("startapp_adtag_placeholder", j());
                }
                this.n.postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.7
                    @Override // java.lang.Runnable
                    public void run() {
                        BannerStandard.this.m();
                    }
                }, this.p.i());
                this.o = System.currentTimeMillis();
                u.a(getContext(), this.webView, str);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int a = t.a(getContext(), this.r.a());
        int a2 = t.a(getContext(), this.r.b());
        if (i < a || i2 < a2) {
            t();
        } else if (this.m && this.k) {
            u();
        }
    }

    @Override // com.startapp.sdk.adsbase.adlisteners.AdEventListener
    public void onFailedToReceiveAd(Ad ad) {
        a(ad.getErrorMessage());
    }

    protected final void a(WebView webView) {
        z();
        if (MetaData.E().Q()) {
            this.y = com.startapp.sdk.omsdk.a.a(webView);
            if (this.y != null) {
                if (this.u != null) {
                    this.y.b(this.u);
                }
                if (this.w != null) {
                    this.y.b(this.w);
                }
                this.y.a(webView);
                this.y.a();
                com.iab.omid.library.startapp.adsession.a.a(this.y).a();
            }
        }
    }

    private void w() {
        if (this.webView != null) {
            com.startapp.common.b.b.c(this.webView);
        }
        if (this.twoPartWebView != null) {
            com.startapp.common.b.b.c(this.twoPartWebView);
        }
    }

    private void x() {
        if (this.webView != null) {
            com.startapp.common.b.b.b(this.webView);
        }
        if (this.twoPartWebView != null) {
            com.startapp.common.b.b.b(this.twoPartWebView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.ads.banner.BannerBase, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.ads.banner.BannerBase, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x();
        a(false);
        y();
        z();
        if (this.y != null) {
            this.y.b();
            this.y = null;
            u.a(this.webView);
        }
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            w();
        } else {
            x();
        }
    }

    @Override // com.startapp.sdk.ads.banner.BannerInterface
    public void setBannerListener(BannerListener bannerListener) {
        this.j = bannerListener;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final int f() {
        return this.p.i();
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final int i() {
        return Math.max(this.p.i() - ((int) this.o), 0);
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final int g() {
        if (this.g != null) {
            return this.g.a();
        }
        return 0;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final int h() {
        return this.e;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final void a(int i) {
        this.e = i;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    public void setAdTag(String str) {
        this.f = str;
    }

    private void a(boolean z) {
        if (this.x != null) {
            this.x.a(z);
        }
    }

    private void y() {
        if (this.z != null) {
            this.z.a();
        }
        if (this.A != null) {
            this.A.a();
        }
    }

    private void z() {
        this.n.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String str2;
        String str3;
        if (this.j != null) {
            this.j.onClick(this);
        }
        a(true);
        y();
        z();
        boolean a = com.startapp.sdk.adsbase.a.a(getContext(), AdPreferences.Placement.INAPP_BANNER);
        String[] q = this.g.q();
        String[] s = this.g.s();
        if (!this.i && str.contains("index=")) {
            try {
                int a2 = com.startapp.sdk.adsbase.a.a(str);
                if (a2 >= 0) {
                    if (this.g.d(a2) && !a) {
                        Context context = getContext();
                        if (a2 < q.length) {
                            str3 = q[a2];
                        } else {
                            str3 = null;
                        }
                        com.startapp.sdk.adsbase.a.a(context, str, str3, a2 < s.length ? s[a2] : null, new TrackingParams(j()), AdsCommonMetaData.a().B(), AdsCommonMetaData.a().C(), this.g.e(a2), this.g.f(a2));
                    } else {
                        Context context2 = getContext();
                        if (a2 < q.length) {
                            str2 = q[a2];
                        } else {
                            str2 = null;
                        }
                        com.startapp.sdk.adsbase.a.a(context2, str, str2, new TrackingParams(j()), this.g.e(a2) && !a, false);
                    }
                } else {
                    new e(InfoEventCategory.ERROR).f("Wrong index extracted from URL").g("adId: " + this.g.getAdId()).a(getContext());
                    return false;
                }
            } catch (Throwable th) {
                new e(th).a(getContext());
                return false;
            }
        } else if (q.length <= 0) {
            new e(InfoEventCategory.ERROR).f("No tracking URLs").g("adId: " + this.g.getAdId()).a(getContext());
            return false;
        } else if (this.g.d(0) && !a) {
            if (s.length <= 0) {
                new e(InfoEventCategory.ERROR).f("No package names").g("adId: " + this.g.getAdId()).a(getContext());
                return false;
            }
            com.startapp.sdk.adsbase.a.a(getContext(), str, q[0], s[0], new TrackingParams(j()), AdsCommonMetaData.a().B(), AdsCommonMetaData.a().C(), this.g.e(0), this.g.f(0));
        } else {
            com.startapp.sdk.adsbase.a.a(getContext(), str, q[0], new TrackingParams(j()), this.g.e(0) && !a, false);
        }
        this.webView.stopLoading();
        setClicked(true);
        return true;
    }

    private static int a(int i, int i2, int i3) {
        return Math.max(i, Math.min(i2, i3));
    }

    private ViewGroup A() {
        View findViewById;
        View view;
        if (this.D != null) {
            return this.D;
        }
        Context context = getContext();
        RelativeLayout relativeLayout = this.v;
        if (!(context instanceof Activity)) {
            findViewById = null;
        } else {
            findViewById = ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        }
        View view2 = findViewById;
        if (relativeLayout == null) {
            view = null;
        } else {
            View rootView = relativeLayout.getRootView();
            if (rootView == null) {
                view = null;
            } else {
                View findViewById2 = rootView.findViewById(16908290);
                if (findViewById2 == null) {
                    view = rootView;
                } else {
                    view = findViewById2;
                }
            }
        }
        View view3 = view2 != null ? view2 : view;
        return view3 instanceof ViewGroup ? (ViewGroup) view3 : this.v;
    }

    private ViewGroup B() {
        if (this.D == null) {
            this.D = A();
        }
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public class MraidBannerController extends com.startapp.sdk.adsbase.mraid.bridge.a {
        private WebView activeWebView;
        private MraidState mraidState;
        private boolean mraidVisibility;
        private com.startapp.sdk.adsbase.mraid.a.a nativeFeatureManager;
        private com.startapp.sdk.adsbase.mraid.b.a orientationProperties;
        private com.startapp.sdk.adsbase.mraid.b.b resizeProperties;

        MraidBannerController(WebView webView, a.InterfaceC0043a interfaceC0043a) {
            super(interfaceC0043a);
            this.mraidState = MraidState.LOADING;
            this.mraidVisibility = false;
            this.activeWebView = webView;
            this.activeWebView.setWebViewClient(new BannerWebViewClient(this));
            this.nativeFeatureManager = new com.startapp.sdk.adsbase.mraid.a.a(BannerStandard.this.getContext());
            this.orientationProperties = new com.startapp.sdk.adsbase.mraid.b.a();
        }

        com.startapp.sdk.adsbase.mraid.b.b getResizeProperties() {
            return this.resizeProperties;
        }

        @Override // com.startapp.sdk.adsbase.mraid.bridge.a, com.startapp.sdk.adsbase.mraid.bridge.b
        public void setResizeProperties(Map<String, String> map) {
            try {
                int parseInt = Integer.parseInt(map.get("width"));
                int parseInt2 = Integer.parseInt(map.get("height"));
                int parseInt3 = Integer.parseInt(map.get("offsetX"));
                int parseInt4 = Integer.parseInt(map.get("offsetY"));
                String str = map.get("allowOffscreen");
                this.resizeProperties = new com.startapp.sdk.adsbase.mraid.b.b(parseInt, parseInt2, parseInt3, parseInt4, map.get("customClosePosition"), str == null || Boolean.parseBoolean(str));
            } catch (Exception e) {
                com.iab.omid.library.startapp.b.a(this.activeWebView, "wrong format", "setResizeProperties");
            }
        }

        MraidState getState() {
            return this.mraidState;
        }

        void setState(MraidState mraidState) {
            this.mraidState = mraidState;
            com.iab.omid.library.startapp.b.a(this.mraidState, this.activeWebView);
        }

        @Override // com.startapp.sdk.adsbase.mraid.bridge.a, com.startapp.sdk.adsbase.mraid.bridge.b
        public void close() {
            BannerStandard.a(BannerStandard.this);
        }

        @Override // com.startapp.sdk.adsbase.mraid.bridge.a, com.startapp.sdk.adsbase.mraid.bridge.b
        public void expand(String str) {
            BannerStandard.b(BannerStandard.this, str);
        }

        @Override // com.startapp.sdk.adsbase.mraid.bridge.a, com.startapp.sdk.adsbase.mraid.bridge.b
        public void resize() {
            BannerStandard.h(BannerStandard.this);
        }

        @Override // com.startapp.sdk.adsbase.mraid.bridge.a, com.startapp.sdk.adsbase.mraid.bridge.b
        public void useCustomClose(String str) {
            BannerStandard.a(BannerStandard.this, Boolean.parseBoolean(str));
        }

        @Override // com.startapp.sdk.adsbase.mraid.bridge.a, com.startapp.sdk.adsbase.mraid.bridge.b
        public void setOrientationProperties(Map<String, String> map) {
            boolean parseBoolean = Boolean.parseBoolean(map.get("allowOrientationChange"));
            String str = map.get("forceOrientation");
            if (this.orientationProperties.a != parseBoolean || this.orientationProperties.b != com.startapp.sdk.adsbase.mraid.b.a.a(str)) {
                this.orientationProperties.a = parseBoolean;
                this.orientationProperties.b = com.startapp.sdk.adsbase.mraid.b.a.a(str);
                applyOrientationProperties((Activity) BannerStandard.this.getContext(), this.orientationProperties);
            }
        }

        @Override // com.startapp.sdk.adsbase.mraid.bridge.a, com.startapp.sdk.adsbase.mraid.bridge.b
        public void setExpandProperties(Map<String, String> map) {
            String str = map.get("useCustomClose");
            if (str != null) {
                BannerStandard.a(BannerStandard.this, Boolean.parseBoolean(str));
            }
        }

        @Override // com.startapp.sdk.adsbase.mraid.bridge.a
        public boolean isFeatureSupported(String str) {
            return this.nativeFeatureManager.a(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fireViewableChangeEvent(boolean z) {
            if (this.mraidVisibility != z) {
                this.mraidVisibility = z;
                com.iab.omid.library.startapp.b.a(this.activeWebView, this.mraidVisibility);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateDisplayMetrics(WebView webView) {
            Context context = BannerStandard.this.getContext();
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                int[] iArr = new int[2];
                BannerStandard.this.getLocationOnScreen(iArr);
                int i3 = iArr[0];
                int i4 = iArr[1];
                com.iab.omid.library.startapp.b.a(context, i, i2, webView);
                com.iab.omid.library.startapp.b.b(context, i3, i4, BannerStandard.this.r.a(), BannerStandard.this.r.b(), webView);
                com.iab.omid.library.startapp.b.b(context, i, i2, webView);
                com.iab.omid.library.startapp.b.a(context, i3, i4, BannerStandard.this.r.a(), BannerStandard.this.r.b(), webView);
            } catch (Throwable th) {
                new e(th).a(context);
            }
        }

        /* compiled from: StartAppSDK */
        /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
        class BannerWebViewClient extends com.startapp.sdk.adsbase.mraid.bridge.c {
            BannerWebViewClient(com.startapp.sdk.adsbase.mraid.bridge.b bVar) {
                super(bVar);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (MraidBannerController.this.mraidState == MraidState.LOADING) {
                    com.iab.omid.library.startapp.b.a("inline", webView);
                    com.iab.omid.library.startapp.b.a(BannerStandard.this.getContext(), webView, MraidBannerController.this.nativeFeatureManager);
                    MraidBannerController.this.updateDisplayMetrics(webView);
                    MraidBannerController.this.mraidState = MraidState.DEFAULT;
                    com.iab.omid.library.startapp.b.a(MraidBannerController.this.mraidState, webView);
                    com.iab.omid.library.startapp.b.a(webView);
                }
                BannerStandard.this.a(webView);
            }
        }
    }
}
