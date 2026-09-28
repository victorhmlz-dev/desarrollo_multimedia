package com.example.someproject_01

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
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        val nameField = findViewById<EditText>(R.id.nameField)
        val hiButton = findViewById<Button>(R.id.hiButton)
        val hiText = findViewById<TextView>(R.id.hiText)
        val cleanButton = findViewById<Button>(R.id.cleanButton)

        hiButton.setOnClickListener {

            val name = nameField.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(
                    this,
                    "Debe escribir su nombre",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                hiText.text = "Hi! $name"
                Toast.makeText(
                    this,
                    "Bienvenido $name!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        cleanButton.setOnClickListener {

            nameField.text.clear()
            hiText.text = ""
        }
    }
}