package edu.fiuba.algo3.modelo;

public class CalleComun extends Calle{

     public CalleComun (Esquina unaEsquina, Esquina otraEsquina) {
         this.esquinaDeUnLado = unaEsquina;
         this.esquinaDelotroLado = otraEsquina;
    }

    public Esquina obtenerEsquinaOpuesta (Esquina esquinaOrigen) {
        return this.esquinaDelotroLado;
    }

    public Esquina serTransitada (Vehiculo unVehiculo) {
        return this.esquinaDelotroLado; // Revisar luego
    }
}
