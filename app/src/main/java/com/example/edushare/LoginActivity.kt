package com.example.edushare

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.edushare.databinding.ActivityLoginBinding
import kotlin.toString

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val TomboLogin : Button = findViewById(R.id.btnLogin)
//        val username : EditText = findViewById(R.id.edrUser)
//        val password : EditText = findViewById(R.id.edtPassword)


        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
//        // Kondisi jika isLogin bernilai true
//        val isLogin = sharedPref.getBoolean("isLogin", false)
//        if (isLogin) {
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//            return
//        }

        binding.btnLogin.setOnClickListener {
            val user = binding.edtUser.text.toString()
            val pass = binding.edtPassword.text.toString()

            if (user.isNotEmpty() && user == pass) {

                val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

                sharedPref.edit()
                    .putBoolean("isLogin", true)
                    .putString("username", user)
                    .apply()

                val intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(
                    this,
                    "Username dan password tidak sesuai",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


}}


