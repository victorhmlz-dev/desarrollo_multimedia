package model

import com.example.square.R

class Square (var color: Int, var ancho: Int, var alto: Int){
    //coordenadas
    var x: Int = 0
    var y: Int = 0

    fun moverArriba(){
        y -= 10
    }

    fun moverAbajo(){
        y += 10
    }

    fun moverIzquierda(){
        x -= 10
    }

    fun moverDerecha(){
        x += 10
    }

    fun cambiarTamanio(nuevoAncho: Int, nuevoAlto: Int){
        ancho = nuevoAncho
        alto = nuevoAlto
    }

    fun cambiarColor(){
        color = R.color.white
    }

}