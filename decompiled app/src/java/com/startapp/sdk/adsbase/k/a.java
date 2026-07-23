package com.startapp.sdk.adsbase.k;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    public int a;
    public String b;

    public static boolean a(View view, int i) {
        if (view != null && view.getParent() != null && view.getRootView() != null && view.getRootView().getParent() != null && view.hasWindowFocus() && view.isShown()) {
            if (view.getWidth() <= 0 || view.getHeight() <= 0) {
                return false;
            }
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect) && !rect.isEmpty()) {
                return a(rect, view) >= ((view.getWidth() * view.getHeight()) * Math.min(Math.max(1, i), 100)) / 100;
            }
            return false;
        }
        return false;
    }

    private static int a(Rect rect, View view) {
        ViewGroup viewGroup = view;
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        while (viewGroup.getParent() instanceof ViewGroup) {
            if (Build.VERSION.SDK_INT >= 11 && viewGroup.getAlpha() < 1.0f) {
                return 0;
            }
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            int childCount = viewGroup2.getChildCount();
            for (int indexOfChild = viewGroup2.indexOfChild(viewGroup) + 1; indexOfChild < childCount; indexOfChild++) {
                View childAt = viewGroup2.getChildAt(indexOfChild);
                if (childAt != null && childAt.getVisibility() == 0 && childAt.getGlobalVisibleRect(rect2)) {
                    region.op(rect2, Region.Op.DIFFERENCE);
                }
            }
            viewGroup = viewGroup2;
        }
        int i = 0;
        RegionIterator regionIterator = new RegionIterator(region);
        while (regionIterator.next(rect2)) {
            i += rect2.width() * rect2.height();
        }
        return i;
    }
}
