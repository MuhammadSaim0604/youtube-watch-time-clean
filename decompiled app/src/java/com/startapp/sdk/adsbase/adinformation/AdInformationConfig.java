package com.startapp.sdk.adsbase.adinformation;

import android.content.Context;
import com.startapp.common.parser.d;
import com.startapp.sdk.adsbase.adinformation.AdInformationPositions;
import com.startapp.sdk.adsbase.j;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AdInformationConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean enabled = true;
    private float fatFingersFactor = 200.0f;
    private String dialogUrlSecured = "https://d1byvlfiet2h9q.cloudfront.net/InApp/resources/adInformationDialog3.html";
    private String eulaUrlSecured = "https://www.com.startapp.com/policy/sdk-policy/";
    @d(b = HashMap.class, c = AdInformationPositions.Position.class, d = AdPreferences.Placement.class)
    protected HashMap<AdPreferences.Placement, AdInformationPositions.Position> Positions = new HashMap<>();
    private transient EnumMap<ImageResourceType, ImageResourceConfig> a = new EnumMap<>(ImageResourceType.class);
    @d(b = ArrayList.class, c = ImageResourceConfig.class)
    private List<ImageResourceConfig> ImageResources = new ArrayList();

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum ImageResourceType {
        INFO_S(17, 14),
        INFO_EX_S(88, 14),
        INFO_L(25, 21),
        INFO_EX_L(130, 21);
        
        private int height;
        private int width;

        ImageResourceType(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public final int getDefaultWidth() {
            return this.width;
        }

        public final int getDefaultHeight() {
            return this.height;
        }

        public static ImageResourceType getByName(String str) {
            ImageResourceType imageResourceType = INFO_S;
            ImageResourceType[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    imageResourceType = values[i];
                }
            }
            return imageResourceType;
        }
    }

    private AdInformationConfig() {
    }

    public static AdInformationConfig a() {
        AdInformationConfig adInformationConfig = new AdInformationConfig();
        a(adInformationConfig);
        return adInformationConfig;
    }

    public static void a(AdInformationConfig adInformationConfig) {
        adInformationConfig.i();
        adInformationConfig.h();
    }

    public final String b() {
        return (this.eulaUrlSecured == null || this.eulaUrlSecured.equals("")) ? "https://www.com.startapp.com/policy/sdk-policy/" : this.eulaUrlSecured;
    }

    public final String c() {
        return (!this.a.containsKey(ImageResourceType.INFO_L) || this.a.get(ImageResourceType.INFO_L).d().equals("")) ? "https://info.startappservice.com/InApp/resources/info_l.png" : this.a.get(ImageResourceType.INFO_L).d();
    }

    public final boolean a(Context context) {
        return !j.a(context, "userDisabledAdInformation", Boolean.FALSE).booleanValue() && this.enabled;
    }

    public static void b(Context context) {
        j.b(context, "userDisabledAdInformation", Boolean.FALSE);
    }

    public final float d() {
        return this.fatFingersFactor / 100.0f;
    }

    public final String e() {
        return this.dialogUrlSecured != null ? this.dialogUrlSecured : "https://d1byvlfiet2h9q.cloudfront.net/InApp/resources/adInformationDialog3.html";
    }

    public final AdInformationPositions.Position a(AdPreferences.Placement placement) {
        AdInformationPositions.Position position = this.Positions.get(placement);
        AdInformationPositions.Position position2 = position;
        if (position == null) {
            position2 = AdInformationPositions.Position.BOTTOM_LEFT;
            this.Positions.put(placement, position2);
        }
        return position2;
    }

    public final ImageResourceConfig a(ImageResourceType imageResourceType) {
        return this.a.get(imageResourceType);
    }

    public final void f() {
        for (ImageResourceConfig imageResourceConfig : this.ImageResources) {
            this.a.put((EnumMap<ImageResourceType, ImageResourceConfig>) ImageResourceType.getByName(imageResourceConfig.a()), (ImageResourceType) imageResourceConfig);
            imageResourceConfig.e();
        }
    }

    private void h() {
        ImageResourceType[] values;
        for (ImageResourceType imageResourceType : ImageResourceType.values()) {
            if (this.a.get(imageResourceType) == null) {
                throw new IllegalArgumentException("AdInformation error in ImageResource [" + imageResourceType + "] cannot be found in MetaData");
            }
        }
    }

    private void i() {
        ImageResourceType[] values;
        for (ImageResourceType imageResourceType : ImageResourceType.values()) {
            ImageResourceConfig imageResourceConfig = this.a.get(imageResourceType);
            Boolean bool = Boolean.TRUE;
            if (imageResourceConfig == null) {
                imageResourceConfig = ImageResourceConfig.b(imageResourceType.name());
                Iterator<ImageResourceConfig> it = this.ImageResources.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (ImageResourceType.getByName(it.next().a()).equals(imageResourceType)) {
                            bool = Boolean.FALSE;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.a.put((EnumMap<ImageResourceType, ImageResourceConfig>) imageResourceType, (ImageResourceType) imageResourceConfig);
                if (bool.booleanValue()) {
                    this.ImageResources.add(imageResourceConfig);
                }
            }
            imageResourceConfig.a(imageResourceType.getDefaultWidth());
            imageResourceConfig.b(imageResourceType.getDefaultHeight());
            imageResourceConfig.a(imageResourceType.name().toLowerCase() + ".png");
        }
    }

    public final void g() {
        this.a = new EnumMap<>(ImageResourceType.class);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdInformationConfig adInformationConfig = (AdInformationConfig) obj;
        return this.enabled == adInformationConfig.enabled && Float.compare(adInformationConfig.fatFingersFactor, this.fatFingersFactor) == 0 && u.b(this.dialogUrlSecured, adInformationConfig.dialogUrlSecured) && u.b(this.eulaUrlSecured, adInformationConfig.eulaUrlSecured) && u.b(this.Positions, adInformationConfig.Positions) && u.b(this.ImageResources, adInformationConfig.ImageResources);
    }

    public int hashCode() {
        return u.a(Boolean.valueOf(this.enabled), Float.valueOf(this.fatFingersFactor), this.dialogUrlSecured, this.eulaUrlSecured, this.Positions, this.ImageResources);
    }
}
