package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.*;

public class Pozo implements Obstaculo {
    public int calcularPenalizacion (TipoDeVehiculo unTipo) {
        return unTipo.calcularPenalizacion(this);
    }
}
