package edu.fiuba.algo3.modelo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaNoFavorable;
import org.junit.jupiter.api.BeforeEach;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Derecha;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

public class TestEntrega2 {

    @BeforeEach
    public void reiniciarTablero ()  {
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.reiniciar ();
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable () {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(0,0);
        Vehiculo unAuto = new Vehiculo (new Auto() , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new SorpresaFavorable (new Posicion(1,0)));
        unAuto.setCantidadDeMovimientos(100);

        unAuto.moverseHacia (unaDireccion);

        assertEquals(unAuto.getCantidadDeMovimientos(), 100 - 20 + 1);
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaNoFavorable () {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(0,0);
        Vehiculo unAuto = new Vehiculo (new Auto() , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new SorpresaNoFavorable(new Posicion(1,0)));
        unAuto.setCantidadDeMovimientos(100);

        unAuto.moverseHacia (unaDireccion);

        assertEquals(unAuto.getCantidadDeMovimientos(), 100 + 25 + 1);
    }

    @Test
    public void UnaMotoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo () {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(0,0);
        Vehiculo unaMoto = new Vehiculo (new Moto () , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new CambioDeVehiculo(new Posicion(1,0)));

        unaMoto.moverseHacia (unaDireccion);

        assertTrue((unaMoto.getTipoDeVehiculo ()).getClass().equals(((new Auto()).getClass())));
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo  () {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(0,0);
        Vehiculo unAuto = new Vehiculo (new Auto () , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new CambioDeVehiculo(new Posicion(1,0)));

        unAuto.moverseHacia (unaDireccion);

        assertTrue((unAuto.getTipoDeVehiculo ()).getClass().equals(((new CuatroPorCuatro()).getClass())));
    }

    @Test
    public void Una4x4AtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo () {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(0,0);
        Vehiculo una4x4 = new Vehiculo (new CuatroPorCuatro () , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new CambioDeVehiculo(new Posicion(1,0)));

        una4x4 .moverseHacia (unaDireccion);

        assertTrue((una4x4.getTipoDeVehiculo ()).getClass().equals(((new Moto()).getClass())));
    }
}
