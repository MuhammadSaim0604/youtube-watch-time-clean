package com.startapp.sdk.adsbase;

import android.content.Context;
import android.content.SharedPreferences;
import com.startapp.sdk.adsbase.j.u;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class j {
    private static SharedPreferences a;

    static {
        j.class.getSimpleName();
        a = null;
    }

    public static SharedPreferences a(Context context) {
        if (a == null) {
            a = context.getApplicationContext().getSharedPreferences("com.startapp.sdk", 0);
        }
        return a;
    }

    public static Boolean a(Context context, String str, Boolean bool) {
        return Boolean.valueOf(a(context).getBoolean(str, bool.booleanValue()));
    }

    public static void b(Context context, String str, Boolean bool) {
        u.a(a(context).edit().putBoolean(str, bool.booleanValue()));
    }

    public static String a(Context context, String str, String str2) {
        return a(context).getString(str, str2);
    }

    public static void b(Context context, String str, String str2) {
        u.a(a(context).edit().putString(str, str2));
    }

    public static Integer a(Context context, String str, Integer num) {
        return Integer.valueOf(a(context).getInt(str, num.intValue()));
    }

    public static void b(Context context, String str, Integer num) {
        u.a(a(context).edit().putInt(str, num.intValue()));
    }

    public static Float a(Context context, String str, Float f) {
        return Float.valueOf(a(context).getFloat(str, f.floatValue()));
    }

    public static void b(Context context, String str, Float f) {
        u.a(a(context).edit().putFloat(str, f.floatValue()));
    }

    public static Long a(Context context, String str, Long l) {
        return Long.valueOf(a(context).getLong(str, l.longValue()));
    }

    public static void b(Context context, String str, Long l) {
        u.a(a(context).edit().putLong(str, l.longValue()));
    }

    public static void a(Context context, String str, Map<String, String> map) {
        b(context, str, new JSONObject(map).toString());
    }

    public static void b(Context context, String str, Map<String, String> map) {
        String string = a(context).getString(str, null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    map.put(next, (String) jSONObject.get(next));
                }
            } catch (JSONException e) {
            }
        }
    }
}
