package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.obstaculo.NoObstaculo;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.obstaculo.Sorpresa;
import edu.fiuba.algo3.modelo.sorpresa.NoSorpresa;
import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;


public class CalleComun extends Calle{

    private Obstaculo unObstaculo;
    private Sorpresa unaSorpresa;

     public CalleComun (Esquina unaEsquina, Esquina otraEsquina) {
         this.esquinaDeUnLado = unaEsquina;
         this.esquinaDelotroLado = otraEsquina;
         this.unaSorpresa = new NoSorpresa();
    }

    public CalleComun (Esquina unaEsquina, Esquina otraEsquina, Sorpresa unaSorpresa) {
        this.esquinaDeUnLado = unaEsquina;
        this.esquinaDelotroLado = otraEsquina;
        this.unaSorpresa = unaSorpresa;
        this.unObstaculo = new NoObstaculo();
    }

    public CalleComun (Esquina unaEsquina, Esquina otraEsquina, Obstaculo unObstaculo) {
        this.esquinaDeUnLado = unaEsquina;
        this.esquinaDelotroLado = otraEsquina;
        this.unObstaculo = unObstaculo;
        this.unaSorpresa = new NoSorpresa();
    }

    public Esquina obtenerEsquinaOpuesta (Esquina esquinaOrigen) {
         return this.esquinaDelotroLado;
    }

    public Esquina serTransitada (Vehiculo unVehiculo) {
        unVehiculo.afectarMovimientos(unObstaculo);
        unaSorpresa.serEncontradaPor(unVehiculo);
        return this.esquinaDelotroLado; // Revisar luego

    }
}