package edu.fiuba.algo3.modelo;

public class CuatroPorCuatro extends TipoDeVehiculo {
    private int pozosAtravesados;
    public CuatroPorCuatro () {
        this.pozosAtravesados = 0;
    }

    public int calcularPenalizacion (Obstaculo unObstaculo) {
        if (unObstaculo.equals ( new Piquete ())) {
            throw new VehiculoNoPuedePasar ();
        }
        if (unObstaculo.equals ( new Pozo ())) {
            this.pozosAtravesados ++;
            if (this.pozosAtravesados == 3) {
                this.pozosAtravesados = 0;
                return 2;
            }
            return 0;
        }
        if ((unObstaculo.equals ( new ControlPolicial ())) && (Math.random() > (1 - 0.5))) {
            return 3;
        }
        return 0;
    }
}