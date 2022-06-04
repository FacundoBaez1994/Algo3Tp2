package edu.fiuba.algo3.modelo;

abstract public class Calle {
    protected Esquina esquinaDeUnLado;
    protected Esquina esquinaDelotroLado;

    abstract public Esquina obtenerEsquinaOpuesta (Esquina esquinaOrigen);
    abstract public Esquina serTransitada (Vehiculo unVehiculo);
}