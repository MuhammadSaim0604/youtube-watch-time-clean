package com.startapp.sdk.adsbase.adinformation;

import android.widget.RelativeLayout;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class AdInformationPositions {
    protected static final String a = Position.BOTTOM_LEFT.name();

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum Position {
        TOP_LEFT(1, new int[]{10, 9}, -1),
        TOP_RIGHT(2, new int[]{10, 11}, 1),
        BOTTOM_LEFT(3, new int[]{12, 9}, -1),
        BOTTOM_RIGHT(4, new int[]{12, 11}, 1);
        
        private int animationMultiplier;
        private int index;
        private int[] rules;

        Position(int i, int[] iArr, int i2) {
            this.rules = iArr;
            this.animationMultiplier = i2;
            this.index = i;
        }

        public final void addRules(RelativeLayout.LayoutParams layoutParams) {
            for (int i = 0; i < this.rules.length; i++) {
                layoutParams.addRule(this.rules[i]);
            }
        }

        public final int getIndex() {
            return this.index;
        }

        public final int getAnimationStartMultiplier() {
            return this.animationMultiplier;
        }

        public static Position getByName(String str) {
            Position position = BOTTOM_LEFT;
            Position[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    position = values[i];
                }
            }
            return position;
        }

        public static Position getByIndex(long j) {
            Position position = BOTTOM_LEFT;
            Position[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].getIndex() == j) {
                    position = values[i];
                }
            }
            return position;
        }
    }
}
