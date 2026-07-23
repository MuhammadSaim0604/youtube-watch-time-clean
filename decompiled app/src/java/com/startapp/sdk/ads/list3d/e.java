package com.startapp.sdk.ads.list3d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.j.t;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataStyle;
import com.startapp.sdk.json.RatingBar;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class e {
    private RelativeLayout a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private RatingBar f;
    private MetaDataStyle g = null;

    public e(Context context) {
        context.setTheme(16973829);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        this.a = new RelativeLayout(context);
        this.a.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{AdsCommonMetaData.a().o(), AdsCommonMetaData.a().p()}));
        this.a.setLayoutParams(layoutParams);
        int a = t.a(context, 3);
        int a2 = t.a(context, 4);
        int a3 = t.a(context, 5);
        int a4 = t.a(context, 6);
        int a5 = t.a(context, 10);
        int a6 = t.a(context, 84);
        this.a.setPadding(a5, a, a5, a);
        this.a.setTag(this);
        this.b = new ImageView(context);
        this.b.setId(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a6, a6);
        layoutParams2.addRule(15);
        this.b.setLayoutParams(layoutParams2);
        this.b.setPadding(0, 0, a4, 0);
        this.c = new TextView(context);
        this.c.setId(2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(com.startapp.common.b.b.a(17), 1);
        layoutParams3.addRule(6, 1);
        this.c.setLayoutParams(layoutParams3);
        this.c.setPadding(0, 0, 0, a3);
        this.c.setTextColor(AdsCommonMetaData.a().r().intValue());
        this.c.setTextSize(AdsCommonMetaData.a().q().intValue());
        this.c.setSingleLine(true);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        t.a(this.c, AdsCommonMetaData.a().s());
        this.d = new TextView(context);
        this.d.setId(3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(com.startapp.common.b.b.a(17), 1);
        layoutParams4.addRule(3, 2);
        layoutParams4.setMargins(0, 0, 0, a3);
        this.d.setLayoutParams(layoutParams4);
        this.d.setTextColor(AdsCommonMetaData.a().u().intValue());
        this.d.setTextSize(AdsCommonMetaData.a().t().intValue());
        this.d.setSingleLine(true);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        t.a(this.d, AdsCommonMetaData.a().v());
        this.f = new RatingBar(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(com.startapp.common.b.b.a(17), 1);
        layoutParams5.addRule(8, 1);
        layoutParams5.setMargins(0, 0, 0, -a3);
        this.f.setLayoutParams(layoutParams5);
        this.f.setPadding(0, 0, 0, a2);
        this.f.setId(5);
        this.e = new TextView(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(com.startapp.common.b.b.a(21));
        layoutParams6.addRule(8, 1);
        this.e.setLayoutParams(layoutParams6);
        a(false);
        this.e.setTextColor(-1);
        this.e.setTextSize(12.0f);
        this.e.setTypeface(null, 1);
        this.e.setPadding(a5, a4, a5, a4);
        this.e.setId(4);
        this.e.setShadowLayer(2.5f, -3.0f, 3.0f, -9013642);
        this.e.setBackgroundDrawable(new ShapeDrawable(new RoundRectShape(new float[]{10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f}, null, null)) { // from class: com.startapp.sdk.ads.list3d.e.1
            @Override // android.graphics.drawable.ShapeDrawable
            protected final void onDraw(Shape shape, Canvas canvas, Paint paint) {
                paint.setColor(-11363070);
                paint.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.4f, 5.0f, 3.0f));
                super.onDraw(shape, canvas, paint);
            }
        });
        this.a.addView(this.b);
        this.a.addView(this.c);
        this.a.addView(this.d);
        this.a.addView(this.f);
        this.a.addView(this.e);
    }

    public final RelativeLayout a() {
        return this.a;
    }

    public final ImageView b() {
        return this.b;
    }

    public final TextView c() {
        return this.c;
    }

    public final TextView d() {
        return this.d;
    }

    public final RatingBar e() {
        return this.f;
    }

    public final void a(boolean z) {
        if (z) {
            this.e.setText("Open");
        } else {
            this.e.setText("Download");
        }
    }

    public final void a(MetaDataStyle metaDataStyle) {
        if (this.g != metaDataStyle) {
            this.g = metaDataStyle;
            this.a.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{metaDataStyle.a().intValue(), metaDataStyle.b().intValue()}));
            this.c.setTextSize(metaDataStyle.c().intValue());
            this.c.setTextColor(metaDataStyle.d().intValue());
            t.a(this.c, metaDataStyle.e());
            this.d.setTextSize(metaDataStyle.f().intValue());
            this.d.setTextColor(metaDataStyle.g().intValue());
            t.a(this.d, metaDataStyle.h());
        }
    }
}
