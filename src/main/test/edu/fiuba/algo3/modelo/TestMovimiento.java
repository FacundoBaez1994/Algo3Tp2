package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.movimiento.Movimiento;
import edu.fiuba.algo3.modelo.movimiento.MovimientoComun;
import edu.fiuba.algo3.modelo.movimiento.direcciones.*;
import edu.fiuba.algo3.modelo.posicion.Posicion;

import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class TestMovimiento {

    @Test
    public void unVehiculoSeMueveHaciaLaDerechaSuPosicionSeModifico  () {
        Vehiculo unVehiculo = mock(Vehiculo.class);
        Posicion unaPosicion = new Posicion(1,1);
        Posicion unaPosicionFinal = new Posicion(2,1);
        Movimiento unMovimiento = new MovimientoComun(new Derecha());
        Posicion otraPosicion = unMovimiento.moverseDesde( unaPosicion, unVehiculo);
        assertTrue (otraPosicion.igualA(unaPosicionFinal));
    }

    @Test
    public void unVehiculoSeMueveHaciaLaIzquierdaSuPosicionSeModifico  () {
        Vehiculo unVehiculo = mock(Vehiculo.class);
        Posicion unaPosicion = new Posicion(1,1);
        Posicion unaPosicionFinal = new Posicion(0,1);
        Movimiento unMovimiento = new MovimientoComun(new Izquierda());
        Posicion otraPosicion = unMovimiento.moverseDesde( unaPosicion, unVehiculo);
        assertTrue (otraPosicion.igualA(unaPosicionFinal));
    }

    @Test
    public void unVehiculoSeMueveHaciaArribaSuPosicionSeModifico  () {
        Vehiculo unVehiculo = mock(Vehiculo.class);
        Posicion unaPosicion = new Posicion(1,1);
        Posicion unaPosicionFinal = new Posicion(1,2);
        Movimiento unMovimiento = new MovimientoComun(new Arriba());
        Posicion otraPosicion = unMovimiento.moverseDesde( unaPosicion, unVehiculo);
        assertTrue (otraPosicion.igualA(unaPosicionFinal));
    }

    @Test
    public void unVehiculoSeMueveHaciaAbajoSuPosicionSeModifico  () {
        Vehiculo unVehiculo = mock(Vehiculo.class);
        Posicion unaPosicion = new Posicion(1,1);
        Posicion unaPosicionFinal = new Posicion(1,0);
        Movimiento unMovimiento = new MovimientoComun(new Abajo());
        Posicion otraPosicion = unMovimiento.moverseDesde( unaPosicion, unVehiculo);
        assertTrue (otraPosicion.igualA(unaPosicionFinal));
    }

}