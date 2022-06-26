package edu.fiuba.algo3.modelo.grilla;

import edu.fiuba.algo3.modelo.excepciones.PosicionFueraDeLimite;
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
    private double probabilidadControlPolicial = 0.3;
    private double probabilidadPiquete = 0.7;
    private double probabilidadSorpresaFavorable = 0.3;
    private double probabilidadSorpresaNoFavorable = 0.7;
    private double probabilidadDeGenerarMetaEnPosicion = 0.7;
    private double probabilidadDeGenerarSorpresaEnUnaPosicion = 0.2;
    private double probabilidadDeGenerarObstaculoEnUnaPosicion = 0.2;


    private Posicion[][] posiciones = new Posicion[this.maximaCantidadDePosicionesEnX][this.maximaCantidadDePosicionesEnY];

    private Grilla(){
        this.crearPosiciones();
        this.ubicables = new ArrayList<>();
        this.posiciones = new Posicion[this.maximaCantidadDePosicionesEnX][this.maximaCantidadDePosicionesEnY];
    }

    private Grilla(int cantX, int cantY){
        this.maximaCantidadDePosicionesEnX = cantX;
        this.maximaCantidadDePosicionesEnY = cantY;
        this.posiciones = new Posicion[this.maximaCantidadDePosicionesEnX][this.maximaCantidadDePosicionesEnY];
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

    public boolean existeUbicableEn (Posicion posicion) {
        for( Ubicable ubicable : ubicables){
            if (ubicable.estaEnPosicion(posicion)) {
                return true;
            }
        }
        return false;
    }

    public Ubicable getUbicableEn (Posicion posicion) {
        for( Ubicable ubicable : ubicables){
            if (ubicable.estaEnPosicion(posicion)) {
                return ubicable;
            }
        }
        return null;
    }

    public void agregarUbicable(Ubicable unUbicable){
        this.ubicables.add(unUbicable);
    }

    public void reiniciar () {
        this.crearPosiciones();
        this.ubicables = new ArrayList<>();
    }

    public void generarUbicablesRandom () {

        for(int i = 1; i < this.maximaCantidadDePosicionesEnX - 1; i++ ){
            for(int j = 0; j < this.maximaCantidadDePosicionesEnY ; j++ ) {
                if ( ( !((i % 2 == 0) && (j % 2 == 0))) ) {
                    if ( this.generarNumeroRandom () < this.probabilidadDeGenerarObstaculoEnUnaPosicion) {
                        Ubicable unObstaculo = this.generarObstaculoRandomEn (new Posicion (i, j));
                        this.agregarUbicable (unObstaculo);
                    }
                    else if ( this.generarNumeroRandom () < this.probabilidadDeGenerarSorpresaEnUnaPosicion) {
                        Ubicable unaSorpresa = this.generarSorpresaRandomEn (new Posicion (i, j));
                        this.agregarUbicable (unaSorpresa);
                    }
                }
            }
        }
    }

    public Ubicable generarObstaculoRandomEn (Posicion unaPosicion) {
        double randomSelection = this.generarNumeroRandom ();

        if ( randomSelection < (this.probabilidadControlPolicial)) {
            return new ControlPolicial (unaPosicion);
        }
        else if ( this.probabilidadControlPolicial < randomSelection &&
                randomSelection < this.probabilidadPiquete) {
            return new Piquete(unaPosicion);
        }
        else {
            return new Pozo(unaPosicion);
        }
    }

    public Double generarNumeroRandom () {
        Random ran = new Random();
        return  ran.nextDouble();
    }

    public Ubicable generarSorpresaRandomEn (Posicion unaPosicion ) {
        double randomSelection = this.generarNumeroRandom ();

        if ( randomSelection < this.probabilidadSorpresaFavorable ) {
            return new SorpresaFavorable(unaPosicion);
        }
        else if ( this.probabilidadSorpresaFavorable < randomSelection &&
                randomSelection < this.probabilidadSorpresaNoFavorable) {
            return new SorpresaNoFavorable (unaPosicion);
        }
        else {
            return new CambioDeVehiculo (unaPosicion);
        }
    }

    public void generarMeta () {

        for(int j = 1; j < this.maximaCantidadDePosicionesEnY; j = j + 2 ){
            if ( Math.random() > (this.probabilidadDeGenerarMetaEnPosicion)) {
                Ubicable meta = new Meta(new Posicion (this.maximaCantidadDePosicionesEnX -1, j));
                this.agregarUbicable (meta);
                return;
            }
        }
        if ( !((this.maximaCantidadDePosicionesEnX % 2 == 0) && (maximaCantidadDePosicionesEnY % 2 == 0))) {
            Ubicable meta = new Meta (new Posicion (this.maximaCantidadDePosicionesEnX -1, maximaCantidadDePosicionesEnY));
            this.agregarUbicable (meta);
        } else {
            Ubicable meta = new Meta (new Posicion (this.maximaCantidadDePosicionesEnX -1, maximaCantidadDePosicionesEnY - 1));
            this.agregarUbicable (meta);
        }
    }

    public int getMaximaCantidadDePosicionesEnX () {
        return this.maximaCantidadDePosicionesEnX;
    }

    public int getMaximaCantidadDePosicionesEnY () {
        return this.maximaCantidadDePosicionesEnY;
    }

    public void comprobarCoordenadasDentroDeLosLimites(int coordenadaX, int coordenadaY) {
        if(     coordenadaX< 0 || coordenadaY < 0
                || this.maximaCantidadDePosicionesEnX < coordenadaX
                || this.maximaCantidadDePosicionesEnY < coordenadaY){
             throw new PosicionFueraDeLimite();
        }
    }
}




