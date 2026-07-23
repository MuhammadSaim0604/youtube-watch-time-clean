package com.startapp.sdk.ads.splash;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.adsbase.j.t;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class e {
    static {
        e.class.getSimpleName();
    }

    public static View a(Context context, SplashConfig splashConfig) {
        View view = null;
        switch (splashConfig.b()) {
            case DEEP_BLUE:
                View b = b(context, splashConfig);
                b.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-16356182, -15029533, -16356182}));
                ((TextView) b.findViewById(100)).setTextColor(Color.rgb(255, 255, 255));
                ((TextView) b.findViewById(105)).setTextColor(Color.rgb(208, 210, 210));
                view = b;
                break;
            case SKY:
                View b2 = b(context, splashConfig);
                int i = context.getResources().getDisplayMetrics().widthPixels;
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{-921103, -6040347});
                gradientDrawable.setGradientType(1);
                gradientDrawable.setGradientRadius(i / 2);
                b2.setBackgroundDrawable(gradientDrawable);
                ((TextView) b2.findViewById(100)).setTextColor(Color.rgb(51, 51, 51));
                ((TextView) b2.findViewById(105)).setTextColor(Color.rgb(162, 172, 175));
                view = b2;
                break;
            case ASHEN_SKY:
                View b3 = b(context, splashConfig);
                b3.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-3881788, -1}));
                ((TextView) b3.findViewById(100)).setTextColor(Color.rgb(51, 51, 51));
                ((TextView) b3.findViewById(105)).setTextColor(Color.rgb(153, 153, 153));
                view = b3;
                break;
            case BLAZE:
                View b4 = b(context, splashConfig);
                int i2 = context.getResources().getDisplayMetrics().widthPixels;
                GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{-92376, -40960});
                gradientDrawable2.setGradientType(1);
                gradientDrawable2.setGradientRadius(i2 / 2);
                b4.setBackgroundDrawable(gradientDrawable2);
                ((TextView) b4.findViewById(100)).setTextColor(Color.rgb(255, 255, 255));
                ((TextView) b4.findViewById(105)).setTextColor(Color.rgb(255, 198, 151));
                view = b4;
                break;
            case GLOOMY:
                View b5 = b(context, splashConfig);
                b5.setBackgroundColor(Color.rgb(47, 53, 63));
                ((TextView) b5.findViewById(100)).setTextColor(Color.rgb(51, 181, 229));
                ((TextView) b5.findViewById(105)).setTextColor(Color.rgb(122, 130, 139));
                view = b5;
                break;
            case OCEAN:
                View b6 = b(context, splashConfig);
                b6.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-14451558, -7876130}));
                ((TextView) b6.findViewById(100)).setTextColor(Color.rgb(6, 61, 82));
                ((TextView) b6.findViewById(105)).setTextColor(Color.rgb(6, 61, 82));
                view = b6;
                break;
        }
        return view;
    }

    private static View b(Context context, SplashConfig splashConfig) {
        int a;
        int a2;
        int a3;
        int a4;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(1475346437);
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(relativeLayout2, layoutParams);
        Point point = new Point(t.a(context, 150), t.a(context, 28));
        if (splashConfig.getOrientation() == SplashConfig.Orientation.PORTRAIT) {
            a = t.a(context, 5);
            a2 = t.a(context, 8);
            a3 = t.a(context, 75);
            a4 = t.a(context, 130);
        } else {
            a = t.a(context, 5);
            a2 = t.a(context, 8);
            a3 = t.a(context, 40);
            a4 = t.a(context, 100);
        }
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(splashConfig.getLogo());
        imageView.setId(101);
        int i = a4;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, 0, 0, a);
        relativeLayout2.addView(imageView, layoutParams2);
        TextView textView = new TextView(context);
        textView.setTypeface(Typeface.DEFAULT);
        textView.setText(splashConfig.getAppName());
        textView.setId(100);
        textView.setTextSize(1, 26.0f);
        textView.setTextColor(Color.rgb(255, 255, 255));
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, 101);
        layoutParams3.setMargins(0, 0, 0, a3);
        relativeLayout2.addView(textView, layoutParams3);
        try {
            WebView webView = new WebView(context);
            webView.setId(102);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(point.x, point.y);
            layoutParams4.addRule(14);
            layoutParams4.addRule(3, 100);
            layoutParams4.setMargins(0, 0, 0, a2);
            webView.setBackgroundColor(Color.argb(0, 0, 0, 0));
            webView.setVerticalScrollBarEnabled(false);
            webView.setHorizontalScrollBarEnabled(false);
            webView.loadDataWithBaseURL(null, "<html>\n<style>\n#fountainG{\nposition:relative;\nwidth:141px;\nheight:17px}\n.fountainG{\nposition:absolute;\ntop:0;\nbackground-color:#000000;\nwidth:18px;\nheight:18px;\n-moz-animation-name:bounce_fountainG;\n-moz-animation-duration:2s;\n-moz-animation-iteration-count:infinite;\n-moz-animation-direction:linear;\n-moz-transform:scale(.3);\n-moz-border-radius:12px;\n-webkit-animation-name:bounce_fountainG;\n-webkit-animation-duration:2s;\n-webkit-animation-iteration-count:infinite;\n-webkit-animation-direction:linear;\n-webkit-transform:scale(.3);\n-webkit-border-radius:12px;\n-ms-animation-name:bounce_fountainG;\n-ms-animation-duration:2s;\n-ms-animation-iteration-count:infinite;\n-ms-animation-direction:linear;\n-ms-transform:scale(.3);\n-ms-border-radius:12px;\n-o-animation-name:bounce_fountainG;\n-o-animation-duration:2s;\n-o-animation-iteration-count:infinite;\n-o-animation-direction:linear;\n-o-transform:scale(.3);\n-o-border-radius:12px;\nanimation-name:bounce_fountainG;\nanimation-duration:2s;\nanimation-iteration-count:infinite;\nanimation-direction:linear;\ntransform:scale(.3);\nborder-radius:12px;\n}\n#fountainG_1{\nleft:0;\n-moz-animation-delay:0.8s;\n-webkit-animation-delay:0.8s;\n-ms-animation-delay:0.8s;\n-o-animation-delay:0.8s;\nanimation-delay:0.8s;\n}\n#fountainG_2{\nleft:18px;\n-moz-animation-delay:1s;\n-webkit-animation-delay:1s;\n-ms-animation-delay:1s;\n-o-animation-delay:1s;\nanimation-delay:1s;\n}\n#fountainG_3{\nleft:35px;\n-moz-animation-delay:1.2s;\n-webkit-animation-delay:1.2s;\n-ms-animation-delay:1.2s;\n-o-animation-delay:1.2s;\nanimation-delay:1.2s;\n}\n#fountainG_4{\nleft:53px;\n-moz-animation-delay:1.4s;\n-webkit-animation-delay:1.4s;\n-ms-animation-delay:1.4s;\n-o-animation-delay:1.4s;\nanimation-delay:1.4s;\n}\n#fountainG_5{\nleft:71px;\n-moz-animation-delay:1.6s;\n-webkit-animation-delay:1.6s;\n-ms-animation-delay:1.6s;\n-o-animation-delay:1.6s;\nanimation-delay:1.6s;\n}\n#fountainG_6{\nleft:88px;\n-moz-animation-delay:1.8s;\n-webkit-animation-delay:1.8s;\n-ms-animation-delay:1.8s;\n-o-animation-delay:1.8s;\nanimation-delay:1.8s;\n}\n#fountainG_7{\nleft:106px;\n-moz-animation-delay:2s;\n-webkit-animation-delay:2s;\n-ms-animation-delay:2s;\n-o-animation-delay:2s;\nanimation-delay:2s;\n}\n#fountainG_8{\nleft:123px;\n-moz-animation-delay:2.2s;\n-webkit-animation-delay:2.2s;\n-ms-animation-delay:2.2s;\n-o-animation-delay:2.2s;\nanimation-delay:2.2s;\n}\n@-moz-keyframes bounce_fountainG{\n0%{\n-moz-transform:scale(1);\nbackground-color:#000000;\n}\n100%{\n-moz-transform:scale(.3);\nbackground-color:rgba(255,255,255,0.2);\n}\n}\n@-webkit-keyframes bounce_fountainG{\n0%{\n-webkit-transform:scale(1);\nbackground-color:#000000;\n}\n100%{\n-webkit-transform:scale(.3);\nbackground-color:rgba(255,255,255,0.2);\n}\n}\n@-ms-keyframes bounce_fountainG{\n0%{\n-ms-transform:scale(1);\nbackground-color:#000000;\n}\n100%{\n-ms-transform:scale(.3);\nbackground-color:rgba(255,255,255,0.2);\n}\n}\n@-o-keyframes bounce_fountainG{\n0%{\n-o-transform:scale(1);\nbackground-color:#000000;\n}\n100%{\n-o-transform:scale(.3);\nbackground-color:rgba(255,255,255,0.2);\n}\n}\n@keyframes bounce_fountainG{\n0%{\ntransform:scale(1);\nbackground-color:#000000;\n}\n100%{\ntransform:scale(.3);\nbackground-color:rgba(255,255,255,0.2);\n}\n}\n</style>\n<body style=\"margin:0;padding:0\">\n<div id=\"fountainG\">\n<div id=\"fountainG_1\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_2\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_3\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_4\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_5\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_6\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_7\" class=\"fountainG\">\n</div>\n<div id=\"fountainG_8\" class=\"fountainG\">\n</div>\n</div>\n</body>\n</html>", "text/html", "utf-8", null);
            relativeLayout2.addView(webView, layoutParams4);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
        TextView textView2 = new TextView(context);
        textView2.setText("Loading...");
        textView2.setId(105);
        textView2.setTextSize(1, 18.0f);
        textView2.setTextColor(Color.rgb(208, 210, 210));
        textView2.setGravity(17);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, 102);
        layoutParams5.setMargins(0, 0, 0, 0);
        relativeLayout2.addView(textView2, layoutParams5);
        return relativeLayout;
    }
}
