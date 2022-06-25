package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaDeLaPartida;
import edu.fiuba.algo3.vista.VistaOpcionesDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.File;

public class HandlerComienzoJuegoEnGrilla implements EventHandler<ActionEvent> {
    private Stage stage;

    public HandlerComienzoJuegoEnGrilla (Stage stage) {
        super();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaDeLaPartida vistaDeLaPartida = new VistaDeLaPartida(this.stage);
        vistaDeLaPartida.mostrarPantalla();
    }
}
