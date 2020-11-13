package clases

import java.util.*

abstract class Llamada(val duracion:Int,val fecha:Date,val ubicacionDestino:Ubicacion) {


    fun costoTotal():Double{
        return duracion * costoPorMinuto()
    }

    abstract fun costoPorMinuto():Double
}
