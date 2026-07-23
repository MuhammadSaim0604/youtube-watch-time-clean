package com.startapp.sdk.f.a;

import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class f {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public static e a(Object obj) {
        InfoEventCategory a;
        if (!(obj instanceof Map)) {
            return new e();
        }
        Object obj2 = ((Map) obj).get("type");
        Object obj3 = ((Map) obj).get("params");
        if (obj2 instanceof Number) {
            switch (((Number) obj2).intValue()) {
                case 1:
                    if (obj3 instanceof Number) {
                        return new a(((Number) obj3).intValue());
                    }
                    break;
                case 2:
                    if (obj3 instanceof List) {
                        LinkedList linkedList = new LinkedList();
                        for (Object obj4 : (List) obj3) {
                            if ((obj4 instanceof String) && (a = InfoEventCategory.a((String) obj4)) != null) {
                                linkedList.add(a);
                            }
                        }
                        if (linkedList.size() > 0) {
                            return new c(linkedList);
                        }
                    }
                    break;
                case 3:
                    if (obj3 instanceof Map) {
                        Object obj5 = ((Map) obj3).get("action");
                        if (obj5 instanceof String) {
                            Object obj6 = ((Map) obj3).get("extras");
                            HashMap hashMap = new HashMap();
                            if (obj6 instanceof Map) {
                                for (Map.Entry entry : ((Map) obj6).entrySet()) {
                                    Object key = entry.getKey();
                                    if (key instanceof String) {
                                        hashMap.put((String) key, String.valueOf(entry.getValue()));
                                    }
                                }
                            }
                            return new b((String) obj5, hashMap);
                        }
                    }
                    break;
            }
        }
        return new e();
    }

    public f(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
    }
}
