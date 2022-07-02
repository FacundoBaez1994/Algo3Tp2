package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.sonido.HandlerJapish;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.vista.VistaCantidadDeJugadoresEnMapaGrande;
import edu.fiuba.algo3.vista.VistaSeleccion1Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerSeleccion1Jugador implements EventHandler<ActionEvent> {

    private Stage stage;

    public HandlerSeleccion1Jugador (Stage stage) {
        super();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        HandlerJapish.reproducirSonido();
        VistaSeleccion1Jugador vistaSeleccion1Jugador  =
                new VistaSeleccion1Jugador(this.stage);
        vistaSeleccion1Jugador.mostrarPantalla();
    }
}