package clases

import java.time.LocalDateTime
import java.util.*

abstract class LlamadaNoLocal(duracion:Int, fecha: LocalDateTime, ubicacionDestino:Ubicacion): Llamada(duracion,fecha,ubicacionDestino) {


    override fun costoPorMinuto(): Double {
        return ubicacionDestino.getValorDeLlamada()
    }
}