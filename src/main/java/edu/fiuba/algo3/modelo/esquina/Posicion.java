package edu.fiuba.algo3.modelo.esquina;
import edu.fiuba.algo3.modelo.direcciones.Direccion;

abstract public class Posicion {
    protected int coordenadaX;
    protected int coordenadaY;
    protected Calle unaCalle; //Esto deberia ser un arrayList con las direcciones

    public abstract void setearCalleEnDireccion (Calle calle, Direccion unaDireccion);
    public abstract Calle obtenerCalleEnDireccion (Direccion unaDireccion);
}
