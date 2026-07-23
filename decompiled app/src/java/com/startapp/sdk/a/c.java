package com.startapp.sdk.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
final class c {
    private final Object a;
    private final Method b;

    public c(Object obj, Method method) {
        this.a = obj;
        this.b = method;
    }

    public final Object a(Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        return this.b.invoke(this.a, objArr);
    }
}
