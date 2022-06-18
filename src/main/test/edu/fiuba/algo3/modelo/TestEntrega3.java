package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import edu.fiuba.algo3.modelo.excepciones.LlegadaALaMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Derecha;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;


public class TestEntrega3 {

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
        unaGrilla.agregarUbicable(new Meta (new Posicion(2,0)));

        Executable task = () -> {
            unaMoto.moverseHacia (unaDireccion);
        };

        assertThrows (LlegadaALaMeta.class, task);
    }

}
