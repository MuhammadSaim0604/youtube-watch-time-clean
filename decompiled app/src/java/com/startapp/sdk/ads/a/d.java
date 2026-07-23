package com.startapp.sdk.ads.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.j.t;
import com.startapp.sdk.adsbase.mraid.bridge.MraidState;
import com.startapp.sdk.adsbase.mraid.bridge.a;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class d extends c implements a.InterfaceC0043a {
    private b m;
    private com.startapp.sdk.adsbase.mraid.a.a n;
    private com.startapp.sdk.adsbase.mraid.b.a o;
    private ImageButton p;
    private TextView q;
    private ImageView r;
    private MraidState l = MraidState.LOADING;
    private boolean s = false;
    private boolean t = false;
    private Handler u = null;

    static /* synthetic */ void n(d dVar) {
        if (dVar.u != null) {
            dVar.u.post(new Runnable() { // from class: com.startapp.sdk.ads.a.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    long e = ((1000 * d.this.e()) - SystemClock.uptimeMillis()) + d.this.f;
                    if (d.this.q != null) {
                        long j = e / 1000;
                        long j2 = j;
                        if (j > 0 && e % 1000 < 100) {
                            j2--;
                        }
                        d.this.q.setText(String.valueOf(j2));
                    }
                    if (e < 1000) {
                        if (d.this.q != null) {
                            d.this.r.setVisibility(8);
                            d.this.q.setVisibility(8);
                        }
                        d.this.F();
                        return;
                    }
                    d.this.u.postDelayed(this, c.a(e));
                }
            });
        }
    }

    @Override // com.startapp.sdk.ads.a.c, com.startapp.sdk.ads.a.b
    public final void a(Bundle bundle) {
        super.a(bundle);
        if (this.n == null) {
            this.n = new com.startapp.sdk.adsbase.mraid.a.a(c());
        }
        if (this.o == null) {
            this.o = new com.startapp.sdk.adsbase.mraid.b.a();
        }
        if (this.m == null) {
            this.m = new b(this);
        }
    }

    @Override // com.startapp.sdk.ads.a.c, com.startapp.sdk.ads.a.b
    public final void u() {
        super.u();
        if (this.u == null && H()) {
            this.u = new Handler();
        }
        this.t = true;
        if (this.l == MraidState.DEFAULT) {
            this.m.fireViewableChangeEvent();
        }
    }

    @Override // com.startapp.sdk.ads.a.b
    public final void v() {
        a();
    }

    @Override // com.startapp.sdk.ads.a.c, com.startapp.sdk.ads.a.b
    public final void s() {
        this.t = false;
        if (this.l == MraidState.DEFAULT) {
            this.m.fireViewableChangeEvent();
        }
        super.s();
    }

    @Override // com.startapp.sdk.ads.a.c
    protected final void y() {
        this.c.setWebViewClient(new a(this.m));
        this.c.setWebChromeClient(new WebChromeClient() { // from class: com.startapp.sdk.ads.a.d.1
            @Override // android.webkit.WebChromeClient
            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                try {
                    if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR && consoleMessage.message().contains("mraid")) {
                        new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("MraidMode.ConsoleError").g(consoleMessage.message()).a((Context) d.this.c());
                    }
                } catch (Throwable th) {
                    new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) d.this.c());
                }
                return super.onConsoleMessage(consoleMessage);
            }
        });
    }

    @Override // com.startapp.sdk.ads.a.c
    protected final boolean b(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.ads.a.c
    public final boolean a(String str, boolean z) {
        this.l = MraidState.HIDDEN;
        com.iab.omid.library.startapp.b.a(this.l, this.c);
        try {
            return super.a(str, z);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) c());
            return false;
        }
    }

    public final void a() {
        Activity c = c();
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            c.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            com.iab.omid.library.startapp.b.a(c, i, i2, this.c);
            com.iab.omid.library.startapp.b.b(c, i, i2, this.c);
            com.iab.omid.library.startapp.b.a(c, 0, 0, i, i2, this.c);
            com.iab.omid.library.startapp.b.b(c, 0, 0, i, i2, this.c);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) c);
        }
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    class b extends com.startapp.sdk.adsbase.mraid.bridge.a {
        public b(a.InterfaceC0043a interfaceC0043a) {
            super(interfaceC0043a);
        }

        @Override // com.startapp.sdk.adsbase.mraid.bridge.a, com.startapp.sdk.adsbase.mraid.bridge.b
        public final void close() {
            d.this.l = MraidState.HIDDEN;
            com.iab.omid.library.startapp.b.a(d.this.l, d.this.c);
            d.this.k.run();
        }

        @Override // com.startapp.sdk.adsbase.mraid.bridge.a, com.startapp.sdk.adsbase.mraid.bridge.b
        public final void useCustomClose(String str) {
            boolean parseBoolean = Boolean.parseBoolean(str);
            if (d.this.s != parseBoolean) {
                d.this.s = parseBoolean;
                if (!parseBoolean) {
                    d.this.I();
                } else {
                    d.h(d.this);
                }
            }
        }

        @Override // com.startapp.sdk.adsbase.mraid.bridge.a, com.startapp.sdk.adsbase.mraid.bridge.b
        public final void setOrientationProperties(Map<String, String> map) {
            new StringBuilder("setOrientationProperties: ").append(map);
            boolean parseBoolean = Boolean.parseBoolean(map.get("allowOrientationChange"));
            String str = map.get("forceOrientation");
            if (d.this.o.a != parseBoolean || d.this.o.b != com.startapp.sdk.adsbase.mraid.b.a.a(str)) {
                d.this.o.a = parseBoolean;
                d.this.o.b = com.startapp.sdk.adsbase.mraid.b.a.a(str);
                applyOrientationProperties(d.this.c(), d.this.o);
            }
        }

        @Override // com.startapp.sdk.adsbase.mraid.bridge.a
        public final boolean isFeatureSupported(String str) {
            return d.this.n.a(str);
        }

        public final void fireViewableChangeEvent() {
            com.iab.omid.library.startapp.b.a(d.this.c, d.this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        try {
            if (this.p != null) {
                this.p.setImageDrawable(com.startapp.common.b.c.a(c().getResources(), "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA39pVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMDY3IDc5LjE1Nzc0NywgMjAxNS8wMy8zMC0yMzo0MDo0MiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDozODRkZTAxYi00OWRkLWM4NDYtYThkNC0wZWRiMDMwYTZlODAiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QkE0Q0U2MUY2QzA0MTFFNUE3MkJGQjQ1MTkzOEYxQUUiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QkE0Q0U2MUU2QzA0MTFFNUE3MkJGQjQ1MTkzOEYxQUUiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChXaW5kb3dzKSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjlkZjAyMGU0LTNlYmUtZTY0ZC04YjRiLWM5ZWY4MTU4ZjFhYyIgc3RSZWY6ZG9jdW1lbnRJRD0iYWRvYmU6ZG9jaWQ6cGhvdG9zaG9wOmU1MzEzNDdlLTZjMDEtMTFlNS1hZGZlLThmMTBjZWYxMGRiZSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PngNsEEAAANeSURBVHjatFfNS1tBEH+pUZOQ0B4i3sTSxHMRFNQoFBEP7dHgvyDiKWgguQra9F+oxqNiwOTQ+oFI1ZM3jSf1YK5FL41ooaKZzu+x+4gv2bx9Rgd+JNn5zO7s7IzH0CQiCvLHZ8YnxkfGe8ZbwS4zSowTxi/GT4/Hc2u8BLHjCOM745b06VboRJpx7GN8ZfyDxUqlQgcHB5RMJmloaIg6Ozupra3NBL5jDTzIQFYQdDOw5db5B8YxLDw+PtLKygr19PQQWDqIRqOUzWZNXUHH2rvBgr2M39C6uLig/v5+bcd2QLdUKskgYLNX57yvIL2zs0OhUOjZziU6Ojro8PBQBnGl3Alm+BknkMI54mybdS4BW3t7ezKIInzVCwDJYm4Zon4p5xLYzfPzcxlEpl7S3SNpmjlznZwQiXn/5CjEnTUzt5GBsbExamlpUfLBg0wjG8vLy3IXlqTzEAoH7m4kElEqTk1Nmfd7bW2tbhBYAw8ykFXZgQ9RJ1CsQghgEr/29/eVStPT09XFhdbX18nr9Vr81tZWyuVyFh+yMzMzSnvwJWjyDS+MYic2NzeV17O7u9vg2m79jsfjBv9bg7PbxOrqqjExMWHxIdvV1aW0V+VrFDtwhFCGh4cbnl0mk6kp+BsbGybsBNlGtkZGRqToEQK4xjfUc6csXlhYcHyFFhcXHe3Al6BrQz427e3tWldpfn5e6Rw83cIkHyvXAUAZb4SdsKZbPe0BaB+Bz+cjTiDlDmxtbZkybo9AKwn9fj9tb2875gBkINvIFnzJJMQ1PMV9GBgYUF6bQCBgFAoFY3x8/Ml6KpUy0un0kzXIQBY6KqrydapViPL5fM0/Rfcj+fhuJw5CqxBpleJYLEY3NzeW8dnZ2RoZrEmCLHQcSvGdWYrFe7CEFTwUqqjR85XLZUokEkoZ8CADWe3HqKoTcnyOdW5KI5m+vj56eHiQz3G0bkNyeXn5ag3J2dmZ/PffVC1Z8bVast3d3eqWLKDVlAaDwaadh8Nhvaa0XluOHg7n9lzn0MWRarfltp0oysEErRqGDTeDCbK9ajApuh7TxGiWERlrjWZzc3M0ODhYM5phDTzbaHb/rNHMFkhUNK13LobTv6K2RJ3se1yO519s4/k7wf5jG89/6I7n/wUYAGo3YtcprD4sAAAAAElFTkSuQmCC"));
                this.p.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) c());
        }
    }

    @Override // com.startapp.sdk.ads.a.c
    protected final long D() {
        return (SystemClock.uptimeMillis() - this.f) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J() {
        return D() >= ((long) e());
    }

    @Override // com.startapp.sdk.ads.a.c
    protected final boolean H() {
        return e() > 0;
    }

    @Override // com.startapp.sdk.ads.a.c, com.startapp.sdk.ads.a.b
    public final boolean r() {
        if (J()) {
            return super.r();
        }
        return true;
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    class a extends com.startapp.sdk.adsbase.mraid.bridge.c {
        public a(com.startapp.sdk.adsbase.mraid.bridge.b bVar) {
            super(bVar);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (d.this.l == MraidState.LOADING) {
                com.iab.omid.library.startapp.b.a("interstitial", webView);
                com.iab.omid.library.startapp.b.a(d.this.c(), webView, d.this.n);
                d.this.a();
                d.m(d.this);
                d.this.l = MraidState.DEFAULT;
                com.iab.omid.library.startapp.b.a(d.this.l, webView);
                com.iab.omid.library.startapp.b.a(webView);
                if (d.this.t) {
                    d.this.m.fireViewableChangeEvent();
                }
                d.n(d.this);
                d.this.a(d.this.p);
            }
        }
    }

    static /* synthetic */ void h(d dVar) {
        try {
            if (dVar.p != null) {
                dVar.p.setImageResource(17170445);
            }
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) dVar.c());
        }
    }

    static /* synthetic */ void m(d dVar) {
        try {
            RelativeLayout relativeLayout = new RelativeLayout(dVar.c());
            dVar.p = new ImageButton(dVar.c());
            dVar.p.setBackgroundColor(0);
            dVar.p.setOnClickListener(new View.OnClickListener() { // from class: com.startapp.sdk.ads.a.d.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (d.this.J()) {
                        d.this.m.close();
                    }
                }
            });
            int a2 = t.a(dVar.c(), 50);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
            layoutParams.addRule(13);
            relativeLayout.addView(dVar.p, layoutParams);
            if (dVar.H() && !dVar.f()) {
                int a3 = t.a(dVar.c(), 32);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a3, a3);
                layoutParams2.addRule(13);
                dVar.r = new ImageView(dVar.c());
                ImageView imageView = dVar.r;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(1);
                gradientDrawable.setColor(-16777216);
                gradientDrawable.setStroke(2, -1);
                int a4 = t.a(dVar.c(), 32);
                gradientDrawable.setSize(a4, a4);
                imageView.setImageDrawable(gradientDrawable);
                dVar.r.setScaleType(ImageView.ScaleType.FIT_CENTER);
                relativeLayout.addView(dVar.r, layoutParams2);
                dVar.q = new TextView(dVar.c());
                dVar.q.setTextColor(-1);
                dVar.q.setGravity(17);
                relativeLayout.addView(dVar.q, layoutParams2);
            }
            if (!dVar.s) {
                dVar.I();
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a2, a2);
            layoutParams3.addRule(10);
            layoutParams3.addRule(11);
            dVar.e.addView(relativeLayout, layoutParams3);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) dVar.c());
        }
    }

    @Override // com.startapp.sdk.adsbase.mraid.bridge.a.InterfaceC0043a
    public final boolean onClickEvent(String str) {
        return a(str, true);
    }
}
