package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.sonido.HandlerJapish;
import edu.fiuba.algo3.vista.VistaCantidadDeJugadoresEnMapaGrande;
import edu.fiuba.algo3.vista.VistaSeleccion1Jugador;
import edu.fiuba.algo3.vista.VistaSeleccion2Jugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerSeleccion2Jugadores implements EventHandler<ActionEvent> {

    private Stage stage;

    public HandlerSeleccion2Jugadores (Stage stage) {
        super();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        HandlerJapish.reproducirSonido();
        VistaSeleccion2Jugadores vistaSeleccion2Jugadores  =
                new VistaSeleccion2Jugadores(this.stage);
        vistaSeleccion2Jugadores.mostrarPantalla();
    }
}