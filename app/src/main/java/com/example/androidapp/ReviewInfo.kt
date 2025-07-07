    package com.example.androidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidapp.databinding.ActivityFirstScreenBinding
import com.example.androidapp.databinding.ActivityReviewInfoBinding

    class ReviewInfo : AppCompatActivity() {
    private lateinit var binding: ActivityReviewInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityReviewInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras
        if (bundle != null) {
            binding.tvFirstNameBox.text = bundle.getString("firstName")
            binding.tvMiddleNameBox.text = bundle.getString("middleName")
            binding.tvLastNameBox.text = bundle.getString("lastName")
            binding.tvEmailBox.text = bundle.getString("email")
        }


        binding.btnBack.setOnClickListener {
            // Declare an intent object
            val intent = Intent(this, Sign_Up::class.java)
            startActivity(intent)
        }
    }
}
