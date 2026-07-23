package com.startapp.sdk.ads.banner.banner3d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.startapp.sdk.ads.banner.BannerBase;
import com.startapp.sdk.ads.banner.BannerInterface;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adinformation.AdInformationOverrides;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.h;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.t;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.b.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class Banner3D extends BannerBase implements BannerInterface, AdEventListener {
    private boolean A;
    private boolean B;
    private boolean C;
    private AdInformationOverrides D;
    private int E;
    private BannerListener F;
    private Runnable G;
    protected BannerOptions g;
    protected List<AdDetails> h;
    protected AdPreferences i;
    protected float j;
    protected boolean k;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    protected boolean o;
    protected boolean p;
    protected boolean q;
    protected boolean r;
    protected List<a> s;
    private Banner3DAd t;
    private Camera u;
    private Matrix v;
    private Paint w;
    private float x;
    private boolean y;
    private boolean z;

    public Banner3D(Activity activity) {
        this((Context) activity);
    }

    public Banner3D(Activity activity, AdPreferences adPreferences) {
        this((Context) activity, adPreferences);
    }

    public Banner3D(Activity activity, BannerListener bannerListener) {
        this((Context) activity, bannerListener);
    }

    public Banner3D(Activity activity, AdPreferences adPreferences, BannerListener bannerListener) {
        this((Context) activity, adPreferences, bannerListener);
    }

    public Banner3D(Activity activity, boolean z) {
        this((Context) activity, z);
    }

    public Banner3D(Activity activity, boolean z, AdPreferences adPreferences) {
        this((Context) activity, z, adPreferences);
    }

    public Banner3D(Activity activity, AttributeSet attributeSet) {
        this((Context) activity, attributeSet);
    }

    public Banner3D(Activity activity, AttributeSet attributeSet, int i) {
        this((Context) activity, attributeSet, i);
    }

    @Deprecated
    public Banner3D(Context context) {
        this(context, true, (AdPreferences) null);
    }

    @Deprecated
    public Banner3D(Context context, AdPreferences adPreferences) {
        this(context, true, adPreferences);
    }

    @Deprecated
    public Banner3D(Context context, BannerListener bannerListener) {
        this(context, true, (AdPreferences) null);
        setBannerListener(bannerListener);
    }

    @Deprecated
    public Banner3D(Context context, AdPreferences adPreferences, BannerListener bannerListener) {
        this(context, true, adPreferences);
        setBannerListener(bannerListener);
    }

    @Deprecated
    public Banner3D(Context context, boolean z) {
        this(context, z, (AdPreferences) null);
    }

    @Deprecated
    public Banner3D(Context context, boolean z, AdPreferences adPreferences) {
        super(context);
        this.u = null;
        this.v = null;
        this.w = null;
        this.j = 45.0f;
        this.x = 0.0f;
        this.k = true;
        this.l = false;
        this.m = true;
        this.n = false;
        this.o = false;
        this.y = false;
        this.z = false;
        this.p = true;
        this.A = true;
        this.q = false;
        this.B = false;
        this.r = false;
        this.C = true;
        this.s = new ArrayList();
        this.E = 0;
        this.G = new Runnable() { // from class: com.startapp.sdk.ads.banner.banner3d.Banner3D.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (Banner3D.this.q && Banner3D.this.s.size() != 0) {
                    if (Banner3D.this.p && Banner3D.this.isShown() && Banner3D.this.c) {
                        Banner3D.a(Banner3D.this, Banner3D.this.s.get(Banner3D.this.t()));
                        if (!Banner3D.this.o) {
                            Banner3D.this.o = true;
                            Banner3D.this.r();
                        }
                    }
                    if (Banner3D.this.k) {
                        Banner3D banner3D = Banner3D.this;
                        int b = Banner3D.this.s().b();
                        if (!Banner3D.this.n) {
                            i = Banner3D.this.g.p();
                        } else {
                            i = 1;
                        }
                        banner3D.a(b * i);
                    }
                    if (Banner3D.this.j <= 90 - Banner3D.this.s().b() || Banner3D.this.j >= 90 + Banner3D.this.s().b() || Banner3D.this.m) {
                        Banner3D.this.postDelayed(this, Banner3D.this.s().a());
                        Banner3D.this.l = true;
                    } else {
                        if (Banner3D.this.r) {
                            Banner3D.this.postDelayed(this, Banner3D.this.s().c());
                        }
                        Banner3D.this.l = false;
                    }
                    if (Banner3D.this.u() == 0) {
                        Banner3D.this.m = false;
                    }
                }
            }
        };
        try {
            this.A = z;
            if (adPreferences == null) {
                this.i = new AdPreferences();
            } else {
                this.i = adPreferences;
            }
            a();
        } catch (Throwable th) {
            new e(th).a(context);
        }
    }

    @Deprecated
    public Banner3D(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public Banner3D(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.u = null;
        this.v = null;
        this.w = null;
        this.j = 45.0f;
        this.x = 0.0f;
        this.k = true;
        this.l = false;
        this.m = true;
        this.n = false;
        this.o = false;
        this.y = false;
        this.z = false;
        this.p = true;
        this.A = true;
        this.q = false;
        this.B = false;
        this.r = false;
        this.C = true;
        this.s = new ArrayList();
        this.E = 0;
        this.G = new Runnable() { // from class: com.startapp.sdk.ads.banner.banner3d.Banner3D.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                if (Banner3D.this.q && Banner3D.this.s.size() != 0) {
                    if (Banner3D.this.p && Banner3D.this.isShown() && Banner3D.this.c) {
                        Banner3D.a(Banner3D.this, Banner3D.this.s.get(Banner3D.this.t()));
                        if (!Banner3D.this.o) {
                            Banner3D.this.o = true;
                            Banner3D.this.r();
                        }
                    }
                    if (Banner3D.this.k) {
                        Banner3D banner3D = Banner3D.this;
                        int b = Banner3D.this.s().b();
                        if (!Banner3D.this.n) {
                            i2 = Banner3D.this.g.p();
                        } else {
                            i2 = 1;
                        }
                        banner3D.a(b * i2);
                    }
                    if (Banner3D.this.j <= 90 - Banner3D.this.s().b() || Banner3D.this.j >= 90 + Banner3D.this.s().b() || Banner3D.this.m) {
                        Banner3D.this.postDelayed(this, Banner3D.this.s().a());
                        Banner3D.this.l = true;
                    } else {
                        if (Banner3D.this.r) {
                            Banner3D.this.postDelayed(this, Banner3D.this.s().c());
                        }
                        Banner3D.this.l = false;
                    }
                    if (Banner3D.this.u() == 0) {
                        Banner3D.this.m = false;
                    }
                }
            }
        };
        try {
            a();
        } catch (Throwable th) {
            new e(th).a(context);
        }
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase, com.startapp.sdk.ads.banner.BannerInterface
    public void hideBanner() {
        this.p = false;
        setVisibility(8);
    }

    @Override // com.startapp.sdk.ads.banner.BannerInterface
    public void showBanner() {
        this.p = true;
        v();
    }

    private void v() {
        setVisibility(0);
        if (this.t != null) {
            c.a(getContext()).h().a(AdPreferences.Placement.INAPP_BANNER, this.t.getAdId());
        }
    }

    protected final BannerOptions s() {
        return this.g;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final void b() {
        if (!this.B) {
            this.g = BannerMetaData.a().c();
            this.h = new ArrayList();
            if (this.i == null) {
                this.i = new AdPreferences();
            }
            this.D = AdInformationOverrides.a();
            E();
            this.s = new ArrayList();
            this.B = true;
            setBackgroundColor(0);
            if (getId() == -1) {
                setId(this.d);
            }
            if (this.A) {
                getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.startapp.sdk.ads.banner.banner3d.Banner3D.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        com.startapp.common.b.b.a(Banner3D.this.getViewTreeObserver(), this);
                        Banner3D.this.a(Banner3D.this.i);
                        if (!Banner3D.this.q) {
                            Banner3D.this.k();
                        }
                    }
                });
            }
        }
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final int c() {
        return 50;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final String d() {
        return "StartApp Banner3D";
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final void e() {
        this.q = false;
        this.B = true;
        this.z = false;
        this.k = true;
        this.m = true;
        this.n = false;
        this.o = false;
        this.c = false;
        this.a = null;
        E();
        this.s = new ArrayList();
        this.t = new Banner3DAd(getContext(), g());
        if (this.i == null) {
            this.i = new AdPreferences();
        }
        this.t.load(this.i, this);
    }

    protected final void a(List<AdDetails> list, boolean z) {
        this.h = list;
        if (list != null) {
            com.startapp.sdk.ads.banner.c cVar = new com.startapp.sdk.ads.banner.c();
            if (Banner3DSize.a(getContext(), getParent(), this.g, this, cVar)) {
                setMinimumWidth(t.a(getContext(), this.g.d()));
                setMinimumHeight(t.a(getContext(), this.g.e()));
                if (getLayoutParams() != null && getLayoutParams().width == -1) {
                    setMinimumWidth(t.a(getContext(), cVar.a()));
                }
                if (getLayoutParams() != null && getLayoutParams().height == -1) {
                    setMinimumHeight(t.a(getContext(), cVar.b()));
                }
                if (getLayoutParams() != null) {
                    if (getLayoutParams().width > 0) {
                        setMinimumWidth(getLayoutParams().width);
                    }
                    if (getLayoutParams().height > 0) {
                        setMinimumHeight(getLayoutParams().height);
                    }
                    if (getLayoutParams().width > 0 && getLayoutParams().height > 0) {
                        this.t.a_();
                    }
                }
                if (x()) {
                    E();
                    removeAllViews();
                    this.s = new ArrayList();
                    for (AdDetails adDetails : list) {
                        this.s.add(new a(getContext(), this, adDetails, this.g, new TrackingParams(j())));
                    }
                    this.E = 0;
                } else {
                    w();
                }
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(D(), C());
                layoutParams.addRule(13);
                int B = B();
                layoutParams.rightMargin = B;
                layoutParams.leftMargin = B;
                int A = A();
                layoutParams.topMargin = A;
                layoutParams.bottomMargin = A;
                addView(relativeLayout, layoutParams);
                new AdInformationObject(getContext(), AdInformationObject.Size.SMALL, AdPreferences.Placement.INAPP_BANNER, this.D).a(relativeLayout);
                if (this.w == null) {
                    this.w = new Paint();
                    this.w.setAntiAlias(true);
                    this.w.setFilterBitmap(true);
                }
                if (!this.z) {
                    this.z = true;
                    F();
                }
                if (this.p) {
                    v();
                }
                if (this.F != null && z) {
                    this.F.onReceiveAd(this);
                    return;
                }
                return;
            }
            setErrorMessage("Error in banner screen size");
            setVisibility(8);
            if (this.F != null && z) {
                this.F.onFailedToReceiveAd(this);
                return;
            }
            return;
        }
        setErrorMessage("No ads to load");
        if (this.F != null && z) {
            this.F.onFailedToReceiveAd(this);
        }
    }

    private void w() {
        for (a aVar : this.s) {
            aVar.a(getContext(), this.g, this);
        }
    }

    private boolean x() {
        return this.s == null || this.s.size() == 0;
    }

    protected final int t() {
        return this.E;
    }

    protected final int u() {
        return (this.E + 1) % y();
    }

    private int y() {
        return this.s.size();
    }

    private void z() {
        this.E = ((this.E - 1) + y()) % y();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.c && !this.B) {
            this.c = true;
            F();
        }
        if (!isInEditMode() && this.p && !x()) {
            try {
                int D = D();
                int C = C();
                int B = B();
                int A = A();
                float l = this.g.l() + (((float) Math.pow(Math.abs(this.j - 45.0f) / 45.0f, this.g.m())) * (1.0f - this.g.l()));
                if (!this.n) {
                    l = this.g.l();
                }
                Bitmap a = this.s.get(((this.E - 1) + this.s.size()) % this.s.size()).a();
                Bitmap a2 = this.s.get(this.E).a();
                if (a2 != null && a != null) {
                    if (this.j < 45.0f) {
                        if (this.j > 3.0f) {
                            a(canvas, a2, A, B, D / 2, C / 2, l, (this.j - 90.0f) * this.g.n().getRotationMultiplier());
                        }
                        a(canvas, a, A, B, D / 2, C / 2, l, this.j * this.g.n().getRotationMultiplier());
                        return;
                    }
                    if (this.j < 87.0f) {
                        a(canvas, a, A, B, D / 2, C / 2, l, this.j * this.g.n().getRotationMultiplier());
                    }
                    a(canvas, a2, A, B, D / 2, C / 2, l, (this.j - 90.0f) * this.g.n().getRotationMultiplier());
                    if (!this.m) {
                        this.n = true;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private int A() {
        return (getHeight() - C()) / 2;
    }

    private int B() {
        return (getWidth() - D()) / 2;
    }

    private int C() {
        return (int) (t.a(getContext(), this.g.e()) * this.g.k());
    }

    private int D() {
        return (int) (t.a(getContext(), this.g.d()) * this.g.j());
    }

    private void a(Canvas canvas, Bitmap bitmap, int i, int i2, int i3, int i4, float f, float f2) {
        if (this.u == null) {
            this.u = new Camera();
        }
        this.u.save();
        this.u.translate(0.0f, 0.0f, i4);
        this.u.rotateX(f2);
        this.u.translate(0.0f, 0.0f, -i4);
        if (this.v == null) {
            this.v = new Matrix();
        }
        this.u.getMatrix(this.v);
        this.u.restore();
        this.v.preTranslate(-i3, -i4);
        this.v.postScale(f, f);
        this.v.postTranslate(i2 + i3, i + i4);
        canvas.drawBitmap(bitmap, this.v, this.w);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int D = D();
        int C = C();
        int B = B();
        int A = A();
        if (!(motionEvent.getX() >= ((float) B) && motionEvent.getY() >= ((float) A) && motionEvent.getX() <= ((float) (B + D)) && motionEvent.getY() <= ((float) (A + C))) || this.s == null || this.s.size() == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.y = true;
                this.x = motionEvent.getY();
                break;
            case 1:
                if (this.y) {
                    if (this.j < 45.0f) {
                        z();
                    }
                    this.y = false;
                    this.k = false;
                    setClicked(true);
                    postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.banner.banner3d.Banner3D.3
                        @Override // java.lang.Runnable
                        public void run() {
                            Banner3D.this.k = true;
                        }
                    }, AdsCommonMetaData.a().B());
                    this.s.get(this.E).b(getContext());
                    if (this.F != null) {
                        this.F.onClick(this);
                        break;
                    }
                }
                break;
            case 2:
                if (this.x - motionEvent.getY() >= 10.0f) {
                    this.y = false;
                    this.x = motionEvent.getY();
                    break;
                }
                break;
        }
        return true;
    }

    private void E() {
        if (this.s != null && !this.s.isEmpty()) {
            for (a aVar : this.s) {
                if (aVar != null) {
                    aVar.c();
                }
            }
        }
    }

    protected final void a(float f) {
        this.j += f;
        if (this.j >= 90.0f) {
            this.E = (this.E + 1) % y();
            this.j -= 90.0f;
        }
        if (this.j <= 0.0f) {
            z();
            this.j += 90.0f;
        }
        invalidate();
    }

    @Override // com.startapp.sdk.adsbase.adlisteners.AdEventListener
    public void onReceiveAd(Ad ad) {
        this.q = true;
        this.B = false;
        this.D = this.t.getAdInfoOverride();
        this.h = ((JsonAd) ad).g();
        a(this.h, this.C);
        this.C = false;
    }

    @Override // com.startapp.sdk.adsbase.adlisteners.AdEventListener
    public void onFailedToReceiveAd(Ad ad) {
        setErrorMessage(ad.getErrorMessage());
        if (this.F != null) {
            this.F.onFailedToReceiveAd(this);
        }
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.bIsVisible = this.p;
        savedState.setDetails(this.h);
        savedState.setRotation(this.j);
        savedState.setFirstRotation(this.m);
        savedState.setFirstRotationFinished(this.n);
        savedState.setCurrentImage(this.E);
        savedState.options = this.g;
        savedState.faces = new a[this.s.size()];
        savedState.loaded = this.q;
        savedState.loading = this.B;
        savedState.overrides = this.D;
        for (int i = 0; i < this.s.size(); i++) {
            savedState.faces[i] = this.s.get(i);
        }
        return savedState;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.p = savedState.bIsVisible;
        if (this.p) {
            this.h = savedState.getDetails();
            this.j = savedState.getRotation();
            this.m = savedState.isFirstRotation();
            this.n = savedState.isFirstRotationFinished();
            this.E = savedState.getCurrentImage();
            a[] aVarArr = savedState.faces;
            E();
            this.s = new ArrayList();
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    this.s.add(aVar);
                }
            }
            this.q = savedState.loaded;
            this.B = savedState.loading;
            this.A = savedState.bDefaultLoad;
            this.D = savedState.overrides;
            this.g = savedState.options;
            if (this.h.size() == 0) {
                this.A = true;
                a();
                return;
            }
            post(new Runnable() { // from class: com.startapp.sdk.ads.banner.banner3d.Banner3D.4
                @Override // java.lang.Runnable
                public void run() {
                    Banner3D.this.a(Banner3D.this.h, false);
                }
            });
        }
    }

    private void F() {
        if (this.r && this.c) {
            removeCallbacks(this.G);
            post(this.G);
        }
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.r = true;
        if (this.g == null || !this.g.o()) {
            this.m = false;
            this.n = true;
        }
        F();
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = false;
        removeCallbacks(this.G);
        if (this.s == null) {
            return;
        }
        for (a aVar : this.s) {
            aVar.b();
        }
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.r = true;
            if (this.g == null || !this.g.o()) {
                this.m = false;
                this.n = true;
            }
            F();
            return;
        }
        this.r = false;
        if (!this.l) {
            removeCallbacks(this.G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.startapp.sdk.ads.banner.banner3d.Banner3D.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public AdRulesResult adRulesResult;
        public boolean bDefaultLoad;
        public boolean bIsVisible;
        private int currentImage;
        private AdDetails[] details;
        public a[] faces;
        private int firstRotation;
        private int firstRotationFinished;
        public boolean loaded;
        public boolean loading;
        public BannerOptions options;
        public AdInformationOverrides overrides;
        private float rotation;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void setCurrentImage(int i) {
            this.currentImage = i;
        }

        public int getCurrentImage() {
            return this.currentImage;
        }

        public void setRotation(float f) {
            this.rotation = f;
        }

        public float getRotation() {
            return this.rotation;
        }

        public boolean isFirstRotation() {
            return this.firstRotation == 1;
        }

        public void setFirstRotation(boolean z) {
            this.firstRotation = z ? 1 : 0;
        }

        public boolean isFirstRotationFinished() {
            return this.firstRotationFinished == 1;
        }

        public void setFirstRotationFinished(boolean z) {
            this.firstRotationFinished = z ? 1 : 0;
        }

        public void setDetails(List<AdDetails> list) {
            this.details = new AdDetails[list.size()];
            for (int i = 0; i < list.size(); i++) {
                this.details[i] = list.get(i);
            }
        }

        public List<AdDetails> getDetails() {
            return Arrays.asList(this.details);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            if (parcel.readInt() == 1) {
                this.bIsVisible = true;
                this.currentImage = parcel.readInt();
                this.rotation = parcel.readFloat();
                this.firstRotation = parcel.readInt();
                this.firstRotationFinished = parcel.readInt();
                Parcelable[] readParcelableArray = parcel.readParcelableArray(AdDetails.class.getClassLoader());
                if (readParcelableArray != null) {
                    this.details = new AdDetails[readParcelableArray.length];
                    System.arraycopy(readParcelableArray, 0, this.details, 0, readParcelableArray.length);
                }
                int readInt = parcel.readInt();
                this.loaded = false;
                if (readInt == 1) {
                    this.loaded = true;
                }
                int readInt2 = parcel.readInt();
                this.loading = false;
                if (readInt2 == 1) {
                    this.loading = true;
                }
                int readInt3 = parcel.readInt();
                this.bDefaultLoad = false;
                if (readInt3 == 1) {
                    this.bDefaultLoad = true;
                }
                int readInt4 = parcel.readInt();
                if (readInt4 > 0) {
                    this.faces = new a[readInt4];
                    for (int i = 0; i < readInt4; i++) {
                        this.faces[i] = (a) parcel.readParcelable(a.class.getClassLoader());
                    }
                }
                this.overrides = (AdInformationOverrides) parcel.readSerializable();
                this.options = (BannerOptions) parcel.readSerializable();
                this.adRulesResult = (AdRulesResult) parcel.readSerializable();
                return;
            }
            this.bIsVisible = false;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            if (!this.bIsVisible) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(this.currentImage);
            parcel.writeFloat(this.rotation);
            parcel.writeInt(this.firstRotation);
            parcel.writeInt(this.firstRotationFinished);
            parcel.writeParcelableArray(this.details, i);
            int i2 = 0;
            if (this.loaded) {
                i2 = 1;
            }
            parcel.writeInt(i2);
            int i3 = 0;
            if (this.loading) {
                i3 = 1;
            }
            parcel.writeInt(i3);
            int i4 = 0;
            if (this.bDefaultLoad) {
                i4 = 1;
            }
            parcel.writeInt(i4);
            parcel.writeInt(this.faces.length);
            for (int i5 = 0; i5 < this.faces.length; i5++) {
                parcel.writeParcelable(this.faces[i5], i);
            }
            parcel.writeSerializable(this.overrides);
            parcel.writeSerializable(this.options);
            parcel.writeSerializable(this.adRulesResult);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    @Override // com.startapp.sdk.ads.banner.BannerInterface
    public void setBannerListener(BannerListener bannerListener) {
        this.F = bannerListener;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final int f() {
        return BannerMetaData.a().b().h();
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final int g() {
        if (this.t != null) {
            return this.t.a();
        }
        return 0;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final int h() {
        return this.d;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    protected final void a(int i) {
        this.d = i;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    public void setAdTag(String str) {
        this.f = str;
    }

    static /* synthetic */ void a(Banner3D banner3D, a aVar) {
        h a = aVar.a(banner3D.getContext());
        if (a == null) {
            return;
        }
        banner3D.a(a);
    }
}
