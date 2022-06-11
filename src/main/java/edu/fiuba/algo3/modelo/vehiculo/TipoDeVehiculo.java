package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;

public abstract class TipoDeVehiculo {
    public abstract int calcularPenalizacion (ControlPolicial unControl);

    public abstract int calcularPenalizacion (Piquete unPiquete);

    public abstract int calcularPenalizacion (Pozo unPozo);

}
