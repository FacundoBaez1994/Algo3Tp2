package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.esquina.Calle;
import edu.fiuba.algo3.modelo.esquina.CalleComun;
import edu.fiuba.algo3.modelo.esquina.Esquina;
import edu.fiuba.algo3.modelo.esquina.EsquinaComun;
import edu.fiuba.algo3.modelo.excepciones.VehiculoNoPuedePasar;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaNoFavorable;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import edu.fiuba.algo3.modelo.direcciones.Derecha;
import edu.fiuba.algo3.modelo.direcciones.Direccion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestVehiculo {
    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadaEnTresMovimientos () {
        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new CalleComun(unaEsquina, otraEsquina, new Pozo());
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
        Vehiculo unAuto = new Vehiculo (new Auto() , unaEsquina);
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
        Vehiculo unaCuatroPorCuatro = new Vehiculo (new CuatroPorCuatro() , unaEsquina);
        unaCuatroPorCuatro.moverseHacia (unaDireccion);
        assertEquals (unaCuatroPorCuatro.getCantidadDeMovimientos(), 1);
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYSeEncuentraConUnPiqueteNoPuedePasar () {

        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun ();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new CalleComun (unaEsquina, otraEsquina, new Piquete());
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

    @Test
    public void UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable () {
        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun ();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new CalleComun (unaEsquina, otraEsquina, new SorpresaFavorable());
        unaEsquina.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unAuto = new Vehiculo (new Auto() , unaEsquina);
        unAuto.setCantidadDeMovimientos(9);
        unAuto.moverseHacia (unaDireccion);
        assertEquals(unAuto.getCantidadDeMovimientos(), 8);
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaNoFavorable () {
        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun ();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new CalleComun (unaEsquina, otraEsquina, new SorpresaNoFavorable());
        unaEsquina.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unAuto = new Vehiculo (new Auto() , unaEsquina);
        unAuto.setCantidadDeMovimientos(9);
        unAuto.moverseHacia (unaDireccion);
        assertEquals(unAuto.getCantidadDeMovimientos(), 13);
    }

    @Test
    public void UnaMotoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo () {
        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun ();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new CalleComun (unaEsquina, otraEsquina, new CambioDeVehiculo());
        unaEsquina.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unaMoto = new Vehiculo (new Moto() , unaEsquina);
        unaMoto.moverseHacia (unaDireccion);
        assertTrue((unaMoto.getTipoDeVehiculo ()).getClass().equals(((new Auto()).getClass())));
    }

    @Test
    public void UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo () {
        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun ();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new CalleComun (unaEsquina, otraEsquina, new CambioDeVehiculo());
        unaEsquina.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unAuto= new Vehiculo (new Auto() , unaEsquina);
        unAuto.moverseHacia (unaDireccion);
        assertTrue((unAuto.getTipoDeVehiculo ()).getClass().equals(((new CuatroPorCuatro()).getClass())));
    }

    @Test
    public void Una4x4AtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo () {
        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun ();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new CalleComun (unaEsquina, otraEsquina, new CambioDeVehiculo());
        unaEsquina.setearCalleEnDireccion (unaCalle, unaDireccion);
        Vehiculo unaCuatroPorCuatro= new Vehiculo (new CuatroPorCuatro() , unaEsquina);
        unaCuatroPorCuatro.moverseHacia (unaDireccion);
        assertTrue((unaCuatroPorCuatro.getTipoDeVehiculo ()).getClass().equals(((new Moto()).getClass())));
    }
}
