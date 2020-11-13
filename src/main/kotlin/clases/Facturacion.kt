package clases

import java.time.Month
import java.util.*

class Facturacion(val cliente: Cliente,var valorAbonoMensual:Double,val mesDeFacturacion: Month,val anioDeFacturacion:Int) {




    fun realizarFacturacion():Double{
        var costoParcial = valorAbonoMensual
        for(llamada in cliente.llamadasRealizadas){
            costoParcial += costoDeLlamadaSiEsDelMes(llamada)
        }
        return costoParcial
    }


    private fun costoDeLlamadaSiEsDelMes(llamada: Llamada):Double{
        var costoParcial = 0.0
        if(llamadaEsDelMesYAnioDeFacturacion(llamada)){
            costoParcial += llamada.costoTotal()
        }
        return costoParcial
    }

    private fun llamadaEsDelMesYAnioDeFacturacion(llamada: Llamada):Boolean{
        return llamada.esDelMesYAnioDeFacturacion(mesDeFacturacion,anioDeFacturacion)
    }

}