package edu.fiuba.algo3.modelo.esquina;

import edu.fiuba.algo3.modelo.direcciones.Direccion;

public class EsquinaComun extends Esquina {
    public EsquinaComun () {
    }

    public EsquinaComun (int UnaCoordenadaX, int UnaCoordenadaY) {
        coordenadaX = UnaCoordenadaX;
        coordenadaY = UnaCoordenadaY;
    }

    public void setearCalleEnDireccion (Calle calle , Direccion unaDireccion) {
        this.unaCalle = calle;
    }

    public Calle obtenerCalleEnDireccion (Direccion unaDireccion) {
        // Falta lo del arraylist con las direcciones
        return this.unaCalle;
    }
}
