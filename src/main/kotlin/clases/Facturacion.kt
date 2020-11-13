package clases

import java.util.*

class Facturacion(var valorAbonoMensual:Double) {

    var llamadasRealizadas:MutableList<Llamada> = mutableListOf()


    fun realizarFacturacion():Double{
        var costoParcial = 0.0
        for(llamada in llamadasRealizadas){
            costoParcial += llamada.costoTotal()
        }
        return costoParcial
    }

    fun agregarLlamadaNueva(llamada:Llamada){
        llamadasRealizadas.add(llamada)
    }
}