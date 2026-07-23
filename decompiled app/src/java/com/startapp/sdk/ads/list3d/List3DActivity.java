package com.startapp.sdk.ads.list3d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adinformation.AdInformationOverrides;
import com.startapp.sdk.adsbase.commontracking.CloseTrackingParams;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.j.t;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.k;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class List3DActivity extends Activity implements h {
    String a;
    String b;
    List<d> c;
    private List3DView d;
    private int g;
    private AdInformationObject h;
    private Long i;
    private Long j;
    private String k;
    private ProgressDialog e = null;
    private WebView f = null;
    private long l = 0;
    private long m = 0;
    private BroadcastReceiver n = new BroadcastReceiver() { // from class: com.startapp.sdk.ads.list3d.List3DActivity.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            List3DActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        View view;
        try {
            overridePendingTransition(0, 0);
            super.onCreate(bundle);
            if (getIntent().getBooleanExtra("fullscreen", false)) {
                requestWindowFeature(1);
                getWindow().setFlags(1024, 1024);
            }
            if (bundle == null) {
                com.startapp.common.b.a(this).a(new Intent("com.startapp.android.ShowDisplayBroadcastListener"));
                this.i = (Long) getIntent().getSerializableExtra("lastLoadTime");
                this.j = (Long) getIntent().getSerializableExtra("adCacheTtl");
            } else {
                if (bundle.containsKey("lastLoadTime")) {
                    this.i = (Long) bundle.getSerializable("lastLoadTime");
                }
                if (bundle.containsKey("adCacheTtl")) {
                    this.j = (Long) bundle.getSerializable("adCacheTtl");
                }
            }
            this.k = getIntent().getStringExtra("position");
            this.a = getIntent().getStringExtra("listModelUuid");
            com.startapp.common.b.a(this).a(this.n, new IntentFilter("com.startapp.android.CloseAdActivity"));
            this.g = getResources().getConfiguration().orientation;
            u.a((Activity) this, true);
            boolean booleanExtra = getIntent().getBooleanExtra("overlay", false);
            requestWindowFeature(1);
            this.b = getIntent().getStringExtra("adTag");
            int e = AdsCommonMetaData.a().e();
            int f = AdsCommonMetaData.a().f();
            this.d = new List3DView(this, this.b, this.a);
            this.d.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{e, f}));
            this.c = g.a().a(this.a).e();
            if (this.c == null) {
                finish();
                return;
            }
            if (booleanExtra) {
                com.startapp.common.b.a(this).a(this.d.p, new IntentFilter("com.startapp.android.Activity3DGetValues"));
            } else {
                this.d.setStarted();
                this.d.setHint(true);
                this.d.setFade(true);
            }
            c cVar = new c(this, this.c, this.b, this.a);
            g.a().a(this.a).a(this, !booleanExtra);
            this.d.setAdapter(cVar);
            this.d.setDynamics(new i());
            this.d.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.startapp.sdk.ads.list3d.List3DActivity.2
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                    String b = List3DActivity.this.c.get(i).b();
                    String e2 = List3DActivity.this.c.get(i).e();
                    String f2 = List3DActivity.this.c.get(i).f();
                    boolean k = List3DActivity.this.c.get(i).k();
                    boolean l = List3DActivity.this.c.get(i).l();
                    String o = List3DActivity.this.c.get(i).o();
                    String n = List3DActivity.this.c.get(i).n();
                    Boolean r = List3DActivity.this.c.get(i).r();
                    g.a().a(List3DActivity.this.a).a(List3DActivity.this.c.get(i).c());
                    if (o == null || TextUtils.isEmpty(o)) {
                        if (!TextUtils.isEmpty(b)) {
                            boolean a = com.startapp.sdk.adsbase.a.a(List3DActivity.this.getApplicationContext(), AdPreferences.Placement.INAPP_OFFER_WALL);
                            if (!k || a) {
                                com.startapp.sdk.adsbase.a.a(List3DActivity.this, b, e2, List3DActivity.this.a(), l && !a, false);
                                List3DActivity.this.finish();
                                return;
                            }
                            com.startapp.sdk.adsbase.a.a(List3DActivity.this, b, e2, f2, List3DActivity.this.a(), AdsCommonMetaData.a().B(), AdsCommonMetaData.a().C(), l, r, false, new Runnable() { // from class: com.startapp.sdk.ads.list3d.List3DActivity.2.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    List3DActivity.this.finish();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    com.startapp.sdk.adsbase.a.a(o, n, b, List3DActivity.this, new TrackingParams(List3DActivity.this.b));
                    List3DActivity.this.finish();
                }
            });
            RelativeLayout relativeLayout = new RelativeLayout(this);
            relativeLayout.setContentDescription("StartApp Ad");
            relativeLayout.setId(1475346432);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            relativeLayout.addView(linearLayout, layoutParams2);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            relativeLayout2.setBackgroundColor(AdsCommonMetaData.a().i().intValue());
            linearLayout.addView(relativeLayout2);
            TextView textView = new TextView(this);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            textView.setLayoutParams(layoutParams3);
            textView.setPadding(0, t.a(this, 2), 0, t.a(this, 5));
            textView.setTextColor(AdsCommonMetaData.a().l().intValue());
            textView.setTextSize(AdsCommonMetaData.a().k().intValue());
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(AdsCommonMetaData.a().j());
            textView.setShadowLayer(2.5f, -2.0f, 2.0f, -11513776);
            t.a(textView, AdsCommonMetaData.a().m());
            relativeLayout2.addView(textView);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(11);
            layoutParams4.addRule(15);
            Bitmap a = com.startapp.sdk.adsbase.j.a.a(this, "close_button.png");
            if (a != null) {
                View imageButton = new ImageButton(this, null, 16973839);
                view = imageButton;
                ((ImageButton) imageButton).setImageBitmap(Bitmap.createScaledBitmap(a, t.a(this, 36), t.a(this, 36), true));
            } else {
                View textView2 = new TextView(this);
                View view2 = textView2;
                ((TextView) textView2).setText("   x   ");
                ((TextView) view2).setTextSize(20.0f);
                view = view2;
            }
            view.setLayoutParams(layoutParams4);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.startapp.sdk.ads.list3d.List3DActivity.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    com.startapp.sdk.adsbase.a.b(List3DActivity.this, List3DActivity.this.b(), List3DActivity.this.a());
                    List3DActivity.this.finish();
                }
            });
            view.setContentDescription("x");
            view.setId(1475346435);
            relativeLayout2.addView(view);
            View view3 = new View(this);
            view3.setLayoutParams(new LinearLayout.LayoutParams(-1, t.a(this, 2)));
            view3.setBackgroundColor(AdsCommonMetaData.a().n().intValue());
            linearLayout.addView(view3);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 0);
            layoutParams5.weight = 1.0f;
            this.d.setLayoutParams(layoutParams5);
            linearLayout.addView(this.d);
            LinearLayout linearLayout2 = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams6.gravity = 80;
            linearLayout2.setLayoutParams(layoutParams6);
            linearLayout2.setBackgroundColor(AdsCommonMetaData.a().w().intValue());
            linearLayout2.setGravity(17);
            linearLayout.addView(linearLayout2);
            TextView textView3 = new TextView(this);
            textView3.setTextColor(AdsCommonMetaData.a().x().intValue());
            textView3.setPadding(0, t.a(this, 2), 0, t.a(this, 3));
            textView3.setText("Powered By ");
            textView3.setTextSize(16.0f);
            linearLayout2.addView(textView3);
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(Bitmap.createScaledBitmap(com.startapp.sdk.adsbase.j.a.a(this, "logo.png"), t.a(this, 56), t.a(this, 12), true));
            linearLayout2.addView(imageView);
            this.h = new AdInformationObject(this, AdInformationObject.Size.LARGE, AdPreferences.Placement.INAPP_OFFER_WALL, (AdInformationOverrides) getIntent().getSerializableExtra("adInfoOverride"));
            this.h.a(relativeLayout);
            setContentView(relativeLayout, layoutParams);
            new Handler().postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.list3d.List3DActivity.4
                @Override // java.lang.Runnable
                public final void run() {
                    List3DActivity.this.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                }
            }, 500L);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) this);
            finish();
        }
    }

    protected final TrackingParams a() {
        this.l = SystemClock.uptimeMillis();
        return new CloseTrackingParams((this.l - this.m) / 1000, this.b);
    }

    protected final String b() {
        if (this.c != null && !this.c.isEmpty()) {
            if (this.c.get(0).d() != null) {
                return this.c.get(0).d();
            }
            return "";
        }
        return "";
    }

    @Override // android.app.Activity
    protected void onResume() {
        boolean z;
        super.onResume();
        if (this.i == null || this.j == null) {
            z = false;
        } else {
            z = System.currentTimeMillis() - this.i.longValue() > this.j.longValue();
        }
        if (z) {
            finish();
            return;
        }
        k.a().a(true);
        this.m = SystemClock.uptimeMillis();
        g.a().a(this.a).c();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        g.a().a(this.a).d();
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        u.a((Activity) this, false);
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        g.a().a(this.a).b();
        if (this.h != null && this.h.b()) {
            this.h.e();
        }
        overridePendingTransition(0, 0);
        if (this.k != null && this.k.equals("back")) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.i != null) {
            bundle.putSerializable("lastLoadTime", this.i);
        }
        if (this.j != null) {
            bundle.putSerializable("adCacheTtl", this.j);
        }
    }

    @Override // com.startapp.sdk.ads.list3d.h
    public final void a(int i) {
        View childAt = this.d.getChildAt(i - this.d.a());
        if (childAt != null) {
            e eVar = (e) childAt.getTag();
            f a = g.a().a(this.a);
            if (a != null && a.e() != null && i < a.e().size()) {
                d dVar = a.e().get(i);
                eVar.b().setImageBitmap(a.a(i, dVar.a(), dVar.i()));
                eVar.b().requestLayout();
                eVar.a(dVar.p());
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            this.l = SystemClock.uptimeMillis();
            com.startapp.sdk.adsbase.a.b(this, b(), a());
            k.a().a(false);
            if (this.g == getResources().getConfiguration().orientation) {
                com.startapp.common.b.a(this).a(new Intent("com.startapp.android.HideDisplayBroadcastListener"));
            }
            synchronized (this) {
                if (this.n != null) {
                    com.startapp.common.b.a(this).a(this.n);
                    this.n = null;
                }
            }
            if (this.a != null) {
                g.a().a(this.a).d();
                if (!AdsConstants.b.booleanValue()) {
                    g.a().b(this.a);
                }
            }
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) this);
        }
        super.finish();
    }
}
