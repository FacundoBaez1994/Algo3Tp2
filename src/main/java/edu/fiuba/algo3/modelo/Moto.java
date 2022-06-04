package edu.fiuba.algo3.modelo;

public class Moto extends Vehiculo {

    public Moto (Esquina unaEsquina) {
        this.posicion = unaEsquina;
    }

    public int serAfectadoPorObstaculo (Obstaculo unObstaculo) {
        return 3;
    }
}
