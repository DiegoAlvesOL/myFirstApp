package com.example.myfirstapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp.R.id.txtMessage

class SuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        val txt = findViewById<TextView>(R.id.txtMessage)

        val name = intent.getStringExtra("NAME")
        val age = intent.getStringExtra("AGE")

        txt.text = "Olá meu nome é $name, e a minha idade é $age"
    }
}