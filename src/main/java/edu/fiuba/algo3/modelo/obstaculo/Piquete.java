package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.VehiculoNoPuedePasar;
import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Piquete implements Obstaculo {
    public int calcularPenalizacion (TipoDeVehiculo unTipo) {
        return unTipo.calcularPenalizacion(this);
    }
}
