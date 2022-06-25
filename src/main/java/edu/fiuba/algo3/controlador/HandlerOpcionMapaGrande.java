package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.vista.VistaCantidadDeJugadoresEnMapaGrande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerOpcionMapaGrande implements EventHandler<ActionEvent> {
    private Stage stage;
    private final int LARGO_DE_GRILLA_EN_X = 60;
    private final int LARGO_DE_GRILLA_EN_Y = 60;

    public HandlerOpcionMapaGrande (Stage stage) {
        super();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Grilla unaGrilla = Grilla.getInstance(LARGO_DE_GRILLA_EN_X,LARGO_DE_GRILLA_EN_Y);
        VistaCantidadDeJugadoresEnMapaGrande vistaCantidadDeJugadoresEnMapaGrande  =
                new VistaCantidadDeJugadoresEnMapaGrande(this.stage);
        vistaCantidadDeJugadoresEnMapaGrande.mostrarPantalla();
    }
}