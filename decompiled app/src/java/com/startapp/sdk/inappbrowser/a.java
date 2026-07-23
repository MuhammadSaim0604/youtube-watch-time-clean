package com.startapp.sdk.inappbrowser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.t;
import com.startapp.sdk.adsbase.j.u;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class a extends com.startapp.sdk.ads.a.b implements View.OnClickListener {
    protected static boolean e = false;
    protected NavigationBarLayout c;
    protected AnimatingProgressBar d;
    private RelativeLayout f;
    private WebView g;
    private FrameLayout h;
    private String i;

    public a(String str) {
        this.i = str;
    }

    @Override // com.startapp.sdk.ads.a.b
    public final void a(Bundle bundle) {
        super.a(bundle);
        e = false;
        this.f = new RelativeLayout(c());
        String str = this.i;
        if (this.c == null) {
            this.c = new NavigationBarLayout(c());
            this.c.a();
            this.c.b();
            this.c.setButtonsListener(this);
        }
        this.f.addView(this.c);
        this.d = new AnimatingProgressBar(c(), null, 16842872);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setColor(Color.parseColor("#45d200"));
        this.d.setProgressDrawable(new ClipDrawable(shapeDrawable, 3, 1));
        this.d.setBackgroundColor(-1);
        this.d.setId(2108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, t.a(c(), 4));
        layoutParams.addRule(3, 2101);
        this.f.addView(this.d, layoutParams);
        this.h = new FrameLayout(c());
        if (this.g == null) {
            try {
                this.g = new WebView(c());
                this.g.getSettings().setJavaScriptEnabled(true);
                this.g.getSettings().setUseWideViewPort(true);
                this.g.getSettings().setLoadWithOverviewMode(true);
                this.g.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                this.g.getSettings().setBuiltInZoomControls(true);
                if (Build.VERSION.SDK_INT >= 11) {
                    this.g.getSettings().setDisplayZoomControls(false);
                }
                this.g.setWebViewClient(new C0045a(c(), this.c, this.d, this));
                this.g.setWebChromeClient(new WebChromeClient() { // from class: com.startapp.sdk.inappbrowser.a.1
                    @Override // android.webkit.WebChromeClient
                    public final void onProgressChanged(WebView webView, int i) {
                        a.this.d.setProgress(i);
                    }

                    @Override // android.webkit.WebChromeClient
                    public final void onReceivedTitle(WebView webView, String str2) {
                        if (str2 != null && !str2.equals("")) {
                            a.this.c.d().setText(str2);
                        }
                    }
                });
                this.g.loadUrl(str);
            } catch (Throwable th) {
                new e(th).a((Context) c());
                this.c.e();
                com.startapp.sdk.adsbase.a.c(c(), str);
                c().finish();
            }
        }
        this.h.addView(this.g);
        this.h.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(15);
        layoutParams2.addRule(3, 2108);
        this.f.addView(this.h, layoutParams2);
        if (bundle != null) {
            this.g.restoreState(bundle);
        }
        c().setContentView(this.f, new RelativeLayout.LayoutParams(-2, -2));
    }

    @Override // com.startapp.sdk.ads.a.b
    public final void u() {
    }

    @Override // com.startapp.sdk.ads.a.b
    public final void s() {
    }

    @Override // com.startapp.sdk.ads.a.b
    public final void b(Bundle bundle) {
        this.g.saveState(bundle);
    }

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.inappbrowser.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
    static class C0045a extends WebViewClient {
        private Context a;
        private a b;
        private NavigationBarLayout c;
        private AnimatingProgressBar d;
        private int e = 0;
        private boolean f = false;

        public C0045a(Context context, NavigationBarLayout navigationBarLayout, AnimatingProgressBar animatingProgressBar, a aVar) {
            this.a = context;
            this.d = animatingProgressBar;
            this.c = navigationBarLayout;
            this.b = aVar;
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!a.e) {
                new StringBuilder("IABWebViewClient::onPageStarted - [").append(str).append("]REDIRECTED  -> ").append(this.e).append(" Can go back ").append(webView.canGoBack());
                if (this.f) {
                    this.e = 1;
                    this.d.a();
                    this.c.a(webView);
                } else {
                    this.e = Math.max(this.e, 1);
                }
                this.d.setVisibility(0);
                this.c.c().setText(str);
                this.c.a(webView);
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (webView == null || str == null) {
                return true;
            }
            if (u.a(webView.getContext(), str)) {
                return true;
            }
            if (!a.e) {
                if (!this.f) {
                    this.f = true;
                    this.d.a();
                    this.e = 0;
                }
                this.e++;
                if (!com.startapp.sdk.adsbase.a.c(str) || com.startapp.sdk.adsbase.a.b(str)) {
                    this.e = 1;
                    com.startapp.sdk.adsbase.a.c(this.a, str);
                    if (this.b != null) {
                        this.b.a();
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            if (!a.e) {
                new StringBuilder("IABWebViewClient::onPageFinished - [").append(str).append("]");
                this.c.a(webView);
                int i = this.e - 1;
                this.e = i;
                if (i == 0) {
                    this.f = false;
                    this.d.a();
                    if (this.d.isShown()) {
                        this.d.setVisibility(8);
                    }
                    this.c.a(webView);
                }
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            new StringBuilder("IABWebViewClient::onReceivedError - [").append(str).append("], [").append(str2).append("]");
            this.d.a();
            super.onReceivedError(webView, i, str, str2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case 2103:
                break;
            case 2104:
                if (this.g != null) {
                    com.startapp.sdk.adsbase.a.c(c(), this.g.getUrl());
                    break;
                } else {
                    return;
                }
            case 2105:
                if (this.g != null && this.g.canGoBack()) {
                    this.d.a();
                    this.g.goBack();
                    return;
                }
                return;
            case 2106:
                if (this.g != null && this.g.canGoForward()) {
                    this.d.a();
                    this.g.goForward();
                    return;
                }
                return;
            default:
                return;
        }
        a();
    }

    @Override // com.startapp.sdk.ads.a.b
    public final boolean a(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 4:
                    if (this.g != null && this.g.canGoBack()) {
                        this.d.a();
                        this.g.goBack();
                    } else {
                        a();
                    }
                    return true;
            }
        }
        return super.a(i, keyEvent);
    }

    final void a() {
        y();
        this.c.e();
        c().finish();
    }

    private void y() {
        try {
            e = true;
            this.g.stopLoading();
            this.g.removeAllViews();
            this.g.postInvalidate();
            com.startapp.common.b.b.b(this.g);
            this.g.destroy();
            this.g = null;
        } catch (Exception e2) {
            new StringBuilder("IABrowserMode::destroyWebview error ").append(e2.getMessage());
        }
    }
}
