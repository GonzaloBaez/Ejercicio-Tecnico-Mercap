import clases.LlamadaInternacional
import clases.LlamadaLocal
import clases.LlamadaNacional
import clases.Ubicacion
import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime
import java.time.Month

class LlamadaNoLocalTest {

    @Test
    fun seRealizaUnaLlamadaInternacionalAPeru(){
        val ubicacion = Ubicacion("Peru",1.0)


        val fechaDeLlamada = LocalDateTime.of(2020,Month.NOVEMBER,2,3,14)
        val llamada = LlamadaInternacional(15,fechaDeLlamada,ubicacion)

        Assert.assertEquals(1.0,llamada.costoPorMinuto(),1e-15)
        Assert.assertEquals(15.0,llamada.costoTotal(),1e-15)
        Assert.assertEquals("Peru",llamada.ubicacionDestino.nombre)
    }
    @Test
    fun seRealizaUnaLlamadaInternacionalAEU(){
        val ubicacion = Ubicacion("Eu",10.0)


        val fechaDeLlamada = LocalDateTime.of(2020,Month.NOVEMBER,2,3,14)
        val llamada = LlamadaInternacional(20,fechaDeLlamada,ubicacion)

        Assert.assertEquals(10.0,llamada.costoPorMinuto(),1e-15)
        Assert.assertEquals(200.0,llamada.costoTotal(),1e-15)
        Assert.assertEquals("Eu",llamada.ubicacionDestino.nombre)
    }

    @Test
    fun seRealizaUnaLlamadaNacionalAMendoza(){
        val ubicacion = Ubicacion("Mendoza",0.5)


        val fechaDeLlamada = LocalDateTime.of(2020,Month.NOVEMBER,2,3,14)
        val llamada = LlamadaNacional(30,fechaDeLlamada,ubicacion)

        Assert.assertEquals(0.5,llamada.costoPorMinuto(),1e-15)
        Assert.assertEquals(15.0,llamada.costoTotal(),1e-15)
        Assert.assertEquals("Mendoza",llamada.ubicacionDestino.nombre)
    }

    @Test
    fun seRealizaUnaLlamadaNacionalARioNegro(){
        val ubicacion = Ubicacion("Mendoza",0.7)


        val fechaDeLlamada = LocalDateTime.of(2020,Month.NOVEMBER,2,3,14)
        val llamada = LlamadaNacional(50,fechaDeLlamada,ubicacion)

        Assert.assertEquals(0.7,llamada.costoPorMinuto(),1e-15)
        Assert.assertEquals(35.0,llamada.costoTotal(),1e-15)
        Assert.assertEquals("Mendoza",llamada.ubicacionDestino.nombre)
    }
}