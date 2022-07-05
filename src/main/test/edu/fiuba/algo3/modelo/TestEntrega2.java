package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.excepciones.VehiculoNoPuedePasar;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaNoFavorable;
import edu.fiuba.algo3.modelo.sorpresa.Sorpressata;
import org.junit.jupiter.api.BeforeEach;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Derecha;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class TestEntrega2 {

    @BeforeEach
    public void reiniciarTablero ()  {
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.reiniciar ();
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable () {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(1,1);
        Vehiculo unAuto = new Vehiculo (new Auto() , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new SorpresaFavorable (new Posicion(2,1)));
        unAuto.setCantidadDeMovimientos(100);

        unAuto.moverseHacia (unaDireccion);

        assertEquals(unAuto.getCantidadDeMovimientos(), 100 - 20 + 1);
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaNoFavorable () {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(1,1);
        Vehiculo unAuto = new Vehiculo (new Auto() , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new SorpresaNoFavorable(new Posicion(2, 1)));
        unAuto.setCantidadDeMovimientos(100);

        unAuto.moverseHacia (unaDireccion);

        assertEquals(unAuto.getCantidadDeMovimientos(), 100 + 25 + 1);
    }

    @Test
    public void UnaMotoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo () {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(1,1);
        Vehiculo unaMoto = new Vehiculo (new Moto () , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new CambioDeVehiculo(new Posicion(2,1)));

        unaMoto.moverseHacia (unaDireccion);

        assertTrue((unaMoto.getTipoDeVehiculo ()).getClass().equals(((new Auto()).getClass())));
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo  () {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(1,1);
        Vehiculo unAuto = new Vehiculo (new Auto () , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new CambioDeVehiculo(new Posicion(2,1)));

        unAuto.moverseHacia (unaDireccion);

        assertTrue((unAuto.getTipoDeVehiculo ()).getClass().equals(((new CuatroPorCuatro()).getClass())));
    }

    @Test
    public void Una4x4AtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo () {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(1,1);
        Vehiculo una4x4 = new Vehiculo (new CuatroPorCuatro () , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new CambioDeVehiculo(new Posicion(2,1)));

        una4x4 .moverseHacia (unaDireccion);

        assertTrue((una4x4.getTipoDeVehiculo ()).getClass().equals(((new Moto()).getClass())));
    }

    @Test
    public void Una4x4ConCantidadDeMovimientosParAtraviesaLaCiudadYEncuentraUnaSorpressata() {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(1,1);
        Vehiculo una4x4 = new Vehiculo (new CuatroPorCuatro () , unaPosicion);
        una4x4.setCantidadDeMovimientos(2);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new Sorpressata(new Posicion(2,1)));
        una4x4.moverseHacia (unaDireccion);
        assertTrue((una4x4.getTipoDeVehiculo ()).getClass().equals(((new Moto()).getClass())));
    }

    @Test
    public void Una4x4ConCantidadDeMovimientosImparAtraviesaLaCiudadYEncuentraUnaSorpressata() {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(1,1);
        Vehiculo una4x4 = new Vehiculo (new CuatroPorCuatro () , unaPosicion);
        una4x4.setCantidadDeMovimientos(3);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new Sorpressata(new Posicion(2,1)));

        Executable task = () -> {
            una4x4.moverseHacia (unaDireccion);
        };

        assertThrows (VehiculoNoPuedePasar.class, task);
    }
}
