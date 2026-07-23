package com.startapp.sdk.adsbase.apppresence;

import android.content.Context;
import android.net.Uri;
import com.startapp.common.ThreadManager;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.infoevents.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class a {
    private final Context a;
    private final List<AppPresenceDetails> b;

    static {
        a.class.getSimpleName();
    }

    public a(Context context, List<AppPresenceDetails> list) {
        this.b = list;
        this.a = context;
    }

    public final void a() {
        ThreadManager.a(ThreadManager.Priority.DEFAULT, new Runnable() { // from class: com.startapp.sdk.adsbase.apppresence.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b();
            }
        });
    }

    protected final Boolean b() {
        String a;
        String a2;
        boolean z = true;
        try {
            List<AppPresenceDetails> list = this.b;
            ArrayList<String> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (AppPresenceDetails appPresenceDetails : list) {
                if (!appPresenceDetails.c() && (a = appPresenceDetails.a()) != null && (a2 = a(a)) != null) {
                    if (appPresenceDetails.d()) {
                        arrayList2.add("d=".concat(String.valueOf(a2)));
                    } else {
                        arrayList3.add("d=".concat(String.valueOf(a2)));
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.addAll(com.startapp.sdk.adsbase.a.a(arrayList2, "false", "true"));
            }
            if (!arrayList3.isEmpty()) {
                arrayList.addAll(com.startapp.sdk.adsbase.a.a(arrayList3, "false", "false"));
            }
            for (String str : arrayList) {
                if (str.length() != 0) {
                    com.startapp.sdk.adsbase.a.a(this.a, str, new TrackingParams().c("APP_PRESENCE"));
                }
            }
        } catch (Throwable th) {
            new e(th).a(this.a);
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private String a(String str) {
        try {
            return Uri.parse(str).getQueryParameter("d");
        } catch (Throwable th) {
            new e(th).a(this.a);
            return null;
        }
    }
}
