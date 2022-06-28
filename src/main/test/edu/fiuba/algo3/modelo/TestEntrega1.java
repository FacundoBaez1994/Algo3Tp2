package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.modelo.grilla.Grilla;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import edu.fiuba.algo3.modelo.excepciones.VehiculoNoPuedePasar;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Derecha;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

public class TestEntrega1 {

    @BeforeEach
    public void reiniciarTablero ()  {
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.reiniciar ();
    }
    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadaEnTresMovimientos () {
        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(1,1);
        Posicion otraPosicion = new Posicion(2,1);
        Vehiculo unaMoto = new Vehiculo (new Moto() , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new Pozo(otraPosicion));
        unaMoto.moverseHacia (unaDireccion);
        assertEquals(unaMoto.getCantidadDeMovimientos(), 3 + 1);
    }

    @Test
    public void unAutoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadaEnTresMovimientos () {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(2,2);
        Posicion otraPosicion = new Posicion(3,2);
        Vehiculo unAuto = new Vehiculo (new Auto() , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new Pozo(otraPosicion));
        unAuto.moverseHacia (unaDireccion);
        assertEquals(unAuto.getCantidadDeMovimientos(), 3 + 1);
    }

    @Test
    public void Una4x4AtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada () {
        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(1,1);
        Posicion otraPosicion = new Posicion(2,1);
        Vehiculo una4x4 = new Vehiculo (new CuatroPorCuatro() , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new Pozo(otraPosicion));

        una4x4.moverseHacia (unaDireccion);

        assertEquals(una4x4.getCantidadDeMovimientos(),  1);
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYSeEncuentraConUnPiqueteNoPuedePasar () {

        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(0,1);
        Posicion otraPosicion = new Posicion(1,1);
        Vehiculo unAuto = new Vehiculo (new Auto () , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new Piquete(otraPosicion));

        Executable task = () -> {
            unAuto.moverseHacia (unaDireccion);
        };

        assertThrows (VehiculoNoPuedePasar.class, task);
    }

    @Test
    public void Una4x4Atraviesa3PozosYEsPenalizadaCon2Movimientos () {
        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(1,1);
        Vehiculo una4x4 = new Vehiculo (new CuatroPorCuatro () , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();

        for (int i = 2; i <= 6; i = i + 2 ){
            unaGrilla.agregarUbicable(new Pozo(new Posicion(i,1)));
        };
        for (int i = 0; i < 3; i++ ){
            una4x4.moverseHacia (unaDireccion);
        };

        assertEquals (una4x4.getCantidadDeMovimientos(), 3 + 2);
    }



}
