package com.my.youtubewatchtime.view.sa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private EditText edittext2;
    private ImageView imageview1;
    private WebView webview1;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initializeViews();
        setupListeners();
    }

    private void initializeViews() {
        edittext2 = findViewById(R.id.edittext2);
        imageview1 = findViewById(R.id.imageview1);
        webview1 = findViewById(R.id.webview1);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);

        setupWebView(webview1);
    }

    private void setupListeners() {
        imageview1.setOnClickListener(v -> {
            String url = edittext2.getText().toString().trim();
            if (isYouTubeUrl(url)) {
                webview1.setVisibility(View.VISIBLE);
                webview1.loadUrl(url);
            } else {
                showMessage("Please enter a valid YouTube URL");
            }
        });

        button1.setOnClickListener(v -> openVideo(Video5Activity.class, "5"));
        button2.setOnClickListener(v -> openVideo(Video10Activity.class, "10"));
        button3.setOnClickListener(v -> openVideo(Video15Activity.class, "15"));
        button4.setOnClickListener(v -> openVideo(Video20Activity.class, "20"));
        button5.setOnClickListener(v -> openVideo(Video25Activity.class, "25"));
        button6.setOnClickListener(v -> openVideo(Video500Activity.class, "500"));
        button7.setOnClickListener(v -> showMessage("Coming Soon"));
        button8.setOnClickListener(v -> openHowItWorks());
    }

    private void setupWebView(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient());
    }

    private void openVideo(Class<?> activityClass, String extraKey) {
        String url = edittext2.getText().toString().trim();
        if (!isYouTubeUrl(url)) {
            showMessage("Please enter a valid YouTube URL");
            return;
        }
        Intent intent = new Intent(this, activityClass);
        intent.putExtra(extraKey, url);
        startActivity(intent);
    }

    private boolean isYouTubeUrl(String url) {
        Uri parsed = Uri.parse(url);
        String host = parsed.getHost();
        return ("http".equalsIgnoreCase(parsed.getScheme())
                || "https".equalsIgnoreCase(parsed.getScheme()))
                && host != null
                && (host.equalsIgnoreCase("youtube.com")
                || host.endsWith(".youtube.com")
                || host.equalsIgnoreCase("youtu.be")
                || host.endsWith(".youtu.be"));
    }

    private void openHowItWorks() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://whatsapp.com/channel/0029VavHzv259PwTIz1XxJ09")));
        } catch (android.content.ActivityNotFoundException exception) {
            showMessage("How it works: enter a YouTube URL and choose a layout.");
        }
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}