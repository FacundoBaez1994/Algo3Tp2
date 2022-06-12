package edu.fiuba.algo3.modelo.esquina;

import edu.fiuba.algo3.modelo.esquina.Calle;
import edu.fiuba.algo3.modelo.obstaculo.NoObstaculo;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.obstaculo.Sorpresa;
import edu.fiuba.algo3.modelo.sorpresa.NoSorpresa;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;


public class CalleComun extends Calle {

    private Obstaculo unObstaculo;
    private Sorpresa unaSorpresa;

     public CalleComun (Posicion unaPosicion, Posicion otraPosicion) {
         this.posicionDeUnLado = unaPosicion;
         this.posicionDelotroLado = otraPosicion;
         this.unaSorpresa = new NoSorpresa();
    }

    public CalleComun (Posicion unaPosicion, Posicion otraPosicion, Sorpresa unaSorpresa) {
        this.posicionDeUnLado = unaPosicion;
        this.posicionDelotroLado = otraPosicion;
        this.unaSorpresa = unaSorpresa;
        this.unObstaculo = new NoObstaculo();
    }

    public CalleComun (Posicion unaPosicion, Posicion otraPosicion, Obstaculo unObstaculo) {
        this.posicionDeUnLado = unaPosicion;
        this.posicionDelotroLado = otraPosicion;
        this.unObstaculo = unObstaculo;
        this.unaSorpresa = new NoSorpresa();
    }

    public Posicion obtenerEsquinaOpuesta (Posicion posicionOrigen) {
         return this.posicionDelotroLado;
    }

    public Posicion serTransitada (Vehiculo unVehiculo) {
        unVehiculo.afectarMovimientos(unObstaculo);
        unaSorpresa.serEncontradaPor(unVehiculo);
        return this.posicionDelotroLado; // Revisar luego

    }
}