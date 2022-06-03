package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MotoTest {
    @Test
    public class UnaMotoAtraviesaLaCiudadYSeEncuentraConUnPozoEsPenalizadaEnTresMovimientos {

        int movimientos;
        Direccion unaDireccion = new Derecha ();
        Esquina unaEsquina = new EsquinaComun ();
        Esquina otraEsquina = new EsquinaComun ();
        Calle unaCalle = new Calle (unaEsquina, otraEsquina)
        Moto unaMoto = new Moto (unaEsquina);

        movimientos = unaMoto moverHacia (unaDireccion);


        assertEquals(movimientos, 3);
    }

}