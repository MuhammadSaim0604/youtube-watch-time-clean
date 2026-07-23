package com.startapp.sdk.adsbase.j;

import android.util.JsonReader;
import android.util.JsonToken;
import com.startapp.networkTest.enums.AppCategoryTypes;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class j {
    public String a = "";
    public AppCategoryTypes b = AppCategoryTypes.Unknown;
    public String c = "";
    public int d = -1;
    @com.startapp.common.parser.d(b = ArrayList.class, c = DiskAdCacheManager.class)
    public ArrayList<DiskAdCacheManager> e = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.adsbase.j.j$1  reason: invalid class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[JsonToken.values().length];

        static {
            try {
                a[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static Object a(JsonReader jsonReader) throws IOException {
        switch (AnonymousClass1.a[jsonReader.peek().ordinal()]) {
            case 1:
                return b(jsonReader);
            case 2:
                HashMap hashMap = new HashMap();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    hashMap.put(jsonReader.nextName(), a(jsonReader));
                }
                jsonReader.endObject();
                return hashMap;
            case 3:
                return jsonReader.nextString();
            case 4:
                return new BigDecimal(jsonReader.nextString());
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                throw new IOException(String.valueOf(jsonReader.peek()));
        }
    }

    public static List<Object> b(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(a(jsonReader));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
