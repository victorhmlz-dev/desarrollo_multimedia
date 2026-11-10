package com.example.square

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.core.content.ContextCompat
import model.Square
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val sqView: View = findViewById(R.id.cyanSquare)
        //
        //ContextCompat.getColor(this
        sqView.post{
            //configuramos varianbles iniciales con los valores de la vista
            val initX = sqView.x.toInt()
            val initY = sqView.y.toInt()
            val initWidth = sqView.layoutParams.width
            val initHeight = sqView.layoutParams.height

            //creamos el objeto square
            val square: Square = Square(ContextCompat.getColor(this, R.color.cyan), initWidth, initHeight).apply{
                x = initX
                y = initY
            }

            val upButton: View = findViewById(R.id.upButton)
            val downButton: View = findViewById(R.id.downButton)
            val leftButton: View = findViewById(R.id.leftButton)
            val rightButton: View = findViewById(R.id.rightButton)
            val changeSizeButton: View = findViewById(R.id.changeSize)
            val changeColorButton: View = findViewById(R.id.changeColor)

            upButton.setOnClickListener {
                square.moverArriba()
                updateView(sqView, square)
            }

            downButton.setOnClickListener {
                square.moverAbajo()
                updateView(sqView, square)
            }

            leftButton.setOnClickListener {
                square.moverIzquierda()
                updateView(sqView, square)
            }

            rightButton.setOnClickListener {
                square.moverDerecha()
                updateView(sqView, square)
            }

            changeColorButton.setOnClickListener {
                //square.color = ContextCompat.getColor(this, R.color.white)
                square.color = generarColorAleatorio()
                updateView(sqView, square)
            }

            changeSizeButton.setOnClickListener {
                square.cambiarTamanio(initWidth + 100, initHeight + 100)
                updateView(sqView, square)
            }

        }
    }

    fun updateView(sqView: View, square: Square){
        sqView.y = square.y.toFloat()
        sqView.x = square.x.toFloat()
        sqView.setBackgroundColor(square.color)
        sqView.layoutParams.width = square.ancho
        sqView.layoutParams.height = square.alto

        // para que se ejecuten los cambios (asegurar)
        sqView.requestLayout()
    }

    fun generarColorAleatorio(): Int{
        //Generar numeros aleatorios
        val random = Random.Default

        //asignar valores comprendidos entre 0 y 255 RGB
        val rojo = random.nextInt(256)
        val verde = random.nextInt(256)
        val azul = random.nextInt(256)

        return Color.rgb(rojo, verde, azul)
    }
}