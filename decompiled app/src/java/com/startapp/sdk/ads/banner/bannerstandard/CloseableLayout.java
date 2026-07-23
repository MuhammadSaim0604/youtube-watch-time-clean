package com.startapp.sdk.ads.banner.bannerstandard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.startapp.common.b.c;
import com.startapp.sdk.adsbase.j.t;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class CloseableLayout extends FrameLayout {
    private final int a;
    private a b;
    private final Drawable c;
    private ClosePosition d;
    private final int e;
    private final int f;
    private final int g;
    private boolean h;
    private final Rect i;
    private final Rect j;
    private final Rect k;
    private final Rect l;
    private boolean m;
    private b n;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface a {
        void onClose();
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum ClosePosition {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);
        
        private final int mGravity;

        ClosePosition(int i) {
            this.mGravity = i;
        }

        public static ClosePosition a(String str, ClosePosition closePosition) throws Exception {
            if (TextUtils.isEmpty(str)) {
                return closePosition;
            }
            if (str.equals("top-left")) {
                return TOP_LEFT;
            }
            if (str.equals("top-right")) {
                return TOP_RIGHT;
            }
            if (str.equals("center")) {
                return CENTER;
            }
            if (str.equals("bottom-left")) {
                return BOTTOM_LEFT;
            }
            if (str.equals("bottom-right")) {
                return BOTTOM_RIGHT;
            }
            if (str.equals("top-center")) {
                return TOP_CENTER;
            }
            if (str.equals("bottom-center")) {
                return BOTTOM_CENTER;
            }
            throw new Exception("Invalid close position: ".concat(String.valueOf(str)));
        }

        final int a() {
            return this.mGravity;
        }
    }

    public CloseableLayout(Context context) {
        this(context, null, 0);
    }

    public CloseableLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloseableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new Rect();
        this.j = new Rect();
        this.k = new Rect();
        this.l = new Rect();
        this.c = c.a(context.getResources(), "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA39pVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMDY3IDc5LjE1Nzc0NywgMjAxNS8wMy8zMC0yMzo0MDo0MiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDozODRkZTAxYi00OWRkLWM4NDYtYThkNC0wZWRiMDMwYTZlODAiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QkE0Q0U2MUY2QzA0MTFFNUE3MkJGQjQ1MTkzOEYxQUUiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QkE0Q0U2MUU2QzA0MTFFNUE3MkJGQjQ1MTkzOEYxQUUiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChXaW5kb3dzKSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjlkZjAyMGU0LTNlYmUtZTY0ZC04YjRiLWM5ZWY4MTU4ZjFhYyIgc3RSZWY6ZG9jdW1lbnRJRD0iYWRvYmU6ZG9jaWQ6cGhvdG9zaG9wOmU1MzEzNDdlLTZjMDEtMTFlNS1hZGZlLThmMTBjZWYxMGRiZSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PngNsEEAAANeSURBVHjatFfNS1tBEH+pUZOQ0B4i3sTSxHMRFNQoFBEP7dHgvyDiKWgguQra9F+oxqNiwOTQ+oFI1ZM3jSf1YK5FL41ooaKZzu+x+4gv2bx9Rgd+JNn5zO7s7IzH0CQiCvLHZ8YnxkfGe8ZbwS4zSowTxi/GT4/Hc2u8BLHjCOM745b06VboRJpx7GN8ZfyDxUqlQgcHB5RMJmloaIg6Ozupra3NBL5jDTzIQFYQdDOw5db5B8YxLDw+PtLKygr19PQQWDqIRqOUzWZNXUHH2rvBgr2M39C6uLig/v5+bcd2QLdUKskgYLNX57yvIL2zs0OhUOjZziU6Ojro8PBQBnGl3Alm+BknkMI54mybdS4BW3t7ezKIInzVCwDJYm4Zon4p5xLYzfPzcxlEpl7S3SNpmjlznZwQiXn/5CjEnTUzt5GBsbExamlpUfLBg0wjG8vLy3IXlqTzEAoH7m4kElEqTk1Nmfd7bW2tbhBYAw8ykFXZgQ9RJ1CsQghgEr/29/eVStPT09XFhdbX18nr9Vr81tZWyuVyFh+yMzMzSnvwJWjyDS+MYic2NzeV17O7u9vg2m79jsfjBv9bg7PbxOrqqjExMWHxIdvV1aW0V+VrFDtwhFCGh4cbnl0mk6kp+BsbGybsBNlGtkZGRqToEQK4xjfUc6csXlhYcHyFFhcXHe3Al6BrQz427e3tWldpfn5e6Rw83cIkHyvXAUAZb4SdsKZbPe0BaB+Bz+cjTiDlDmxtbZkybo9AKwn9fj9tb2875gBkINvIFnzJJMQ1PMV9GBgYUF6bQCBgFAoFY3x8/Ml6KpUy0un0kzXIQBY6KqrydapViPL5fM0/Rfcj+fhuJw5CqxBpleJYLEY3NzeW8dnZ2RoZrEmCLHQcSvGdWYrFe7CEFTwUqqjR85XLZUokEkoZ8CADWe3HqKoTcnyOdW5KI5m+vj56eHiQz3G0bkNyeXn5ag3J2dmZ/PffVC1Z8bVast3d3eqWLKDVlAaDwaadh8Nhvaa0XluOHg7n9lzn0MWRarfltp0oysEErRqGDTeDCbK9ajApuh7TxGiWERlrjWZzc3M0ODhYM5phDTzbaHb/rNHMFkhUNK13LobTv6K2RJ3se1yO519s4/k7wf5jG89/6I7n/wUYAGo3YtcprD4sAAAAAElFTkSuQmCC");
        this.d = ClosePosition.TOP_RIGHT;
        this.c.setState(EMPTY_STATE_SET);
        this.c.setCallback(this);
        this.a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.e = t.a(context, 50);
        this.f = t.a(context, 30);
        this.g = t.a(context, 8);
        setWillNotDraw(false);
        this.m = true;
    }

    public void setOnCloseListener(a aVar) {
        this.b = aVar;
    }

    public void setClosePosition(ClosePosition closePosition) {
        this.d = closePosition;
        this.h = true;
        invalidate();
    }

    public void setCloseVisible(boolean z) {
        if (this.c.setVisible(z, false)) {
            invalidate(this.j);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.h) {
            this.h = false;
            this.i.set(0, 0, getWidth(), getHeight());
            a(this.d, this.i, this.j);
            this.l.set(this.j);
            this.l.inset(this.g, this.g);
            a(this.d, this.f, this.l, this.k);
            this.c.setBounds(this.k);
        }
        if (this.c.isVisible()) {
            this.c.draw(canvas);
        }
    }

    public final void a(ClosePosition closePosition, Rect rect, Rect rect2) {
        a(closePosition, this.e, rect, rect2);
    }

    private static void a(ClosePosition closePosition, int i, Rect rect, Rect rect2) {
        Gravity.apply(closePosition.a(), i, i, rect, rect2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return a((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (a((int) motionEvent.getX(), (int) motionEvent.getY(), this.a)) {
            if (this.m || this.c.isVisible()) {
                switch (motionEvent.getAction()) {
                    case 0:
                        a(true);
                        break;
                    case 1:
                        if (b()) {
                            if (this.n == null) {
                                this.n = new b(this, (byte) 0);
                            }
                            postDelayed(this.n, ViewConfiguration.getPressedStateDuration());
                            playSoundEffect(0);
                            if (this.b != null) {
                                this.b.onClose();
                                break;
                            }
                        }
                        break;
                    case 3:
                        a(false);
                        break;
                }
                return true;
            }
        }
        a(false);
        super.onTouchEvent(motionEvent);
        return false;
    }

    public void setCloseAlwaysInteractable(boolean z) {
        this.m = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z != b()) {
            this.c.setState(z ? SELECTED_STATE_SET : EMPTY_STATE_SET);
            invalidate(this.j);
        }
    }

    private boolean b() {
        return this.c.getState() == SELECTED_STATE_SET;
    }

    private boolean a(int i, int i2, int i3) {
        return i >= this.j.left - i3 && i2 >= this.j.top - i3 && i < this.j.right + i3 && i2 < this.j.bottom + i3;
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    final class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(CloseableLayout closeableLayout, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            CloseableLayout.this.a(false);
        }
    }

    public void setCloseBounds(Rect rect) {
        this.j.set(rect);
    }

    public void setCloseBoundChanged(boolean z) {
        this.h = z;
    }

    public final boolean a() {
        return this.c.isVisible();
    }
}
