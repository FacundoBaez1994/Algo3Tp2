package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.*;
import edu.fiuba.algo3.modelo.excepciones.VehiculoNoPuedePasar;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.mockito.Mockito.*;

public class TestTipoDeVehiculo {
    @Test
    public void testUnaMotoSeEncuentraConUnPozo(){
        Pozo  unPozo = mock(Pozo.class);
        TipoDeVehiculo unaMoto = new Moto();
        assertEquals(unaMoto.calcularPenalizacion(unPozo), 3);
    }
    @Test
    public void testUnAutoSeEncuentraConUnPozo(){
        Pozo  unPozo = mock(Pozo.class);
        TipoDeVehiculo unAuto = new Auto();
        assertEquals(unAuto.calcularPenalizacion(unPozo), 3);
    }
    @Test
    public void testUnaCuatroPorCuatroSeEncuentraPorPrimeraVezConUnPozo(){
        Pozo  unPozo = mock(Pozo.class);
        TipoDeVehiculo unaCuatroPorCuatro = new CuatroPorCuatro();
        assertEquals(unaCuatroPorCuatro.calcularPenalizacion(unPozo), 0);
    }
    @Test
    public void testUnaCuatroPorCuatroSeEncuentraPorTerceraVezConUnPozo(){
        Pozo  unPozo = mock(Pozo.class);
        TipoDeVehiculo unaCuatroPorCuatro = new CuatroPorCuatro();

        assertEquals(unaCuatroPorCuatro.calcularPenalizacion(unPozo), 0);
        assertEquals(unaCuatroPorCuatro.calcularPenalizacion(unPozo), 0);
        assertEquals(unaCuatroPorCuatro.calcularPenalizacion(unPozo), 2);
    }
    @Test
    public void testUnaMotoSeEncuentraConUnPiquete(){
        Piquete  unPiquete = mock(Piquete.class);
        TipoDeVehiculo unaMoto = new Moto();
        assertEquals(unaMoto.calcularPenalizacion(unPiquete), 2);
    }
    @Test
    public void testUnAutoSeEncuentraConUnPiquete(){
        Piquete  unPiquete = mock(Piquete.class);
        TipoDeVehiculo unAuto = new Auto();
        Executable task = () -> {
            unAuto.calcularPenalizacion(unPiquete);
        };
        assertThrows (VehiculoNoPuedePasar.class, task);
    }
    @Test
    public void testUnCuatroPorCuatroSeEncuentraConUnPiquete(){
        Piquete  unPiquete = mock(Piquete.class);
        TipoDeVehiculo unCuatroPorCuatro = new CuatroPorCuatro();
        Executable task = () -> {
            unCuatroPorCuatro.calcularPenalizacion(unPiquete);
        };
        assertThrows (VehiculoNoPuedePasar.class, task);
    }

}
