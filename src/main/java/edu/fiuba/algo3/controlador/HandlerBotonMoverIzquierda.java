package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Derecha;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Izquierda;
import edu.fiuba.algo3.vista.VistaDeLaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerBotonMoverIzquierda implements EventHandler<ActionEvent> {
    private Stage stage;
    private Izquierda izquierda;

    public HandlerBotonMoverIzquierda(Stage stage) {
        this.izquierda = new Izquierda();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego.getInstance().jugadorConTurnoActualMueveVehiculo(this.izquierda);
        VistaDeLaPartida vistaDeLaPartida = new VistaDeLaPartida(this.stage);
        vistaDeLaPartida.mostrarPantalla();
    }
}
