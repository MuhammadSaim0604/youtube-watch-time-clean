package com.startapp.sdk.inappbrowser;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class AnimatingProgressBar extends ProgressBar {
    private static final Interpolator a = new AccelerateDecelerateInterpolator();
    private ValueAnimator b;
    private boolean c;

    public AnimatingProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        this.c = Build.VERSION.SDK_INT >= 11;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        if (!this.c) {
            super.setProgress(i);
            return;
        }
        if (this.b != null) {
            this.b.cancel();
            if (getProgress() >= i) {
                return;
            }
        } else {
            this.b = ValueAnimator.ofInt(getProgress(), i);
            this.b.setInterpolator(a);
            this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.startapp.sdk.inappbrowser.AnimatingProgressBar.1
                private Integer a;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.a = (Integer) valueAnimator.getAnimatedValue();
                    AnimatingProgressBar.super.setProgress(this.a.intValue());
                }
            });
        }
        this.b.setIntValues(getProgress(), i);
        this.b.start();
    }

    public final void a() {
        super.setProgress(0);
        if (this.b != null) {
            this.b.cancel();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            this.b.cancel();
        }
    }
}
