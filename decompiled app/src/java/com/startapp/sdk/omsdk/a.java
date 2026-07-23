package com.startapp.sdk.omsdk;

import android.content.Context;
import android.webkit.WebView;
import com.iab.omid.library.startapp.adsession.Owner;
import com.startapp.sdk.GeneratedConstants;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.infoevents.e;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class a {
    static {
        a.class.getSimpleName();
    }

    public static com.iab.omid.library.startapp.adsession.b a(WebView webView) {
        if (!a(webView.getContext())) {
            return null;
        }
        return a(com.startapp.common.c.a.a(com.startapp.networkTest.utils.a.a("StartApp", GeneratedConstants.INAPP_VERSION), webView, ""), false);
    }

    public static com.iab.omid.library.startapp.adsession.b a(Context context, AdVerification adVerification) {
        if (!a(context)) {
            return null;
        }
        if (adVerification == null) {
            new e(InfoEventCategory.ERROR).f("OMSDK: Verification details can't be null!").a(context);
            return null;
        }
        String a = b.a();
        List<VerificationDetails> a2 = adVerification.a();
        ArrayList arrayList = new ArrayList(a2.size());
        for (VerificationDetails verificationDetails : a2) {
            URL a3 = a(context, verificationDetails.b());
            if (a3 != null) {
                arrayList.add(com.startapp.networkTest.utils.e.a(verificationDetails.a(), a3, verificationDetails.c()));
            }
        }
        return a(com.startapp.common.c.a.a(com.startapp.networkTest.utils.a.a("StartApp", GeneratedConstants.INAPP_VERSION), a, arrayList, ""), true);
    }

    private static com.iab.omid.library.startapp.adsession.b a(com.startapp.common.c.a aVar, boolean z) {
        return com.iab.omid.library.startapp.adsession.b.a(com.startapp.common.b.e.a(Owner.NATIVE, z ? Owner.NATIVE : Owner.NONE), aVar);
    }

    private static URL a(Context context, String str) {
        try {
            return new URL(str);
        } catch (Throwable th) {
            new e(th).a(context);
            return null;
        }
    }

    private static boolean a(Context context) {
        try {
            if (com.iab.omid.library.startapp.a.b() || com.iab.omid.library.startapp.a.a(com.iab.omid.library.startapp.a.a(), context)) {
                return true;
            }
            new e(InfoEventCategory.ERROR).f("OMSDK: Failed to activate sdk.").a(context);
            return false;
        } catch (Throwable th) {
            new e(th).a(context);
            return false;
        }
    }
}
