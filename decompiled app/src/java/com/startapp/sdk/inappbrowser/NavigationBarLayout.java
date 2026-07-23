package com.startapp.sdk.inappbrowser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.sdk.adsbase.j.t;
import java.util.HashMap;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class NavigationBarLayout extends RelativeLayout {
    private static final int n = Color.rgb(78, 86, 101);
    private static final int o = Color.rgb(148, 155, 166);
    private RelativeLayout a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private Bitmap i;
    private TextView j;
    private TextView k;
    private Boolean l;
    private Map<String, b> m;

    public NavigationBarLayout(Context context) {
        super(context);
        this.l = Boolean.FALSE;
    }

    public final void a() {
        setDescendantFocusability(262144);
        setBackgroundColor(Color.parseColor("#e9e9e9"));
        setLayoutParams(new RelativeLayout.LayoutParams(-1, t.a(getContext(), 60)));
        setId(2101);
        HashMap hashMap = new HashMap();
        hashMap.put("BACK", new b(14, 22, "back_.png"));
        hashMap.put("BACK_DARK", new b(14, 22, "back_dark.png"));
        hashMap.put("FORWARD", new b(14, 22, "forward_.png"));
        hashMap.put("FORWARD_DARK", new b(14, 22, "forward_dark.png"));
        hashMap.put("X", new b(23, 23, "x_dark.png"));
        hashMap.put("BROWSER", new b(28, 28, "browser_icon_dark.png"));
        this.m = hashMap;
    }

    public final void b() {
        Typeface typeface = Typeface.DEFAULT;
        this.j = t.a(getContext(), typeface, 16.46f, n, 2102);
        this.k = t.a(getContext(), typeface, 12.12f, o, 2107);
        this.j.setText("Loading...");
        this.a = new RelativeLayout(getContext());
        this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.a.addView(this.j, t.a(getContext(), new int[]{0, 0, 0, 0}, new int[0]));
        this.a.addView(this.k, t.a(getContext(), new int[]{0, 0, 0, 0}, new int[0], 3, 2102));
        f();
        this.b = t.a(getContext(), this.m.get("X").d(), 2103);
        this.d = t.a(getContext(), this.m.get("BROWSER").d(), 2104);
        this.e = t.a(getContext(), this.m.get("BACK").d(), 2105);
        this.c = t.a(getContext(), this.m.get("FORWARD").d(), 2106);
        int a = t.a(getContext(), 10);
        this.c.setPadding(a, a, a, a);
        this.c.setEnabled(false);
        this.e.setPadding(a, a, a, a);
        addView(this.b, t.a(getContext(), new int[]{0, 0, 16, 0}, new int[]{15, 11}));
        addView(this.d, t.a(getContext(), new int[]{0, 0, 17, 0}, new int[]{15}, 0, 2103));
        addView(this.a, t.a(getContext(), new int[]{16, 6, 16, 0}, new int[]{9}, 0, 2104));
    }

    private void f() {
        for (b bVar : this.m.values()) {
            Bitmap a = com.startapp.sdk.adsbase.j.a.a(getContext(), bVar.c());
            if (a == null) {
                new StringBuilder("Error getting navigation bar bitmap - ").append(bVar.c()).append(" from resources ");
            } else {
                bVar.a(Bitmap.createScaledBitmap(a, t.a(getContext(), bVar.a()), t.a(getContext(), bVar.b()), true));
            }
        }
    }

    public final void a(WebView webView) {
        if (!this.l.booleanValue()) {
            if (!webView.canGoBack()) {
                return;
            }
            this.e.setImageBitmap(this.m.get("BACK_DARK").d());
            addView(this.e, t.a(getContext(), new int[]{6, 0, 0, 0}, new int[]{15, 9}));
            addView(this.c, t.a(getContext(), new int[]{9, 0, 0, 0}, new int[]{15}, 1, 2105));
            removeView(this.a);
            this.a.removeView(this.k);
            this.a.removeView(this.j);
            this.a.addView(this.j, t.a(getContext(), new int[]{0, 0, 0, 0}, new int[]{14}));
            this.a.addView(this.k, t.a(getContext(), new int[]{0, 0, 0, 0}, new int[]{14}, 3, 2102));
            RelativeLayout.LayoutParams a = t.a(getContext(), new int[]{16, 0, 16, 0}, new int[]{15}, 1, 2106);
            a.addRule(0, 2104);
            addView(this.a, a);
            this.l = Boolean.TRUE;
            return;
        }
        if (webView.canGoBack()) {
            this.e.setImageBitmap(this.m.get("BACK_DARK").d());
            this.e.setEnabled(true);
        } else {
            this.e.setImageBitmap(this.m.get("BACK").d());
            this.e.setEnabled(false);
        }
        if (webView.canGoForward()) {
            this.c.setImageBitmap(this.m.get("FORWARD_DARK").d());
            this.c.setEnabled(true);
        } else {
            this.c.setImageBitmap(this.m.get("FORWARD").d());
            this.c.setEnabled(false);
        }
        if (webView.getTitle() == null) {
            return;
        }
        this.j.setText(webView.getTitle());
    }

    public final TextView c() {
        return this.k;
    }

    public final TextView d() {
        return this.j;
    }

    public void setButtonsListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
        this.e.setOnClickListener(onClickListener);
        this.c.setOnClickListener(onClickListener);
        this.d.setOnClickListener(onClickListener);
    }

    public final void e() {
        if (Build.VERSION.SDK_INT < 11) {
            ((BitmapDrawable) this.b.getDrawable()).getBitmap().recycle();
            ((BitmapDrawable) this.d.getDrawable()).getBitmap().recycle();
            ((BitmapDrawable) this.e.getDrawable()).getBitmap().recycle();
            ((BitmapDrawable) this.c.getDrawable()).getBitmap().recycle();
        }
        this.m = null;
        this.f = null;
        this.h = null;
        this.g = null;
        this.i = null;
    }
}
