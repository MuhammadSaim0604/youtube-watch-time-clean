package com.my.youtubewatchtime.view.sa;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Video10Activity extends AppCompatActivity {
    private WebView webview24, webview25, webview26, webview27, webview28, webview29, webview30, webview31;
    private String link = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video10);

        initializeViews();
        loadVideos();
    }

    private void initializeViews() {
        webview24 = findViewById(R.id.webview24);
        webview25 = findViewById(R.id.webview25);
        webview26 = findViewById(R.id.webview26);
        webview27 = findViewById(R.id.webview27);
        webview28 = findViewById(R.id.webview28);
        webview29 = findViewById(R.id.webview29);
        webview30 = findViewById(R.id.webview30);
        webview31 = findViewById(R.id.webview31);
        setupWebView(webview24);
        setupWebView(webview25);
        setupWebView(webview26);
        setupWebView(webview27);
        setupWebView(webview28);
        setupWebView(webview29);
        setupWebView(webview30);
        setupWebView(webview31);
    }

    private void setupWebView(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient());
    }

    private void loadVideos() {
        link = getIntent().getStringExtra("10");
        if (link == null || link.isEmpty()) {
            Toast.makeText(this, "No URL provided", Toast.LENGTH_SHORT).show();
            return;
        }

        webview24.loadUrl(link);
        webview25.loadUrl(link);
        webview26.loadUrl(link);
        webview27.loadUrl(link);
        webview28.loadUrl(link);
        webview29.loadUrl(link);
        webview30.loadUrl(link);
        webview31.loadUrl(link);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}