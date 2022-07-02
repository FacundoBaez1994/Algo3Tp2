package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vista.VistaOpcionesDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.File;

public class HandlerInicioDeJuego implements EventHandler<ActionEvent> {
    private Stage stage;

    public HandlerInicioDeJuego (Stage stage) {
        super();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaOpcionesDeJuego vistaOpcionesDeJuego = new VistaOpcionesDeJuego(this.stage);
        vistaOpcionesDeJuego.mostrarPantalla();

    }
}
