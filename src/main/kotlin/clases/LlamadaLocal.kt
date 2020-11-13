package clases

import java.util.*

class LlamadaLocal(duracion:Int, fecha: Date, ubicacionDestino:Ubicacion): Llamada(duracion,fecha,ubicacionDestino) {
    override fun costoPorMinuto(): Double {
        return 0.0
    }
}