package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.NoObstaculo;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.vehiculo.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import static org.mockito.Mockito.mock;

public class TestObstaculo {
    @Test
    public void pozoCalculaLaPenalizacionDeAuto(){
        TipoDeVehiculo unAuto = mock(Auto.class);
        Pozo unPozo = new Pozo();

        unPozo.calcularPenalizacion(unAuto);
        verify(unAuto, times (1)).calcularPenalizacion(unPozo);
    }
    @Test
    public void pozoCalculaPenalizacionDeMoto(){
        TipoDeVehiculo unaMoto = mock(Moto.class);
        Pozo unPozo = new Pozo();

        unPozo.calcularPenalizacion(unaMoto);
        verify(unaMoto, times (1)).calcularPenalizacion(unPozo);
    }
    @Test
    public void pozoCalculaPenalizacionDeCuatroPorCuatro(){
        TipoDeVehiculo unaCuatroPorCuatro = mock(CuatroPorCuatro.class);
        Pozo unPozo = new Pozo();

        unPozo.calcularPenalizacion(unaCuatroPorCuatro);
        verify(unaCuatroPorCuatro, times (1)).calcularPenalizacion(unPozo);
    }
    @Test
    public void piqueteCalculaPenalizacionDeCuatroPorCuatro(){
        TipoDeVehiculo unaCuatroPorCuatro = mock(CuatroPorCuatro.class);
        Piquete unPiquete = new Piquete();

        unPiquete.calcularPenalizacion(unaCuatroPorCuatro);
        verify(unaCuatroPorCuatro, times (1)).calcularPenalizacion(unPiquete);
    }
    @Test
    public void controlPolicialCalculaPenalizacionDeCuatroPorCuatro(){
        TipoDeVehiculo unaCuatroPorCuatro = mock(CuatroPorCuatro.class);
        ControlPolicial unControlPolicial = new ControlPolicial();

        unControlPolicial.calcularPenalizacion(unaCuatroPorCuatro);
        verify(unaCuatroPorCuatro, times (1)).calcularPenalizacion(unControlPolicial);
    }
    @Test
    public void noObstaculoCalculaPenalizacionDeCuatroPorCuatro(){
        TipoDeVehiculo unaCuatroPorCuatro = mock(CuatroPorCuatro.class);
        NoObstaculo unNoObstaculo = new NoObstaculo();

        unNoObstaculo.calcularPenalizacion(unaCuatroPorCuatro);
        assertEquals( unNoObstaculo.calcularPenalizacion(unaCuatroPorCuatro), 0);
    }
}
