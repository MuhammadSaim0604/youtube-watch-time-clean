package com.iab.omid.library.startapp.c;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.startapp.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class c implements a {
    private final int[] a = new int[2];

    @Override // com.iab.omid.library.startapp.c.a
    public final JSONObject a(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.a);
        return com.iab.omid.library.startapp.d.b.a(this.a[0], this.a[1], width, height);
    }

    @Override // com.iab.omid.library.startapp.c.a
    public final void a(View view, JSONObject jSONObject, a.InterfaceC0004a interfaceC0004a, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    interfaceC0004a.a(viewGroup.getChildAt(i), this, jSONObject);
                }
                return;
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
                ArrayList arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(Float.valueOf(childAt.getZ()), arrayList2);
                }
                arrayList2.add(childAt);
            }
            ArrayList arrayList3 = new ArrayList(hashMap.keySet());
            Collections.sort(arrayList3);
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
                while (it2.hasNext()) {
                    interfaceC0004a.a((View) it2.next(), this, jSONObject);
                }
            }
        }
    }
}
