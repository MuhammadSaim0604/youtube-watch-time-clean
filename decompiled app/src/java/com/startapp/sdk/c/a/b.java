package com.startapp.sdk.c.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import java.util.LinkedHashSet;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class b extends com.startapp.sdk.c.a<a> {
    @Override // com.startapp.sdk.c.a
    protected final /* synthetic */ a a() {
        List<InputMethodSubtype> enabledInputMethodSubtypeList;
        if (Build.VERSION.SDK_INT >= 11) {
            Object systemService = this.a.getSystemService("input_method");
            if (systemService instanceof InputMethodManager) {
                LinkedHashSet linkedHashSet = null;
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                InputMethodSubtype currentInputMethodSubtype = inputMethodManager.getCurrentInputMethodSubtype();
                if (currentInputMethodSubtype != null && "keyboard".equals(currentInputMethodSubtype.getMode())) {
                    String locale = currentInputMethodSubtype.getLocale();
                    if (!TextUtils.isEmpty(locale)) {
                        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                        linkedHashSet = linkedHashSet2;
                        if (linkedHashSet2.size() < 10) {
                            linkedHashSet.add(locale);
                        }
                    }
                }
                List<InputMethodInfo> inputMethodList = inputMethodManager.getInputMethodList();
                if (inputMethodList != null) {
                    for (InputMethodInfo inputMethodInfo : inputMethodList) {
                        if (inputMethodInfo != null && (enabledInputMethodSubtypeList = inputMethodManager.getEnabledInputMethodSubtypeList(inputMethodInfo, true)) != null) {
                            for (InputMethodSubtype inputMethodSubtype : enabledInputMethodSubtypeList) {
                                if (inputMethodSubtype != null && "keyboard".equals(inputMethodSubtype.getMode())) {
                                    String locale2 = inputMethodSubtype.getLocale();
                                    if (!TextUtils.isEmpty(locale2)) {
                                        if (linkedHashSet == null) {
                                            linkedHashSet = new LinkedHashSet();
                                        }
                                        if (linkedHashSet.size() < 10) {
                                            linkedHashSet.add(locale2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (linkedHashSet != null) {
                    return new a(linkedHashSet);
                }
            }
        }
        return null;
    }

    public b(Context context) {
        super(context);
    }

    @Override // com.startapp.sdk.c.a
    protected final /* bridge */ /* synthetic */ a b() {
        return a.a;
    }
}
