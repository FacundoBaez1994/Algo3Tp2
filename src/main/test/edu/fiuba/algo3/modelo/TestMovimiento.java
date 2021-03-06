package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.PosicionFueraDeLimite;
import edu.fiuba.algo3.modelo.excepciones.VehiculoNoPuedePasar;
import edu.fiuba.algo3.modelo.movimiento.Movimiento;
import edu.fiuba.algo3.modelo.movimiento.MovimientoComun;
import edu.fiuba.algo3.modelo.movimiento.direcciones.*;
import edu.fiuba.algo3.modelo.posicion.Posicion;

import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TestMovimiento {

    @Test
    public void unVehiculoSeMueveHaciaLaDerechaSuPosicionSeModifico  () {
        Posicion unaPosicion = new Posicion(1,1);
        Vehiculo unVehiculo = new Vehiculo(new Moto(), unaPosicion);
        Posicion unaPosicionFinal = new Posicion(2,1);
        Movimiento unMovimiento = new MovimientoComun(new Derecha());
        unMovimiento.moverse ( unVehiculo);
        assertTrue (unVehiculo.getPosicion().igualA(unaPosicionFinal));
    }

    @Test
    public void unVehiculoSeMueveHaciaLaIzquierdaSuPosicionSeModifico() {
        Posicion unaPosicion = new Posicion(2,2);
        Vehiculo unVehiculo = new Vehiculo(new Moto(), unaPosicion);
        Posicion unaPosicionFinal = new Posicion(1,2);
        Movimiento unMovimiento = new MovimientoComun(new Izquierda());
        unMovimiento.moverse ( unVehiculo);
        assertTrue (unVehiculo.getPosicion().igualA(unaPosicionFinal));
    }
    @Test
    public void unVehiculoSeMueveHaciaArribaSuPosicionSeModifico() {
        Posicion unaPosicion = new Posicion(1,1);
        Vehiculo unVehiculo = new Vehiculo(new Moto(), unaPosicion);
        Posicion unaPosicionFinal = new Posicion(1,2);
        Movimiento unMovimiento = new MovimientoComun(new Arriba());
        unMovimiento.moverse ( unVehiculo);
        assertTrue (unVehiculo.getPosicion().igualA(unaPosicionFinal));
    }
    @Test
    public void unVehiculoSeMueveHaciaAbajoSuPosicionSeModifico() {
        Posicion unaPosicion = new Posicion(2,2);
        Vehiculo unVehiculo = new Vehiculo(new Moto(), unaPosicion);
        Posicion unaPosicionFinal = new Posicion(2,1);
        Movimiento unMovimiento = new MovimientoComun(new Abajo());
        unMovimiento.moverse ( unVehiculo);
        assertTrue (unVehiculo.getPosicion().igualA(unaPosicionFinal));
    }

    @Test
    public void unVehiculoSeMueveFueraDeLosLimitesDeLaGrillaYDevuelveExcepcion() {
        Posicion unaPosicion = new Posicion(0,1);
        Vehiculo unVehiculo = new Vehiculo(new Moto(), unaPosicion);
        Movimiento unMovimiento = new MovimientoComun(new Izquierda());

        Executable task = () -> {
            unMovimiento.moverse ( unVehiculo);
        };
        assertThrows (PosicionFueraDeLimite.class, task);
        assertTrue (unVehiculo.getPosicion().igualA(unaPosicion));
    }
    @Test
    public void unVehiculoSeMueveFueraDeLosLimitesMaximosDeLaGrillaYDevuelveExcepcion() {
        Posicion unaPosicion = new Posicion(20,1);
        Vehiculo unVehiculo = new Vehiculo(new Moto(), unaPosicion);
        Movimiento unMovimiento = new MovimientoComun(new Derecha());

        Executable task = () -> {
            unMovimiento.moverse ( unVehiculo);
        };
        assertThrows (PosicionFueraDeLimite.class, task);
        assertTrue (unVehiculo.getPosicion().igualA(unaPosicion));
    }

}