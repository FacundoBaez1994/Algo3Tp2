package edu.fiuba.algo3.modelo;

public class Auto extends TipoDeVehiculo {

    public Auto () {
    }

    public int calcularPenalizacion (Obstaculo unObstaculo) {
      if (unObstaculo.equals ( new Piquete ())) {
            throw new VehiculoNoPuedePasar ();
        }
       return 3;
    }
}