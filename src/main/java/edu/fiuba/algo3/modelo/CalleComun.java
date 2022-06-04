package edu.fiuba.algo3.modelo;

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

    public Esquina serTransitada (Vehiculo unVehiculo) {
         this.unObstaculo.afectarMovimientos(unVehiculo);
         return this.esquinaDelotroLado; // Revisar luego
    }
}
