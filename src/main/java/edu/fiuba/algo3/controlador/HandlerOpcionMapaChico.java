package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.vista.VistaCantidadDeJugadoresEnMapaChico;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;



public class HandlerOpcionMapaChico implements EventHandler<ActionEvent> {
    private Stage stage;
    private final int LARGO_DE_GRILLA_EN_X = 20;
    private final int LARGO_DE_GRILLA_EN_Y = 20;

    public HandlerOpcionMapaChico (Stage stage) {
        super();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Grilla unaGrilla = Grilla.getInstance();
        VistaCantidadDeJugadoresEnMapaChico vistaCantidadDeJugadoresEnMapaChico  =
                new VistaCantidadDeJugadoresEnMapaChico (this.stage);
        vistaCantidadDeJugadoresEnMapaChico.mostrarPantalla();
    }
}