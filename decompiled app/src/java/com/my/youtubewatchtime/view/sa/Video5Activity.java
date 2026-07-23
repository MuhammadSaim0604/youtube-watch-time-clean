package com.my.youtubewatchtime.view.sa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex
 */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class Video5Activity extends AppCompatActivity {
    private LinearLayout linear43;
    private LinearLayout linear44;
    private LinearLayout linear45;
    private LinearLayout linear46;
    private LinearLayout linear47;
    private TimerTask t;
    private WebView webview17;
    private WebView webview19;
    private WebView webview21;
    private WebView webview22;
    private WebView webview23;
    private Timer _timer = new Timer();
    private String link = "";
    private Intent i = new Intent();

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427453);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear43 = (LinearLayout) findViewById(2131230979);
        this.linear44 = (LinearLayout) findViewById(2131230980);
        this.linear45 = (LinearLayout) findViewById(2131230981);
        this.linear46 = (LinearLayout) findViewById(2131230982);
        this.linear47 = (LinearLayout) findViewById(2131230983);
        this.webview17 = (WebView) findViewById(2131231241);
        this.webview17.getSettings().setJavaScriptEnabled(true);
        this.webview17.getSettings().setSupportZoom(true);
        this.webview19 = (WebView) findViewById(2131231242);
        this.webview19.getSettings().setJavaScriptEnabled(true);
        this.webview19.getSettings().setSupportZoom(true);
        this.webview21 = (WebView) findViewById(2131231243);
        this.webview21.getSettings().setJavaScriptEnabled(true);
        this.webview21.getSettings().setSupportZoom(true);
        this.webview22 = (WebView) findViewById(2131231244);
        this.webview22.getSettings().setJavaScriptEnabled(true);
        this.webview22.getSettings().setSupportZoom(true);
        this.webview23 = (WebView) findViewById(2131231245);
        this.webview23.getSettings().setJavaScriptEnabled(true);
        this.webview23.getSettings().setSupportZoom(true);
        this.webview17.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video5Activity.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview19.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video5Activity.2
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview21.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video5Activity.3
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview22.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video5Activity.4
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview23.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video5Activity.5
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initializeLogic() {
        StartAppSDK.init((Context) this, "207208158", false);
        Banner banner = new Banner((Activity) this);
        banner.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.linear47.addView(banner);
        this.link = getIntent().getStringExtra("5");
        this.webview17.loadUrl(this.link);
        this.webview19.loadUrl(this.link);
        this.webview21.loadUrl(this.link);
        this.webview22.loadUrl(this.link);
        this.webview23.loadUrl(this.link);
        this.t = new AnonymousClass6();
        this._timer.schedule(this.t, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
      /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex
     */
    /* renamed from: com.my.youtubewatchtime.view.sa.Video5Activity$6  reason: invalid class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
    public class AnonymousClass6 extends TimerTask {
        AnonymousClass6() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Video5Activity.this.runOnUiThread(new Runnable() { // from class: com.my.youtubewatchtime.view.sa.Video5Activity.6.1
                @Override // java.lang.Runnable
                public void run() {
                    new StartAppAd(Video5Activity.this).showAd(new AdDisplayListener() { // from class: com.my.youtubewatchtime.view.sa.Video5Activity.6.1.1
                        @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                        public void adDisplayed(Ad ad) {
                            SketchwareUtil.showMessage(Video5Activity.this.getApplicationContext(), "AD SHOW");
                        }

                        @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                        public void adClicked(Ad ad) {
                            SketchwareUtil.showMessage(Video5Activity.this.getApplicationContext(), "CLICK");
                        }

                        @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                        public void adHidden(Ad ad) {
                            SketchwareUtil.showMessage(Video5Activity.this.getApplicationContext(), "AD CLOSE");
                        }

                        @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                        public void adNotDisplayed(Ad ad) {
                            SketchwareUtil.showMessage(Video5Activity.this.getApplicationContext(), "AD Failed ");
                        }
                    });
                }
            });
        }
    }

    public void onBackPressed() {
        this.i.setClass(getApplicationContext(), HomeActivity.class);
        startActivity(this.i);
    }

    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Deprecated
    public int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList<Double> arrayList = new ArrayList<>();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf(checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i) {
        return TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
