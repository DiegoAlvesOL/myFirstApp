package com.example.myfirstapp

import android.content.Intent
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
            val name = ediName.text.toString().trim()
            val age = ediAge.text.toString().trim()

            when {
                // caso usuário não colocou nada
                name.isEmpty() && age.isEmpty()->{
                    startActivity(
                        Intent(this, EmptyFieldsActivity::class.java)
                    )
                }

                // usuário colocou nome mas não a idade
                name.isNotEmpty() && age.isEmpty()->{
                    startActivity(
                        Intent(this, MissingAgeActivity::class.java)
                            .putExtra("NAME", name)
                    )
                }

                // usuário colocou a idade mas não o nome
                name.isEmpty() && age.isNotEmpty()->{
                    startActivity(
                        Intent(this, MissingNameActivity::class.java)
                            .putExtra("AGE", age)
                    )
                }


                else ->{
                    startActivity(
                        Intent(this, SuccessActivity::class.java)
                            .putExtra("NAME", name)
                            .putExtra("AGE", age)
                    )
                }
            }
        }
    }
}