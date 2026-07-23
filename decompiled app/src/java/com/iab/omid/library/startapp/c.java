package com.iab.omid.library.startapp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class c {
    private static final Pattern a = Pattern.compile("<(head)( [^>]*)?>", 2);
    private static final Pattern b = Pattern.compile("<(head)( [^>]*)?/>", 2);
    private static final Pattern c = Pattern.compile("<(body)( [^>]*?)?>", 2);
    private static final Pattern d = Pattern.compile("<(body)( [^>]*?)?/>", 2);
    private static final Pattern e = Pattern.compile("<(html)( [^>]*?)?>", 2);
    private static final Pattern f = Pattern.compile("<(html)( [^>]*?)?/>", 2);
    private static final Pattern g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    private static boolean a(int i, int[][] iArr) {
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(start, iArr)) {
                sb.append(str.substring(0, matcher.end()));
                sb.append(str2);
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i = end;
        }
        return false;
    }

    private static int[][] a(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int length = str.length();
        while (i < length) {
            int indexOf = str.indexOf("<!--", i);
            i = length;
            if (indexOf >= 0) {
                int indexOf2 = str.indexOf("-->", indexOf);
                if (indexOf2 >= 0) {
                    arrayList.add(new int[]{indexOf, indexOf2});
                    i = indexOf2 + 3;
                } else {
                    arrayList.add(new int[]{indexOf, i});
                }
            }
        }
        return (int[][]) arrayList.toArray((int[][]) Array.newInstance(Integer.TYPE, 0, 2));
    }

    private static boolean b(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(start, iArr)) {
                sb.append(str.substring(0, matcher.end() - 2));
                sb.append(">");
                sb.append(str2);
                sb.append("</");
                sb.append(matcher.group(1));
                sb.append(">");
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i = end;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2) {
        String str3 = "<script type=\"text/javascript\">" + str + "</script>";
        b.b(str2, "HTML is null or empty");
        int[][] a2 = a(str2);
        StringBuilder sb = new StringBuilder(str2.length() + str3.length() + 16);
        if (!b(str2, sb, b, str3, a2) && !a(str2, sb, a, str3, a2) && !b(str2, sb, d, str3, a2) && !a(str2, sb, c, str3, a2) && !b(str2, sb, f, str3, a2) && !a(str2, sb, e, str3, a2) && !a(str2, sb, g, str3, a2)) {
            return str3 + str2;
        }
        return sb.toString();
    }
}
