package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;


public class VistaCalleVertical extends StackPane {
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;
    private EventHandler<MouseEvent> eventHandler = null;

    private Posicion posicion;
    private ImageView imagen;
    //private static DiccionarioImagenes diccionarioImagenes = new DiccionarioImagenes();

    public VistaCalleVertical (Posicion pos) {
        super();
        this.posicion = pos;
        this.imagen = new ImageView("file:src/recursos/img/CalleVertical.png");
        this.imagen.setFitHeight(ALTURA_CASILLERO);
        this.imagen.setFitWidth(ANCHURA_CASILLERO);

        this.getChildren().add(this.imagen);
    }

    public Posicion getPosicion() { return this.posicion; }
}