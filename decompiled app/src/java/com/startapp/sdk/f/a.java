package com.startapp.sdk.f;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.Base64;
import android.util.JsonReader;
import android.util.Pair;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.j.g;
import com.startapp.sdk.adsbase.j.j;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.remoteconfig.RscMetadata;
import com.startapp.sdk.adsbase.remoteconfig.RscMetadataItem;
import com.startapp.sdk.f.a.e;
import com.startapp.sdk.f.a.f;
import java.io.IOException;
import java.io.StringReader;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class a {
    private final Context a;
    private final g<RscMetadata> b;
    private RscMetadata c;
    private List<e> d;
    private List<b> e;
    private final Map<com.startapp.sdk.a.a, Pair<Long, SoftReference<JSONObject>>> f = new WeakHashMap();

    static {
        a.class.getSimpleName();
    }

    public a(Context context, g<RscMetadata> gVar) {
        this.a = context;
        this.b = gVar;
    }

    public final void a() {
        List<b> c = c();
        if (a(1024)) {
            new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.GENERAL).f("RSC init").g("targets: " + (c != null ? Integer.valueOf(c.size()) : null)).a(this.a);
        }
    }

    private RscMetadata b() {
        RscMetadata a = this.b.a();
        if (a == null || !a.a()) {
            return null;
        }
        return a;
    }

    private boolean a(int i) {
        RscMetadata b = b();
        return (b == null || (b.d() & i) == 0) ? false : true;
    }

    private static boolean a(RscMetadata rscMetadata, int i) {
        return (rscMetadata == null || (rscMetadata.d() & i) == 0) ? false : true;
    }

    private static boolean a(RscMetadata rscMetadata, RscMetadataItem rscMetadataItem, int i) {
        return (rscMetadata.a(rscMetadataItem) & i) != 0;
    }

    private List<b> c() {
        List<b> a;
        com.startapp.sdk.a.a a2;
        int i;
        int i2;
        if (Build.VERSION.SDK_INT < 11) {
            return null;
        }
        RscMetadata b = b();
        if (b == null) {
            return a((RscMetadata) null, (List<e>) null, (List<b>) null);
        }
        List<e> list = this;
        synchronized (this) {
            try {
                if (b.equals(this.c)) {
                    List<b> list2 = this.e;
                    a = list2;
                } else {
                    List<e> a3 = a(this.a, b);
                    list = a3;
                    if (a3 == null || list.size() <= 0) {
                        a = a(b, (List<e>) null, (List<b>) null);
                    } else {
                        List<RscMetadataItem> c = b.c();
                        if (c == null || c.size() <= 0) {
                            a = a(b, (List<e>) null, (List<b>) null);
                        } else {
                            LinkedList linkedList = new LinkedList();
                            for (RscMetadataItem rscMetadataItem : c) {
                                if (rscMetadataItem != null && (a2 = a(this.a, b, rscMetadataItem)) != null) {
                                    List<Pair<e, Boolean>> a4 = a(list, rscMetadataItem.b(), rscMetadataItem.c());
                                    if (a4.size() > 0) {
                                        if (rscMetadataItem.d() != null) {
                                            i = rscMetadataItem.d().intValue();
                                        } else {
                                            i = 300;
                                        }
                                        int[] e = rscMetadataItem.e();
                                        Integer f = rscMetadataItem.f();
                                        if (rscMetadataItem.g() != null) {
                                            i2 = rscMetadataItem.g().intValue();
                                        } else {
                                            i2 = 0;
                                        }
                                        linkedList.add(new b(a2, a4, i, e, f, i2, b.a(rscMetadataItem)));
                                    }
                                }
                            }
                            a = a(b, list, linkedList);
                        }
                    }
                }
                return a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private synchronized List<b> a(RscMetadata rscMetadata, List<e> list, List<b> list2) {
        if (this.d != null) {
            for (e eVar : this.d) {
                eVar.a(this.a);
            }
        }
        this.c = rscMetadata;
        this.d = list;
        this.e = list2;
        if (list != null) {
            for (e eVar2 : this.d) {
                eVar2.a(this.a, this);
            }
        }
        return list2;
    }

    private static List<e> a(Context context, RscMetadata rscMetadata) {
        String b = rscMetadata.b();
        if (b == null || b.length() <= 0) {
            return null;
        }
        try {
            try {
                List<Object> b2 = j.b(new JsonReader(new StringReader(a(b))));
                ArrayList arrayList = new ArrayList();
                for (Object obj : b2) {
                    arrayList.add(f.a(obj));
                }
                return arrayList;
            } catch (Throwable th) {
                if (a(rscMetadata, 1)) {
                    new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                }
                return null;
            }
        } catch (Throwable th2) {
            if (a(rscMetadata, 1)) {
                new com.startapp.sdk.adsbase.infoevents.e(th2).a(context);
            }
            return null;
        }
    }

    private static com.startapp.sdk.a.a a(Context context, RscMetadata rscMetadata, RscMetadataItem rscMetadataItem) {
        String a = rscMetadataItem.a();
        if (a == null || a.length() <= 0) {
            return null;
        }
        try {
            com.startapp.sdk.a.a aVar = null;
            try {
                aVar = com.startapp.sdk.a.b.a(a(a));
            } catch (Throwable th) {
                if (a(rscMetadata, rscMetadataItem, 4)) {
                    new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                }
            }
            return aVar;
        } catch (Throwable th2) {
            if (a(rscMetadata, rscMetadataItem, 2)) {
                new com.startapp.sdk.adsbase.infoevents.e(th2).a(context);
            }
            return null;
        }
    }

    public final String a(Object obj) {
        List<b> c = c();
        if (c == null) {
            return null;
        }
        JSONObject jSONObject = null;
        for (b bVar : c) {
            int i = 0;
            try {
                i = bVar.a(obj);
            } catch (Throwable th) {
                if (bVar.b(256)) {
                    new com.startapp.sdk.adsbase.infoevents.e(th).a(this.a);
                }
            }
            if ((i & 1) != 0) {
                com.startapp.sdk.a.a a = bVar.a();
                JSONObject jSONObject2 = null;
                if ((i & 2) == 0) {
                    jSONObject2 = a(a, bVar.b());
                }
                if (jSONObject2 == null) {
                    JSONArray jSONArray = null;
                    try {
                        jSONArray = a.a(this.a, bVar.c(), bVar.d());
                    } catch (Throwable th2) {
                        if (bVar.b(8)) {
                            new com.startapp.sdk.adsbase.infoevents.e(th2).a(this.a);
                        }
                    }
                    if (jSONArray != null && jSONArray.length() > 0) {
                        jSONObject2 = new JSONObject();
                        try {
                            if (bVar.a(1)) {
                                jSONObject2.put("currentTimeMillis", System.currentTimeMillis());
                            }
                            if (bVar.a(2)) {
                                jSONObject2.put("bootTimeMillis", SystemClock.elapsedRealtime());
                            }
                            JSONArray a2 = a(this.a, bVar);
                            if (a2 != null) {
                                jSONObject2.put("params", a2);
                            }
                            jSONObject2.put("items", jSONArray);
                        } catch (JSONException e) {
                            if (bVar.b(32)) {
                                new com.startapp.sdk.adsbase.infoevents.e(e).a(this.a);
                            }
                        }
                        a(a, jSONObject2);
                    }
                }
                if (jSONObject2 != null) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    try {
                        JSONObject optJSONObject = jSONObject.optJSONObject(a.a());
                        JSONObject jSONObject3 = optJSONObject;
                        if (optJSONObject == null) {
                            jSONObject3 = new JSONObject();
                            jSONObject.put(a.a(), jSONObject3);
                        }
                        JSONArray optJSONArray = jSONObject3.optJSONArray(a.b());
                        JSONArray jSONArray2 = optJSONArray;
                        if (optJSONArray == null) {
                            jSONArray2 = new JSONArray();
                            jSONObject3.put(a.b(), jSONArray2);
                        }
                        jSONArray2.put(jSONObject2);
                    } catch (JSONException e2) {
                        if (bVar.b(32)) {
                            new com.startapp.sdk.adsbase.infoevents.e(e2).a(this.a);
                        }
                    }
                }
            }
        }
        if (jSONObject == null) {
            return null;
        }
        String str = null;
        try {
            str = Base64.encodeToString(com.startapp.common.b.a.a(u.a(jSONObject.toString())), 10);
        } catch (Throwable th3) {
            if (a(16)) {
                new com.startapp.sdk.adsbase.infoevents.e(th3).a(this.a);
            }
        }
        return str;
    }

    private static JSONArray a(Context context, b bVar) {
        String[] c = bVar.a().c();
        Object[] d = bVar.a().d();
        if (c.length == d.length) {
            int length = c.length;
            if (length == 0) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(c[i], d[i]);
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            } catch (JSONException e) {
                if (bVar.b(32)) {
                    new com.startapp.sdk.adsbase.infoevents.e(e).a(context);
                }
            }
        } else if (bVar.b(512)) {
            new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("c690e4ef5365d88b").g(Arrays.toString(c) + ", " + Arrays.toString(d)).a(context);
        }
        return null;
    }

    private JSONObject a(com.startapp.sdk.a.a aVar, int i) {
        Pair<Long, SoftReference<JSONObject>> pair;
        JSONObject jSONObject;
        synchronized (this) {
            pair = this.f.get(aVar);
        }
        if (pair != null && (jSONObject = (JSONObject) ((SoftReference) pair.second).get()) != null) {
            if (((Long) pair.first).longValue() + (i * 1000) < SystemClock.elapsedRealtime()) {
                return null;
            }
            return jSONObject;
        }
        return null;
    }

    private synchronized void a(com.startapp.sdk.a.a aVar, JSONObject jSONObject) {
        this.f.put(aVar, new Pair<>(Long.valueOf(SystemClock.elapsedRealtime()), new SoftReference(jSONObject)));
    }

    private static List<Pair<e, Boolean>> a(List<e> list, int i, int i2) {
        ArrayList arrayList = new ArrayList(Math.min(list.size(), Integer.bitCount(i)));
        int i3 = 0;
        for (e eVar : list) {
            if ((i & (1 << i3)) != 0) {
                arrayList.add(new Pair(eVar, Boolean.valueOf((i2 & (1 << i3)) != 0)));
            }
            i3++;
        }
        return arrayList;
    }

    private static String a(String str) throws IOException {
        return new String(u.a(com.startapp.common.b.a.a(Base64.decode(str, 8))));
    }
}
