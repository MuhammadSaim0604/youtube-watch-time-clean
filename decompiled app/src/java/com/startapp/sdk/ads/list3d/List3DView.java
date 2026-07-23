package com.startapp.sdk.ads.list3d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import java.util.LinkedList;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class List3DView extends AdapterView<Adapter> {
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    protected int a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    protected a j;
    protected float k;
    protected boolean l;
    protected boolean m;
    protected String n;
    protected String o;
    public BroadcastReceiver p;
    private String q;
    private Adapter r;
    private VelocityTracker s;
    private Runnable t;
    private final LinkedList<View> u;
    private Runnable v;
    private Rect w;
    private Camera x;
    private Matrix y;
    private Paint z;

    public List3DView(Context context, String str, String str2) {
        super(context, null);
        this.q = "List3DView";
        this.a = 0;
        this.u = new LinkedList<>();
        this.A = Integer.MIN_VALUE;
        this.k = 0.0f;
        this.l = false;
        this.m = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.p = new BroadcastReceiver() { // from class: com.startapp.sdk.ads.list3d.List3DView.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                double height = List3DView.this.getHeight() / intent.getIntExtra("getHeight", List3DView.this.getHeight());
                new StringBuilder().append(List3DView.this.q).append("Updating Position with Ratio: [").append(height).append("]");
                List3DView.this.a = intent.getIntExtra("mTouchState", List3DView.this.a);
                List3DView.this.b = intent.getIntExtra("mTouchStartX", List3DView.this.b);
                List3DView.this.c = intent.getIntExtra("mTouchStartY", List3DView.this.c);
                List3DView.this.g = intent.getIntExtra("mListRotation", List3DView.this.g);
                List3DView.this.h = (int) (intent.getIntExtra("mFirstItemPosition", List3DView.this.h) * height);
                List3DView list3DView = List3DView.this;
                list3DView.h--;
                List3DView.this.i = (int) (intent.getIntExtra("mLastItemPosition", List3DView.this.i) * height);
                List3DView list3DView2 = List3DView.this;
                list3DView2.i--;
                List3DView.this.e = (int) (intent.getIntExtra("mListTop", List3DView.this.e) * height);
                List3DView.this.d = (int) (intent.getIntExtra("mListTopStart", List3DView.this.d) * height);
                List3DView.this.f = (int) (intent.getIntExtra("mListTopOffset", List3DView.this.f) * height);
                List3DView.this.j = (a) intent.getParcelableExtra("mDynamics");
                List3DView.this.k = intent.getFloatExtra("mLastVelocity", List3DView.this.k);
                List3DView.this.j.a(height);
                List3DView.this.setAdapter(new c(List3DView.this.getContext(), intent.getParcelableArrayListExtra("list"), List3DView.this.n, List3DView.this.o));
                List3DView.this.l = true;
                List3DView.this.m = true;
                List3DView.this.a(List3DView.this.k, true);
                com.startapp.common.b.a(context2).a(this);
            }
        };
        this.n = str;
        this.o = str2;
    }

    public void setTag(String str) {
        this.q = str;
    }

    public void setStarted() {
        this.l = true;
    }

    public void setHint(boolean z) {
        this.C = z;
    }

    public void setFade(boolean z) {
        this.B = z;
    }

    @Override // android.widget.AdapterView
    public Adapter getAdapter() {
        return this.r;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    public void setDynamics(a aVar) {
        if (this.j != null) {
            aVar.a(this.j.a(), this.j.b(), AnimationUtils.currentAnimationTimeMillis());
        }
        this.j = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (com.startapp.common.b.b.a()) {
                    com.startapp.common.b.b.a(this);
                }
                removeCallbacks(this.t);
                this.b = (int) motionEvent.getX();
                this.c = (int) motionEvent.getY();
                this.d = a(getChildAt(0)) - this.f;
                if (this.v == null) {
                    this.v = new Runnable() { // from class: com.startapp.sdk.ads.list3d.List3DView.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            int a;
                            if (List3DView.this.a == 1 && (a = List3DView.this.a(List3DView.this.b, List3DView.this.c)) != -1) {
                                List3DView.this.b(a);
                            }
                        }
                    };
                }
                postDelayed(this.v, ViewConfiguration.getLongPressTimeout());
                this.s = VelocityTracker.obtain();
                this.s.addMovement(motionEvent);
                this.a = 1;
                break;
            case 1:
                float f = 0.0f;
                if (this.a == 1) {
                    int a = a((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (a != -1) {
                        View childAt = getChildAt(a);
                        int i = this.h + a;
                        performItemClick(childAt, i, this.r.getItemId(i));
                    }
                } else if (this.a == 2) {
                    this.s.addMovement(motionEvent);
                    this.s.computeCurrentVelocity(1000);
                    f = this.s.getYVelocity();
                    this.k = f;
                }
                a(f, false);
                break;
            case 2:
                if (this.a == 1) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x < this.b - 10 || x > this.b + 10 || y < this.c - 10 || y > this.c + 10) {
                        removeCallbacks(this.v);
                        this.a = 2;
                    }
                }
                if (this.a == 2) {
                    this.s.addMovement(motionEvent);
                    a(((int) motionEvent.getY()) - this.c);
                    break;
                }
                break;
            default:
                a(0.0f, false);
                break;
        }
        return true;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.l && this.r != null) {
            if (getChildCount() != 0) {
                int a = (this.e + this.f) - a(getChildAt(0));
                int childCount = getChildCount();
                if (this.i != this.r.getCount() - 1 && childCount > 1) {
                    View childAt = getChildAt(0);
                    while (true) {
                        View view = childAt;
                        if (view == null || c(view) + a >= 0) {
                            break;
                        }
                        removeViewInLayout(view);
                        childCount--;
                        this.u.addLast(view);
                        this.h++;
                        this.f += d(view);
                        if (childCount > 1) {
                            childAt = getChildAt(0);
                        } else {
                            childAt = null;
                        }
                    }
                }
                if (this.h != 0 && childCount > 1) {
                    View childAt2 = getChildAt(childCount - 1);
                    while (true) {
                        View view2 = childAt2;
                        if (view2 == null || a(view2) + a <= getHeight()) {
                            break;
                        }
                        removeViewInLayout(view2);
                        childCount--;
                        this.u.addLast(view2);
                        this.i--;
                        if (childCount > 1) {
                            childAt2 = getChildAt(childCount - 1);
                        } else {
                            childAt2 = null;
                        }
                    }
                }
                b(c(getChildAt(getChildCount() - 1)), a);
                int a2 = a(getChildAt(0));
                while (a2 + a > 0 && this.h > 0) {
                    this.h--;
                    View view3 = this.r.getView(this.h, c(), this);
                    a(view3, 1);
                    int d = d(view3);
                    a2 -= d;
                    this.f -= d;
                }
            } else {
                if (this.C) {
                    this.e = getHeight() / 3;
                }
                if (!this.m) {
                    this.i = -1;
                } else {
                    this.i = this.h;
                    this.h++;
                }
                b(this.e, 0);
            }
            int i5 = this.e + this.f;
            float width = getWidth() * 0.0f;
            float height = 1.0f / (getHeight() * 0.9f);
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt3 = getChildAt(i6);
                int sin = (int) (width * Math.sin(6.283185307179586d * height * i5));
                int measuredWidth = childAt3.getMeasuredWidth();
                int measuredHeight = childAt3.getMeasuredHeight();
                int width2 = sin + ((getWidth() - measuredWidth) / 2);
                int b = b(childAt3);
                int i7 = i5 + b;
                childAt3.layout(width2, i7, width2 + measuredWidth, i7 + measuredHeight);
                i5 += measuredHeight + (2 * b);
            }
            if (this.C && !this.D) {
                this.D = true;
                dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 0, 0.0f, 0.0f, 0));
                postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.list3d.List3DView.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        List3DView.this.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 2, 0.0f, -20.0f, 0));
                        List3DView.this.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 1, 0.0f, -20.0f, 0));
                    }
                }, 5L);
            }
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return super.drawChild(canvas, view, j);
        }
        int top = view.getTop();
        int left = view.getLeft();
        int width = view.getWidth() / 2;
        int height = view.getHeight() / 2;
        float height2 = getHeight() / 2;
        float f = ((top + height) - height2) / height2;
        float cos = (float) (1.0d - (0.15000000596046448d * (1.0d - Math.cos(f))));
        float f2 = (this.g - (20.0f * f)) % 90.0f;
        float f3 = f2;
        if (f2 < 0.0f) {
            f3 += 90.0f;
        }
        if (f3 < 45.0f) {
            a(canvas, drawingCache, top, left, width, height, cos, f3 - 90.0f);
            a(canvas, drawingCache, top, left, width, height, cos, f3);
        } else {
            a(canvas, drawingCache, top, left, width, height, cos, f3);
            a(canvas, drawingCache, top, left, width, height, cos, f3 - 90.0f);
        }
        return false;
    }

    private void a(Canvas canvas, Bitmap bitmap, int i, int i2, int i3, int i4, float f, float f2) {
        if (this.x == null) {
            this.x = new Camera();
        }
        this.x.save();
        this.x.translate(0.0f, 0.0f, i4);
        this.x.rotateX(f2);
        this.x.translate(0.0f, 0.0f, -i4);
        if (this.y == null) {
            this.y = new Matrix();
        }
        this.x.getMatrix(this.y);
        this.x.restore();
        this.y.preTranslate(-i3, -i4);
        this.y.postScale(f, f);
        this.y.postTranslate(i2 + i3, i + i4);
        if (this.z == null) {
            this.z = new Paint();
            this.z.setAntiAlias(true);
            this.z.setFilterBitmap(true);
        }
        this.z.setColorFilter(a(f2));
        canvas.drawBitmap(bitmap, this.y, this.z);
    }

    private static LightingColorFilter a(float f) {
        double cos = Math.cos((3.141592653589793d * f) / 180.0d);
        int i = 55 + ((int) (cos * 200.0d));
        int pow = (int) (70.0d * Math.pow(cos, 200.0d));
        if (i > 255) {
            i = 255;
        }
        if (pow > 255) {
            pow = 255;
        }
        int i2 = i;
        int rgb = Color.rgb(i2, i2, i);
        int i3 = pow;
        return new LightingColorFilter(rgb, Color.rgb(i3, i3, pow));
    }

    protected final void a(float f, boolean z) {
        if (this.s != null || z) {
            if (this.s != null) {
                this.s.recycle();
            }
            this.s = null;
            removeCallbacks(this.v);
            if (this.t == null) {
                this.t = new Runnable() { // from class: com.startapp.sdk.ads.list3d.List3DView.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (List3DView.this.j != null) {
                            View childAt = List3DView.this.getChildAt(0);
                            if (childAt != null) {
                                List3DView.this.d = List3DView.a(childAt) - List3DView.this.f;
                                List3DView.this.j.a(AnimationUtils.currentAnimationTimeMillis());
                                List3DView.this.a(((int) List3DView.this.j.a()) - List3DView.this.d);
                            }
                            if (!List3DView.this.j.c()) {
                                List3DView.this.postDelayed(this, 16L);
                            }
                        }
                    }
                };
            }
            if (this.j != null) {
                if (!z) {
                    this.j.a(this.e, f, AnimationUtils.currentAnimationTimeMillis());
                }
                post(this.t);
            }
            this.a = 0;
        }
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.t);
    }

    protected final void a(int i) {
        this.e = this.d + i;
        this.g = (-(270 * this.e)) / getHeight();
        b();
        requestLayout();
    }

    private void b() {
        int i = this.g % 90;
        int height = i < 45 ? ((-(this.g - i)) * getHeight()) / 270 : ((-((this.g + 90) - i)) * getHeight()) / 270;
        if (this.A == Integer.MIN_VALUE && this.i == this.r.getCount() - 1 && c(getChildAt(getChildCount() - 1)) < getHeight()) {
            this.A = height;
        }
        if (height <= 0) {
            if (height < this.A) {
                height = this.A;
            }
        } else {
            height = 0;
        }
        this.j.a(height);
        this.j.b(height);
    }

    protected final int a(int i, int i2) {
        if (this.w == null) {
            this.w = new Rect();
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).getHitRect(this.w);
            if (this.w.contains(i, i2)) {
                return i3;
            }
        }
        return -1;
    }

    protected final void b(int i) {
        View childAt = getChildAt(i);
        int i2 = this.h + i;
        long itemId = this.r.getItemId(i2);
        AdapterView.OnItemLongClickListener onItemLongClickListener = getOnItemLongClickListener();
        if (onItemLongClickListener != null) {
            onItemLongClickListener.onItemLongClick(this, childAt, i2, itemId);
        }
    }

    private void b(int i, int i2) {
        int i3 = i;
        while (i3 + i2 < getHeight() && this.i < this.r.getCount() - 1) {
            this.i++;
            View view = this.r.getView(this.i, c(), this);
            a(view, 0);
            i3 += d(view);
        }
    }

    private void a(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
        }
        int i2 = i == 1 ? 0 : -1;
        view.setDrawingCacheEnabled(true);
        addViewInLayout(view, i2, layoutParams2, true);
        view.measure(1073741824 | ((int) (getWidth() * 0.85f)), 0);
    }

    private View c() {
        if (this.u.size() != 0) {
            return this.u.removeFirst();
        }
        return null;
    }

    private static int b(View view) {
        return (int) ((view.getMeasuredHeight() * 0.35000002f) / 2.0f);
    }

    protected static int a(View view) {
        return view.getTop() - b(view);
    }

    private static int c(View view) {
        return view.getBottom() + b(view);
    }

    private static int d(View view) {
        return view.getMeasuredHeight() + (2 * b(view));
    }

    public final int a() {
        return this.h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(Adapter adapter) {
        if (com.startapp.common.b.b.a() && this.B) {
            com.startapp.common.b.b.a(this, 0.0f);
        }
        this.r = adapter;
        removeAllViewsInLayout();
        requestLayout();
    }
}
