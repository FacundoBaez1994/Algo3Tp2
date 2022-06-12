package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestVehiculo {
        /*
    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadaEnTresMovimientos () {
        Direccion unaDireccion = new Derecha ();
        Posicion unaPosicion = new PosicionComun();
        Posicion otraPosicion = new PosicionComun();
        Calle unaCalle = new CalleComun(unaPosicion, otraPosicion, new Pozo());
        unaPosicion.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unaMoto = new Vehiculo (new Moto() , unaPosicion);
        unaMoto.moverseHacia (unaDireccion);
        assertEquals(unaMoto.getCantidadDeMovimientos(), 3 + 1);
    }

    @Test
    public void unAutoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadaEnTresMovimientos () {

        Direccion unaDireccion = new Derecha ();
        Posicion unaPosicion = new PosicionComun();
        Posicion otraPosicion = new PosicionComun();
        Calle unaCalle = new CalleComun (unaPosicion, otraPosicion, new Pozo ());
        unaPosicion.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unAuto = new Vehiculo (new Auto() , unaPosicion);
        unAuto.moverseHacia (unaDireccion);
        assertEquals(unAuto.getCantidadDeMovimientos(), 3 + 1);
    }

    @Test
    public void Una4x4AtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada () {

        Direccion unaDireccion = new Derecha ();
        Posicion unaPosicion = new PosicionComun();
        Posicion otraPosicion = new PosicionComun();
        Calle unaCalle = new CalleComun (unaPosicion, otraPosicion, new Pozo ());
        unaPosicion.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unaCuatroPorCuatro = new Vehiculo (new CuatroPorCuatro() , unaPosicion);
        unaCuatroPorCuatro.moverseHacia (unaDireccion);
        assertEquals (unaCuatroPorCuatro.getCantidadDeMovimientos(), 1);
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYSeEncuentraConUnPiqueteNoPuedePasar () {

        Direccion unaDireccion = new Derecha ();
        Posicion unaPosicion = new PosicionComun();
        Posicion otraPosicion = new PosicionComun();
        Calle unaCalle = new CalleComun (unaPosicion, otraPosicion, new Piquete());
        unaPosicion.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unAuto = new Vehiculo (new Auto () , unaPosicion);


        Executable task = () -> {
            unAuto.moverseHacia (unaDireccion);
        };

        assertThrows (VehiculoNoPuedePasar.class, task);
    }


    @Test
    public void Una4x4Atraviesa3PozosYEsPenalizadaCon3Movimientos () {

        Direccion unaDireccion = new Derecha ();

        Posicion unaPosicion = new PosicionComun();
        Vehiculo unaCuatroPorCuatro = new Vehiculo (new CuatroPorCuatro () , unaPosicion);
        for (int i = 0; i < 3; i++ ){
            Posicion otraPosicion = new PosicionComun();
            Calle unaCalle = new CalleComun (unaPosicion, otraPosicion, new Pozo());
            unaPosicion.setearCalleEnDireccion(unaCalle, unaDireccion);
            unaCuatroPorCuatro.moverseHacia (unaDireccion);
            unaPosicion = otraPosicion;
        }

        assertEquals (unaCuatroPorCuatro.getCantidadDeMovimientos(), 3 + 2);
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable () {
        Direccion unaDireccion = new Derecha ();
        Posicion unaPosicion = new PosicionComun();
        Posicion otraPosicion = new PosicionComun();
        Calle unaCalle = new CalleComun (unaPosicion, otraPosicion, new SorpresaFavorable());
        unaPosicion.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unAuto = new Vehiculo (new Auto() , unaPosicion);
        unAuto.setCantidadDeMovimientos(9);
        unAuto.moverseHacia (unaDireccion);
        assertEquals(unAuto.getCantidadDeMovimientos(), 8);
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaNoFavorable () {
        Direccion unaDireccion = new Derecha ();
        Posicion unaPosicion = new PosicionComun();
        Posicion otraPosicion = new PosicionComun();
        Calle unaCalle = new CalleComun (unaPosicion, otraPosicion, new SorpresaNoFavorable());
        unaPosicion.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unAuto = new Vehiculo (new Auto() , unaPosicion);
        unAuto.setCantidadDeMovimientos(9);
        unAuto.moverseHacia (unaDireccion);
        assertEquals(unAuto.getCantidadDeMovimientos(), 13);
    }

    @Test
    public void UnaMotoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo () {
        Direccion unaDireccion = new Derecha ();
        Posicion unaPosicion = new PosicionComun();
        Posicion otraPosicion = new PosicionComun();
        Calle unaCalle = new CalleComun (unaPosicion, otraPosicion, new CambioDeVehiculo());
        unaPosicion.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unaMoto = new Vehiculo (new Moto() , unaPosicion);
        unaMoto.moverseHacia (unaDireccion);
        assertTrue((unaMoto.getTipoDeVehiculo ()).getClass().equals(((new Auto()).getClass())));
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo () {
        Direccion unaDireccion = new Derecha ();
        Posicion unaPosicion = new PosicionComun();
        Posicion otraPosicion = new PosicionComun();
        Calle unaCalle = new CalleComun (unaPosicion, otraPosicion, new CambioDeVehiculo());
        unaPosicion.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unAuto= new Vehiculo (new Auto() , unaPosicion);
        unAuto.moverseHacia (unaDireccion);
        assertTrue((unAuto.getTipoDeVehiculo ()).getClass().equals(((new CuatroPorCuatro()).getClass())));
    }

    @Test
    public void Una4x4AtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo () {
        Direccion unaDireccion = new Derecha ();
        Posicion unaPosicion = new PosicionComun();
        Posicion otraPosicion = new PosicionComun();
        Calle unaCalle = new CalleComun (unaPosicion, otraPosicion, new CambioDeVehiculo());
        unaPosicion.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unaCuatroPorCuatro= new Vehiculo (new CuatroPorCuatro() , unaPosicion);
        unaCuatroPorCuatro.moverseHacia (unaDireccion);
        assertTrue((unaCuatroPorCuatro.getTipoDeVehiculo ()).getClass().equals(((new Moto()).getClass())));
    }

         */
}
