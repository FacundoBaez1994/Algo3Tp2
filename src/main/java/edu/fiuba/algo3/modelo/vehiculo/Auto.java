package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.excepciones.VehiculoNoPuedePasar;
import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.NoObstaculo;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;

public class Auto extends TipoDeVehiculo {


    private double probDetencion;
    public Auto () {
        this.probDetencion = 0.5;
        this.penalizacionPorControlPolicial =3;
        this.penalizacionPorPozo = 3;
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
        throw new VehiculoNoPuedePasar();
    }
    public int calcularPenalizacion (NoObstaculo unNoObstaculo) {
        return 0;
    }

    public TipoDeVehiculo proximoTipoDeVehiculo () {
        return new CuatroPorCuatro();
    }

}