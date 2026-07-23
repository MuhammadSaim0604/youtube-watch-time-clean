package com.my.youtubewatchtime.view.sa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex
 */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class HomeActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button7;
    private Button button8;
    private CircleImageView circleimageview1;
    private EditText edittext2;
    private ImageView imageview1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private TimerTask t;
    private TextView textview1;
    private WebView webview1;
    private Timer _timer = new Timer();
    private Intent i5 = new Intent();
    private Intent i10 = new Intent();
    private Intent i15 = new Intent();
    private Intent i20 = new Intent();
    private Intent i25 = new Intent();
    private Intent i8 = new Intent();
    private Intent i = new Intent();

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427373);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear2 = (LinearLayout) findViewById(2131230976);
        this.linear3 = (LinearLayout) findViewById(2131230977);
        this.edittext2 = (EditText) findViewById(2131230904);
        this.imageview1 = (ImageView) findViewById(2131230953);
        this.linear8 = (LinearLayout) findViewById(2131231000);
        this.linear4 = (LinearLayout) findViewById(2131230978);
        this.linear5 = (LinearLayout) findViewById(2131230986);
        this.linear6 = (LinearLayout) findViewById(2131230995);
        this.linear7 = (LinearLayout) findViewById(2131230999);
        this.linear9 = (LinearLayout) findViewById(2131231001);
        this.circleimageview1 = (CircleImageView) findViewById(2131230846);
        this.textview1 = (TextView) findViewById(2131231207);
        this.button1 = (Button) findViewById(2131230818);
        this.button2 = (Button) findViewById(2131230819);
        this.button3 = (Button) findViewById(2131230820);
        this.button4 = (Button) findViewById(2131230821);
        this.button5 = (Button) findViewById(2131230822);
        this.button8 = (Button) findViewById(2131230824);
        this.button7 = (Button) findViewById(2131230823);
        this.webview1 = (WebView) findViewById(2131231240);
        this.webview1.getSettings().setJavaScriptEnabled(true);
        this.webview1.getSettings().setSupportZoom(true);
        this.imageview1.setOnClickListener(new View.OnClickListener() { // from class: com.my.youtubewatchtime.view.sa.HomeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new StartAppAd(HomeActivity.this).showAd(new AdDisplayListener() { // from class: com.my.youtubewatchtime.view.sa.HomeActivity.1.1
                    @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                    public void adDisplayed(Ad ad) {
                        SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "AD SHOW");
                    }

                    @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                    public void adClicked(Ad ad) {
                        SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "CLICK");
                    }

                    @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                    public void adHidden(Ad ad) {
                        SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "AD CLOSE");
                    }

                    @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                    public void adNotDisplayed(Ad ad) {
                        SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "AD Failed ");
                    }
                });
                HomeActivity.this.webview1.loadUrl(HomeActivity.this.edittext2.getText().toString());
            }
        });
        this.button1.setOnClickListener(new View.OnClickListener() { // from class: com.my.youtubewatchtime.view.sa.HomeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomeActivity.this.i5.setClass(HomeActivity.this.getApplicationContext(), Video5Activity.class);
                HomeActivity.this.i5.putExtra("5", HomeActivity.this.edittext2.getText().toString());
                HomeActivity.this.startActivity(HomeActivity.this.i5);
            }
        });
        this.button2.setOnClickListener(new View.OnClickListener() { // from class: com.my.youtubewatchtime.view.sa.HomeActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomeActivity.this.i10.setClass(HomeActivity.this.getApplicationContext(), Video10Activity.class);
                HomeActivity.this.i10.putExtra("10", HomeActivity.this.edittext2.getText().toString());
                HomeActivity.this.startActivity(HomeActivity.this.i10);
            }
        });
        this.button3.setOnClickListener(new View.OnClickListener() { // from class: com.my.youtubewatchtime.view.sa.HomeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomeActivity.this.i15.setClass(HomeActivity.this.getApplicationContext(), Video15Activity.class);
                HomeActivity.this.i15.putExtra("15", HomeActivity.this.edittext2.getText().toString());
                HomeActivity.this.startActivity(HomeActivity.this.i15);
            }
        });
        this.button4.setOnClickListener(new View.OnClickListener() { // from class: com.my.youtubewatchtime.view.sa.HomeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomeActivity.this.i20.setClass(HomeActivity.this.getApplicationContext(), Video20Activity.class);
                HomeActivity.this.i20.putExtra("20", HomeActivity.this.edittext2.getText().toString());
                HomeActivity.this.startActivity(HomeActivity.this.i20);
            }
        });
        this.button5.setOnClickListener(new View.OnClickListener() { // from class: com.my.youtubewatchtime.view.sa.HomeActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomeActivity.this.i25.setClass(HomeActivity.this.getApplicationContext(), Video25Activity.class);
                HomeActivity.this.i25.putExtra("25", HomeActivity.this.edittext2.getText().toString());
                HomeActivity.this.startActivity(HomeActivity.this.i25);
            }
        });
        this.button8.setOnClickListener(new View.OnClickListener() { // from class: com.my.youtubewatchtime.view.sa.HomeActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomeActivity.this.i8.setAction("android.intent.action.VIEW");
                HomeActivity.this.i8.setData(Uri.parse("https://whatsapp.com/channel/0029VavHzv259PwTIz1XxJ09"));
                HomeActivity.this.startActivity(HomeActivity.this.i8);
            }
        });
        this.button7.setOnClickListener(new View.OnClickListener() { // from class: com.my.youtubewatchtime.view.sa.HomeActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "Coming Soon Stay On My App Store\nSite: allmodapphere.blogspot.com");
            }
        });
        this.webview1.setWebViewClient(new WebViewClient() { // from class: com.my.youtubewatchtime.view.sa.HomeActivity.9
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
        this.linear8.addView(banner);
        this.t = new AnonymousClass10();
        this._timer.schedule(this.t, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
      /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex
     */
    /* renamed from: com.my.youtubewatchtime.view.sa.HomeActivity$10  reason: invalid class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
    public class AnonymousClass10 extends TimerTask {
        AnonymousClass10() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() { // from class: com.my.youtubewatchtime.view.sa.HomeActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    new StartAppAd(HomeActivity.this).showAd(new AdDisplayListener() { // from class: com.my.youtubewatchtime.view.sa.HomeActivity.10.1.1
                        @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                        public void adDisplayed(Ad ad) {
                            SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "AD SHOW");
                        }

                        @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                        public void adClicked(Ad ad) {
                            SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "CLICK");
                        }

                        @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                        public void adHidden(Ad ad) {
                            SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "AD CLOSE");
                        }

                        @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                        public void adNotDisplayed(Ad ad) {
                            SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "AD Failed ");
                        }
                    });
                }
            });
        }
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
