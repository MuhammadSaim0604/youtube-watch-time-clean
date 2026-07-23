package com.startapp.sdk.a;

import android.content.Context;
import com.startapp.sdk.adsbase.j.d;
import com.startapp.sdk.adsbase.j.h;
import com.startapp.sdk.adsbase.j.u;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    private final String a;
    private final String b;
    private final String[] c;
    private final Object[] d;
    private final String[] e;
    private transient SoftReference<c> f;
    private final transient Map<String, SoftReference<Map<String, Object>>> g = new ConcurrentHashMap();

    static {
        a.class.getSimpleName();
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String[] c() {
        return this.c;
    }

    public final Object[] d() {
        return this.d;
    }

    public a(String str, String str2, String[] strArr, Object[] objArr, String[] strArr2) {
        this.a = str;
        this.b = str2;
        this.c = strArr;
        this.d = objArr;
        this.e = strArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return u.b(this.a, aVar.a) && u.b(this.b, aVar.b) && Arrays.equals(this.c, aVar.c) && Arrays.equals(this.d, aVar.d) && Arrays.equals(this.e, aVar.e);
    }

    public int hashCode() {
        return u.a(this.a, this.b, this.c, this.d, this.e);
    }

    public String toString() {
        return super.toString();
    }

    public final JSONArray a(Context context, int[] iArr, Integer num) {
        b it;
        try {
            Object a = a(context).a(this.d);
            if (a == null) {
                it = b.a;
            } else if (a instanceof Collection) {
                it = ((Collection) a).iterator();
            } else if (a.getClass().isArray()) {
                it = new C0027a(a, Array.getLength(a));
            } else {
                it = Collections.singleton(a).iterator();
            }
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null) {
                    JSONObject jSONObject = new JSONObject();
                    Class<?> cls = next.getClass();
                    SoftReference<Map<String, Object>> softReference = this.g.get(cls.getName());
                    Map<String, Object> map = softReference != null ? softReference.get() : null;
                    Map<String, Object> map2 = map;
                    if (map == null) {
                        map2 = a(cls, this.e);
                        this.g.put(cls.getName(), new SoftReference<>(map2));
                    }
                    for (Map.Entry<String, Object> entry : map2.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        try {
                            if (value instanceof Field) {
                                jSONObject.put(key, a(((Field) value).get(next)));
                            } else if (value instanceof Method) {
                                jSONObject.put(key, a(((Method) value).invoke(next, new Object[0])));
                            }
                        } catch (Throwable th) {
                        }
                    }
                    arrayList.add(jSONObject);
                }
            }
            if (iArr != null && iArr.length > 0) {
                d dVar = null;
                int length = this.e.length;
                for (int i : iArr) {
                    if (i != 0 && Math.abs(i) <= length) {
                        h hVar = new h(this.e[Math.abs(i) - 1]);
                        if (i < 0) {
                            hVar = Collections.reverseOrder(hVar);
                        }
                        if (dVar == null) {
                            dVar = hVar;
                        } else {
                            dVar = new d(dVar, hVar);
                        }
                    }
                }
                if (dVar != null) {
                    Collections.sort(arrayList, dVar);
                }
            }
            List<JSONObject> subList = (num == null || num.intValue() <= 0) ? arrayList : arrayList.subList(0, Math.min(num.intValue(), arrayList.size()));
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject2 : subList) {
                jSONArray.put(jSONObject2);
            }
            return jSONArray;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("5", e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException("5", e2);
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof Short) {
            return Integer.valueOf(((Short) obj).intValue());
        }
        if (obj instanceof Integer) {
            return obj;
        }
        if (obj instanceof Long) {
            return obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof Double) {
            return obj;
        }
        if (obj instanceof Boolean) {
            return obj;
        }
        if (obj instanceof String) {
            return obj;
        }
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    private c a(Context context) {
        c cVar = this.f != null ? this.f.get() : null;
        c cVar2 = cVar;
        if (cVar == null) {
            Object systemService = context.getApplicationContext().getSystemService(this.a);
            if (systemService != null) {
                try {
                    try {
                        Method a = a(systemService.getClass(), this.b, e());
                        if (!a.isAccessible()) {
                            try {
                                a.setAccessible(true);
                            } catch (SecurityException e) {
                                throw new RuntimeException("4", e);
                            }
                        }
                        cVar2 = new c(systemService, a);
                        this.f = new SoftReference<>(cVar2);
                    } catch (NoSuchMethodException e2) {
                        throw new RuntimeException("3", e2);
                    }
                } catch (ClassNotFoundException e3) {
                    throw new RuntimeException("2", e3);
                }
            } else {
                throw new RuntimeException("1");
            }
        }
        return cVar2;
    }

    private Class[] e() throws ClassNotFoundException {
        Class cls;
        Class[] clsArr = new Class[this.c.length];
        int length = clsArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i;
            String str = this.c[i];
            boolean z = true;
            switch (str.hashCode()) {
                case -1808118735:
                    if (str.equals("String")) {
                        z = true;
                        break;
                    }
                    break;
                case -1325958191:
                    if (str.equals("double")) {
                        z = true;
                        break;
                    }
                    break;
                case -891985903:
                    if (str.equals("string")) {
                        z = true;
                        break;
                    }
                    break;
                case 104431:
                    if (str.equals("int")) {
                        z = true;
                        break;
                    }
                    break;
                case 3039496:
                    if (str.equals("byte")) {
                        z = false;
                        break;
                    }
                    break;
                case 3052374:
                    if (str.equals("char")) {
                        z = true;
                        break;
                    }
                    break;
                case 3327612:
                    if (str.equals("long")) {
                        z = true;
                        break;
                    }
                    break;
                case 64711720:
                    if (str.equals("boolean")) {
                        z = true;
                        break;
                    }
                    break;
                case 97526364:
                    if (str.equals("float")) {
                        z = true;
                        break;
                    }
                    break;
                case 109413500:
                    if (str.equals("short")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    cls = Byte.TYPE;
                    break;
                case true:
                    cls = Short.TYPE;
                    break;
                case true:
                    cls = Integer.TYPE;
                    break;
                case true:
                    cls = Long.TYPE;
                    break;
                case true:
                    cls = Float.TYPE;
                    break;
                case true:
                    cls = Double.TYPE;
                    break;
                case true:
                    cls = Boolean.TYPE;
                    break;
                case true:
                    cls = Character.TYPE;
                    break;
                case true:
                case true:
                    cls = String.class;
                    break;
                default:
                    cls = Class.forName(str);
                    break;
            }
            clsArr[i2] = cls;
        }
        return clsArr;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) throws NoSuchMethodException {
        NoSuchMethodException noSuchMethodException = null;
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                return cls2.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e) {
                if (noSuchMethodException == null) {
                    noSuchMethodException = e;
                }
            }
        }
        throw noSuchMethodException;
    }

    private static Field a(Class<?> cls, String str) throws NoSuchFieldException {
        NoSuchFieldException noSuchFieldException = null;
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                return cls2.getDeclaredField(str);
            } catch (NoSuchFieldException e) {
                if (noSuchFieldException == null) {
                    noSuchFieldException = e;
                }
            }
        }
        throw noSuchFieldException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c A[Catch: NoSuchMethodException -> 0x008c, SecurityException -> 0x00c4, TryCatch #4 {NoSuchMethodException -> 0x008c, SecurityException -> 0x00c4, blocks: (B:14:0x0060, B:16:0x007c, B:17:0x0081), top: B:40:0x0060 }] */
    /* JADX WARN: Type inference failed for: r9v36, types: [java.lang.NoSuchFieldException] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.String, java.lang.Object> a(java.lang.Class<?> r13, java.lang.String[] r14) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.a.a.a(java.lang.Class, java.lang.String[]):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public static class C0027a implements Iterator<Object> {
        private Object a;
        private int b;
        private int c;

        public C0027a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.c < this.b;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Object obj = this.a;
            int i = this.c;
            this.c = i + 1;
            return Array.get(obj, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public static class b implements Iterator<Object> {
        static final b a = new b();

        b() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            return null;
        }
    }
}
