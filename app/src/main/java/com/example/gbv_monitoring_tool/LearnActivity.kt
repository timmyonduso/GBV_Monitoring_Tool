package com.example.gbv_monitoring_tool

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class LearnActivity : AppCompatActivity() {

        lateinit var wb_view: WebView
        @RequiresApi(Build.VERSION_CODES.O)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_learn)
            wb_view=findViewById(R.id.webView)
            webview()
        }
        @RequiresApi(Build.VERSION_CODES.O)
        private fun webview(){
            wb_view.webViewClient= WebViewClient()
            wb_view.apply {
                loadUrl("https://www.unicef.org/protection/gender-based-violence-in-emergencies")
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


