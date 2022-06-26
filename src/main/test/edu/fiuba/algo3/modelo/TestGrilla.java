package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;



import edu.fiuba.algo3.modelo.excepciones.LlegadaALaMeta;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.grilla.Meta;
import edu.fiuba.algo3.modelo.grilla.Ubicable;
import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaNoFavorable;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Derecha;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class TestGrilla {

    @BeforeEach
    public void reiniciarTablero ()  {
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.reiniciar ();
    }


    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConLaMeta () {
        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(0,0);
        Vehiculo unaMoto = new Vehiculo (new Moto() , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new Meta(new Posicion(2,0)));

        Executable task = () -> {
            unaMoto.moverseHacia (unaDireccion);
        };

        assertThrows (LlegadaALaMeta.class, task);
    }

    @Test
    public void SeGeneraControlPolicialEnUnaPosicionDeLaGrilla () {
        try (MockedStatic<Grilla> mocked = mockStatic(Grilla.class)) {
            Grilla mockedGrilla = spy (Grilla.class);
            mocked.when(Grilla::getInstance).thenReturn(mockedGrilla);
            when(mockedGrilla.generarNumeroRandom()).thenReturn(0.2);

            Ubicable unObstaculo = mockedGrilla.generarObstaculoRandomEn (new Posicion(3,3));

            assertTrue(unObstaculo.getClass().equals(((new ControlPolicial()).getClass())));
            assertTrue(unObstaculo.estaEnPosicion(new Posicion(3,3)));
        }
    }
    @Test
    public void SeGeneraUnPiqueteEnUnaPosicionDeLaGrilla () {
        try (MockedStatic<Grilla> mocked = mockStatic(Grilla.class)) {
            Grilla mockedGrilla = spy (Grilla.class);
            mocked.when(Grilla::getInstance).thenReturn(mockedGrilla);
            when(mockedGrilla.generarNumeroRandom()).thenReturn(0.5);

            Ubicable unObstaculo = mockedGrilla.generarObstaculoRandomEn (new Posicion(4,5));

            assertTrue(unObstaculo.getClass().equals(((new Piquete()).getClass())));
            assertTrue(unObstaculo.estaEnPosicion(new Posicion(4,5)));}
    }

    @Test
    public void SeGeneraUnPozoEnUnaPosicionDeLaGrilla () {
        try (MockedStatic<Grilla> mocked = mockStatic(Grilla.class)) {
            Grilla mockedGrilla0 = spy (Grilla.class);
            mocked.when(Grilla::getInstance).thenReturn(mockedGrilla0);
            when(mockedGrilla0.generarNumeroRandom()).thenReturn(0.9);

            Ubicable unObstaculo = mockedGrilla0.generarObstaculoRandomEn (new Posicion(6,7));

            assertTrue(unObstaculo.getClass().equals(((new Pozo()).getClass())));
            assertTrue(unObstaculo.estaEnPosicion(new Posicion(6,7)));}
    }

    @Test
    public void SeGeneraUnaSorpresaFavorableEnUnaPosicionDeLaGrilla () {
        try (MockedStatic<Grilla> mocked = mockStatic(Grilla.class)) {
            Grilla mockedGrilla2 = spy (Grilla.class);
            mocked.when(Grilla::getInstance).thenReturn(mockedGrilla2);
            when(mockedGrilla2.generarNumeroRandom()).thenReturn(0.2);

            Ubicable unaSorpresa = mockedGrilla2.generarSorpresaRandomEn(new Posicion(3,3));

            assertTrue(unaSorpresa.getClass().equals(((new SorpresaFavorable()).getClass())));
            assertTrue(unaSorpresa.estaEnPosicion(new Posicion(3,3)));
        }
    }

    @Test
    public void SeGeneraUnaSorpresaNoFavorableEnUnaPosicionDeLaGrilla () {
        try (MockedStatic<Grilla> mocked = mockStatic(Grilla.class)) {
            Grilla mockedGrilla3 = spy (Grilla.class);
            mocked.when(Grilla::getInstance).thenReturn(mockedGrilla3);
            when(mockedGrilla3.generarNumeroRandom()).thenReturn(0.5);

            Ubicable unaSorpresa = mockedGrilla3.generarSorpresaRandomEn(new Posicion(3,3));

            assertTrue(unaSorpresa.getClass().equals(((new SorpresaNoFavorable()).getClass())));
            assertTrue(unaSorpresa.estaEnPosicion(new Posicion(3,3)));
        }
    }

    @Test
    public void SeGeneraUnCambioDeVehiculoEnUnaPosicionDeLaGrilla () {
        try (MockedStatic<Grilla> mocked = mockStatic(Grilla.class)) {
            Grilla mockedGrilla = spy (Grilla.class);
            mocked.when(Grilla::getInstance).thenReturn(mockedGrilla);
            when(mockedGrilla.generarNumeroRandom()).thenReturn(0.9);

            Ubicable unaSorpresa = mockedGrilla.generarSorpresaRandomEn(new Posicion(7,3));

            assertTrue(unaSorpresa.getClass().equals(((new CambioDeVehiculo()).getClass())));
            assertTrue(unaSorpresa.estaEnPosicion(new Posicion(7,3)));
        }
    }

    @Test
    public void SeGeneranUbicablesDeFormaRandomEnLaGrillaNingunoEnPosicionXParYPar () {
        Grilla unaGrilla1 = Grilla.getInstance();
        unaGrilla1.generarUbicablesRandom ();

        for (int i = 1; i < unaGrilla1.getMaximaCantidadDePosicionesEnX(); i++ ){
            for (int j = 0; j < unaGrilla1.getMaximaCantidadDePosicionesEnY() ; j++ ) {
                if (i % 2 == 0 && j % 2 == 0) {
                    assertTrue(! (unaGrilla1.existeUbicableEn (new Posicion (i, j))));
                }
            }
        }
      
    }

    @Test
    public void SeGeneranUbicablesEnTodasPartesLasPartesPermitidas () {
        try (MockedStatic<Grilla> mocked = mockStatic(Grilla.class)) {
            Grilla mockedGrilla = spy (Grilla.class);
            mocked.when(Grilla::getInstance).thenReturn(mockedGrilla);
            when(mockedGrilla.generarNumeroRandom()).thenReturn(0.01);

            mockedGrilla.generarUbicablesRandom();

            for(int i = 1; i < mockedGrilla.getMaximaCantidadDePosicionesEnX() - 1; i++ ){
                for(int j = 0; j < mockedGrilla.getMaximaCantidadDePosicionesEnY() ; j++ ) {
                   if ( !((i % 2 == 0) && (j % 2 == 0))) {
                        assertTrue( mockedGrilla.existeUbicableEn (new Posicion (i, j)));
                   }
                }
            }
        }
    }

    @Test
    public void SeGeneraLaMetaEnUnaPosicionDelFinalDeLaGrilla () {
        Grilla unaGrilla1 = Grilla.getInstance();
        unaGrilla1.generarMeta ();
        int finalDeGrillaX = unaGrilla1.getMaximaCantidadDePosicionesEnX();
        int contadorDeUbicables = 0;

        for (int j = 0; j < unaGrilla1.getMaximaCantidadDePosicionesEnY() ; j++ ) {
            if (unaGrilla1.existeUbicableEn (new Posicion (finalDeGrillaX -1, j))) {
                contadorDeUbicables++;
            }
        }

        assertEquals(contadorDeUbicables , 1);
    }


}
