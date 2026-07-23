package com.startapp.sdk.adsbase.c;

import android.content.Context;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.u;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class c implements Runnable {
    private static final Comparator<File> a;
    private final Context b;
    private final File[] c;

    static {
        c.class.getSimpleName();
        a = new Comparator<File>() { // from class: com.startapp.sdk.adsbase.c.c.1
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        };
    }

    public c(Context context, File[] fileArr) {
        this.b = context;
        this.c = fileArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        File[] fileArr;
        String str;
        String str2;
        String str3;
        e eVar = null;
        e eVar2 = null;
        Arrays.sort(this.c, a);
        int i = 0;
        for (File file : this.c) {
            if (i >= 5) {
                u.d(file);
            } else {
                List<String> c = u.c(file);
                if (c == null || c.size() < 2) {
                    u.d(file);
                } else {
                    if (c.size() < 3) {
                        str = AdsConstants.c + ".0";
                        str2 = c.get(0);
                        str3 = c.get(1);
                    } else {
                        str = c.get(0);
                        str2 = c.get(1);
                        str3 = c.get(2);
                    }
                    if (str != null && str2 != null && str3 != null) {
                        e eVar3 = new e(InfoEventCategory.EXCEPTION_FATAL);
                        eVar3.a(str);
                        eVar3.f(str2);
                        eVar3.g(str3);
                        eVar3.a((Object) file);
                        if (eVar == null) {
                            eVar = eVar3;
                        }
                        if (eVar2 != null) {
                            eVar2.a(eVar3);
                        }
                        eVar2 = eVar3;
                        i++;
                    }
                }
            }
        }
        if (eVar != null) {
            eVar.a(this.b, new a());
        }
    }
}
