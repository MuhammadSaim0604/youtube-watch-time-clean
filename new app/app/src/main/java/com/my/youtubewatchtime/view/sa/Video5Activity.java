package com.my.youtubewatchtime.view.sa;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Video5Activity extends AppCompatActivity {
    private WebView webview17, webview19, webview21, webview22, webview23;
    private String link = "";
    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video5);

        initializeViews();
        loadVideos();
    }

    private void initializeViews() {
        webview17 = findViewById(R.id.webview17);
        webview19 = findViewById(R.id.webview19);
        webview21 = findViewById(R.id.webview21);
        webview22 = findViewById(R.id.webview22);
        webview23 = findViewById(R.id.webview23);
        setupWebView(webview17);
        setupWebView(webview19);
        setupWebView(webview21);
        setupWebView(webview22);
        setupWebView(webview23);
    }

    private void setupWebView(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient());
    }

    private void loadVideos() {
        link = getIntent().getStringExtra("5");
        if (link == null || link.isEmpty()) {
            Toast.makeText(this, "No URL provided", Toast.LENGTH_SHORT).show();
            return;
        }

        webview17.loadUrl(link);
        webview19.loadUrl(link);
        webview21.loadUrl(link);
        webview22.loadUrl(link);
        webview23.loadUrl(link);
    }

    @Override
    public void onBackPressed() {
        intent.setClass(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        finish();
    }
}