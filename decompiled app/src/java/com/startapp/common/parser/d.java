package com.startapp.common.parser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: StartAppSDK */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public @interface d {
    boolean a() default false;

    Class b() default Object.class;

    Class c() default String.class;

    Class d() default String.class;

    Class e() default String.class;

    String f() default "";
}
