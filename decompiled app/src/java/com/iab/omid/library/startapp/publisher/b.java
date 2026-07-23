package com.iab.omid.library.startapp.publisher;

import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.startapp.b.c;
import com.iab.omid.library.startapp.b.d;
import com.startapp.networkTest.utils.e;
import java.util.List;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b extends AdSessionStatePublisher {
    private WebView a;
    private List<e> b;
    private final String c;

    public b(List<e> list, String str) {
        this.b = list;
        this.c = str;
    }

    @Override // com.iab.omid.library.startapp.publisher.AdSessionStatePublisher
    public final void b() {
        super.b();
        new Handler().postDelayed(new Runnable() { // from class: com.iab.omid.library.startapp.publisher.b.1
            private WebView a;

            {
                this.a = b.this.a;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.destroy();
            }
        }, 2000L);
        this.a = null;
    }

    @Override // com.iab.omid.library.startapp.publisher.AdSessionStatePublisher
    public final void a() {
        super.a();
        this.a = new WebView(c.a().b());
        this.a.getSettings().setJavaScriptEnabled(true);
        a(this.a);
        d.a();
        d.a(this.a, this.c);
        for (e eVar : this.b) {
            String externalForm = eVar.b().toExternalForm();
            d.a();
            WebView webView = this.a;
            if (externalForm != null) {
                d.a(webView, "var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);".replace("%SCRIPT_SRC%", externalForm));
            }
        }
    }
}
