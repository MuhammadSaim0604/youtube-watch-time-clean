package com.startapp.sdk.adsbase.mraid.a;

import android.content.Context;
import android.os.Build;
import com.startapp.common.b.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    private Context a;
    private List<String> b = new ArrayList();

    public a(Context context) {
        this.a = context.getApplicationContext();
    }

    public final boolean a() {
        return this.b.contains("calendar") && Build.VERSION.SDK_INT >= 14 && b.a(this.a, "android.permission.WRITE_CALENDAR");
    }

    public final boolean b() {
        return this.b.contains("inlineVideo");
    }

    public final boolean c() {
        return this.b.contains("sms") && b.a(this.a, "android.permission.SEND_SMS");
    }

    public final boolean d() {
        return this.b.contains("storePicture");
    }

    public final boolean e() {
        return this.b.contains("tel") && b.a(this.a, "android.permission.CALL_PHONE");
    }

    public final boolean a(String str) {
        return this.b.contains(str);
    }
}
