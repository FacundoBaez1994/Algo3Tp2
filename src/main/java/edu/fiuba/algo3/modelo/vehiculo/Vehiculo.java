package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;

public class Vehiculo   {
    private Esquina posicion;
    private TipoDeVehiculo unTipoDeVehiculo;
    private int cantidadDeMovimientos;

    public Vehiculo(TipoDeVehiculo unTipoDeVehiculo, Esquina unaEsquina){
        this.cantidadDeMovimientos = 0;
        this.unTipoDeVehiculo = unTipoDeVehiculo;
        this.posicion = unaEsquina;
    }

    public void moverseHacia (Direccion unaDireccion) {

        Movimiento unMovimiento = new MovimientoComun(unaDireccion);
        Calle unaCalle = this.posicion.obtenerCalleEnDireccion(unaDireccion);
        unMovimiento.mover(unaCalle,this );
    }

    public  void afectarMovimientos(Obstaculo unObstaculo) {
        this.cantidadDeMovimientos += unObstaculo.calcularPenalizacion (this.unTipoDeVehiculo);
        this.cantidadDeMovimientos += 1;
    }

    public int getCantidadDeMovimientos(){
        return this.cantidadDeMovimientos;
    }

    public void aumentarCantidadMovimientosEnPorcentaje(int porcentaje) {
        int aumento;
        aumento = (int) this.cantidadDeMovimientos * (porcentaje / 100);
        this.cantidadDeMovimientos += aumento;
    }

    public void disminuirCantidadMovimientosEnPorcentaje(int porcentaje) {
        int aumento;
        aumento = (int) this.cantidadDeMovimientos * (porcentaje / 100);
        this.cantidadDeMovimientos -= aumento;
    }

    public void proximoVehiculo() {
        this.unTipoDeVehiculo = this.unTipoDeVehiculo.proximoTipoDeVehiculo();
    }

}