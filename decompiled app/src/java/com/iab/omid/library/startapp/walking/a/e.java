package com.iab.omid.library.startapp.walking.a;

import com.iab.omid.library.startapp.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class e extends a {
    public e(b.InterfaceC0005b interfaceC0005b, HashSet<String> hashSet, JSONObject jSONObject, double d) {
        super(interfaceC0005b, hashSet, jSONObject, d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iab.omid.library.startapp.walking.a.b, android.os.AsyncTask
    /* renamed from: a */
    public final void onPostExecute(String str) {
        com.iab.omid.library.startapp.b.a a = com.iab.omid.library.startapp.b.a.a();
        if (a != null) {
            for (com.iab.omid.library.startapp.adsession.b bVar : a.b()) {
                if (this.a.contains(bVar.f())) {
                    bVar.e().b(str, this.c);
                }
            }
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ String doInBackground(Object[] objArr) {
        return this.b.toString();
    }
}
