package com.example.random

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val numeroAleatorio = Random.nextInt(from=1, until=101)

        val numeroIntroducido = findViewById<EditText>(R.id.editTextText)
        val boton = findViewById<Button>(R.id.button)
        val texto = findViewById<TextView>(R.id.textView)

        var contador = 0

        boton.setOnClickListener {

            val entrada = numeroIntroducido.text.toString()
            val numero = entrada.toIntOrNull()

            if (numero == null || numero !in 0..100) {
                numeroIntroducido.error = "Introduce un número válido del 0 al 100."
            } else {
                contador++

                when {
                    numero < numeroAleatorio -> {
                        texto.text = "El número es mayor. Intentos: $contador"
                    }

                    numero > numeroAleatorio -> {
                        texto.text = "El número es menor. Intentos: $contador"
                    }

                    else -> {
                        texto.text = "¡Correcto! El número era $numeroAleatorio. " + "Intentos: $contador"
                        boton.isEnabled = false
                    }
                }

                //borra el contenido del campo
                numeroIntroducido.text.clear()
            }
        }
    }
}