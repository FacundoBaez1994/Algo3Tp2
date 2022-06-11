package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;

public class Moto extends TipoDeVehiculo {

    private double probDetencion;
    public Moto () {
        this.probDetencion = 0.8;
        this.penalizacionPorControlPolicial =3;
    }

    public int calcularPenalizacion (ControlPolicial unControl) {
        if ( Math.random() > (1 - this.probDetencion)) {
            return this.penalizacionPorControlPolicial;
        }
        return 0;
    }

    public int calcularPenalizacion (Pozo unPozo) {
        return 3;
    }

    public int calcularPenalizacion (Piquete unPiquete) {
        return 2;
    }

    public TipoDeVehiculo proximoTipoDeVehiculo () {
        return new Auto();
    }
}
