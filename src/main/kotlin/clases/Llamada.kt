package clases

import java.time.LocalDateTime
import java.util.*

abstract class Llamada(val duracion:Int,val fecha:LocalDateTime,val ubicacionDestino:Ubicacion) {


    fun costoTotal():Double{
        return duracion * costoPorMinuto()
    }

    abstract fun costoPorMinuto():Double
}
