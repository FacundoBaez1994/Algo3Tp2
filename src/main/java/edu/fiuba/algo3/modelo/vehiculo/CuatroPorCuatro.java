package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.excepciones.VehiculoNoPuedePasar;
import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;

public class CuatroPorCuatro extends TipoDeVehiculo {
    private int pozosAtravesados;
    private double probDetencion;
    public CuatroPorCuatro () {
        this.pozosAtravesados = 0;
        this.probDetencion = 0.5;
    }

    public int calcularPenalizacion (ControlPolicial unControl) {
        if ( Math.random() > (1 - this.probDetencion)) {
            return 3;
        }
        return 0;
    }

    public int calcularPenalizacion (Pozo unPozo) {
        this.pozosAtravesados ++;
        if (this.pozosAtravesados == 3) {
            this.pozosAtravesados = 0;
            return 2;
        }
        return 0;
    }

    public int calcularPenalizacion (Piquete unPiquete) {
        throw new VehiculoNoPuedePasar();
    }

    public TipoDeVehiculo proximoTipoDeVehiculo () {
        return new Moto();
    }
}