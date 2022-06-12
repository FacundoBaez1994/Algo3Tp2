package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.movimiento.Movimiento;
import edu.fiuba.algo3.modelo.movimiento.MovimientoComun;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;

public class Vehiculo   {
    private Posicion posicion;
    private TipoDeVehiculo unTipoDeVehiculo;
    private int cantidadDeMovimientos;

    public Vehiculo(TipoDeVehiculo unTipoDeVehiculo, Posicion unaPosicion){
        this.cantidadDeMovimientos = 0;
        this.unTipoDeVehiculo = unTipoDeVehiculo;
        this.posicion = unaPosicion;
    }

    public void moverseHacia (Direccion unaDireccion) {

        Movimiento unMovimiento = new MovimientoComun(unaDireccion);
        this.posicion = unMovimiento.moverseDesde(this.posicion, this);
        // APLICAR OBSTACULOS Y REGALOS
    }

    public  void afectarMovimientos(Obstaculo unObstaculo) {
        this.cantidadDeMovimientos += unObstaculo.calcularPenalizacion (this.unTipoDeVehiculo);
        this.cantidadDeMovimientos += 1;
    }

    public int getCantidadDeMovimientos(){
        return this.cantidadDeMovimientos;
    }
    public void setCantidadDeMovimientos(int unaCantidadDeMovimientos){
        this.cantidadDeMovimientos = unaCantidadDeMovimientos;
    }

    public void aumentarCantidadMovimientosEnPorcentaje(double porcentaje) {
        int aumento;
        aumento = (int) Math.round(this.cantidadDeMovimientos * (porcentaje / 100));
        this.cantidadDeMovimientos += aumento;
    }

    public void disminuirCantidadMovimientosEnPorcentaje(double porcentaje) {
        int aumento;
        aumento = (int) Math.round(this.cantidadDeMovimientos * (porcentaje / 100));
        this.cantidadDeMovimientos -= aumento;
    }

    public void proximoVehiculo() {
        this.unTipoDeVehiculo = this.unTipoDeVehiculo.proximoTipoDeVehiculo();
    }

    public TipoDeVehiculo getTipoDeVehiculo(){
        return this.unTipoDeVehiculo;
    }

}
