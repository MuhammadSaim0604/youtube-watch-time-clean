package com.my.youtubewatchtime.view.sa;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
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
public class Video25Activity extends AppCompatActivity {
    private LinearLayout linear51;
    private LinearLayout linear52;
    private LinearLayout linear55;
    private LinearLayout linear56;
    private LinearLayout linear57;
    private LinearLayout linear58;
    private LinearLayout linear59;
    private LinearLayout linear60;
    private LinearLayout linear61;
    private LinearLayout linear62;
    private TimerTask t;
    private ScrollView vscroll3;
    private WebView webview32;
    private WebView webview33;
    private WebView webview34;
    private WebView webview35;
    private WebView webview36;
    private WebView webview37;
    private WebView webview38;
    private WebView webview39;
    private WebView webview40;
    private WebView webview41;
    private WebView webview42;
    private WebView webview43;
    private WebView webview44;
    private WebView webview45;
    private WebView webview46;
    private WebView webview47;
    private WebView webview48;
    private WebView webview49;
    private WebView webview50;
    private WebView webview51;
    private WebView webview52;
    private WebView webview53;
    private WebView webview54;
    private WebView webview55;
    private WebView webview56;
    private Timer _timer = new Timer();
    private String link = "";
    private Intent i = new Intent();

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427452);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.vscroll3 = (ScrollView) findViewById(2131231239);
        this.linear51 = (LinearLayout) findViewById(2131230988);
        this.linear52 = (LinearLayout) findViewById(2131230989);
        this.linear55 = (LinearLayout) findViewById(2131230990);
        this.linear56 = (LinearLayout) findViewById(2131230991);
        this.linear57 = (LinearLayout) findViewById(2131230992);
        this.linear58 = (LinearLayout) findViewById(2131230993);
        this.linear59 = (LinearLayout) findViewById(2131230994);
        this.linear60 = (LinearLayout) findViewById(2131230996);
        this.linear61 = (LinearLayout) findViewById(2131230997);
        this.linear62 = (LinearLayout) findViewById(2131230998);
        this.webview32 = (WebView) findViewById(2131231252);
        this.webview32.getSettings().setJavaScriptEnabled(true);
        this.webview32.getSettings().setSupportZoom(true);
        this.webview33 = (WebView) findViewById(2131231253);
        this.webview33.getSettings().setJavaScriptEnabled(true);
        this.webview33.getSettings().setSupportZoom(true);
        this.webview34 = (WebView) findViewById(2131231254);
        this.webview34.getSettings().setJavaScriptEnabled(true);
        this.webview34.getSettings().setSupportZoom(true);
        this.webview35 = (WebView) findViewById(2131231255);
        this.webview35.getSettings().setJavaScriptEnabled(true);
        this.webview35.getSettings().setSupportZoom(true);
        this.webview36 = (WebView) findViewById(2131231256);
        this.webview36.getSettings().setJavaScriptEnabled(true);
        this.webview36.getSettings().setSupportZoom(true);
        this.webview37 = (WebView) findViewById(2131231257);
        this.webview37.getSettings().setJavaScriptEnabled(true);
        this.webview37.getSettings().setSupportZoom(true);
        this.webview38 = (WebView) findViewById(2131231258);
        this.webview38.getSettings().setJavaScriptEnabled(true);
        this.webview38.getSettings().setSupportZoom(true);
        this.webview39 = (WebView) findViewById(2131231259);
        this.webview39.getSettings().setJavaScriptEnabled(true);
        this.webview39.getSettings().setSupportZoom(true);
        this.webview40 = (WebView) findViewById(2131231260);
        this.webview40.getSettings().setJavaScriptEnabled(true);
        this.webview40.getSettings().setSupportZoom(true);
        this.webview41 = (WebView) findViewById(2131231261);
        this.webview41.getSettings().setJavaScriptEnabled(true);
        this.webview41.getSettings().setSupportZoom(true);
        this.webview42 = (WebView) findViewById(2131231262);
        this.webview42.getSettings().setJavaScriptEnabled(true);
        this.webview42.getSettings().setSupportZoom(true);
        this.webview43 = (WebView) findViewById(2131231263);
        this.webview43.getSettings().setJavaScriptEnabled(true);
        this.webview43.getSettings().setSupportZoom(true);
        this.webview44 = (WebView) findViewById(2131231264);
        this.webview44.getSettings().setJavaScriptEnabled(true);
        this.webview44.getSettings().setSupportZoom(true);
        this.webview45 = (WebView) findViewById(2131231265);
        this.webview45.getSettings().setJavaScriptEnabled(true);
        this.webview45.getSettings().setSupportZoom(true);
        this.webview46 = (WebView) findViewById(2131231266);
        this.webview46.getSettings().setJavaScriptEnabled(true);
        this.webview46.getSettings().setSupportZoom(true);
        this.webview47 = (WebView) findViewById(2131231267);
        this.webview47.getSettings().setJavaScriptEnabled(true);
        this.webview47.getSettings().setSupportZoom(true);
        this.webview48 = (WebView) findViewById(2131231268);
        this.webview48.getSettings().setJavaScriptEnabled(true);
        this.webview48.getSettings().setSupportZoom(true);
        this.webview49 = (WebView) findViewById(2131231269);
        this.webview49.getSettings().setJavaScriptEnabled(true);
        this.webview49.getSettings().setSupportZoom(true);
        this.webview50 = (WebView) findViewById(2131231270);
        this.webview50.getSettings().setJavaScriptEnabled(true);
        this.webview50.getSettings().setSupportZoom(true);
        this.webview51 = (WebView) findViewById(2131231271);
        this.webview51.getSettings().setJavaScriptEnabled(true);
        this.webview51.getSettings().setSupportZoom(true);
        this.webview52 = (WebView) findViewById(2131231272);
        this.webview52.getSettings().setJavaScriptEnabled(true);
        this.webview52.getSettings().setSupportZoom(true);
        this.webview53 = (WebView) findViewById(2131231273);
        this.webview53.getSettings().setJavaScriptEnabled(true);
        this.webview53.getSettings().setSupportZoom(true);
        this.webview54 = (WebView) findViewById(2131231274);
        this.webview54.getSettings().setJavaScriptEnabled(true);
        this.webview54.getSettings().setSupportZoom(true);
        this.webview55 = (WebView) findViewById(2131231275);
        this.webview55.getSettings().setJavaScriptEnabled(true);
        this.webview55.getSettings().setSupportZoom(true);
        this.webview56 = (WebView) findViewById(2131231276);
        this.webview56.getSettings().setJavaScriptEnabled(true);
        this.webview56.getSettings().setSupportZoom(true);
        this.webview32.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview33.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.2
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview34.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.3
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview35.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.4
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview36.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.5
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview37.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.6
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview38.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.7
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview39.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.8
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview40.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.9
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview41.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.10
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview42.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.11
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview43.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.12
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview44.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.13
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview45.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.14
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview46.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.15
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview47.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.16
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview48.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.17
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview49.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.18
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview50.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.19
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview51.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.20
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview52.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.21
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview53.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.22
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview54.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.23
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview55.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.24
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.webview56.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.25
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
        this.link = getIntent().getStringExtra("25");
        this.webview32.loadUrl(this.link);
        this.webview33.loadUrl(this.link);
        this.webview34.loadUrl(this.link);
        this.webview35.loadUrl(this.link);
        this.webview36.loadUrl(this.link);
        this.webview37.loadUrl(this.link);
        this.webview38.loadUrl(this.link);
        this.webview39.loadUrl(this.link);
        this.webview40.loadUrl(this.link);
        this.webview41.loadUrl(this.link);
        this.webview42.loadUrl(this.link);
        this.webview43.loadUrl(this.link);
        this.webview44.loadUrl(this.link);
        this.webview45.loadUrl(this.link);
        this.webview46.loadUrl(this.link);
        this.webview47.loadUrl(this.link);
        this.webview48.loadUrl(this.link);
        this.webview49.loadUrl(this.link);
        this.webview50.loadUrl(this.link);
        this.webview51.loadUrl(this.link);
        this.webview52.loadUrl(this.link);
        this.webview53.loadUrl(this.link);
        this.webview54.loadUrl(this.link);
        this.webview55.loadUrl(this.link);
        this.webview56.loadUrl(this.link);
        this.t = new AnonymousClass26();
        this._timer.schedule(this.t, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
      /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex
     */
    /* renamed from: com.my.youtubewatchtime.view.sa.Video25Activity$26  reason: invalid class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
    public class AnonymousClass26 extends TimerTask {
        AnonymousClass26() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Video25Activity.this.runOnUiThread(new Runnable() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.26.1
                @Override // java.lang.Runnable
                public void run() {
                    new StartAppAd(Video25Activity.this).showAd(new AdDisplayListener() { // from class: com.my.youtubewatchtime.view.sa.Video25Activity.26.1.1
                        @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                        public void adDisplayed(Ad ad) {
                            SketchwareUtil.showMessage(Video25Activity.this.getApplicationContext(), "AD SHOW");
                        }

                        @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                        public void adClicked(Ad ad) {
                            SketchwareUtil.showMessage(Video25Activity.this.getApplicationContext(), "CLICK");
                        }

                        @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                        public void adHidden(Ad ad) {
                            SketchwareUtil.showMessage(Video25Activity.this.getApplicationContext(), "AD CLOSE");
                        }

                        @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                        public void adNotDisplayed(Ad ad) {
                            SketchwareUtil.showMessage(Video25Activity.this.getApplicationContext(), "AD Failed ");
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
