package com.startapp.sdk.adsbase.consent;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.startapp.common.b.b;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.b.c;
import java.net.URI;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class ConsentActivity extends Activity {
    private WebView a;
    private String b;
    private boolean c;

    static /* synthetic */ boolean a(ConsentActivity consentActivity) {
        consentActivity.c = true;
        return true;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        String dataString = getIntent().getDataString();
        if (!TextUtils.isEmpty(dataString)) {
            try {
                URI uri = new URI(dataString);
                this.b = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, null).toString();
                this.a = new WebView(this);
                this.a.setWebViewClient(new a());
                this.a.getSettings().setJavaScriptEnabled(true);
                this.a.setHorizontalScrollBarEnabled(false);
                this.a.setVerticalScrollBarEnabled(false);
                if (Build.VERSION.SDK_INT >= 15) {
                    this.a.getSettings().setTextZoom(100);
                } else {
                    this.a.getSettings().setTextSize(WebSettings.TextSize.NORMAL);
                }
                this.a.loadUrl(dataString);
                this.a.setBackgroundColor(0);
                b.d(this.a);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(13);
                relativeLayout.addView(this.a, layoutParams2);
            } catch (Throwable th) {
                new e(th).a((Context) this);
            }
        }
        setContentView(relativeLayout, layoutParams);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        c.a(this).f().c();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        ConsentConfig f = MetaData.E().f();
        if (!this.c && f != null && f.b() && u.c(this) && u.h(this)) {
            new e(InfoEventCategory.GENERAL).f("ConsentActivityHasBeenCovered").a((Context) this);
            finish();
            startActivity(getIntent());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.a == null) {
            this.c = true;
            super.onBackPressed();
            return;
        }
        String url = this.a.getUrl();
        if (this.b != null && url != null && url.contains(this.b)) {
            this.a.loadUrl("javascript:startappBackPressed();");
        } else if (this.a.canGoBack()) {
            this.a.goBack();
        } else {
            this.c = true;
            super.onBackPressed();
        }
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            Bundle extras = ConsentActivity.this.getIntent().getExtras();
            if (extras != null) {
                StringBuilder sb = new StringBuilder("javascript:var obj = {};");
                if (!TextUtils.isEmpty(str)) {
                    sb.append("obj.template = '").append(str).append("';");
                }
                if (extras.containsKey("allowCT")) {
                    sb.append("obj.allowCT = ").append(extras.getBoolean("allowCT")).append(";");
                }
                String a = u.a((Context) ConsentActivity.this);
                if (!TextUtils.isEmpty(a)) {
                    sb.append("obj.imageBase64 = '").append(a).append("';");
                }
                if (extras.containsKey("dParam")) {
                    String string = extras.getString("dParam");
                    if (!TextUtils.isEmpty(string)) {
                        sb.append("obj.dParam = '").append(string).append("';");
                    }
                }
                if (extras.containsKey("clickUrl")) {
                    String string2 = extras.getString("clickUrl");
                    if (!TextUtils.isEmpty(string2)) {
                        sb.append("obj.clickUrl = '").append(string2).append("';");
                    }
                }
                if (extras.containsKey("impressionUrl")) {
                    String string3 = extras.getString("impressionUrl");
                    if (!TextUtils.isEmpty(string3)) {
                        sb.append("obj.impressionUrl = '").append(string3).append("';");
                    }
                }
                String c = c.a(ConsentActivity.this).a().c().c();
                if (!TextUtils.isEmpty(c)) {
                    sb.append("obj.locales = '").append(c).append("';");
                }
                if (extras.containsKey("timestamp")) {
                    sb.append("obj.timeStamp = ").append(extras.getLong("timestamp")).append(";");
                }
                if (extras.containsKey("templateName")) {
                    sb.append("obj.templateName = ").append(extras.getInt("templateName")).append(";");
                }
                if (extras.containsKey("templateId")) {
                    sb.append("obj.templateId = ").append(extras.getInt("templateId")).append(";");
                }
                sb.append("obj.os = 'android';");
                sb.append("obj.consentTypeInfo = {};");
                if (extras.containsKey("impression")) {
                    sb.append("obj.consentTypeInfo.impression = ").append(extras.getInt("impression")).append(";");
                }
                if (extras.containsKey("trueClick")) {
                    sb.append("obj.consentTypeInfo.trueClick = ").append(extras.getInt("trueClick")).append(";");
                }
                if (extras.containsKey("falseClick")) {
                    sb.append("obj.consentTypeInfo.falseClick = ").append(extras.getInt("falseClick")).append(";");
                }
                sb.append("startappInit(obj);");
                webView.loadUrl(sb.toString());
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return a(webResourceRequest.getUrl());
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return a(Uri.parse(str));
        }

        private boolean a(Uri uri) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            ConsentConfig f = MetaData.E().f();
            if (scheme == null || !scheme.equalsIgnoreCase("startappad") || TextUtils.isEmpty(host) || f == null) {
                return false;
            }
            if (host.equalsIgnoreCase("setconsent")) {
                String queryParameter = uri.getQueryParameter("status");
                String queryParameter2 = uri.getQueryParameter("apc");
                Integer num = null;
                Boolean bool = null;
                try {
                    if (!TextUtils.isEmpty(queryParameter)) {
                        num = Integer.valueOf(Integer.parseInt(queryParameter));
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        bool = Boolean.valueOf(Boolean.parseBoolean(queryParameter2));
                    }
                    c.a(ConsentActivity.this).f().a(num, Long.valueOf(f.e()), bool, true, true);
                } catch (Throwable th) {
                    new e(th).a((Context) ConsentActivity.this);
                }
                return true;
            } else if (host.equalsIgnoreCase("close")) {
                ConsentActivity.a(ConsentActivity.this);
                ConsentActivity.this.finish();
                return true;
            } else {
                return false;
            }
        }
    }
}
