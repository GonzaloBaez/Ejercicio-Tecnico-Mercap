import clases.LlamadaLocal
import clases.Ubicacion
import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime
import java.time.Month

class LlamadaLocalTest {


    @Test
    fun seRealizadaUnaLlamadaEnHorarioNoHabilYDiaHabil(){
        val ubicacion = Ubicacion("quilmes",1.0)

        // se realizo un viernes, dia habil, pero fuera del horario habil
        val fechaDeLlamada = LocalDateTime.of(2020,Month.NOVEMBER,13,21,14)
        val llamada = LlamadaLocal(10,fechaDeLlamada,ubicacion)

        Assert.assertEquals(0.10,llamada.costoPorMinuto(),1e-15)
        Assert.assertEquals(1.0,llamada.costoTotal(),1e-15)
    }

    @Test
    fun seRealizadaUnaLlamadaEnDiaNoHabilYHorarioHabil(){
        val ubicacion = Ubicacion("quilmes",1.0)

        // se realizo un viernes, dia habil, pero fuera del horario habil
        val fechaDeLlamada = LocalDateTime.of(2020,Month.NOVEMBER,14,8,14)
        val llamada = LlamadaLocal(100,fechaDeLlamada,ubicacion)

        Assert.assertEquals(0.10,llamada.costoPorMinuto(),1e-15)
        Assert.assertEquals(10.0,llamada.costoTotal(),1e-15)
    }

    @Test
    fun seRealizadaUnaLlamadaEnDiaHabilYHorarioHabil(){
        val ubicacion = Ubicacion("quilmes",1.0)

        // se realizo un viernes, dia habil, pero fuera del horario habil
        val fechaDeLlamada = LocalDateTime.of(2020,Month.NOVEMBER,13,8,0)
        val llamada = LlamadaLocal(1000,fechaDeLlamada,ubicacion)

        Assert.assertEquals(0.20,llamada.costoPorMinuto(),1e-15)
        Assert.assertEquals(200.0,llamada.costoTotal(),1e-15)
    }
}