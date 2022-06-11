package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class CalleComun extends Calle{

    private Obstaculo unObstaculo;

     public CalleComun (Esquina unaEsquina, Esquina otraEsquina) {
         this.esquinaDeUnLado = unaEsquina;
         this.esquinaDelotroLado = otraEsquina;
    }
    public CalleComun (Esquina unaEsquina, Esquina otraEsquina, Obstaculo unObstaculo) {
        this.esquinaDeUnLado = unaEsquina;
        this.esquinaDelotroLado = otraEsquina;
        this.unObstaculo = unObstaculo;
    }

    public Esquina obtenerEsquinaOpuesta (Esquina esquinaOrigen) {
         return this.esquinaDelotroLado;
    }

    public Esquina serTransitada (TipoDeVehiculo unTipoDeVehiculo) {
        unObstaculo.afectarMovimientos (unVehiculo);
         return this.esquinaDelotroLado; // Revisar luego
    }
}
