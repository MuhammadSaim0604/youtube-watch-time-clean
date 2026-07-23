package com.startapp.sdk.adsbase;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class StartAppInitProvider extends ContentProvider {

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    interface a {
        String a();

        boolean b();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        g gVar = new g(applicationContext);
        String a2 = gVar.a();
        if (!TextUtils.isEmpty(a2)) {
            k.a().a(applicationContext, null, a2, new SDKAdPreferences(), gVar.b());
            if (applicationContext.getSharedPreferences("com.startapp.sdk", 0).getBoolean("shared_prefs_first_init", true)) {
                new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.GENERAL).f("ManifestInit").a(applicationContext);
            }
            return true;
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
