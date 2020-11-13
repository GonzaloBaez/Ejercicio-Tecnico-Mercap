package clases

class Cliente(val nombre:String){

    var llamadasRealizadas:MutableList<Llamada> = mutableListOf()

    fun agregarLlamada(llamada: Llamada){
        llamadasRealizadas.add(llamada)
    }
}