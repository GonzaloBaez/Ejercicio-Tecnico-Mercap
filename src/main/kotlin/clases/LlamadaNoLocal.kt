package clases

import java.util.*

abstract class LlamadaNoLocal(duracion:Int, fecha: Date, ubicacionDestino:Ubicacion): Llamada(duracion,fecha,ubicacionDestino) {


    override fun costoPorMinuto(): Double {
        return ubicacionDestino.getValorDeLlamada()
    }
}