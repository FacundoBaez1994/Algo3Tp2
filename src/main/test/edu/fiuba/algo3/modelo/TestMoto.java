package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMoto {
    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadaEnTresMovimientos () {

        int movimientos;

        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun ();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new CalleComun (unaEsquina, otraEsquina);
        unaEsquina.setearCalleEnDireccion (unaCalle, unaDireccion);
        Moto unaMoto = new Moto (unaEsquina);

        movimientos = unaMoto.moverseHacia (unaDireccion);
        assertEquals(movimientos, 3);
    }

}