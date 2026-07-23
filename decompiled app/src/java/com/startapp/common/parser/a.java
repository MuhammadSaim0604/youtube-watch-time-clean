package com.startapp.common.parser;

import android.os.Build;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a extends InputStream {
    private static final String a = com.startapp.common.b.b.a(a.class);
    private static Map<String, Class> d;
    private InputStream b = null;
    private String c;

    static {
        HashMap hashMap = new HashMap();
        d = hashMap;
        hashMap.put("int[]", Integer.class);
        d.put("long[]", Long.class);
        d.put("double[]", Double.class);
        d.put("float[]", Float.class);
        d.put("bool[]", Boolean.class);
        d.put("char[]", Character.class);
        d.put("byte[]", Byte.class);
        d.put("void[]", Void.class);
        d.put("short[]", Short.class);
    }

    public a(String str) {
        this.c = str;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T a(Class<T> cls) {
        T t = null;
        try {
            t = a(cls, (JSONObject) null);
        } catch (JSONStreamException e) {
            Log.e(a, "Error while trying to parse object " + cls.toString(), e);
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T a(Class<T> cls, JSONObject jSONObject) throws JSONStreamException {
        Object a2;
        JSONObject jSONObject2 = jSONObject;
        if (this.c == null) {
            throw new JSONStreamException("Can't read object, the input is null.");
        }
        if (this.c == null) {
            try {
                this.c = a();
            } catch (Exception e) {
                throw new JSONStreamException("Can't read input stream.", e);
            }
        }
        if (jSONObject2 == null) {
            try {
                jSONObject2 = new JSONObject(this.c);
            } catch (JSONException e2) {
                throw new JSONStreamException("Can't deserialize the object. Failed to create JSON object.", e2);
            }
        }
        Object obj = null;
        try {
            c cVar = (c) cls.getAnnotation(c.class);
            if (Build.VERSION.SDK_INT >= 9 && cls.equals(HttpCookie.class)) {
                Constructor<?> constructor = cls.getDeclaredConstructors()[0];
                constructor.setAccessible(true);
                obj = constructor.newInstance("name", "value");
            } else if (cls.isPrimitive()) {
                return cls.newInstance();
            } else {
                if (cls.getAnnotation(c.class) == null || cVar.c()) {
                    Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    obj = declaredConstructor.newInstance(new Object[0]);
                } else if (!cVar.c()) {
                    try {
                        return (T) a(Class.forName(cVar.b() + "." + jSONObject2.getString(cVar.a())), jSONObject2);
                    } catch (ClassNotFoundException e3) {
                        throw new JSONStreamException("Problem instantiating object class ", e3);
                    } catch (JSONException e4) {
                        throw new JSONStreamException("Problem instantiating object class ", e4);
                    }
                }
            }
            Field[] declaredFields = cls.getDeclaredFields();
            if (cVar != null && cVar.c()) {
                int length = declaredFields.length;
                Field[] declaredFields2 = cls.getSuperclass().getDeclaredFields();
                int length2 = declaredFields2.length;
                Field[] fieldArr = new Field[length + length2];
                System.arraycopy(declaredFields, 0, fieldArr, 0, length);
                System.arraycopy(declaredFields2, 0, fieldArr, length, length2);
                declaredFields = fieldArr;
            }
            Field[] fieldArr2 = declaredFields;
            for (Field field : fieldArr2) {
                int modifiers = field.getModifiers();
                boolean z = false;
                boolean z2 = false;
                Class<T> cls2 = null;
                Class cls3 = null;
                Class cls4 = null;
                Class cls5 = null;
                if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                    String a3 = com.iab.omid.library.startapp.b.a(field);
                    try {
                        if (jSONObject2.has(a3)) {
                            field.setAccessible(true);
                            if (field.getDeclaredAnnotations().length > 0) {
                                Annotation annotation = field.getDeclaredAnnotations()[0];
                                if (annotation.annotationType().equals(d.class)) {
                                    z2 = true;
                                    d dVar = (d) annotation;
                                    cls2 = dVar.b();
                                    cls3 = dVar.d();
                                    cls4 = dVar.c();
                                    z = dVar.a();
                                    cls5 = dVar.e();
                                }
                            }
                            if (field.getType().getAnnotation(c.class) != null) {
                                c cVar2 = (c) field.getType().getAnnotation(c.class);
                                field.set(obj, a(Class.forName(cVar2.b() + "." + jSONObject2.getJSONObject(a3).getString(cVar2.a())), jSONObject2.getJSONObject(a3)));
                            } else if (z) {
                                field.set(obj, a(field.getType(), jSONObject2.getJSONObject(a3)));
                            } else if (z2 && (Map.class.isAssignableFrom(cls2) || Collection.class.isAssignableFrom(cls2))) {
                                if (cls2.equals(HashMap.class)) {
                                    JSONObject jSONObject3 = jSONObject2.getJSONObject(a3);
                                    field.set(obj, a(cls3, cls4, cls5, jSONObject3, jSONObject3.keys()));
                                } else if (cls2.equals(ArrayList.class)) {
                                    field.set(obj, c(cls4, jSONObject2.getJSONArray(a3)));
                                } else if (cls2.equals(HashSet.class)) {
                                    field.set(obj, a(cls4, jSONObject2.getJSONArray(a3)));
                                } else if (cls2.equals(EnumSet.class)) {
                                    field.set(obj, b(cls4, jSONObject2.getJSONArray(a3)));
                                }
                            } else if (!field.getType().isEnum()) {
                                if (field.getType().isPrimitive()) {
                                    Object obj2 = obj;
                                    JSONObject jSONObject4 = jSONObject2;
                                    Object obj3 = jSONObject2.get(a3);
                                    Class<?> type = field.getType();
                                    Object obj4 = obj3;
                                    Object obj5 = obj4;
                                    if (!obj3.getClass().equals(type)) {
                                        if (obj3.getClass().equals(String.class)) {
                                            obj5 = obj4;
                                            if (type.equals(Integer.TYPE)) {
                                                obj5 = Integer.valueOf(jSONObject4.getInt(com.iab.omid.library.startapp.b.a(field)));
                                            }
                                        } else if (type.equals(Integer.TYPE)) {
                                            obj5 = Integer.valueOf(((Number) obj3).intValue());
                                        } else if (type.equals(Float.TYPE)) {
                                            obj5 = Float.valueOf(((Number) obj3).floatValue());
                                        } else if (type.equals(Long.TYPE)) {
                                            obj5 = Long.valueOf(((Number) obj3).longValue());
                                        } else {
                                            obj5 = obj4;
                                            if (type.equals(Double.TYPE)) {
                                                obj5 = Double.valueOf(((Number) obj3).doubleValue());
                                            }
                                        }
                                    }
                                    field.set(obj2, obj5);
                                } else if (!field.getType().isArray()) {
                                    Object obj6 = jSONObject2.get(a3);
                                    Class<?> type2 = field.getType();
                                    Object obj7 = obj6;
                                    Object obj8 = obj7;
                                    if (!obj6.getClass().equals(type2)) {
                                        if (type2.equals(Integer.class)) {
                                            if (obj6.getClass().equals(Double.class)) {
                                                obj8 = Integer.valueOf(((Double) obj6).intValue());
                                            } else {
                                                obj8 = obj7;
                                                if (obj6.getClass().equals(Long.class)) {
                                                    obj8 = Integer.valueOf(((Long) obj6).intValue());
                                                }
                                            }
                                        } else {
                                            obj8 = obj7;
                                            if (type2.equals(Long.class)) {
                                                obj8 = obj7;
                                                if (obj6.getClass().equals(Integer.class)) {
                                                    obj8 = Long.valueOf(((Integer) obj6).longValue());
                                                }
                                            }
                                        }
                                    }
                                    Object obj9 = obj8;
                                    if (obj9.equals(null)) {
                                        field.set(obj, null);
                                    } else {
                                        field.set(obj, obj9);
                                    }
                                } else {
                                    Object obj10 = obj;
                                    JSONObject jSONObject5 = jSONObject2;
                                    if (cls2 != null) {
                                        a2 = a(jSONObject5, cls2, field);
                                    } else {
                                        a2 = a(jSONObject5, field);
                                    }
                                    field.set(obj10, a2);
                                }
                            } else {
                                field.set(obj, Enum.valueOf(cls2, (String) jSONObject2.get(a3)));
                            }
                        } else {
                            Log.i(a, String.format("Field [%s] doesn't exist. Keeping default value.", a3));
                        }
                    } catch (Exception e5) {
                        Log.e(a, String.format("Failed to get field [%s] %s", a3, e5.toString()));
                    } catch (Throwable th) {
                        throw new JSONStreamException("Unknown error occurred ", th);
                    }
                }
            }
            return obj;
        } catch (Exception e6) {
            throw new JSONStreamException("Can't deserialize the object. Failed to instantiate object.", e6);
        }
    }

    private static Object a(JSONObject jSONObject, Field field) throws JSONException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException, IllegalArgumentException, NoSuchFieldException {
        Object newInstance;
        JSONArray jSONArray = jSONObject.getJSONArray(com.iab.omid.library.startapp.b.a(field));
        int length = jSONArray.length();
        Class cls = d.get(field.getType().getSimpleName());
        Object newInstance2 = Array.newInstance((Class) cls.getField("TYPE").get(null), length);
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            Class cls2 = String.class;
            if (cls.equals(Character.class)) {
                cls2 = Character.TYPE;
            }
            Constructor constructor = cls.getConstructor(cls2);
            if (cls.equals(Character.class)) {
                newInstance = constructor.newInstance(Character.valueOf(string.charAt(0)));
            } else {
                newInstance = constructor.newInstance(string);
            }
            Array.set(newInstance2, i, newInstance);
        }
        return newInstance2;
    }

    private <T> T[] a(JSONObject jSONObject, Class<T> cls, Field field) throws JSONStreamException, JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(com.iab.omid.library.startapp.b.a(field));
        int length = jSONArray.length();
        Object newInstance = Array.newInstance((Class<?>) cls, length);
        for (int i = 0; i < length; i++) {
            Array.set(newInstance, i, a(cls, jSONArray.getJSONObject(i)));
        }
        return (T[]) ((Object[]) newInstance);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.Map, java.util.HashMap, java.util.Map<K, V>] */
    /* JADX WARN: Type inference failed for: r10v31, types: [java.lang.Enum] */
    private <K, V> Map<K, V> a(Class<K> cls, Class<V> cls2, Class cls3, JSONObject jSONObject, Iterator<K> it) throws JSONException, JSONStreamException {
        HashMap hashMap = new HashMap();
        while (it.hasNext()) {
            K next = it.next();
            K k = next;
            if (cls.equals(Integer.class)) {
                k = cls.cast(Integer.valueOf(Integer.parseInt((String) next)));
            }
            if (cls.isEnum()) {
                k = Enum.valueOf(cls, k.toString());
            }
            JSONObject optJSONObject = jSONObject.optJSONObject((String) next);
            if (optJSONObject == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray((String) next);
                if (optJSONArray == null) {
                    if (cls2.isEnum()) {
                        hashMap.put(k, Enum.valueOf(cls2, (String) jSONObject.get((String) next)));
                    } else {
                        hashMap.put(k, jSONObject.get((String) next));
                    }
                } else {
                    hashMap.put(k, a(cls3, optJSONArray));
                }
            } else {
                hashMap.put(k, a(cls2, optJSONObject));
            }
        }
        return hashMap;
    }

    private <V> Set<V> a(Class<V> cls, JSONArray jSONArray) throws JSONException, JSONStreamException {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                hashSet.add(jSONArray.get(i));
            } else {
                hashSet.add(a(cls, optJSONObject));
            }
        }
        return hashSet;
    }

    private static <V> Set b(Class<V> cls, JSONArray jSONArray) throws JSONException, JSONStreamException {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(Enum.valueOf(cls, jSONArray.getString(i)));
        }
        return hashSet;
    }

    private <V> List<V> c(Class<V> cls, JSONArray jSONArray) throws JSONException, JSONStreamException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                arrayList.add(jSONArray.get(i));
            } else {
                arrayList.add(a(cls, optJSONObject));
            }
        }
        return arrayList;
    }

    @Override // java.io.InputStream
    @Deprecated
    public final int read() throws IOException {
        return 0;
    }

    private static String a() throws Exception {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(null));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        return sb.toString();
                    }
                } catch (IOException e) {
                    Log.e(a, String.format("Can't create BufferedReader [%s]", e.toString()));
                    throw e;
                }
            }
        } catch (Exception e2) {
            Log.e(a, String.format("Can't create BufferedReader [%s]", e2.toString()));
            throw e2;
        }
    }
}
