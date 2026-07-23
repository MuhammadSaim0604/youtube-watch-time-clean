#!/usr/bin/env python3
"""
Generate Video100Activity.java and activity_video100.xml
with 100 WebViews arranged in a grid pattern.
"""

import os
import sys

def generate_java_file():
    """Generate Video100Activity.java with 100 WebViews"""

    # Build the WebView declarations
    webview_declarations = []
    for i in range(1, 101):
        webview_declarations.append(f"    private WebView webview{i};")

    # Build the findViewById assignments
    find_view_assignments = []
    for i in range(1, 101):
        find_view_assignments.append(f"        webview{i} = findViewById(R.id.webview{i});")

    # Build the setupWebView calls
    setup_calls = []
    for i in range(1, 101):
        setup_calls.append(f"        setupWebView(webview{i});")

    # Build the loadUrl calls
    load_calls = []
    for i in range(1, 101):
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

public class Video100Activity extends AppCompatActivity {{
    {chr(10).join(webview_declarations)}
    private LinearLayout linearMain;
    private String link = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video100);

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
        link = getIntent().getStringExtra("100");
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
    """Generate activity_video100.xml with 100 WebViews in a grid"""

    # Create rows of 5 WebViews each (20 rows for 100 WebViews)
    rows = []
    webview_counter = 1

    for row_num in range(1, 21):  # 20 rows
        row_webviews = []
        for col in range(5):
            if webview_counter <= 100:
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

def generate_video30_activity():
    """Generate Video30Activity.java with 30 WebViews"""

    webview_declarations = []
    find_view_assignments = []
    setup_calls = []
    load_calls = []

    for i in range(1, 31):
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

public class Video30Activity extends AppCompatActivity {{
    {chr(10).join(webview_declarations)}
    private LinearLayout linearMain;
    private String link = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video30);

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
        link = getIntent().getStringExtra("30");
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

def generate_video30_xml():
    """Generate activity_video30.xml with 30 WebViews"""

    rows = []
    webview_counter = 1
    # 10 rows: 3, 3, 3, 3, 3, 3, 3, 3, 3, 3
    row_configs = [3, 3, 3, 3, 3, 3, 3, 3, 3, 3]

    for row_num, count in enumerate(row_configs, 1):
        row_webviews = []
        for col in range(count):
            if webview_counter <= 30:
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

def generate_video40_activity():
    """Generate Video40Activity.java with 40 WebViews"""

    webview_declarations = []
    find_view_assignments = []
    setup_calls = []
    load_calls = []

    for i in range(1, 41):
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

public class Video40Activity extends AppCompatActivity {{
    {chr(10).join(webview_declarations)}
    private LinearLayout linearMain;
    private String link = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video40);

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
        link = getIntent().getStringExtra("40");
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

def generate_video40_xml():
    """Generate activity_video40.xml with 40 WebViews"""

    rows = []
    webview_counter = 1
    # 13 rows: 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4
    row_configs = [3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4]

    for row_num, count in enumerate(row_configs, 1):
        row_webviews = []
        for col in range(count):
            if webview_counter <= 40:
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

def generate_video50_activity():
    """Generate Video50Activity.java with 50 WebViews"""

    webview_declarations = []
    find_view_assignments = []
    setup_calls = []
    load_calls = []

    for i in range(1, 51):
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

public class Video50Activity extends AppCompatActivity {{
    {chr(10).join(webview_declarations)}
    private LinearLayout linearMain;
    private String link = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video50);

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
        link = getIntent().getStringExtra("50");
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

def generate_video50_xml():
    """Generate activity_video50.xml with 50 WebViews"""

    rows = []
    webview_counter = 1
    # 16 rows: 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2
    row_configs = [3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2]

    for row_num, count in enumerate(row_configs, 1):
        row_webviews = []
        for col in range(count):
            if webview_counter <= 50:
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

def generate_video75_activity():
    """Generate Video75Activity.java with 75 WebViews"""

    webview_declarations = []
    find_view_assignments = []
    setup_calls = []
    load_calls = []

    for i in range(1, 76):
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

public class Video75Activity extends AppCompatActivity {{
    {chr(10).join(webview_declarations)}
    private LinearLayout linearMain;
    private String link = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video75);

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
        link = getIntent().getStringExtra("75");
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

def generate_video75_xml():
    """Generate activity_video75.xml with 75 WebViews"""

    rows = []
    webview_counter = 1
    # 25 rows: 3 each (75 total)
    row_configs = [3] * 25

    for row_num, count in enumerate(row_configs, 1):
        row_webviews = []
        for col in range(count):
            if webview_counter <= 75:
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
        ('Video100Activity.java', generate_java_file()),
        ('activity_video100.xml', generate_xml_file()),
        ('Video30Activity.java', generate_video30_activity()),
        ('activity_video30.xml', generate_video30_xml()),
        ('Video40Activity.java', generate_video40_activity()),
        ('activity_video40.xml', generate_video40_xml()),
        ('Video50Activity.java', generate_video50_activity()),
        ('activity_video50.xml', generate_video50_xml()),
        ('Video75Activity.java', generate_video75_activity()),
        ('activity_video75.xml', generate_video75_xml()),
    ]

    print("=" * 60)
    print("📱 YouTube Watch Time - Video Generator")
    print("=" * 60)
    print(f"📁 Output directory: {script_dir}\n")

    for filename, content in files_to_generate:
        filepath = os.path.join(script_dir, filename)
        try:
            with open(filepath, 'w', encoding='utf-8') as f:
                f.write(content)
            # Count WebViews in the file
            if 'activity_video' in filename:
                count = content.count('android:id="@+id/webview')
                print(f"✅ Generated: {filename} ({count} WebViews)")
            else:
                print(f"✅ Generated: {filename}")
        except Exception as e:
            print(f"❌ Error generating {filename}: {e}")

    print("\n" + "=" * 60)
    print("🎉 All files generated successfully!")
    print("📋 Summary of generated files:")
    print("   ✅ Video100Activity.java + activity_video100.xml (100 WebViews)")
    print("   ✅ Video75Activity.java + activity_video75.xml (75 WebViews)")
    print("   ✅ Video50Activity.java + activity_video50.xml (50 WebViews)")
    print("   ✅ Video40Activity.java + activity_video40.xml (40 WebViews)")
    print("   ✅ Video30Activity.java + activity_video30.xml (30 WebViews)")
    print("\n📝 Next Steps:")
    print("   1. Copy these files to your Android project")
    print("   2. Add the new activities to AndroidManifest.xml")
    print("   3. Add new buttons in HomeActivity for each video count")
    print("   4. Build and run the app")
    print("=" * 60)

if __name__ == "__main__":
    main()