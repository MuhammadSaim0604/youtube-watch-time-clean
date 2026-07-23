package com.startapp.sdk.ads.banner.banner3d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.sdk.ads.banner.banner3d.Banner3DSize;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.j.t;
import com.startapp.sdk.json.RatingBar;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class Banner3DView extends RelativeLayout {
    private TextView a;
    private TextView b;
    private ImageView c;
    private RatingBar d;
    private TextView e;
    private Point f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum Template {
        XS,
        S,
        M,
        L,
        XL
    }

    public Banner3DView(Context context) {
        super(context);
        a();
    }

    public Banner3DView(Context context, Point point) {
        super(context);
        this.f = point;
        a();
    }

    public Banner3DView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public Banner3DView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        Context context = getContext();
        Template b = b();
        setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{AdsCommonMetaData.a().o(), AdsCommonMetaData.a().p()}));
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int a = t.a(context, 2);
        int a2 = t.a(context, 3);
        t.a(context, 4);
        int a3 = t.a(context, 5);
        int a4 = t.a(context, 6);
        int a5 = t.a(context, 8);
        t.a(context, 10);
        int a6 = t.a(context, 20);
        t.a(context, 84);
        int a7 = t.a(context, 90);
        setPadding(a3, 0, a3, 0);
        setTag(this);
        this.c = new ImageView(context);
        this.c.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a7, a7);
        layoutParams.addRule(15);
        this.c.setLayoutParams(layoutParams);
        this.a = new TextView(context);
        this.a.setId(2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(com.startapp.common.b.b.a(17), 1);
        layoutParams2.addRule(14);
        this.a.setLayoutParams(layoutParams2);
        this.a.setTextColor(AdsCommonMetaData.a().r().intValue());
        this.a.setGravity(com.startapp.common.b.b.a(8388611));
        this.a.setBackgroundColor(0);
        switch (b) {
            case XS:
            case S:
                this.a.setTextSize(17.0f);
                this.a.setPadding(a2, 0, 0, a);
                layoutParams2.width = t.a(getContext(), (int) (this.f.x * 0.55d));
                break;
            case M:
                this.a.setTextSize(17.0f);
                this.a.setPadding(a2, 0, 0, a);
                layoutParams2.width = t.a(getContext(), (int) (this.f.x * 0.65d));
                break;
            case L:
            case XL:
                this.a.setTextSize(22.0f);
                this.a.setPadding(a2, 0, 0, a3);
                break;
        }
        this.a.setSingleLine(true);
        this.a.setEllipsize(TextUtils.TruncateAt.END);
        t.a(this.a, AdsCommonMetaData.a().s());
        this.b = new TextView(context);
        this.b.setId(3);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(com.startapp.common.b.b.a(17), 1);
        layoutParams3.addRule(3, 2);
        layoutParams3.setMargins(0, 0, 0, a3);
        this.b.setLayoutParams(layoutParams3);
        this.b.setTextColor(AdsCommonMetaData.a().u().intValue());
        this.b.setTextSize(18.0f);
        this.b.setMaxLines(2);
        this.b.setLines(2);
        this.b.setSingleLine(false);
        this.b.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.b.setHorizontallyScrolling(true);
        this.b.setPadding(a2, 0, 0, 0);
        this.d = new RatingBar(getContext());
        this.d.setId(5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        switch (b) {
            case XS:
            case S:
            case M:
                layoutParams4.addRule(com.startapp.common.b.b.a(17), 1);
                layoutParams4.addRule(8, 1);
                break;
            case L:
            case XL:
                layoutParams4.addRule(com.startapp.common.b.b.a(17), 2);
                layoutParams3.width = t.a(getContext(), (int) (this.f.x * 0.6d));
                break;
        }
        layoutParams4.setMargins(a2, a5, a2, 0);
        this.d.setLayoutParams(layoutParams4);
        this.e = new TextView(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        switch (b) {
            case XS:
            case S:
            case M:
                this.e.setTextSize(13.0f);
                layoutParams5.addRule(com.startapp.common.b.b.a(17), 2);
                layoutParams5.addRule(15);
                break;
            case L:
                layoutParams5.addRule(com.startapp.common.b.b.a(17), 3);
                layoutParams5.addRule(15);
                layoutParams5.setMargins(a6, 0, 0, 0);
                this.e.setTextSize(26.0f);
                break;
            case XL:
                layoutParams5.addRule(com.startapp.common.b.b.a(17), 3);
                layoutParams5.addRule(15);
                layoutParams5.setMargins(a6 * 7, 0, 0, 0);
                this.e.setTextSize(26.0f);
                break;
        }
        this.e.setPadding(a4, a4, a4, a4);
        this.e.setLayoutParams(layoutParams5);
        setButtonText(false);
        this.e.setTextColor(-1);
        this.e.setTypeface(null, 1);
        this.e.setId(4);
        this.e.setShadowLayer(2.5f, -3.0f, 3.0f, -9013642);
        this.e.setBackgroundDrawable(new ShapeDrawable(new RoundRectShape(new float[]{10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f}, null, null)) { // from class: com.startapp.sdk.ads.banner.banner3d.Banner3DView.1
            @Override // android.graphics.drawable.ShapeDrawable
            protected final void onDraw(Shape shape, Canvas canvas, Paint paint) {
                paint.setColor(-11363070);
                paint.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.4f, 5.0f, 3.0f));
                super.onDraw(shape, canvas, paint);
            }
        });
        addView(this.c);
        addView(this.a);
        switch (b) {
            case XS:
            case S:
            case M:
                addView(this.e);
                break;
            case L:
            case XL:
                addView(this.e);
                addView(this.b);
                break;
        }
        addView(this.d);
    }

    public void setText(String str) {
        this.a.setText(str);
    }

    public void setImage(Bitmap bitmap) {
        this.c.setImageBitmap(bitmap);
    }

    public void setImage(int i, int i2, int i3) {
        this.c.setImageResource(i);
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        this.c.setLayoutParams(layoutParams);
    }

    public void setRating(float f) {
        try {
            this.d.setRating(f);
        } catch (NullPointerException e) {
        }
    }

    public void setImage(Bitmap bitmap, int i, int i2) {
        this.c.setImageBitmap(bitmap);
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.c.setLayoutParams(layoutParams);
    }

    public void setDescription(String str) {
        if (str != null && str.compareTo("") != 0) {
            String[] a = a(str);
            String str2 = a[0];
            String str3 = "";
            if (a[1] != null) {
                str3 = a(a[1])[0];
            }
            if (str.length() >= 110) {
                str3 = str3 + "...";
            }
            this.b.setText(str2 + "\n" + str3);
        }
    }

    private static String[] a(String str) {
        String[] strArr = new String[2];
        if (str.length() > 55) {
            char[] charArray = str.substring(0, 55).toCharArray();
            boolean z = false;
            int length = charArray.length - 1;
            int i = length;
            int i2 = length - 1;
            while (true) {
                if (i2 <= 0) {
                    break;
                } else if (charArray[i2] != ' ') {
                    i2--;
                } else {
                    i = i2;
                    z = true;
                    break;
                }
            }
            if (!z) {
                i = 55;
            }
            strArr[0] = str.substring(0, i);
            strArr[1] = str.substring(i + 1, str.length());
        } else {
            strArr[0] = str;
            strArr[1] = null;
        }
        return strArr;
    }

    private Template b() {
        Template template = Template.S;
        if (this.f.x > Banner3DSize.Size.SMALL.getSize().a() || this.f.y > Banner3DSize.Size.SMALL.getSize().b()) {
            template = Template.M;
        }
        if (this.f.x > Banner3DSize.Size.MEDIUM.getSize().a() || this.f.y > Banner3DSize.Size.MEDIUM.getSize().b()) {
            template = Template.L;
        }
        if (this.f.x > Banner3DSize.Size.LARGE.getSize().a() || this.f.y > Banner3DSize.Size.LARGE.getSize().b()) {
            template = Template.XL;
        }
        return template;
    }

    public void setButtonText(boolean z) {
        if (z) {
            this.e.setText("OPEN");
        } else {
            this.e.setText("DOWNLOAD");
        }
    }
}
