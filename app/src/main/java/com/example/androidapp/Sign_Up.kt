package com.example.androidapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Sign_Up : AppCompatActivity() {
    // Declare layout object variables
    lateinit var btnBack: Button
    lateinit var btnCreate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBack = findViewById<Button>(R.id.btnBack)
        // Creates an action listener
        btnBack.setOnClickListener {
            // Declare an intent object
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        btnCreate = findViewById<Button>(R.id.btnCreate)
        // Creates an action listener
        btnCreate.setOnClickListener {
            // Declare an intent object
            val intent = Intent(this, ReviewInfo::class.java)
            startActivity(intent)
        }
    }
}