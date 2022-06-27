package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Abajo;
import edu.fiuba.algo3.vista.VistaDeLaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerBotonMoverAbajo implements EventHandler<ActionEvent> {
    private Stage stage;
    private Abajo abajo;

    public HandlerBotonMoverAbajo(Stage stage) {
        this.abajo = new Abajo();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego.getInstance().jugadorConTurnoActualMueveVehiculo(this.abajo);
        VistaDeLaPartida vistaDeLaPartida = new VistaDeLaPartida(this.stage);
        vistaDeLaPartida.mostrarPantalla();
    }
}
