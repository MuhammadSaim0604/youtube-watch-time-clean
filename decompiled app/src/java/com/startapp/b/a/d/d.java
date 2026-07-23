package com.startapp.b.a.d;

import java.util.regex.Pattern;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class d implements c {
    private final Pattern a = Pattern.compile("\\+");
    private final Pattern b = Pattern.compile("/");
    private final Pattern c = Pattern.compile("=");
    private final Pattern d = Pattern.compile("_");
    private final Pattern e = Pattern.compile("\\*");
    private final Pattern f = Pattern.compile("#");

    @Override // com.startapp.b.a.d.c
    public final String a(String str) {
        return this.c.matcher(this.b.matcher(this.a.matcher(str).replaceAll("_")).replaceAll("*")).replaceAll("#");
    }
}
