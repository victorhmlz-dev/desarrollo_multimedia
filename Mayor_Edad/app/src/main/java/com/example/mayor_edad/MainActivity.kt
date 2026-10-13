package com.example.mayor_edad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //-----------------------------------------------------

        //Declarar variables
        val edad = findViewById<EditText>(R.id.edad)
        val boton = findViewById<Button>(R.id.boton)
        val mensaje = findViewById<TextView>(R.id.mensaje)
        val botonSumar = findViewById<Button>(R.id.botonSumar)
        val botonRestar = findViewById<Button>(R.id.botonRestar)

        // Acción del botón principal con el listener
        boton.setOnClickListener {

            val numeroEdad = edad.text.toString().toIntOrNull()
            comprobarMensaje(numeroEdad, mensaje)
        }

        // Acción del botón principal con el listener
        botonSumar.setOnClickListener {

            var numeroEdad = edad.text.toString().toIntOrNull()
            if (numeroEdad == null) {
                mensaje.text = "Debes decir tu edad"
            } else{
                edad.setText((++numeroEdad).toString())
            }
            comprobarMensaje(numeroEdad, mensaje)
        }

        // Acción del botón principal con el listener
        botonRestar.setOnClickListener {

            var numeroEdad = edad.text.toString().toIntOrNull()
            if (numeroEdad == null) {
                mensaje.text = "Debes decir tu edad"
            } else{
                edad.setText((--numeroEdad).toString())
            }
            comprobarMensaje(numeroEdad, mensaje)
        }
    }
    //Función mensaje
    fun comprobarMensaje(numeroEdad: Int?, mensaje: TextView) {
        if (numeroEdad == null) {
            mensaje.text = "Debes introducir una edad"
        } else if (numeroEdad <= 17) {
            mensaje.text = "Eres menor de edad"
        } else if (numeroEdad == 18) {
            mensaje.text = "Tienes exactamente 18 años"
        } else {
            mensaje.text = "Eres mayor de edad"
        }
    }

}