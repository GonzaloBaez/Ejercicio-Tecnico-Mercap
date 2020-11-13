package clases

import java.time.LocalDateTime
import java.time.Month


abstract class Llamada(val duracion:Int,val fecha:LocalDateTime,val ubicacionDestino:Ubicacion) {


    fun costoTotal():Double{
        return duracion * costoPorMinuto()
    }

    fun esDelMesYAnioDeFacturacion(mesFacturacion:Month,anioFacturacion:Int):Boolean{
        val mesLlamada = fecha.month.name
        val anioLlamada = fecha.year

        return anioLlamada==anioFacturacion && mesLlamada == mesFacturacion.name
    }

    abstract fun costoPorMinuto():Double

    fun toShow():String{
        return(
            "---------------------------------------------------------------------\n" +
            "Duracion: $duracion min \t " +
            "Destino de llamada: ${ubicacionDestino.nombre} \t" +
            "Total: ${costoTotal()}$\n")

    }
}
