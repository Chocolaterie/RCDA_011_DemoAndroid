package com.example.enidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class DemoWebviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_webview)

        findViewById<WebView>(R.id.webview).loadUrl("https://stackoverflow.com/")
    }
}