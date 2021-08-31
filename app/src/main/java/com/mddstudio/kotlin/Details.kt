package com.mddstudio.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient


class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var webiew=findViewById<WebView>(R.id.webView)
        //var progress=findViewById<ProgressBar>(R.id.progresBar)
        val url=intent.getStringExtra("url")
        if (url!=null){
            webiew.settings.javaScriptEnabled=true
            webiew.settings.userAgentString="Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"
            webiew.webViewClient=object :WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                   // progress.visibility=View.GONE
                  //  webiew.visibility=View.VISIBLE


                }

            }
            webiew.loadUrl(url)

        }

    }
}