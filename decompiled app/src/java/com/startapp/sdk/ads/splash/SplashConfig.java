package com.startapp.sdk.ads.splash;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class SplashConfig implements Serializable {
    private static long a = 0;
    private static final Theme b;
    private static final MinSplashTime c;
    private static final long d;
    private static final MaxAdDisplayTime e;
    private static final Orientation f;
    private static final long serialVersionUID = 1;
    private boolean forceNative = false;
    private int customScreen = -1;
    private String appName = "";
    private transient Drawable g = null;
    private byte[] logoByteArray = null;
    private int logoRes = -1;
    @com.startapp.common.parser.d(b = Theme.class)
    private Theme defaultTheme = b;
    @com.startapp.common.parser.d(b = MinSplashTime.class)
    private MinSplashTime defaultMinSplashTime = c;
    private Long defaultMaxLoadTime = Long.valueOf(d);
    @com.startapp.common.parser.d(b = MaxAdDisplayTime.class)
    private MaxAdDisplayTime defaultMaxAdDisplayTime = e;
    @com.startapp.common.parser.d(b = Orientation.class)
    private Orientation defaultOrientation = f;
    private boolean htmlSplash = true;
    private String splashBgColor = "#066CAA";
    private String splashFontColor = "ffffff";
    private String splashLoadingType = "LoadingDots";
    private transient String h = "";

    static {
        SplashConfig.class.getSimpleName();
        a = 7500L;
        b = Theme.OCEAN;
        c = MinSplashTime.REGULAR;
        d = a;
        e = MaxAdDisplayTime.FOR_EVER;
        f = Orientation.AUTO;
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum MaxAdDisplayTime {
        SHORT(5000),
        LONG(10000),
        FOR_EVER(86400000);
        
        private long index;

        MaxAdDisplayTime(long j) {
            this.index = j;
        }

        public final long getIndex() {
            return this.index;
        }

        public static MaxAdDisplayTime getByIndex(long j) {
            MaxAdDisplayTime maxAdDisplayTime = SHORT;
            MaxAdDisplayTime[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].getIndex() == j) {
                    maxAdDisplayTime = values[i];
                }
            }
            return maxAdDisplayTime;
        }

        public static MaxAdDisplayTime getByName(String str) {
            MaxAdDisplayTime maxAdDisplayTime = FOR_EVER;
            MaxAdDisplayTime[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    maxAdDisplayTime = values[i];
                }
            }
            return maxAdDisplayTime;
        }
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum MinSplashTime {
        REGULAR(3000),
        SHORT(2000),
        LONG(5000);
        
        private long index;

        MinSplashTime(int i) {
            this.index = i;
        }

        public final long getIndex() {
            return this.index;
        }

        public static MinSplashTime getByIndex(long j) {
            MinSplashTime minSplashTime = SHORT;
            MinSplashTime[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].getIndex() == j) {
                    minSplashTime = values[i];
                }
            }
            return minSplashTime;
        }

        public static MinSplashTime getByName(String str) {
            MinSplashTime minSplashTime = LONG;
            MinSplashTime[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    minSplashTime = values[i];
                }
            }
            return minSplashTime;
        }
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum Orientation {
        PORTRAIT(1),
        LANDSCAPE(2),
        AUTO(3);
        
        private int index;

        Orientation(int i) {
            this.index = i;
        }

        public final int getIndex() {
            return this.index;
        }

        public static Orientation getByIndex(int i) {
            Orientation orientation = PORTRAIT;
            Orientation[] values = values();
            for (int i2 = 0; i2 < values.length; i2++) {
                if (values[i2].getIndex() == i) {
                    orientation = values[i2];
                }
            }
            return orientation;
        }

        public static Orientation getByName(String str) {
            Orientation orientation = AUTO;
            Orientation[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    orientation = values[i];
                }
            }
            return orientation;
        }
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum Theme {
        DEEP_BLUE(1),
        SKY(2),
        ASHEN_SKY(3),
        BLAZE(4),
        GLOOMY(5),
        OCEAN(6),
        USER_DEFINED(0);
        
        private int index;

        Theme(int i) {
            this.index = i;
        }

        public final int getIndex() {
            return this.index;
        }

        public static Theme getByIndex(int i) {
            Theme theme = DEEP_BLUE;
            Theme[] values = values();
            for (int i2 = 0; i2 < values.length; i2++) {
                if (values[i2].getIndex() == i) {
                    theme = values[i2];
                }
            }
            return theme;
        }

        public static Theme getByName(String str) {
            Theme theme = DEEP_BLUE;
            Theme[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    theme = values[i];
                }
            }
            return theme;
        }
    }

    public static SplashConfig getDefaultSplashConfig() {
        SplashConfig splashConfig = new SplashConfig();
        splashConfig.setTheme(b).setMinSplashTime(c).a(d).setMaxAdDisplayTime(e).setOrientation(f).setLoadingType("LoadingDots").setAppName("");
        return splashConfig;
    }

    public SplashConfig setTheme(Theme theme) {
        this.defaultTheme = theme;
        return this;
    }

    public SplashConfig setCustomScreen(int i) {
        this.customScreen = i;
        return this;
    }

    public SplashConfig setAppName(String str) {
        this.appName = str;
        return this;
    }

    public SplashConfig setLogo(int i) {
        this.logoRes = i;
        return this;
    }

    public SplashConfig setLogo(byte[] bArr) {
        this.logoByteArray = bArr;
        return this;
    }

    private SplashConfig a(long j) {
        this.defaultMaxLoadTime = Long.valueOf(j);
        return this;
    }

    public SplashConfig setOrientation(Orientation orientation) {
        this.defaultOrientation = orientation;
        return this;
    }

    public SplashConfig setMinSplashTime(MinSplashTime minSplashTime) {
        this.defaultMinSplashTime = minSplashTime;
        return this;
    }

    public SplashConfig setMaxAdDisplayTime(MaxAdDisplayTime maxAdDisplayTime) {
        this.defaultMaxAdDisplayTime = maxAdDisplayTime;
        return this;
    }

    public int getCustomScreen() {
        return this.customScreen;
    }

    public String getAppName() {
        return this.appName;
    }

    public Drawable getLogo() {
        return this.g;
    }

    public int getLogoRes() {
        return this.logoRes;
    }

    public byte[] getLogoByteArray() {
        return this.logoByteArray;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Long a() {
        return this.defaultMaxLoadTime;
    }

    public String getErrorMessage() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Theme b() {
        return this.defaultTheme;
    }

    public Orientation getOrientation() {
        return this.defaultOrientation;
    }

    public MinSplashTime getMinSplashTime() {
        return this.defaultMinSplashTime;
    }

    public MaxAdDisplayTime getMaxAdDisplayTime() {
        return this.defaultMaxAdDisplayTime;
    }

    public boolean isHtmlSplash() {
        if (!this.forceNative) {
            return this.htmlSplash;
        }
        return false;
    }

    public String getBgColor() {
        return this.splashBgColor;
    }

    public String getFontColor() {
        return this.splashFontColor;
    }

    public String getLoadingType() {
        return this.splashLoadingType;
    }

    public SplashConfig setLoadingType(String str) {
        this.splashLoadingType = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(Context context) {
        boolean z = true;
        switch (this.defaultTheme) {
            case USER_DEFINED:
                if (getCustomScreen() == -1) {
                    z = false;
                    this.h = "StartApp: Exception getting custom screen resource id, make sure it is set";
                    break;
                }
                break;
            default:
                if (getAppName().equals("")) {
                    setAppName(com.startapp.sdk.adsbase.a.a(context, "Welcome!"));
                }
                if (getLogo() == null && getLogoByteArray() == null) {
                    if (getLogoRes() == -1) {
                        setLogo(context.getApplicationInfo().icon);
                        this.g = context.getResources().getDrawable(context.getApplicationInfo().icon);
                        break;
                    } else {
                        this.g = context.getResources().getDrawable(getLogoRes());
                        break;
                    }
                }
                break;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View b(Context context) {
        View view = null;
        switch (this.defaultTheme) {
            case USER_DEFINED:
                try {
                    view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getCustomScreen(), (ViewGroup) null);
                    break;
                } catch (Resources.NotFoundException e2) {
                    throw new Resources.NotFoundException("StartApp: Can't find Custom layout resource");
                } catch (InflateException e3) {
                    throw new InflateException("StartApp: Can't inflate layout in Custom mode, Are you sure layout resource is valid?");
                } catch (Throwable th) {
                    new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                    break;
                }
            default:
                view = e.a(context, this);
                break;
        }
        return view;
    }

    public void setDefaults(Context context) {
        SplashConfig a2 = SplashMetaData.b().a();
        SplashConfig splashConfig = a2;
        if (a2 == null) {
            splashConfig = getDefaultSplashConfig();
        } else {
            this.htmlSplash = splashConfig.isHtmlSplash();
        }
        SplashConfig splashConfig2 = splashConfig;
        SplashConfig defaultSplashConfig = getDefaultSplashConfig();
        if (splashConfig2.defaultTheme == null) {
            splashConfig2.setTheme(defaultSplashConfig.defaultTheme);
        }
        if (splashConfig2.getMinSplashTime() == null) {
            splashConfig2.setMinSplashTime(defaultSplashConfig.getMinSplashTime());
        }
        if (splashConfig2.defaultMaxLoadTime == null) {
            splashConfig2.a(defaultSplashConfig.defaultMaxLoadTime.longValue());
        }
        if (splashConfig2.getMaxAdDisplayTime() == null) {
            splashConfig2.setMaxAdDisplayTime(defaultSplashConfig.getMaxAdDisplayTime());
        }
        if (splashConfig2.getOrientation() == null) {
            splashConfig2.setOrientation(defaultSplashConfig.getOrientation());
        }
        if (splashConfig2.getLoadingType() == null) {
            splashConfig2.setLoadingType(defaultSplashConfig.getLoadingType());
        }
        if (splashConfig2.getAppName().equals("")) {
            splashConfig2.setAppName(com.startapp.sdk.adsbase.a.a(context, "Welcome!"));
        }
        if (getMaxAdDisplayTime() == null) {
            setMaxAdDisplayTime(splashConfig.getMaxAdDisplayTime());
        }
        if (this.defaultMaxLoadTime == null) {
            a(splashConfig.defaultMaxLoadTime.longValue());
        }
        if (getMinSplashTime() == null) {
            setMinSplashTime(splashConfig.getMinSplashTime());
        }
        if (getOrientation() == null) {
            setOrientation(splashConfig.getOrientation());
        }
        if (this.defaultTheme == null) {
            setTheme(splashConfig.defaultTheme);
        }
        if (getLogoRes() == -1) {
            setLogo(context.getApplicationInfo().icon);
        }
        if (getAppName().equals("")) {
            setAppName(splashConfig.getAppName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Activity activity) {
        if (getLogo() == null && getLogoRes() == -1 && getLogoByteArray() != null) {
            byte[] logoByteArray = getLogoByteArray();
            this.g = new BitmapDrawable(activity.getResources(), BitmapFactory.decodeByteArray(logoByteArray, 0, logoByteArray.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SplashHtml b(Activity activity) {
        String str = "#066CAA";
        String str2 = "ffffff";
        switch (this.defaultTheme) {
            case DEEP_BLUE:
                str2 = "#FFFFFF";
                str = "#066CAA";
                break;
            case SKY:
                str2 = "#333333";
                str = "#a3d4e5";
                break;
            case ASHEN_SKY:
                str2 = "#333333";
                str = "#E3E3E3";
                break;
            case BLAZE:
                str2 = "#FFFFFF";
                str = "#FF6600";
                break;
            case GLOOMY:
                str2 = "#33B5E5";
                str = "#2F353F";
                break;
            case OCEAN:
                str2 = "#063D51";
                str = "#237C9A";
                break;
        }
        this.splashBgColor = str;
        this.splashFontColor = str2;
        SplashHtml splashHtml = new SplashHtml(activity);
        splashHtml.a(this);
        splashHtml.a();
        return splashHtml;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        return this.defaultTheme == Theme.USER_DEFINED || getCustomScreen() != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SplashConfig splashConfig = (SplashConfig) obj;
        return this.forceNative == splashConfig.forceNative && this.customScreen == splashConfig.customScreen && this.logoRes == splashConfig.logoRes && this.htmlSplash == splashConfig.htmlSplash && u.b(this.appName, splashConfig.appName) && Arrays.equals(this.logoByteArray, splashConfig.logoByteArray) && this.defaultTheme == splashConfig.defaultTheme && this.defaultMinSplashTime == splashConfig.defaultMinSplashTime && u.b(this.defaultMaxLoadTime, splashConfig.defaultMaxLoadTime) && this.defaultMaxAdDisplayTime == splashConfig.defaultMaxAdDisplayTime && this.defaultOrientation == splashConfig.defaultOrientation && u.b(this.splashBgColor, splashConfig.splashBgColor) && u.b(this.splashFontColor, splashConfig.splashFontColor) && u.b(this.splashLoadingType, splashConfig.splashLoadingType);
    }

    public int hashCode() {
        return (u.a(Boolean.valueOf(this.forceNative), Integer.valueOf(this.customScreen), this.appName, Integer.valueOf(this.logoRes), this.defaultTheme, this.defaultMinSplashTime, this.defaultMaxLoadTime, this.defaultMaxAdDisplayTime, this.defaultOrientation, Boolean.valueOf(this.htmlSplash), this.splashBgColor, this.splashFontColor, this.splashLoadingType) * 31) + Arrays.hashCode(this.logoByteArray);
    }
}
