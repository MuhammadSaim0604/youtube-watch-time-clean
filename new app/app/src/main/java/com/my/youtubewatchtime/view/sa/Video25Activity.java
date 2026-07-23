package com.my.youtubewatchtime.view.sa;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Video25Activity extends AppCompatActivity {
    private WebView webview32, webview33, webview34, webview35, webview36, webview37,
              webview38, webview39, webview40, webview41, webview42, webview43,
              webview44, webview45, webview46, webview47, webview48, webview49,
              webview50, webview51, webview52, webview53, webview54, webview55, webview56;
    private String link = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video25);

        initializeViews();
        loadVideos();
    }

    private void initializeViews() {
        webview32 = findViewById(R.id.webview32);
        webview33 = findViewById(R.id.webview33);
        webview34 = findViewById(R.id.webview34);
        webview35 = findViewById(R.id.webview35);
        webview36 = findViewById(R.id.webview36);
        webview37 = findViewById(R.id.webview37);
        webview38 = findViewById(R.id.webview38);
        webview39 = findViewById(R.id.webview39);
        webview40 = findViewById(R.id.webview40);
        webview41 = findViewById(R.id.webview41);
        webview42 = findViewById(R.id.webview42);
        webview43 = findViewById(R.id.webview43);
        webview44 = findViewById(R.id.webview44);
        webview45 = findViewById(R.id.webview45);
        webview46 = findViewById(R.id.webview46);
        webview47 = findViewById(R.id.webview47);
        webview48 = findViewById(R.id.webview48);
        webview49 = findViewById(R.id.webview49);
        webview50 = findViewById(R.id.webview50);
        webview51 = findViewById(R.id.webview51);
        webview52 = findViewById(R.id.webview52);
        webview53 = findViewById(R.id.webview53);
        webview54 = findViewById(R.id.webview54);
        webview55 = findViewById(R.id.webview55);
        webview56 = findViewById(R.id.webview56);

        setupWebView(webview32);
        setupWebView(webview33);
        setupWebView(webview34);
        setupWebView(webview35);
        setupWebView(webview36);
        setupWebView(webview37);
        setupWebView(webview38);
        setupWebView(webview39);
        setupWebView(webview40);
        setupWebView(webview41);
        setupWebView(webview42);
        setupWebView(webview43);
        setupWebView(webview44);
        setupWebView(webview45);
        setupWebView(webview46);
        setupWebView(webview47);
        setupWebView(webview48);
        setupWebView(webview49);
        setupWebView(webview50);
        setupWebView(webview51);
        setupWebView(webview52);
        setupWebView(webview53);
        setupWebView(webview54);
        setupWebView(webview55);
        setupWebView(webview56);
    }

    private void setupWebView(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient());
    }

    private void loadVideos() {
        link = getIntent().getStringExtra("25");
        if (link == null || link.isEmpty()) {
            Toast.makeText(this, "No URL provided", Toast.LENGTH_SHORT).show();
            return;
        }

        webview32.loadUrl(link);
        webview33.loadUrl(link);
        webview34.loadUrl(link);
        webview35.loadUrl(link);
        webview36.loadUrl(link);
        webview37.loadUrl(link);
        webview38.loadUrl(link);
        webview39.loadUrl(link);
        webview40.loadUrl(link);
        webview41.loadUrl(link);
        webview42.loadUrl(link);
        webview43.loadUrl(link);
        webview44.loadUrl(link);
        webview45.loadUrl(link);
        webview46.loadUrl(link);
        webview47.loadUrl(link);
        webview48.loadUrl(link);
        webview49.loadUrl(link);
        webview50.loadUrl(link);
        webview51.loadUrl(link);
        webview52.loadUrl(link);
        webview53.loadUrl(link);
        webview54.loadUrl(link);
        webview55.loadUrl(link);
        webview56.loadUrl(link);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}