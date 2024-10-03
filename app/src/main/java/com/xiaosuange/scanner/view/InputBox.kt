package com.xiaosuange.scanner.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import com.xiaosuange.scanner.R

class InputBox : LinearLayout {
    private var editTextKey: EditText? = null // Input box for key
    private var editTextValue: EditText? = null // Input box for value
    private var removeButton: ImageButton? = null // Remove button

    // Constructor to initialize the view programmatically
    constructor(context: Context) : super(context) {
        initialize(context)
    }

    // Constructor to initialize the view from XML attributes
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initialize(context)
    }

    // Method to inflate the layout and initialize the components
    private fun initialize(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.input_box, this, true)

        // Reference components inside the custom layout
        editTextKey = findViewById(R.id.editTextKey)
        editTextValue = findViewById(R.id.editTextValue)
        removeButton = findViewById(R.id.removeButton)
    }

    var keyText: String?
        // Getter for the key input field
        get() = editTextKey!!.getText().toString()
        // Setter for the key input field
        set(key) {
            editTextKey!!.setText(key)
        }
    var valueText: String?
        // Getter for the value input field
        get() = editTextValue!!.getText().toString()
        // Setter for the value input field
        set(value) {
            editTextValue!!.setText(value)
        }

    // Setter for the remove button click listener
    fun setRemoveButtonClickListener(listener: OnClickListener?) {
        removeButton!!.setOnClickListener(listener)
    }
}
