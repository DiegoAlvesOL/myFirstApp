package com.example.myfirstapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<LinearLayout>(R.id.mainLayout)
        val ediName = findViewById<EditText>(R.id.ediName)
        val ediAge = findViewById<EditText>(R.id.ediAge)
        val btnAction = findViewById<Button>(R.id.btnAction)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnAction.setOnClickListener {

         val name = ediName.text.toString()
         val age = ediAge.text.toString()
         if (name.isNotEmpty()){
             if(age.isNotEmpty()){
                 val message = "Olá, $name! Bem-vindo ao meu primeiro App. Sua idade é: $age"

                 val spannable = android.text.SpannableString(message)
                 val start = message.indexOf(name)
                 val end = start + name.length

                 spannable.setSpan(
                     android.text.style.StyleSpan(android.graphics.Typeface.BOLD),
                     start,
                     end,
                     android.text.Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                 )
                 spannable.setSpan(
                     android.text.style.ForegroundColorSpan(android.graphics.Color.parseColor("#1976D2")),
                     start,
                     end,
                     android.text.Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                 )

                 txtResult.text=spannable
                 mainLayout.setBackgroundColor(Color.parseColor("#E3F2FD"))

             }else{
                 txtResult.text = "Você precisa digitar sua ideade"
                 mainLayout.setBackgroundColor(Color.parseColor("#f2ddf0"))
             }
         }else{
             txtResult.text = "Você precisa digitar um nome primeiro"
             mainLayout.setBackgroundColor(Color.parseColor("#FFCDD2"))
         }
        }
    }
}