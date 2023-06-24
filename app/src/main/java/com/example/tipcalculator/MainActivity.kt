package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculate = findViewById<Button>(R.id.calculateButton)
        val bill = findViewById<EditText>(R.id.billEditText)
        val tipPercentage = findViewById<EditText>(R.id.tipPercentageEditText)
        val info = findViewById<TextView>(R.id.infoTextView)

        calculate.setOnClickListener {
            val bill = bill.text.toString().toDouble()
            val tipPercentage = tipPercentage.text.toString().toDouble() / 100
            val tip = bill * tipPercentage
            val total = tip + bill

            info.visibility = View.VISIBLE

            info.text = "Tip: ${doubleToDollar(tip)} Total: ${doubleToDollar(total)}"
        }

    }

    fun doubleToDollar(number:Double): String {
        return "$" + String.format("%.2f",number)
    }
}