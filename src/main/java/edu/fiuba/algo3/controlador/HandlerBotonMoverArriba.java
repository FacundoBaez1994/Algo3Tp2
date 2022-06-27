package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Arriba;
import edu.fiuba.algo3.vista.VistaDeLaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerBotonMoverArriba implements EventHandler<ActionEvent> {
    private Stage stage;
    private Arriba Arriba;

    public HandlerBotonMoverArriba(Stage stage) {
        this.Arriba = new Arriba();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego.getInstance().jugadorConTurnoActualMueveVehiculo(this.Arriba);
        VistaDeLaPartida vistaDeLaPartida = new VistaDeLaPartida(this.stage);
        vistaDeLaPartida.mostrarPantalla();
    }
}
