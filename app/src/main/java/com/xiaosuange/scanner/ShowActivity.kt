// MainActivity.java
package com.xiaosuange.scanner

import android.os.Bundle
import android.webkit.WebView
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class ShowActivity : AppCompatActivity() {
    private var viewContainer: LinearLayout? = null // Container to hold the custom views
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        val webView = findViewById<WebView>(R.id.webView)
        val urlEdit = findViewById<EditText>(R.id.result)

        val url =  intent.getStringExtra("url")
        val bundle = intent.getBundleExtra("headers")
        urlEdit.setText(url)
        val mp = HashMap<String?, String?>()

        for (key in bundle!!.keySet()) {
            mp[key] = bundle.getString(key)
        }
        webView.loadUrl(url!!, mp)
    }
}
