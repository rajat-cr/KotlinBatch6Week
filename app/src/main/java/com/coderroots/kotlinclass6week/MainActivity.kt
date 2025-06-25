package com.coderroots.kotlinclass6week

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var email : EditText
    lateinit var password : EditText
    lateinit var btnCheck : Button

    lateinit var tvEmail : TextView
    lateinit var tvPassword: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        email = findViewById(R.id.etEmail)
        password = findViewById(R.id.etPassword)
        btnCheck = findViewById(R.id.btnCheck)

        tvEmail = findViewById(R.id.tvEmail)
        tvPassword = findViewById(R.id.tvPassword)

        btnCheck.setOnClickListener {
            if(email.text.isEmpty()){//true
                email.error = "Enter Your Id"
            }else if(password.text.isEmpty()){
                password.error = "Enter Your Name"
            }else{

                tvEmail.text = email.text.toString()
                tvPassword.text = password.text.toString()
            }
        }
    }
}