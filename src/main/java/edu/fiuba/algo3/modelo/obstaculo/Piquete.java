package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;

public class Piquete implements Obstaculo {
    public int calcularPenalizacion (TipoDeVehiculo unTipo) {
        return unTipo.calcularPenalizacion(this);
    }
}
