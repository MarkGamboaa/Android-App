package com.example.androidapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidapp.databinding.ActivityFirstScreenBinding
import com.example.androidapp.databinding.ActivityReviewInfoBinding
import com.example.androidapp.databinding.ActivitySignUpBinding

class Sign_Up : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btnBack.setOnClickListener {
            // Declare an intent object
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.btnCreate.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("firstName", binding.etFirstName.text.toString())
            bundle.putString("middleName", binding.etMiddleName.text.toString())
            bundle.putString("lastName", binding.etLastName.text.toString())
            bundle.putString("email", binding.etEmail.text.toString())
            bundle.putString("password", binding.etPassword.text.toString())

            if(binding.etPassword.text.toString().equals(binding.etConfirmPassword.text.toString()) ) {
                val intent = Intent(this, ReviewInfo::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Passwords do not match, Re-enter Password", Toast.LENGTH_SHORT).show()
            }


        }
    }
}