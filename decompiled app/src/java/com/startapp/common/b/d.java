package com.startapp.common.b;

import android.content.Context;
import android.util.Log;
import com.startapp.common.ThreadManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class d {
    private static final String a = b.a(d.class);

    public static <T> T a(Context context, String str) {
        return (T) d(context, str);
    }

    public static void a(Context context, String str, Serializable serializable) {
        c(context, str, serializable);
    }

    public static void b(final Context context, final String str, final Serializable serializable) {
        ThreadManager.a(ThreadManager.Priority.DEFAULT, new Runnable() { // from class: com.startapp.common.b.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.c(context, str, serializable);
            }
        });
    }

    public static void c(Context context, String str, Serializable serializable) {
        if (str != null) {
            try {
                a(e(context, null), str, serializable);
            } catch (Exception e) {
                new StringBuilder("Failed writing to disk: ").append(e.getLocalizedMessage());
            }
        }
    }

    public static void a(Context context, String str, String str2, Serializable serializable) {
        if (str2 != null) {
            try {
                a(f(context, str), str2, serializable);
            } catch (Exception e) {
                new StringBuilder("Failed writing to disk: ").append(e.getLocalizedMessage());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T d(Context context, String str) {
        if (str == null) {
            return null;
        }
        T t = null;
        try {
            t = a(e(context, null), str);
        } catch (Error e) {
            Log.e(a, "Failed to read from disk: " + e.getLocalizedMessage());
        } catch (Exception e2) {
            Log.e(a, "Failed to read from disk: " + e2.getLocalizedMessage());
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(Context context, String str, String str2) {
        if (str2 == null) {
            return null;
        }
        T t = null;
        try {
            t = a(f(context, str), str2);
        } catch (Error e) {
            Log.e(a, "Failed to read from disk: " + e.getLocalizedMessage());
        } catch (Exception e2) {
            Log.e(a, "Failed to read from disk: " + e2.getLocalizedMessage());
        }
        return t;
    }

    public static <T> List<T> b(Context context, String str) {
        File file;
        ArrayList arrayList = new ArrayList();
        try {
            file = new File(f(context, str));
        } catch (Exception e) {
            Log.e(a, "Failed to read from disk: " + e.getLocalizedMessage());
        }
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        String[] list = file.list();
        if (list == null) {
            return null;
        }
        for (String str2 : list) {
            File file2 = new File(file, str2);
            Log.i(a, "Reading file: " + file2.getPath());
            arrayList.add(b(file2));
        }
        return arrayList;
    }

    public static void c(Context context, String str) {
        if (str != null) {
            a(new File(e(context, str)));
            a(new File(f(context, str)));
        }
    }

    private static String e(Context context, String str) {
        return context.getFilesDir().toString() + (str != null ? File.separator + str : "");
    }

    private static String f(Context context, String str) {
        return context.getCacheDir().toString() + (str != null ? File.separator + str : "");
    }

    private static void a(String str, String str2, Serializable serializable) throws IOException {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file, str2);
            Log.i(a, "Writing file: " + file2.getPath());
            a(serializable, file2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(String str, String str2) throws IOException, ClassNotFoundException {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(file, str2);
            T t = null;
            if (file2.exists()) {
                Log.i(a, "Reading file: " + file2.getPath());
                t = b(file2);
            }
            return t;
        }
        return null;
    }

    private static void a(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                a(file2);
            }
        }
        file.delete();
    }

    private static void a(Serializable serializable, File file) throws FileNotFoundException, IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    private static <T> T b(File file) throws FileNotFoundException, StreamCorruptedException, IOException, OptionalDataException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        T t = (T) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return t;
    }
}
