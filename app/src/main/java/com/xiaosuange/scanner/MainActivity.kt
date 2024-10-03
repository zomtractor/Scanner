// MainActivity.java
package com.xiaosuange.scanner

import android.content.Intent
import android.os.Bundle
import android.util.JsonWriter
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.king.zxing.CaptureActivity
import com.xiaosuange.scanner.view.InputBox
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private var viewContainer: LinearLayout? = null // Container to hold the custom views
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewContainer = findViewById<LinearLayout>(R.id.viewContainer) // Reference to the container
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            addInputBox(null) // Call the method to add a new custom view
        }
        addInputBox("authorization") // Call the method to add a new custom view

        val scanButton = findViewById<Button>(R.id.scanner)
        scanButton.setOnClickListener {
            startActivity(Intent(this, ScannerActivity::class.java)
                .putExtra("headers", getAllHeaders()))
        }

    }


    private fun addInputBox(title: String?) {
        // Create a new instance of the custom InputBox class
        val inputBoxView = InputBox(this)

        // Set a remove button listener to delete the current view from the container
        inputBoxView.setRemoveButtonClickListener { viewContainer!!.removeView(inputBoxView) }
        inputBoxView.keyText = title?:""
        // Add the custom InputBox view to the container
        viewContainer!!.addView(inputBoxView)
    }

    private fun getAllHeaders(): Bundle {
        val bundle = Bundle()
        val childCount: Int = viewContainer!!.getChildCount()
        for (i in 0 until childCount) {
            val view: View = viewContainer!!.getChildAt(i)
            if (view is InputBox) {
                val inputBox = view
                val key = inputBox.keyText
                val value = inputBox.valueText

                // Add only non-empty key-value pairs to the headers
                if (!key!!.isEmpty()) {
                    bundle.putString(key, value)
                }
            }
        }
        return bundle
    }

}
