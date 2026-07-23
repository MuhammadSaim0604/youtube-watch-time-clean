package com.example.youtubewatchtime;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class VideoActivity extends Activity {
    public static final String EXTRA_URL = "video_url";
    protected int layoutId = R.layout.video5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        WebView player = findViewById(R.id.video_webview);
        player.setWebViewClient(new WebViewClient());
        player.getSettings().setJavaScriptEnabled(true);
        player.getSettings().setSupportZoom(true);
        String url = getIntent().getStringExtra(EXTRA_URL);
        if (url != null && !url.trim().isEmpty()) {
            player.loadUrl(url);
        }
    }
}