package com.startapp.common.parser;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class b {
    static {
        com.startapp.common.b.b.a(b.class);
    }

    public static <T> T a(String str, Class<T> cls) {
        a aVar = null;
        try {
            a aVar2 = new a(str);
            aVar = aVar2;
            T t = (T) aVar2.a(cls);
            try {
                aVar.close();
            } catch (IOException e) {
            }
            return t;
        } catch (Throwable th) {
            if (aVar != null) {
                try {
                    aVar.close();
                } catch (IOException e2) {
                }
            }
            throw th;
        }
    }

    public static String a(Object obj) {
        return String.valueOf(b(obj));
    }

    private static JSONObject b(Object obj) {
        boolean z;
        if (obj == null) {
            return null;
        }
        ArrayList<Field> arrayList = new ArrayList();
        for (Class<? super Object> cls = obj.getClass(); cls != null && !Object.class.equals(cls); cls = cls.getSuperclass()) {
            arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
        }
        JSONObject jSONObject = new JSONObject();
        for (Field field : arrayList) {
            int modifiers = field.getModifiers();
            if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                try {
                    field.setAccessible(true);
                    if (field.get(obj) != null) {
                        String a = com.iab.omid.library.startapp.b.a(field);
                        Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                        if (declaredAnnotations == null || declaredAnnotations.length == 0) {
                            z = false;
                        } else {
                            Annotation annotation = field.getDeclaredAnnotations()[0];
                            z = !annotation.annotationType().equals(d.class) ? false : ((d) annotation).a();
                        }
                        if (z) {
                            jSONObject.put(a, b(field.get(obj)));
                        } else if (List.class.isAssignableFrom(field.getType())) {
                            JSONArray jSONArray = new JSONArray();
                            for (Object obj2 : (List) field.get(obj)) {
                                jSONArray.put(c(obj2));
                            }
                            jSONObject.put(a, jSONArray);
                        } else if (Set.class.isAssignableFrom(field.getType())) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (Object obj3 : (Set) field.get(obj)) {
                                jSONArray2.put(c(obj3));
                            }
                            jSONObject.put(a, jSONArray2);
                        } else if (Map.class.isAssignableFrom(field.getType())) {
                            JSONObject jSONObject2 = new JSONObject();
                            for (Map.Entry entry : ((Map) field.get(obj)).entrySet()) {
                                jSONObject2.put(entry.getKey().toString(), c(entry.getValue()));
                            }
                            jSONObject.put(a, jSONObject2);
                        } else {
                            jSONObject.put(a, field.get(obj));
                        }
                    }
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e2) {
                } catch (JSONException e3) {
                }
            }
        }
        return jSONObject;
    }

    private static Object c(Object obj) {
        if (!com.iab.omid.library.startapp.b.a(obj)) {
            return b(obj);
        }
        return obj;
    }
}
