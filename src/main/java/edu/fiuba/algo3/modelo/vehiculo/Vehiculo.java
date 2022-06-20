package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.grilla.Ubicable;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.obstaculo.*;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.movimiento.Movimiento;
import edu.fiuba.algo3.modelo.movimiento.MovimientoComun;
// Comentario
public class Vehiculo{
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
        unMovimiento.moverse (this);
        unMovimiento.moverse (this);
        this.cantidadDeMovimientos += 1;
    }
/*
    public  void afectarMovimientos(Obstaculo unObstaculo) {
        this.cantidadDeMovimientos += unObstaculo.calcularPenalizacion (this.unTipoDeVehiculo);
        this.cantidadDeMovimientos += 1;
    }*/

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

    public void cambiarPosicionHacia(Posicion posicionRelativa) {
        this.posicion.sumarCoordenadas(posicionRelativa);
    }
    public boolean estaEnPosicion(Posicion unaPosicion){
        return this.posicion.equals(unaPosicion);
    }
    public Posicion getPosicion(){
        return this.posicion;
    }

    public void calcularPenalizacion(Pozo pozo) {
        this.cantidadDeMovimientos += this.unTipoDeVehiculo.calcularPenalizacion(pozo);
    }
    public void calcularPenalizacion(ControlPolicial controlPolicial) {
        this.cantidadDeMovimientos += this.unTipoDeVehiculo.calcularPenalizacion(controlPolicial);
    }
    public void calcularPenalizacion(Piquete piquete) {
        this.cantidadDeMovimientos += this.unTipoDeVehiculo.calcularPenalizacion(piquete);
    }
    public void calcularPenalizacion(NoObstaculo noObstaculo) {
        this.cantidadDeMovimientos += this.unTipoDeVehiculo.calcularPenalizacion(noObstaculo);
    }

    public void toparseConUn(Ubicable ubicable) {
        if( ubicable.estaEnPosicion(this.posicion)) {
            ubicable.serEncontradoPor(this);
        }
    }
}
