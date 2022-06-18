package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaNoFavorable;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Random;

public class Grilla {
    // Singleton pattern
    private static Grilla INSTANCE = null;
    private ArrayList<Ubicable> ubicables = null;
    private int maximaCantidadDePosicionesEnX = 20;
    private int maximaCantidadDePosicionesEnY = 20;

    private Posicion[][] posiciones = new Posicion[this.maximaCantidadDePosicionesEnX][this.maximaCantidadDePosicionesEnY];

    private Grilla(){
        this.crearPosiciones();
        this.ubicables = new ArrayList<>();
    }

    private Grilla(int cantX, int cantY){
        this.maximaCantidadDePosicionesEnX = cantX;
        this.maximaCantidadDePosicionesEnY = cantY;
        this.crearPosiciones();
        this.ubicables = new ArrayList<>();
    }

    public static Grilla getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Grilla();
        }
        return INSTANCE;
    }
    public static Grilla getInstance(int cantX, int cantY) {
        if (INSTANCE == null) {
            INSTANCE = new Grilla(cantX, cantY);
        }
        return INSTANCE;
    }

    public Posicion[][] getPosiciones(){
        return this.posiciones;
    }

    private void crearPosiciones() {
        for(int i = 0; i < this.maximaCantidadDePosicionesEnX; i++ ){
            for(int j = 0; j < this.maximaCantidadDePosicionesEnY ; j++ ) {
                this.posiciones [i][j] = new Posicion (i,j);
            }
        }
    }
    public void aplicarElementoUbicableAVehiculo (Vehiculo unVehiculo) {
        for( Ubicable ubicable : ubicables){
            unVehiculo.toparseConUn (ubicable);
        }
    }

    private void buscarElementosEn(Posicion posicion) {
        for(int i = 0; i < this.maximaCantidadDePosicionesEnX; i++ ){
            for(int j = 0; j < this.maximaCantidadDePosicionesEnY ; j++ ) {
                // que elemento tienen la posicion
            }
        }
    }
    public void agregarUbicable(Ubicable unUbicable){
        this.ubicables.add(unUbicable);
    }

    public void reiniciar () {
        this.crearPosiciones();
        this.ubicables = new ArrayList<>();
    }

    public void generarUbicablesRandom () {
        // Random rand = new Random(System.currentTimeMillis());
        for(int i = 0; i < this.maximaCantidadDePosicionesEnX; i++ ){
            for(int j = 0; j < this.maximaCantidadDePosicionesEnY ; j++ ) {
                if ( !((i % 2 == 0) && (j % 2 == 0))) {
                    if ( Math.random() > (1 - 0.5)) {
                        Ubicable unObstaculo = this.generarObstaculoRandomEn (new Posicion (i, j));
                        this.agregarUbicable (unObstaculo);
                    }
                    else if ( Math.random() > (1 - 0.5)) {
                        Ubicable unaSorpresa = this.generarSorpresaRandomEn (new Posicion (i, j));
                        this.agregarUbicable (unaSorpresa);
                    }
                }
            }
        }
    }
    private Ubicable generarObstaculoRandomEn (Posicion unaPosicion) {
        if ( Math.random() > (0.7)) {
            return new ControlPolicial (unaPosicion);
        }
        else if ( Math.random() > (0.7)) {
            return new Piquete(unaPosicion);
        }
        else {
            return new Pozo(unaPosicion);
        }
    }

    private Ubicable generarSorpresaRandomEn (Posicion unaPosicion ) {
        if ( Math.random() > (0.7)) {
            return new SorpresaFavorable(unaPosicion);
        }
        else if ( Math.random() > (0.7)) {
            return new SorpresaNoFavorable (unaPosicion);
        }
        else {
            return new CambioDeVehiculo (unaPosicion);
        }
    }

    public void generarMeta () {
        // Random rand = new Random(System.currentTimeMillis());
        for(int j = 1; j < this.maximaCantidadDePosicionesEnY; j = j + 2 ){
            if ( Math.random() > (0.7)) {
                Ubicable meta = new Meta (new Posicion (this.maximaCantidadDePosicionesEnX, j));
                this.agregarUbicable (meta);
                return;
            }
        }
        if ( !((this.maximaCantidadDePosicionesEnX % 2 == 0) && (maximaCantidadDePosicionesEnY % 2 == 0))) {
            Ubicable meta = new Meta (new Posicion (this.maximaCantidadDePosicionesEnX, maximaCantidadDePosicionesEnY));
            this.agregarUbicable (meta);
        } else {
            Ubicable meta = new Meta (new Posicion (this.maximaCantidadDePosicionesEnX, maximaCantidadDePosicionesEnY - 1));
            this.agregarUbicable (meta);
        }
    }


}




