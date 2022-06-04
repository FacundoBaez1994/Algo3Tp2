package edu.fiuba.algo3.modelo;

abstract public class Esquina {
    protected int coordenadaX;
    protected int coordenadaY;
    protected Calle unaCalle; //Esto deberia ser un arrayList con las direcciones

    public abstract void setearCalleEnDireccion (Calle calle, Direccion unaDireccion);
    public abstract Calle obtenerCalleEnDireccion (Direccion unaDireccion);
}
