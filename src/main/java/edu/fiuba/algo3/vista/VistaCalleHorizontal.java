package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.grilla.Ubicable;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;



public class VistaCalleHorizontal extends StackPane {
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;

    private Posicion posicion;
    private ImageView imagen;

    private static DiccionarioDeImagenes diccionarioImagenes = new DiccionarioDeImagenes();

    public VistaCalleHorizontal (Posicion pos) {
        super();
        this.posicion = pos;
        this.imagen = new ImageView("file:src/recursos/img/CalleHorizontal.PNG");
        this.imagen.setFitHeight(ALTURA_CASILLERO);
        this.imagen.setFitWidth(ANCHURA_CASILLERO);
        this.getChildren().add(this.imagen);
        this.agregarUbicable();
    }

    private void agregarUbicable () {
        Grilla grilla = Grilla.getInstance();
        Ubicable ubicable = grilla.getUbicableEn(this.posicion);
        if ( ubicable != null){
            ImageView imagen = this.diccionarioImagenes.get(ubicable.getClass());
            this.getChildren().add(imagen);
        }
    }

    public Posicion getPosicion() { return this.posicion; }

}
