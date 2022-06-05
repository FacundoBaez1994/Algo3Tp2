package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestVehiculo {
    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadaEnTresMovimientos () {
        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun ();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new CalleComun (unaEsquina, otraEsquina, new Pozo ());
        unaEsquina.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unaMoto = new Vehiculo (new Moto() , unaEsquina);
        unaMoto.moverseHacia (unaDireccion);
        assertEquals(unaMoto.getCantidadDeMovimientos(), 3 + 1);
    }

    @Test
    public void unAutoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadaEnTresMovimientos () {

        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun ();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new CalleComun (unaEsquina, otraEsquina, new Pozo ());
        unaEsquina.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unAuto = new Vehiculo (new Auto () , unaEsquina);
        unAuto.moverseHacia (unaDireccion);
        assertEquals(unAuto.getCantidadDeMovimientos(), 3 + 1);
    }

    @Test
    public void Una4x4AtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada () {

        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun ();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new CalleComun (unaEsquina, otraEsquina, new Pozo ());
        unaEsquina.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unaCuatroPorCuatro = new Vehiculo (new CuatroPorCuatro () , unaEsquina);
        unaCuatroPorCuatro.moverseHacia (unaDireccion);
        assertEquals (unaCuatroPorCuatro.getCantidadDeMovimientos(), 1);
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYSeEncuentraConUnPiqueteNoPuedePasar () {

        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun ();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new CalleComun (unaEsquina, otraEsquina, new Piquete ());
        unaEsquina.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unAuto = new Vehiculo (new Auto () , unaEsquina);


        Executable task = () -> {
            unAuto.moverseHacia (unaDireccion);
        };

        assertThrows (VehiculoNoPuedePasar.class, task);
    }


    @Test
    public void Una4x4Atraviesa3PozosYEsPenalizadaCon3Movimientos () {

        Direccion unaDireccion = new Derecha ();

        Esquina unaEsquina = new EsquinaComun();
        Vehiculo unaCuatroPorCuatro = new Vehiculo (new CuatroPorCuatro () , unaEsquina);
        for (int i = 0; i < 3; i++ ){
            Esquina otraEsquina = new EsquinaComun();
            Calle unaCalle = new CalleComun (unaEsquina, otraEsquina, new Pozo());
            unaEsquina.setearCalleEnDireccion(unaCalle, unaDireccion);
            unaCuatroPorCuatro.moverseHacia (unaDireccion);
            unaEsquina = otraEsquina;
        }

        assertEquals (unaCuatroPorCuatro.getCantidadDeMovimientos(), 3 + 2);
    }

}
