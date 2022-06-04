package edu.fiuba.algo3.modelo;
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

        Movimiento unMovimiento = new MovimientoComun (unaDireccion);
        Calle unaCalle = this.posicion.obtenerCalleEnDireccion(unaDireccion);
        unMovimiento.mover(unaCalle,this);
    }

    public  void afectarMovimientos(Obstaculo unObstaculo) {
        this.cantidadDeMovimientos += this.unTipoDeVehiculo.calcularPenalizacion (unObstaculo);
        this.cantidadDeMovimientos += 1;
    }

    public int getCantidadDeMovimientos(){
        return this.cantidadDeMovimientos;
    }
}