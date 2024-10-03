package com.xiaosuange.scanner

import android.content.Intent
import android.view.View
import android.webkit.WebView
import com.google.zxing.Result
import com.king.zxing.CaptureActivity
import com.xiaosuange.scanner.view.InputBox


class ScannerActivity: CaptureActivity() {
    override fun onScanResultCallback(result: Result?): Boolean {
        println("res:--"+result)
        startActivity(Intent(this, ShowActivity::class.java)
            .putExtra("url", result!!.text)
            .putExtra("headers", intent.getBundleExtra("headers")))
        return super.onScanResultCallback(result)
    }
}
