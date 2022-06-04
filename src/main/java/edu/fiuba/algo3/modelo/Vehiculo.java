package edu.fiuba.algo3.modelo;

abstract public class Vehiculo   {
    protected Esquina posicion;

    public int moverseHacia (Direccion unaDireccion) {
        int cantidadDeMovimientos = 3;
       //Movimiento unMovimiento = new Movimiento (unaDireccion);

        return cantidadDeMovimientos;
    }

    public abstract int serAfectadoPorObstaculo (Obstaculo unObstaculo);
}