package com.startapp.sdk.adsbase.j;

import com.startapp.common.SDKException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class k extends m {
    private List<l> a;

    public k() {
        this.a = null;
        this.a = new ArrayList();
    }

    @Override // com.startapp.sdk.adsbase.j.m
    public final void a(String str, Object obj, boolean z, boolean z2) throws SDKException {
        if (z && obj == null) {
            throw new SDKException("Required key: [" + str + "] is missing", null);
        }
        if (obj != null && !obj.toString().equals("")) {
            try {
                l lVar = new l();
                lVar.a(str);
                String obj2 = obj.toString();
                if (z2) {
                    obj2 = URLEncoder.encode(obj2, "UTF-8");
                }
                lVar.b(obj2);
                this.a.add(lVar);
            } catch (UnsupportedEncodingException e) {
                if (z) {
                    throw new SDKException("failed encoding value: [" + obj + "]", e);
                }
            }
        }
    }

    @Override // com.startapp.sdk.adsbase.j.m
    public final void a(String str, Set<String> set) throws SDKException {
        if (set != null) {
            l lVar = new l();
            lVar.a(str);
            HashSet hashSet = new HashSet();
            for (String str2 : set) {
                try {
                    hashSet.add(URLEncoder.encode(str2, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                }
            }
            lVar.a(hashSet);
            this.a.add(lVar);
        }
    }

    public final String toString() {
        Set<String> c;
        StringBuilder sb = new StringBuilder();
        if (this.a == null) {
            return sb.toString();
        }
        sb.append('?');
        for (l lVar : this.a) {
            if (lVar.b() != null) {
                sb.append(lVar.a()).append('=').append(lVar.b()).append('&');
            } else if (lVar.c() != null && (c = lVar.c()) != null) {
                for (String str : c) {
                    sb.append(lVar.a()).append('=').append(str).append('&');
                }
            }
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString().replace("+", "%20");
    }
}
