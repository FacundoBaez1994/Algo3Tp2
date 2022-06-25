package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaSeleccion2Jugadores;
import edu.fiuba.algo3.vista.VistaSeleccion4Jugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerSeleccion4Jugadores implements EventHandler<ActionEvent> {

    private Stage stage;

    public HandlerSeleccion4Jugadores (Stage stage) {
        super();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaSeleccion4Jugadores vistaSeleccion4Jugadores  =
                new VistaSeleccion4Jugadores(this.stage);
        vistaSeleccion4Jugadores.mostrarPantalla();
    }
}