package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaOpcionesDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
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
