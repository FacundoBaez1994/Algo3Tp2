package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.grilla.Meta;
import edu.fiuba.algo3.modelo.grilla.Ubicable;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;


public class VistaEsquina extends StackPane {
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;
    private static String rutaCirculoVerde = "file:src/recursos/img/circuloVerde.png";


    private Posicion posicion;
    private ImageView imagen;
    private static DiccionarioDeImagenes diccionarioImagenes = new DiccionarioDeImagenes();

    public VistaEsquina (Posicion pos) {
        super();
        this.posicion = pos;
        this.imagen = new ImageView("file:src/recursos/img/esquina.png");
        this.imagen.setFitHeight(ALTURA_CASILLERO);
        this.imagen.setFitWidth(ANCHURA_CASILLERO);
        this.getChildren().add(this.imagen);
        this.agregarUbicable();
        this.agregarVehiculos();
        this.agregarOcultabilidad();
    }

    private void agregarUbicable () {
        Grilla grilla = Grilla.getInstance();
        Ubicable ubicable = grilla.getUbicableEn(this.posicion);
        if ( ubicable != null){
            ImageView imagen = this.diccionarioImagenes.get(ubicable.getClass());
            this.getChildren().add(imagen);
        }
    }

    private void agregarVehiculos () {
        Juego juego = Juego.getInstance();
        Posicion posicionDeJugadorActual = juego.obtenerPosicionDeJugadorActual ();
        TipoDeVehiculo unTipoDeVehiculo = juego.obtenerVehiculoEnPosicion (this.posicion);
        if ( unTipoDeVehiculo != null){
            ImageView imagen = this.diccionarioImagenes.get(unTipoDeVehiculo.getClass());
            int id = juego.obtenerNumeroDeJugadorEnPosicion(this.posicion);
            if (id > 0) {
                // AGREGAR DICCIONARIO
                ImageView img = this.diccionarioImagenes.get(id);
                this.getChildren().add(img);
                this.getChildren().add(imagen);
            } else  {
            this.getChildren().add(imagen);
            }
        }
    }

    public Posicion getPosicion() { return this.posicion; }
    private void agregarOcultabilidad () {
        Grilla grilla = Grilla.getInstance();
        Ubicable unUbicable = grilla.getUbicableEn (this.posicion);
            Juego juego = Juego.getInstance();
            Posicion posJugador = juego.obtenerPosicionDeJugadorActual ();
            if (this.posicion.obtenerDistanciaMayor(posJugador) > 2) {
                if (unUbicable != null){
                    if (unUbicable.getClass() == (new Meta ()).getClass()){
                        return;
                    }
                }
            ImageView imagen = new ImageView("file:src/recursos/img/Manzana.PNG");
            imagen.setFitHeight(30);
            imagen.setFitWidth(30);
            this.getChildren().add(imagen);
            }
    }
}
//unUbicable.getClass() != Meta.class