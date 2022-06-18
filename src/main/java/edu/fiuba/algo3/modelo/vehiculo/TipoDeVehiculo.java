package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.obstaculo.*;

public abstract class TipoDeVehiculo {
    protected int penalizacionPorPozo;
    protected int penalizacionPorControlPolicial;

    public abstract int calcularPenalizacion (ControlPolicial unControl);

    public abstract int calcularPenalizacion (Piquete unPiquete);

    public abstract int calcularPenalizacion (Pozo unPozo);
    public int calcularPenalizacion (NoObstaculo unNoObstaculo) {
        return 0;
    }

    public abstract TipoDeVehiculo proximoTipoDeVehiculo ();

}
