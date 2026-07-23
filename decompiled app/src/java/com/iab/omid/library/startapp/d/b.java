package com.iab.omid.library.startapp.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b {
    private static WindowManager a = null;
    private static String[] b = {"x", "y", "width", "height"};
    private static float c = Resources.getSystem().getDisplayMetrics().density;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    static class a {
        final float a;
        final float b;

        a(float f, float f2) {
            this.a = f;
            this.b = f2;
        }
    }

    public static void a(Context context) {
        if (context != null) {
            c = context.getResources().getDisplayMetrics().density;
            a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            com.iab.omid.library.startapp.b.a("Error with setting ad session id", e);
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            com.iab.omid.library.startapp.b.a("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    public static void a(JSONObject jSONObject, List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
        } catch (JSONException e) {
            com.iab.omid.library.startapp.b.a("Error with setting friendly obstruction", e);
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            JSONArray jSONArray = optJSONArray;
            if (optJSONArray == null) {
                jSONArray = new JSONArray();
                jSONObject.put("childViews", jSONArray);
            }
            jSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray == null || jSONArray2 == null) {
            return false;
        }
        return jSONArray.length() == jSONArray2.length();
    }

    public static JSONObject a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", i / c);
            jSONObject.put("y", i2 / c);
            jSONObject.put("width", i3 / c);
            jSONObject.put("height", i4 / c);
        } catch (JSONException e) {
            com.iab.omid.library.startapp.b.a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    public static void a(JSONObject jSONObject) {
        Point point;
        float f = 0.0f;
        float f2 = 0.0f;
        if (Build.VERSION.SDK_INT < 17) {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        double optDouble = optJSONObject.optDouble("x");
                        double optDouble2 = optJSONObject.optDouble("y");
                        double optDouble3 = optJSONObject.optDouble("width");
                        double optDouble4 = optJSONObject.optDouble("height");
                        f = Math.max(f, (float) (optDouble + optDouble3));
                        f2 = Math.max(f2, (float) (optDouble2 + optDouble4));
                    }
                }
            }
        } else if (a != null) {
            a.getDefaultDisplay().getRealSize(new Point(0, 0));
            f = point.x / c;
            f2 = point.y / c;
        }
        a aVar = new a(f, f2);
        try {
            jSONObject.put("width", aVar.a);
            jSONObject.put("height", aVar.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(@android.support.annotation.NonNull org.json.JSONObject r13, @android.support.annotation.Nullable org.json.JSONObject r14) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iab.omid.library.startapp.d.b.b(org.json.JSONObject, org.json.JSONObject):boolean");
    }
}
