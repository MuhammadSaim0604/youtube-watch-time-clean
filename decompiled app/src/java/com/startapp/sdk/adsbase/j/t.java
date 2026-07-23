package com.startapp.sdk.adsbase.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class t {
    public String a;
    public String b;

    public static int a(Context context, int i) {
        return Math.round(TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics()));
    }

    public static int b(Context context, int i) {
        return Math.round(i / context.getResources().getDisplayMetrics().density);
    }

    public static void a(TextView textView, Set<String> set) {
        if (set.contains("UNDERLINE")) {
            textView.setPaintFlags(textView.getPaintFlags() | 8);
        }
        int i = 0;
        if (set.contains("BOLD") && set.contains("ITALIC")) {
            i = 3;
        } else if (set.contains("BOLD")) {
            i = 1;
        } else if (set.contains("ITALIC")) {
            i = 2;
        }
        textView.setTypeface(null, i);
    }

    public static TextView a(Context context, Typeface typeface, float f, int i, int i2) {
        TextView textView = new TextView(context);
        textView.setTypeface(typeface, 1);
        textView.setTextSize(1, f);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(i);
        textView.setId(i2);
        return textView;
    }

    public static RelativeLayout.LayoutParams a(Context context, int[] iArr, int[] iArr2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        for (int i : iArr2) {
            layoutParams.addRule(i);
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] == 0 ? 0 : a(context, iArr[i2]);
        }
        layoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        return layoutParams;
    }

    public static RelativeLayout.LayoutParams a(Context context, int[] iArr, int[] iArr2, int i, int i2) {
        RelativeLayout.LayoutParams a = a(context, iArr, iArr2);
        a.addRule(i, i2);
        return a;
    }

    public static ImageView a(Context context, Bitmap bitmap, int i) {
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(bitmap);
        imageView.setId(i);
        return imageView;
    }

    public t(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
