package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Derecha;
import edu.fiuba.algo3.vista.VistaBotonera;
import edu.fiuba.algo3.vista.VistaDeLaPartida;
import edu.fiuba.algo3.vista.VistaSeleccion1Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerBotonMoverDerecha implements EventHandler<ActionEvent> {
    private Stage stage;
    private Derecha derecha;

    public HandlerBotonMoverDerecha (Stage stage) {
        this.derecha = new Derecha();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego.getInstance().jugadorConTurnoActualMueveVehiculo(this.derecha);
        VistaDeLaPartida vistaDeLaPartida = new VistaDeLaPartida(this.stage);
        vistaDeLaPartida.mostrarPantalla();
    }
}
