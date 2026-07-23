package com.startapp.networkTest.net;

import android.util.Log;
import com.startapp.sdk.adsbase.j.t;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public abstract class WebApiClient {
    private static final String a = WebApiClient.class.getSimpleName();

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public enum RequestMethod {
        POST,
        GET,
        PUT,
        DELETE
    }

    private static com.startapp.sdk.adsbase.k.a a(RequestMethod requestMethod, String str, t[] tVarArr) throws IOException {
        com.startapp.sdk.adsbase.k.a aVar = new com.startapp.sdk.adsbase.k.a();
        URL url = new URL(str);
        new URL(str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(requestMethod.toString());
        for (int i = 0; i < 2; i++) {
            t tVar = tVarArr[i];
            httpURLConnection.setRequestProperty(tVar.a, tVar.b);
        }
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        aVar.a = httpURLConnection.getResponseCode();
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
        } catch (Exception e) {
            Log.e(a, "read content: " + e.getMessage());
        }
        httpURLConnection.disconnect();
        aVar.b = sb.toString();
        return aVar;
    }

    public static com.startapp.sdk.adsbase.k.a a(RequestMethod requestMethod, String str) throws IOException {
        return a(requestMethod, str, new t[]{new t("Content-Type", "application/json; charset=UTF-8"), new t("Accept", "application/json")});
    }
}
