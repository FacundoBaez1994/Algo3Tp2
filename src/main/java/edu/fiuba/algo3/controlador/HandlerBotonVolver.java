package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vista.VistaDeLaPartida;
import edu.fiuba.algo3.vista.VistaInicioDeJuego;
import edu.fiuba.algo3.vista.VistaOpcionesDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class HandlerBotonVolver implements EventHandler<ActionEvent> {
    private Stage stage;

    public HandlerBotonVolver(Stage stage){
        this.stage = stage;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Juego unJuego = Juego.getInstance();
        unJuego.reiniciar();
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.reiniciar();
        VistaInicioDeJuego vistaInicioDeJuego = new VistaInicioDeJuego(this.stage);
        vistaInicioDeJuego.mostrarPantalla(); //ver como volver a la pantalla de inicio en vez de a opciones de juego
    }
}