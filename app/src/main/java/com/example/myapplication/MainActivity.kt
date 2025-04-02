package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnReset = findViewById<Button>(R.id.btnReset)
        val txtView = findViewById<TextView>(R.id.TxtView)
        val edtTime = findViewById<EditText>(R.id.EdtTime)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val btnExit = findViewById<Button>(R.id.btnExit)


        btnGenerate.setOnClickListener {
            val Input = edtTime.text.toString().trim().lowercase()

            val meals: String

            when (Input) {
                "morning" -> {
                    meals = "Breakfast: Eggs"
                }

                "mid-morning" -> {
                    meals = "Snack: Fruit"
                }

                "afternoon" -> {
                    meals = "Lunch: Sandwich"
                }

                "mid-afternoon" -> {
                    meals = "Snack: Cake"
                }

                "dinner" -> {
                    meals = "Main Course: Pasta"
                }

                "after dinner" -> {
                    meals = "Dessert: Ice cream"
                }

                else -> {
                    meals = "Please enter Text!"
                    Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show()
                }
            }
            txtView.text = meals
        }
        btnReset.setOnClickListener {
            txtView.text = ""
            edtTime.text.clear()
            Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show()
        }
        btnExit.setOnClickListener{
            finish()
        }
    }
}