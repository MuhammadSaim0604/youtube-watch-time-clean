package com.startapp.sdk.adsbase.adinformation;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.adinformation.AdInformationConfig;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.SimpleTokenConfig;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AdInformationObject implements View.OnClickListener {
    Context a;
    RelativeLayout b;
    RelativeLayout c;
    private AdInformationView d;
    private WebView e;
    private AdPreferences.Placement g;
    private AdInformationOverrides k;
    private Dialog f = null;
    private final Handler h = new Handler(Looper.getMainLooper());
    private DisplayMode i = DisplayMode.REGULAR;
    private boolean j = false;
    private Runnable n = new Runnable() { // from class: com.startapp.sdk.adsbase.adinformation.AdInformationObject.1
        @Override // java.lang.Runnable
        public final void run() {
            try {
                AdInformationObject.this.e();
                SimpleTokenConfig.a(AdInformationObject.this.a, true);
                AdInformationConfig.b(AdInformationObject.this.a);
                AdInformationObject.this.a(false);
            } catch (Throwable th) {
                new e(th).a(AdInformationObject.this.a);
            }
        }
    };
    private Runnable o = new Runnable() { // from class: com.startapp.sdk.adsbase.adinformation.AdInformationObject.2
        @Override // java.lang.Runnable
        public final void run() {
            try {
                AdInformationObject.this.e();
                SimpleTokenUtils.b();
                SimpleTokenConfig.a(AdInformationObject.this.a, false);
                AdInformationConfig.b(AdInformationObject.this.a);
                AdInformationObject.this.a(false);
            } catch (Throwable th) {
                new e(th).a(AdInformationObject.this.a);
            }
        }
    };
    private Runnable p = new Runnable() { // from class: com.startapp.sdk.adsbase.adinformation.AdInformationObject.3
        @Override // java.lang.Runnable
        public final void run() {
            try {
                AdInformationObject.this.e();
                AdInformationObject.this.d();
                AdInformationObject.this.a(false);
            } catch (Throwable th) {
                new e(th).a(AdInformationObject.this.a);
            }
        }
    };
    private AdInformationConfig l = AdInformationMetaData.b().a();
    private SimpleTokenConfig m = MetaData.E().e();

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum DisplayMode {
        REGULAR,
        LAYOUT
    }

    static {
        AdInformationObject.class.getSimpleName();
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum Size {
        SMALL(AdInformationConfig.ImageResourceType.INFO_S, AdInformationConfig.ImageResourceType.INFO_EX_S),
        LARGE(AdInformationConfig.ImageResourceType.INFO_L, AdInformationConfig.ImageResourceType.INFO_EX_L);
        
        private AdInformationConfig.ImageResourceType infoExtendedType;
        private AdInformationConfig.ImageResourceType infoType;

        Size(AdInformationConfig.ImageResourceType imageResourceType, AdInformationConfig.ImageResourceType imageResourceType2) {
            this.infoType = imageResourceType;
            this.infoExtendedType = imageResourceType2;
        }

        public final AdInformationConfig.ImageResourceType a() {
            return this.infoType;
        }
    }

    public AdInformationObject(Context context, Size size, AdPreferences.Placement placement, AdInformationOverrides adInformationOverrides) {
        this.a = context;
        this.g = placement;
        this.k = adInformationOverrides;
        this.d = new AdInformationView(context, size, placement, adInformationOverrides, this);
    }

    public final void a(RelativeLayout relativeLayout) {
        boolean a;
        if (this.k != null && this.k.e()) {
            a = this.k.b();
        } else {
            a = AdInformationMetaData.b().a().a(this.a);
        }
        if (a) {
            this.c = relativeLayout;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.k != null && this.k.d()) {
                this.k.c().addRules(layoutParams);
            } else {
                AdInformationMetaData.b().a().a(this.g).addRules(layoutParams);
            }
            this.c.addView(this.d, layoutParams);
        }
    }

    public final View a() {
        return this.d;
    }

    public final boolean b() {
        return this.j;
    }

    public static AdInformationConfig c() {
        return AdInformationMetaData.b().a();
    }

    final void a(boolean z) {
        AdPreferences.Placement placement = this.g;
        if (!(placement == AdPreferences.Placement.INAPP_FULL_SCREEN || placement == AdPreferences.Placement.INAPP_OFFER_WALL || placement == AdPreferences.Placement.INAPP_SPLASH || placement == AdPreferences.Placement.INAPP_OVERLAY) && (this.a instanceof Activity)) {
            u.a((Activity) this.a, z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.m.a(this.a) && (this.a instanceof Activity) && !((Activity) this.a).isFinishing()) {
            a(true);
            this.b = new RelativeLayout(this.a);
            try {
                this.e = new WebView(this.a);
                this.e.setWebViewClient(new WebViewClient());
                this.e.setWebChromeClient(new WebChromeClient());
                this.e.getSettings().setJavaScriptEnabled(true);
                this.e.setHorizontalScrollBarEnabled(false);
                this.e.setVerticalScrollBarEnabled(false);
                WebView webView = this.e;
                StringBuilder sb = new StringBuilder(this.l.e());
                if (j.a(this.a, "shared_prefs_using_location", Boolean.FALSE).booleanValue()) {
                    sb.append("?le=true");
                }
                webView.loadUrl(sb.toString());
                this.e.addJavascriptInterface(new a(this.a, this.n, this.o, this.p), "startappwall");
                Point point = new Point(1, 1);
                try {
                    WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
                    if (Build.VERSION.SDK_INT >= 13) {
                        windowManager.getDefaultDisplay().getSize(point);
                    } else {
                        point.x = windowManager.getDefaultDisplay().getWidth();
                        point.y = windowManager.getDefaultDisplay().getHeight();
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    this.e.setPadding(0, 0, 0, 0);
                    layoutParams.setMargins(0, 0, 0, 0);
                    this.b.addView(this.e, layoutParams);
                    String a = com.startapp.sdk.adsbase.a.a(this.a, (String) null);
                    if (a != null) {
                        this.e.loadUrl("javascript:window.onload=function(){document.getElementById('titlePlacement').innerText='" + a + "';}");
                    }
                    switch (this.i) {
                        case LAYOUT:
                            final RelativeLayout relativeLayout = this.b;
                            this.j = true;
                            final RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (point.x * 0.9f), (int) (point.y * 0.85f));
                            layoutParams2.addRule(13);
                            this.h.post(new Runnable() { // from class: com.startapp.sdk.adsbase.adinformation.AdInformationObject.5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AdInformationObject.this.c.addView(relativeLayout, layoutParams2);
                                }
                            });
                            return;
                        case REGULAR:
                            RelativeLayout relativeLayout2 = this.b;
                            this.j = true;
                            this.f = new Dialog(this.a);
                            this.f.requestWindowFeature(1);
                            this.f.setContentView(relativeLayout2);
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams();
                            layoutParams3.copyFrom(this.f.getWindow().getAttributes());
                            layoutParams3.width = (int) (point.x * 0.9f);
                            layoutParams3.height = (int) (point.y * 0.85f);
                            this.f.show();
                            this.f.getWindow().setAttributes(layoutParams3);
                            return;
                        default:
                            return;
                    }
                } catch (Throwable th) {
                    new e(th).a(this.a);
                    a(false);
                    return;
                }
            } catch (Throwable th2) {
                new e(th2).a(this.a);
                a(false);
                return;
            }
        }
        d();
    }

    protected final void d() {
        if (!u.a(256L) || !MetaData.E().y()) {
            com.startapp.sdk.adsbase.a.c(this.a, this.l.b());
        } else {
            com.startapp.sdk.adsbase.a.a(this.a, this.l.b(), "");
        }
    }

    public final void e() {
        this.j = false;
        switch (this.i) {
            case LAYOUT:
                this.h.post(new Runnable() { // from class: com.startapp.sdk.adsbase.adinformation.AdInformationObject.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdInformationObject.this.c.removeView(AdInformationObject.this.b);
                    }
                });
                return;
            case REGULAR:
                this.f.dismiss();
                return;
            default:
                return;
        }
    }
}
