package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;

public class Moto extends TipoDeVehiculo {

    private double probDetencion;
    private int penalizacionPorPiquete;
    public Moto () {
        this.probDetencion = 0.8;
        this.penalizacionPorControlPolicial =3;
        this.penalizacionPorPozo = 3;
        this.penalizacionPorPiquete = 2;
    }

    public int calcularPenalizacion (ControlPolicial unControl) {
        if ( Math.random() > (1 - this.probDetencion)) {
            return this.penalizacionPorControlPolicial;
        }
        return 0;
    }

    public int calcularPenalizacion (Pozo unPozo) {
        return this.penalizacionPorPozo;
    }

    public int calcularPenalizacion (Piquete unPiquete) {
        return this.penalizacionPorPiquete;
    }

    public TipoDeVehiculo proximoTipoDeVehiculo () {
        return new Auto();
    }
}
