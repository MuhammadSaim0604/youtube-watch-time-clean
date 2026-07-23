package com.startapp.sdk.c.b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import java.util.LinkedHashSet;
import java.util.Locale;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class b extends com.startapp.sdk.c.a<a> {
    @Override // com.startapp.sdk.c.a
    protected final /* synthetic */ a a() {
        Locale locale;
        Configuration configuration;
        LocaleList locales;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Locale locale2 = null;
        Resources resources = this.a.getResources();
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            locale2 = configuration.locale;
            if (Build.VERSION.SDK_INT >= 24 && (locales = configuration.getLocales()) != null && locales.size() > 0) {
                boolean z = true;
                int size = locales.size();
                for (int i = 0; i < size; i++) {
                    Locale locale3 = locales.get(i);
                    if (locale3 != null) {
                        if (linkedHashSet.size() < 11) {
                            linkedHashSet.add(locale3);
                        }
                        if (z) {
                            z = false;
                            locale2 = locale3;
                        }
                    }
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 24 && (locale = Locale.getDefault(Locale.Category.DISPLAY)) != null) {
            if (locale2 == null) {
                locale2 = locale;
            }
            if (linkedHashSet.size() < 11) {
                linkedHashSet.add(locale);
            }
        }
        Locale locale4 = Locale.getDefault();
        if (locale4 != null) {
            if (locale2 == null) {
                locale2 = locale4;
            }
            if (linkedHashSet.size() < 11) {
                linkedHashSet.add(locale4);
            }
        }
        if (locale2 == null) {
            locale2 = new Locale("en");
        }
        linkedHashSet.remove(locale2);
        return new a(locale2, linkedHashSet);
    }

    public b(Context context) {
        super(context);
    }

    @Override // com.startapp.sdk.c.a
    protected final /* bridge */ /* synthetic */ a b() {
        return a.a;
    }
}
