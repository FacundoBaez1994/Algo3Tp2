package edu.fiuba.algo3.modelo;

public class Moto extends TipoDeVehiculo {

    public Moto () {
    }

    public int calcularPenalizacion (Obstaculo unObstaculo) {
        if (unObstaculo.equals ( new Piquete ())) {
            return 2;
        }
        if (unObstaculo.equals ( new Pozo ())) {
            return 3;
        }
        if ((unObstaculo.equals ( new ControlPolicial ())) && (Math.random() > (1 - 0.8))) {
            return 3;
        }
        return 0;
    }
}
