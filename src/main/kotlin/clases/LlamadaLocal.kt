package clases

import java.time.LocalDateTime
import java.util.*

class LlamadaLocal(duracion:Int, fecha: LocalDateTime, ubicacionDestino:Ubicacion): Llamada(duracion,fecha,ubicacionDestino) {

    val diasHabiles:List<String> = listOf("MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY")
    val horariosHabiles: List<Int> = listOf(8,20)

    override fun costoPorMinuto(): Double {
        val diaDeLaLlamada = fecha.dayOfWeek.name
        val horaDeLaLlamada = fecha.hour
        var costoMinuto: Double
        if(seRealizoDiaYHorarioHabiles(diaDeLaLlamada,horaDeLaLlamada)) {
            costoMinuto = 0.20
        }else{
            costoMinuto = 0.10
        }
        return costoMinuto
    }

    private fun seRealizoDiaYHorarioHabiles(dia:String,hora:Int):Boolean{
        return seRealizoDiaHabil(dia) && seRealizoHorarioHabil(hora)
    }

    private fun seRealizoDiaHabil(dia: String):Boolean{
        return diasHabiles.contains(dia)
    }

    private fun seRealizoHorarioHabil(hora:Int):Boolean{
        val inicioHoraHabil = horariosHabiles[0]
        val finHoraHabil = horariosHabiles[1]
        return hora in inicioHoraHabil..finHoraHabil
    }
}