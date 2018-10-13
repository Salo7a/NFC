package com.hma.nfc;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.hma.nfc", Context.MODE_PRIVATE);
        String ip = sharedPreferences.getString("ip", "192.168.1.30");
        final String id = sharedPreferences.getString("nid", "55");
        final String pass = sharedPreferences.getString("pass", "doctor");
        final WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.loadUrl(
                        "document.getElementById(\"+id\").value = \"" + id + "\";" +
                                "document.getElementById( \" pass \").value = \"" + pass + "\";" +
                                " document.getElementById(\"doc\").click();");

            }
        });
        webView.loadUrl(ip + "/LoginPage.php");

    }
}
