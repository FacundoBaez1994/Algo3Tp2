package edu.fiuba.algo3.modelo;

public class Auto extends TipoDeVehiculo {

    public Auto () {
    }

    public int calcularPenalizacion (Obstaculo unObstaculo) {
      if (unObstaculo.equals ( new Piquete ())) {
          throw new VehiculoNoPuedePasar ();
      }
      if (unObstaculo.equals ( new Pozo ())) {
          return 3;
      }
      if ((unObstaculo.equals ( new ControlPolicial ())) && (Math.random() > (1 - 0.5))) {
          return 3;
      }
      return 0;
    }
}