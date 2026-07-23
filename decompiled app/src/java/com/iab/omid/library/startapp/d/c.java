package com.iab.omid.library.startapp.d;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class c {
    public static float a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean c(View view) {
        if ((Build.VERSION.SDK_INT < 19 || view.isAttachedToWindow()) && view.getVisibility() == 0 && view.getAlpha() != 0.0f) {
            return true;
        }
        return false;
    }

    public static boolean b(View view) {
        View view2 = view;
        if ((Build.VERSION.SDK_INT < 19 || view2.isAttachedToWindow()) && view2.isShown()) {
            while (view2 != null) {
                if (view2.getAlpha() == 0.0f) {
                    return false;
                }
                ViewParent parent = view2.getParent();
                view2 = parent instanceof View ? (View) parent : null;
            }
            return true;
        }
        return false;
    }
}
