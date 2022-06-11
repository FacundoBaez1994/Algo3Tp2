package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.esquina.Calle;
import edu.fiuba.algo3.modelo.esquina.Esquina;
import edu.fiuba.algo3.modelo.movimiento.Movimiento;
import edu.fiuba.algo3.modelo.movimiento.MovimientoComun;
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
