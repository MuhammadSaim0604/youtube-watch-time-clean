package com.startapp.sdk.adsbase.consent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.adsbase.remoteconfig.b;
import com.startapp.sdk.b.c;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a implements b {
    private final Context a;
    private final SharedPreferences b;
    private Intent c;
    private boolean d = false;
    private boolean e = true;

    static {
        a.class.getSimpleName();
    }

    public final void a(Intent intent) {
        this.c = intent;
    }

    public final boolean b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        this.d = false;
        if (this.c != null) {
            this.a.startActivity(this.c);
        }
    }

    public a(Context context) {
        this.a = context;
        this.b = context.getSharedPreferences("com.startapp.sdk", 0);
    }

    public final void a(Integer num, Long l, Boolean bool, boolean z, boolean z2) {
        new StringBuilder("set ct=").append(num).append(", timestamp=").append(l).append(", apc=").append(bool);
        if (i()) {
            long j = this.b.getLong("consentTimestamp", 0L);
            int i = this.b.getInt("consentType", -1);
            boolean contains = this.b.contains("consentApc");
            boolean z3 = (num == null || i == num.intValue()) ? false : true;
            boolean z4 = (bool == null || (contains && this.b.getBoolean("consentApc", false) == bool.booleanValue())) ? false : true;
            boolean z5 = l != null && l.longValue() > j;
            if (z || z5) {
                if (z3 || z4) {
                    SharedPreferences.Editor edit = this.b.edit();
                    if (z3) {
                        edit.putInt("consentType", num.intValue());
                    }
                    if (z4) {
                        edit.putBoolean("consentApc", bool.booleanValue());
                    }
                    if (z5) {
                        edit.putLong("consentTimestamp", l.longValue());
                    }
                    edit.commit();
                    if (z2) {
                        MetaData.E().a(this.a, new AdPreferences(), MetaDataRequest.RequestReason.CONSENT, false, null, true);
                    }
                }
            }
        }
    }

    public final void a(boolean z) {
        this.e = z;
    }

    private boolean i() {
        ConsentConfig f = MetaData.E().f();
        return this.e && f != null && f.a();
    }

    public final Integer d() {
        if (i()) {
            int hashCode = c.a(this.a).d().b().a().hashCode();
            if (!this.b.contains("advIdHash") || this.b.getInt("advIdHash", 0) != hashCode) {
                this.b.edit().remove("consentType").remove("consentTimestamp").putInt("advIdHash", hashCode).commit();
            }
        }
        if (i() && this.b.contains("consentType")) {
            return Integer.valueOf(this.b.getInt("consentType", -1));
        }
        return null;
    }

    public final Long e() {
        if (i() && this.b.contains("consentTimestamp")) {
            return Long.valueOf(this.b.getLong("consentTimestamp", 0L));
        }
        return null;
    }

    public final Boolean f() {
        if (i() && this.b.contains("consentApc")) {
            return Boolean.valueOf(this.b.getBoolean("consentApc", false));
        }
        return null;
    }

    public final boolean g() {
        Boolean f = f();
        return f != null && f.booleanValue();
    }

    public final void h() {
        ConsentConfig f = MetaData.E().f();
        if (f != null && i() && !this.d && u.c(this.a) && u.h(this.a) && f.d() != null && f.h() != null && !this.b.contains("consentApc")) {
            Intent intent = new Intent(this.a, ConsentActivity.class);
            intent.setFlags(805306368);
            intent.putExtra("allowCT", f.a());
            intent.putExtra("timestamp", f.e());
            intent.putExtra("templateName", f.h());
            intent.putExtra("templateId", f.i());
            if (!TextUtils.isEmpty(f.d())) {
                intent.setData(Uri.parse(f.d()));
            }
            if (!TextUtils.isEmpty(f.j())) {
                intent.putExtra("dParam", f.j());
            }
            if (!TextUtils.isEmpty(f.g())) {
                intent.putExtra("clickUrl", f.g());
            }
            if (!TextUtils.isEmpty(f.f())) {
                intent.putExtra("impressionUrl", f.f());
            }
            ConsentTypeInfoConfig k = f.k();
            if (k != null) {
                intent.putExtra("impression", k.a());
                intent.putExtra("trueClick", k.b());
                intent.putExtra("falseClick", k.c());
            }
            new StringBuilder("Dialog becomes visible with ts=").append(f.e());
            this.d = true;
            this.a.startActivity(intent);
        }
    }

    @Override // com.startapp.sdk.adsbase.remoteconfig.b
    public final void a(MetaDataRequest.RequestReason requestReason, boolean z) {
        MetaData.E().a(this);
        ConsentConfig f = MetaData.E().f();
        if (f != null && i()) {
            Integer c = f.c();
            if (c != null) {
                a(c, Long.valueOf(f.e()), null, false, false);
            }
            if (requestReason == MetaDataRequest.RequestReason.CONSENT) {
                this.b.edit().putLong("consentTimestamp", f.e()).commit();
            } else if (requestReason == MetaDataRequest.RequestReason.LAUNCH) {
                h();
            }
        }
    }

    @Override // com.startapp.sdk.adsbase.remoteconfig.b
    public final void a() {
        MetaData.E().a(this);
    }
}
