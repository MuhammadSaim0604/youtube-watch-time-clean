#!/usr/bin/env python3
"""
Generate Video500Activity.java and activity_video500.xml
with 500 WebViews arranged in a grid pattern.
"""

import os
import sys

def generate_java_file():
    """Generate Video500Activity.java with 500 WebViews"""

    # Build the WebView declarations
    webview_declarations = []
    for i in range(1, 501):
        webview_declarations.append(f"    private WebView webview{i};")

    # Build the findViewById assignments
    find_view_assignments = []
    for i in range(1, 501):
        find_view_assignments.append(f"        webview{i} = findViewById(R.id.webview{i});")

    # Build the setupWebView calls
    setup_calls = []
    for i in range(1, 501):
        setup_calls.append(f"        setupWebView(webview{i});")

    # Build the loadUrl calls
    load_calls = []
    for i in range(1, 501):
        load_calls.append(f"        webview{i}.loadUrl(link);")

    java_content = f'''package com.my.youtubewatchtime.view.sa;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;

public class Video500Activity extends AppCompatActivity {{
    {chr(10).join(webview_declarations)}
    private LinearLayout linearMain;
    private String link = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video500);

        FirebaseApp.initializeApp(this);
        initializeViews();
        loadVideos();
    }}

    private void initializeViews() {{
        {chr(10).join(find_view_assignments)}
        linearMain = findViewById(R.id.linearMain);

        {chr(10).join(setup_calls)}
    }}

    private void setupWebView(WebView webView) {{
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient());
    }}

    private void loadVideos() {{
        link = getIntent().getStringExtra("500");
        if (link == null || link.isEmpty()) {{
            Toast.makeText(this, "No URL provided", Toast.LENGTH_SHORT).show();
            return;
        }}

        {chr(10).join(load_calls)}
    }}

    @Override
    public void onBackPressed() {{
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }}
}}
'''
    return java_content

def generate_xml_file():
    """Generate activity_video500.xml with 500 WebViews in a grid"""

    # Create rows of 5 WebViews each (100 rows for 500 WebViews)
    rows = []
    webview_counter = 1

    for row_num in range(1, 101):  # 100 rows
        row_webviews = []
        for col in range(5):
            if webview_counter <= 500:
                row_webviews.append(f'''        <WebView
            android:id="@+id/webview{webview_counter}"
            android:layout_width="110dp"
            android:layout_height="100dp"
            android:layout_margin="4dp" />''')
            webview_counter += 1

        row_content = '\n'.join(row_webviews)
        rows.append(f'''    <!-- Row {row_num} -->
    <LinearLayout
        android:id="@+id/linearRow{row_num}"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal">
{row_content}
    </LinearLayout>''')

    xml_content = f'''<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@android:color/black">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:id="@+id/linearMain"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:orientation="vertical"
            android:padding="8dp">

{chr(10).join(rows)}

            <!-- Banner Ad -->
            <LinearLayout
                android:id="@+id/linearAd"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:padding="8dp"
                android:layout_marginTop="8dp" />

        </LinearLayout>
    </ScrollView>
</LinearLayout>
'''
    return xml_content

def generate_video10_activity_with_script():
    """Generate Video10Activity.java with 10 WebViews using script"""

    webview_declarations = []
    find_view_assignments = []
    setup_calls = []
    load_calls = []

    for i in range(1, 11):
        webview_declarations.append(f"    private WebView webview{i};")
        find_view_assignments.append(f"        webview{i} = findViewById(R.id.webview{i});")
        setup_calls.append(f"        setupWebView(webview{i});")
        load_calls.append(f"        webview{i}.loadUrl(link);")

    return f'''package com.my.youtubewatchtime.view.sa;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;

public class Video10Activity extends AppCompatActivity {{
    {chr(10).join(webview_declarations)}
    private LinearLayout linearMain;
    private String link = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video10);

        FirebaseApp.initializeApp(this);
        initializeViews();
        loadVideos();
    }}

    private void initializeViews() {{
        {chr(10).join(find_view_assignments)}
        linearMain = findViewById(R.id.linearMain);

        {chr(10).join(setup_calls)}
    }}

    private void setupWebView(WebView webView) {{
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient());
    }}

    private void loadVideos() {{
        link = getIntent().getStringExtra("10");
        if (link == null || link.isEmpty()) {{
            Toast.makeText(this, "No URL provided", Toast.LENGTH_SHORT).show();
            return;
        }}

        {chr(10).join(load_calls)}
    }}

    @Override
    public void onBackPressed() {{
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }}
}}
'''

def generate_video10_xml():
    """Generate activity_video10.xml with 10 WebViews"""

    rows = []
    webview_counter = 1
    row_configs = [3, 3, 4]  # 3 rows: 3, 3, 4 webviews

    for row_num, count in enumerate(row_configs, 1):
        row_webviews = []
        for col in range(count):
            if webview_counter <= 10:
                row_webviews.append(f'''        <WebView
            android:id="@+id/webview{webview_counter}"
            android:layout_width="110dp"
            android:layout_height="100dp"
            android:layout_margin="4dp" />''')
            webview_counter += 1

        row_content = '\n'.join(row_webviews)
        rows.append(f'''    <!-- Row {row_num} -->
    <LinearLayout
        android:id="@+id/linearRow{row_num}"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal">
{row_content}
    </LinearLayout>''')

    return f'''<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@android:color/black">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:id="@+id/linearMain"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:orientation="vertical"
            android:padding="8dp">

{chr(10).join(rows)}

            <!-- Banner Ad -->
            <LinearLayout
                android:id="@+id/linearAd"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:padding="8dp"
                android:layout_marginTop="8dp" />

        </LinearLayout>
    </ScrollView>
</LinearLayout>
'''

def generate_video20_activity_with_script():
    """Generate Video20Activity.java with 20 WebViews"""

    webview_declarations = []
    find_view_assignments = []
    setup_calls = []
    load_calls = []

    for i in range(1, 21):
        webview_declarations.append(f"    private WebView webview{i};")
        find_view_assignments.append(f"        webview{i} = findViewById(R.id.webview{i});")
        setup_calls.append(f"        setupWebView(webview{i});")
        load_calls.append(f"        webview{i}.loadUrl(link);")

    return f'''package com.my.youtubewatchtime.view.sa;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;

public class Video20Activity extends AppCompatActivity {{
    {chr(10).join(webview_declarations)}
    private LinearLayout linearMain;
    private String link = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video20);

        FirebaseApp.initializeApp(this);
        initializeViews();
        loadVideos();
    }}

    private void initializeViews() {{
        {chr(10).join(find_view_assignments)}
        linearMain = findViewById(R.id.linearMain);

        {chr(10).join(setup_calls)}
    }}

    private void setupWebView(WebView webView) {{
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient());
    }}

    private void loadVideos() {{
        link = getIntent().getStringExtra("20");
        if (link == null || link.isEmpty()) {{
            Toast.makeText(this, "No URL provided", Toast.LENGTH_SHORT).show();
            return;
        }}

        {chr(10).join(load_calls)}
    }}

    @Override
    public void onBackPressed() {{
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }}
}}
'''

def generate_video20_xml():
    """Generate activity_video20.xml with 20 WebViews"""

    rows = []
    webview_counter = 1
    # 7 rows: 3, 3, 3, 3, 3, 3, 2
    row_configs = [3, 3, 3, 3, 3, 3, 2]

    for row_num, count in enumerate(row_configs, 1):
        row_webviews = []
        for col in range(count):
            if webview_counter <= 20:
                row_webviews.append(f'''        <WebView
            android:id="@+id/webview{webview_counter}"
            android:layout_width="110dp"
            android:layout_height="100dp"
            android:layout_margin="4dp" />''')
            webview_counter += 1

        row_content = '\n'.join(row_webviews)
        rows.append(f'''    <!-- Row {row_num} -->
    <LinearLayout
        android:id="@+id/linearRow{row_num}"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal">
{row_content}
    </LinearLayout>''')

    return f'''<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@android:color/black">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:id="@+id/linearMain"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:orientation="vertical"
            android:padding="8dp">

{chr(10).join(rows)}

            <!-- Banner Ad -->
            <LinearLayout
                android:id="@+id/linearAd"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:padding="8dp"
                android:layout_marginTop="8dp" />

        </LinearLayout>
    </ScrollView>
</LinearLayout>
'''

def main():
    """Main function to generate all files"""

    # Get the directory where the script is running
    script_dir = os.path.dirname(os.path.abspath(__file__))

    # Files to generate
    files_to_generate = [
        ('Video500Activity.java', generate_java_file()),
        ('activity_video500.xml', generate_xml_file()),
        ('Video10Activity.java', generate_video10_activity_with_script()),
        ('activity_video10.xml', generate_video10_xml()),
        ('Video20Activity.java', generate_video20_activity_with_script()),
        ('activity_video20.xml', generate_video20_xml()),
    ]

    print("=" * 60)
    print("📱 YouTube Watch Time - File Generator")
    print("=" * 60)
    print(f"📁 Output directory: {script_dir}\n")

    for filename, content in files_to_generate:
        filepath = os.path.join(script_dir, filename)
        try:
            with open(filepath, 'w', encoding='utf-8') as f:
                f.write(content)
            print(f"✅ Generated: {filename}")
        except Exception as e:
            print(f"❌ Error generating {filename}: {e}")

    print("\n" + "=" * 60)
    print("🎉 All files generated successfully!")
    print("📋 Summary:")
    print(f"   - Video500Activity.java (500 WebViews)")
    print(f"   - activity_video500.xml (500 WebViews in 100 rows)")
    print(f"   - Video10Activity.java (10 WebViews)")
    print(f"   - activity_video10.xml (10 WebViews)")
    print(f"   - Video20Activity.java (20 WebViews)")
    print(f"   - activity_video20.xml (20 WebViews)")
    print("\n📝 Next Steps:")
    print("   1. Copy these files to your Android project")
    print("   2. Add Video500Activity to AndroidManifest.xml")
    print("   3. Add '500' button in HomeActivity")
    print("   4. Build and run the app")
    print("=" * 60)

if __name__ == "__main__":
    main()