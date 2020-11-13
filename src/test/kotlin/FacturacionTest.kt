import clases.*
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime
import java.time.Month
import java.util.*


class FacturacionTest {

    lateinit var ubicacion1:Ubicacion
    lateinit var fechaDeLlamada1:LocalDateTime
    lateinit var llamada1:Llamada

    lateinit var ubicacion2 :Ubicacion
    lateinit var fechaDeLlamada2 :LocalDateTime
    lateinit var llamada2:Llamada

    lateinit var ubicacion3:Ubicacion
    lateinit var fechaDeLlamada3:LocalDateTime
    lateinit var llamada3:Llamada

    lateinit var ubicacion4 :Ubicacion
    lateinit var fechaDeLlamada4 :LocalDateTime
    lateinit var llamada4:Llamada

    lateinit var ubicacion5:Ubicacion
    lateinit var fechaDeLlamada5:LocalDateTime
    lateinit var llamada5:Llamada

    lateinit var ubicacion6 :Ubicacion
    lateinit var fechaDeLlamada6 :LocalDateTime
    lateinit var llamada6:Llamada

    lateinit var cliente:Cliente

    @Before
    fun setUp(){
         ubicacion1 = Ubicacion("Mendoza",0.5)
         fechaDeLlamada1 = LocalDateTime.of(2020, Month.JANUARY,2,3,14)
         llamada1 = LlamadaNacional(30,fechaDeLlamada1,ubicacion1) // valor 15

         ubicacion2 = Ubicacion("Eu",10.0)
         fechaDeLlamada2 = LocalDateTime.of(2020,Month.JANUARY,2,3,14)
         llamada2 = LlamadaInternacional(20,fechaDeLlamada2,ubicacion2) //valor 200

        ubicacion3 = Ubicacion("Quilmes",1.0)
        fechaDeLlamada3 = LocalDateTime.of(2020,Month.NOVEMBER,13,21,14)
        llamada3 = LlamadaLocal(10,fechaDeLlamada3,ubicacion3) //valor 1

        ubicacion4 = Ubicacion("Quilmes",1.0)
        fechaDeLlamada4 = LocalDateTime.of(2020,Month.NOVEMBER,13,8,0)
        llamada4 = LlamadaLocal(1000,fechaDeLlamada4,ubicacion4) //valor 200

        cliente = Cliente("Juan")
    }
    @Test
    fun gastoTotalDeClienteEnEnero(){
        cliente.agregarLlamada(llamada1)
        cliente.agregarLlamada(llamada2)

        val facturacionEneroJuan = Facturacion(cliente,500.0,Month.JANUARY,2020)

        Assert.assertEquals(715.0,facturacionEneroJuan.realizarFacturacion(),1e-15)
        mostrarFactura(facturacionEneroJuan)
    }

    @Test
    fun gastoTotalDeClienteEnMarzo(){
        cliente.agregarLlamada(llamada1)
        cliente.agregarLlamada(llamada2)

        //el cliente no realizo llamadas en marzo

        val facturacionEneroJuan = Facturacion(cliente,500.0,Month.MARCH,2020)

        Assert.assertEquals(500.0,facturacionEneroJuan.realizarFacturacion(),1e-15)
        mostrarFactura(facturacionEneroJuan)
    }

    @Test
    fun gastoTotalDelClienteEnNoviembre(){
        cliente.agregarLlamada(llamada1)
        cliente.agregarLlamada(llamada3)
        cliente.agregarLlamada(llamada2)
        cliente.agregarLlamada(llamada4)

        val facturacionEneroJuan = Facturacion(cliente,300.0,Month.NOVEMBER,2020)

        Assert.assertEquals(501.0,facturacionEneroJuan.realizarFacturacion(),1e-15)

        mostrarFactura(facturacionEneroJuan)
    }

    fun mostrarFactura(facturacion: Facturacion){

        println("/--------------------------------------------------------------------/")
        println("Cliente: ${facturacion.cliente.nombre} \t" +
                "Mes:${facturacion.mesDeFacturacion} \t" +
                "Año: ${facturacion.anioDeFacturacion}\n\n" +
                "Historial de llamadas")
        val llamadasDelMesDeFacturacion = facturacion.cliente.llamadasRealizadas.filter { llamada -> llamada.fecha.month == facturacion.mesDeFacturacion   }
        llamadasDelMesDeFacturacion.forEach() { llamada->print(llamada.toShow()) }

        println("\nValor abono mensual: ${facturacion.valorAbonoMensual}$\n")
        println("\nTotal: ${facturacion.realizarFacturacion()}$")

        println("\n/--------------------------------------------------------------------/\n\n\n")
    }
}