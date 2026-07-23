package com.startapp.sdk.ads.banner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.common.ThreadManager;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.adrules.AdaptMetaData;
import com.startapp.sdk.adsbase.h;
import com.startapp.sdk.adsbase.j.t;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class BannerBase extends RelativeLayout {
    protected AdRulesResult a;
    protected Point b;
    protected boolean c;
    protected int d;
    protected int e;
    protected String f;
    private boolean g;
    private AdPreferences h;
    private int i;
    private boolean j;
    private com.startapp.sdk.adsbase.k.b k;
    private boolean l;
    private boolean m;
    private String n;
    private ScheduledFuture<?> o;
    private Timer p;
    private a q;
    private final Handler r;
    private final Object s;

    protected abstract void a(int i);

    protected abstract void b();

    protected abstract int c();

    protected abstract String d();

    protected abstract void e();

    protected abstract int f();

    protected abstract int g();

    protected abstract int h();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void hideBanner();

    public abstract void setAdTag(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            BannerBase.this.post(new Runnable() { // from class: com.startapp.sdk.ads.banner.BannerBase.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (BannerBase.this.isShown() || (BannerBase.this.a != null && !BannerBase.this.a.a())) {
                        BannerBase.this.m();
                    }
                }
            });
        }
    }

    public BannerBase(Context context) {
        super(context);
        this.g = false;
        this.i = 0;
        this.j = true;
        this.c = false;
        this.d = 159868227 + new Random().nextInt(100000);
        this.e = this.d + 1;
        this.f = null;
        this.l = false;
        this.m = false;
        this.o = null;
        this.p = new Timer();
        this.q = new a();
        this.r = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.startapp.sdk.ads.banner.BannerBase.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                if (message.what == 1) {
                    BannerBase.this.l();
                }
                return true;
            }
        });
        this.s = new Object();
    }

    public BannerBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = false;
        this.i = 0;
        this.j = true;
        this.c = false;
        this.d = 159868227 + new Random().nextInt(100000);
        this.e = this.d + 1;
        this.f = null;
        this.l = false;
        this.m = false;
        this.o = null;
        this.p = new Timer();
        this.q = new a();
        this.r = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.startapp.sdk.ads.banner.BannerBase.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                if (message.what == 1) {
                    BannerBase.this.l();
                }
                return true;
            }
        });
        this.s = new Object();
        setAdTag(new b(context, attributeSet).a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        if (!isInEditMode()) {
            b();
            return;
        }
        setMinimumWidth(t.a(getContext(), 300));
        setMinimumHeight(t.a(getContext(), c()));
        setBackgroundColor(Color.rgb(169, 169, 169));
        TextView textView = new TextView(getContext());
        textView.setText(d());
        textView.setTextColor(-16777216);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(textView, layoutParams);
    }

    protected int i() {
        return f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String j() {
        return this.f;
    }

    public void loadAd(int i, int i2) {
        if (getParent() == null) {
            this.b = new Point(i, i2);
            k();
        }
    }

    public void loadAd() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        loadAd(t.b(getContext(), displayMetrics.widthPixels), t.b(getContext(), displayMetrics.heightPixels));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k() {
        synchronized (this.s) {
            if (!this.r.hasMessages(1)) {
                this.r.sendEmptyMessage(1);
            }
        }
    }

    protected final void l() {
        p();
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m() {
        s();
        if (this.a == null || AdaptMetaData.a().b().a()) {
            this.a = AdaptMetaData.a().b().a(AdPreferences.Placement.INAPP_BANNER, this.f);
            if (this.a.a()) {
                e();
            } else {
                hideBanner();
            }
        } else if (this.a.a()) {
            e();
        }
    }

    private void s() {
        if (this.k != null) {
            this.k.b();
            this.k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int n() {
        return BannerMetaData.a().b().q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(h hVar) {
        if (this.k == null) {
            this.k = new com.startapp.sdk.adsbase.k.b(o(), hVar, n());
            this.k.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View o() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        if (this.g && !isInEditMode()) {
            if (this.q != null) {
                this.q.cancel();
            }
            if (this.p != null) {
                this.p.cancel();
            }
            this.q = new a();
            this.p = new Timer();
            this.p.schedule(this.q, i());
            if (this.o != null) {
                this.o.cancel(false);
            }
            this.o = ThreadManager.a(new Runnable() { // from class: com.startapp.sdk.ads.banner.BannerBase.2
                @Override // java.lang.Runnable
                public final void run() {
                    BannerBase.this.k();
                }
            }, MetaData.E().D() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q() {
        if (!isInEditMode()) {
            if (this.q != null) {
                this.q.cancel();
            }
            if (this.p != null) {
                this.p.cancel();
            }
            if (this.o != null) {
                this.o.cancel(false);
            }
            this.q = null;
            this.p = null;
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        if (isClicked()) {
            setClicked(false);
            this.m = true;
        }
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putInt("bannerId", h());
        bundle.putParcelable("upperState", onSaveInstanceState);
        bundle.putSerializable("adRulesResult", this.a);
        bundle.putSerializable("adPreferences", this.h);
        bundle.putInt("offset", this.i);
        bundle.putBoolean("firstLoad", this.j);
        bundle.putBoolean("shouldReloadBanner", this.m);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        a(bundle.getInt("bannerId"));
        this.a = (AdRulesResult) bundle.getSerializable("adRulesResult");
        this.h = (AdPreferences) bundle.getSerializable("adPreferences");
        this.i = bundle.getInt("offset");
        this.j = bundle.getBoolean("firstLoad");
        this.m = bundle.getBoolean("shouldReloadBanner");
        super.onRestoreInstanceState(bundle.getParcelable("upperState"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.g = true;
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
        q();
        s();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (this.m) {
                this.m = false;
                m();
            }
            this.g = true;
            p();
            return;
        }
        this.g = false;
        q();
    }

    public boolean isFirstLoad() {
        return this.j;
    }

    public void setFirstLoad(boolean z) {
        this.j = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r() {
        if (isFirstLoad() || AdaptMetaData.a().b().a()) {
            setFirstLoad(false);
            com.startapp.sdk.adsbase.adrules.b.a().a(new com.startapp.sdk.adsbase.adrules.a(AdPreferences.Placement.INAPP_BANNER, this.f));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(AdPreferences adPreferences) {
        adPreferences.setHardwareAccelerated(com.startapp.common.b.b.a(this, this.g));
    }

    public boolean isClicked() {
        return this.l;
    }

    public void setClicked(boolean z) {
        this.l = z;
    }

    public void setErrorMessage(String str) {
        this.n = str;
    }

    public String getErrorMessage() {
        return this.n;
    }
}
