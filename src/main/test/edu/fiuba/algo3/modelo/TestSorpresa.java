package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaNoFavorable;
import edu.fiuba.algo3.modelo.vehiculo.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

public class TestSorpresa {
    @Test
    public void testUnVehiculoSeEncuentraUnaSorpresaFavorable(){
        Vehiculo unVehiculo = mock(Vehiculo.class);
        SorpresaFavorable unaSorpresa = new SorpresaFavorable();
        unaSorpresa.serEncontradaPor(unVehiculo);
        verify(unVehiculo, times(1)).disminuirCantidadMovimientosEnPorcentaje(20);
    }
    @Test
    public void testUnVehiculoSeEncuentraUnaSorpresaNoFavorable(){
        Vehiculo unVehiculo = mock(Vehiculo.class);
        SorpresaNoFavorable unaSorpresa = new SorpresaNoFavorable();
        unaSorpresa.serEncontradaPor(unVehiculo);
        verify(unVehiculo, times(1)).aumentarCantidadMovimientosEnPorcentaje(25);
    }
    @Test
    public void testUnVehiculoSeEncuentraUnaSorpresaCambioVehiculo(){
        Vehiculo unVehiculo = mock(Vehiculo.class);
        CambioDeVehiculo unaSorpresa = new CambioDeVehiculo();
        unaSorpresa.serEncontradaPor(unVehiculo);
        verify(unVehiculo, times(1)).proximoVehiculo();
    }
}
