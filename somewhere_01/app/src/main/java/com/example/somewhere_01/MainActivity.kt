package com.example.somewhere_01

import android.os.Bundle
import android.widget.Button
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

        //Añadimos una variable button, y la asociamos al botón de la view
        val mainButton : Button = findViewById(R.id.mainButton)

        //Agregamos listener para que aparezca mensaje emergente al presionar
        mainButton.setOnClickListener {
            //Mensaje emergente con "toast"
            Toast.makeText(this, "Main button pressed by you!!", Toast.LENGTH_LONG).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}