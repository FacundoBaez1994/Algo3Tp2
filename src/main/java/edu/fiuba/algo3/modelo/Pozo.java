package edu.fiuba.algo3.modelo;

public class Pozo implements Obstaculo {

    public void afectarMovimientos(Vehiculo unVehiculo){
        unVehiculo.afectarMovimientos(3);
    }
}
