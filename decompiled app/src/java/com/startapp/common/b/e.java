package com.startapp.common.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.iab.omid.library.startapp.adsession.Owner;
import com.startapp.common.SDKException;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class e {
    private final Owner a;
    private final Owner b;
    private final boolean c;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public static class a {
        private String a;
        private String b;

        public final String a() {
            return this.a;
        }

        public final void a(String str) {
            this.a = str;
        }

        public final String b() {
            return this.b;
        }

        public final void b(String str) {
            this.b = str;
        }

        public final String toString() {
            return "HttpResult: " + this.b + " " + this.a;
        }
    }

    public static String a(String str, byte[] bArr, Map<String, String> map, String str2, boolean z, String str3) throws SDKException {
        String str4 = null;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection b = b(str, bArr, map, str2, z, str3);
                if (bArr != null && bArr.length > 0) {
                    OutputStream outputStream = null;
                    try {
                        OutputStream outputStream2 = b.getOutputStream();
                        outputStream = outputStream2;
                        outputStream2.write(bArr);
                        outputStream.flush();
                        b.a(outputStream);
                    } catch (Throwable th) {
                        b.a(outputStream);
                        throw th;
                    }
                }
                int responseCode = b.getResponseCode();
                if (responseCode != 200) {
                    throw new SDKException("POST", Uri.parse(str).buildUpon().query(null).build(), responseCode, false);
                }
                InputStream inputStream = b.getInputStream();
                if (inputStream != null) {
                    StringWriter stringWriter = new StringWriter();
                    char[] cArr = new char[1024];
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                    while (true) {
                        int read = bufferedReader.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        stringWriter.write(cArr, 0, read);
                    }
                    str4 = stringWriter.toString();
                }
                String str5 = str4;
                b.a(inputStream);
                if (b != null) {
                    b.disconnect();
                }
                return str5;
            } catch (IOException e) {
                throw new SDKException("POST", Uri.parse(str).buildUpon().query(null).build(), 0, false, e);
            }
        } catch (Throwable th2) {
            b.a((Closeable) null);
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th2;
        }
    }

    public static a a(String str, Map<String, String> map, String str2, boolean z) throws SDKException {
        CookieManager a2;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection b = b(str, null, map, str2, z, null);
                int responseCode = b.getResponseCode();
                if (responseCode != 200) {
                    throw new SDKException("GET", Uri.parse(str).buildUpon().query(null).build(), responseCode, true);
                }
                if (Build.VERSION.SDK_INT >= 9 && (a2 = com.startapp.common.c.a.a()) != null) {
                    a2.put(URI.create(str), b.getHeaderFields());
                }
                InputStream inputStream = b.getInputStream();
                a aVar = new a();
                aVar.b(b.getContentType());
                if (inputStream != null) {
                    StringWriter stringWriter = new StringWriter();
                    char[] cArr = new char[1024];
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                    while (true) {
                        int read = bufferedReader.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        stringWriter.write(cArr, 0, read);
                    }
                    aVar.a(stringWriter.toString());
                }
                b.a(inputStream);
                if (b != null) {
                    b.disconnect();
                }
                return aVar;
            } catch (IOException e) {
                throw new SDKException("GET", Uri.parse(str).buildUpon().query(null).build(), 0, false, e);
            }
        } catch (Throwable th) {
            b.a((Closeable) null);
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private static HttpURLConnection b(String str, byte[] bArr, Map<String, String> map, String str2, boolean z, String str3) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
        com.startapp.common.c.a.a(httpURLConnection, str);
        if (str2 != null && str2.compareTo("-1") != 0) {
            httpURLConnection.addRequestProperty("User-Agent", str2);
        }
        httpURLConnection.setRequestProperty("Accept", "application/json;text/html;text/plain");
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setConnectTimeout(10000);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            if (str3 != null) {
                httpURLConnection.setRequestProperty("Content-Type", str3);
            }
            if (z) {
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            }
        } else {
            httpURLConnection.setRequestMethod("GET");
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    httpURLConnection.setRequestProperty(key, value);
                }
            }
        }
        return httpURLConnection;
    }

    @SuppressLint({"MissingPermission"})
    public static String a(Context context) {
        NetworkCapabilities networkCapabilities;
        String str = "e100";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (b.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    str = "e102";
                    if (Build.VERSION.SDK_INT >= 23) {
                        Network activeNetwork = connectivityManager.getActiveNetwork();
                        if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                            if (networkCapabilities.hasTransport(1)) {
                                str = "WIFI";
                            } else if (networkCapabilities.hasTransport(0)) {
                                str = c(context);
                            }
                        }
                    } else {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            String typeName = activeNetworkInfo.getTypeName();
                            if (typeName.toLowerCase().compareTo("WIFI".toLowerCase()) == 0) {
                                str = "WIFI";
                            } else if (typeName.toLowerCase().compareTo("MOBILE".toLowerCase()) == 0) {
                                str = c(context);
                            }
                        }
                    }
                } else {
                    str = "e105";
                }
            }
        } catch (Exception e) {
            str = "e105";
        }
        return str;
    }

    private static String c(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null ? Integer.toString(telephonyManager.getNetworkType()) : "e101";
    }

    public static Boolean b(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || !b.a(context, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return null;
        }
        return Boolean.valueOf(activeNetworkInfo.isRoaming());
    }

    private e(Owner owner, Owner owner2) {
        this.a = owner;
        if (owner2 == null) {
            this.b = Owner.NONE;
        } else {
            this.b = owner2;
        }
        this.c = false;
    }

    public static e a(Owner owner, Owner owner2) {
        com.iab.omid.library.startapp.b.a(owner, "Impression owner is null");
        if (owner.equals(Owner.NONE)) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        return new e(owner, owner2);
    }

    public final boolean a() {
        return Owner.NATIVE == this.a;
    }

    public final boolean b() {
        return Owner.NATIVE == this.b;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        com.iab.omid.library.startapp.d.b.a(jSONObject, "impressionOwner", this.a);
        com.iab.omid.library.startapp.d.b.a(jSONObject, "videoEventsOwner", this.b);
        com.iab.omid.library.startapp.d.b.a(jSONObject, "isolateVerificationScripts", Boolean.FALSE);
        return jSONObject;
    }
}
