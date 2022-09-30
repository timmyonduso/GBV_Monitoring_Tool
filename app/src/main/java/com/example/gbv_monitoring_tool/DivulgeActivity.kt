package com.example.gbv_monitoring_tool

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class DivulgeActivity : AppCompatActivity() {
    lateinit var wb_view: WebView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_divulge)
        wb_view=findViewById(R.id.webView2)
        webview()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webview(){
        wb_view.webViewClient= WebViewClient()
        wb_view.apply {
            loadUrl("https://ee.kobotoolbox.org/x/Qg8r4Pe2")
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (wb_view.canGoBack())wb_view.goBack() else
            super.onBackPressed()
    }
}