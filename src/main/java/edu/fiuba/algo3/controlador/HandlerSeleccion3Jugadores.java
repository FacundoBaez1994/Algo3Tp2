package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaCantidadDeJugadoresEnMapaGrande;
import edu.fiuba.algo3.vista.VistaSeleccion2Jugadores;
import edu.fiuba.algo3.vista.VistaSeleccion3Jugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerSeleccion3Jugadores implements EventHandler<ActionEvent> {

    private Stage stage;

    public HandlerSeleccion3Jugadores (Stage stage) {
        super();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaSeleccion3Jugadores vistaSeleccion3Jugadores  =
                new VistaSeleccion3Jugadores(this.stage);
        vistaSeleccion3Jugadores.mostrarPantalla();
    }
}