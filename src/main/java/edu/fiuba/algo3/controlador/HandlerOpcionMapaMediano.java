package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.vista.VistaCantidadDeJugadoresEnMapaMediano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerOpcionMapaMediano implements EventHandler<ActionEvent> {
    private Stage stage;
    private final int LARGO_DE_GRILLA_EN_X = 40;
    private final int LARGO_DE_GRILLA_EN_Y = 40;

    public HandlerOpcionMapaMediano (Stage stage) {
        super();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Grilla unaGrilla = Grilla.getInstance(40,40);
        VistaCantidadDeJugadoresEnMapaMediano vistaCantidadDeJugadoresEnMapaChico
                = new VistaCantidadDeJugadoresEnMapaMediano (this.stage);
        vistaCantidadDeJugadoresEnMapaChico.mostrarPantalla();
    }
}