package com.startapp.sdk.a;

import android.util.JsonReader;
import com.startapp.sdk.adsbase.j.j;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b {
    public static a a(String str) {
        try {
            List<Object> b = j.b(new JsonReader(new StringReader(str)));
            String str2 = (String) b.get(0);
            if (str2 == null) {
                throw new IllegalArgumentException(str);
            }
            String str3 = (String) b.get(1);
            if (str3 == null) {
                throw new IllegalArgumentException(str);
            }
            List list = (List) b.get(2);
            if (list == null) {
                throw new IllegalArgumentException(str);
            }
            String[] strArr = new String[list.size()];
            Object[] objArr = new Object[list.size()];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Map map = (Map) list.get(i);
                if (map == null) {
                    throw new IllegalArgumentException(str);
                }
                if (map.size() != 1) {
                    throw new IllegalArgumentException(str);
                }
                Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
                String str4 = (String) entry.getKey();
                if (str4 == null) {
                    throw new IllegalArgumentException(str);
                }
                strArr[i] = str4;
                objArr[i] = entry.getValue();
            }
            List list2 = (List) b.get(3);
            if (list2 == null) {
                throw new IllegalArgumentException(str);
            }
            String[] strArr2 = new String[list2.size()];
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str5 = (String) list2.get(i2);
                if (str5 == null) {
                    throw new IllegalArgumentException(str);
                }
                strArr2[i2] = str5;
            }
            return new a(str2, str3, strArr, objArr, strArr2);
        } catch (IOException e) {
            throw new IllegalArgumentException(str, e);
        } catch (ClassCastException e2) {
            throw new IllegalArgumentException(str, e2);
        }
    }

    public final String toString() {
        return com.iab.omid.library.startapp.b.b(this);
    }
}
