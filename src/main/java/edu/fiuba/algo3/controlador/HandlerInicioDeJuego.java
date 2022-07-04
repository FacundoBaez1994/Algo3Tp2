package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.sonido.HandlerBuenoVamoAJuga;
import edu.fiuba.algo3.controlador.sonido.HandlerTemaPrincipal;
import edu.fiuba.algo3.vista.VistaOpcionesDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerInicioDeJuego implements EventHandler<ActionEvent> {
    private Stage stage;


    public HandlerInicioDeJuego (Stage stage) {
        super();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        HandlerBuenoVamoAJuga.reproducirSonido();
        VistaOpcionesDeJuego vistaOpcionesDeJuego = new VistaOpcionesDeJuego(this.stage);
        vistaOpcionesDeJuego.mostrarPantalla();

    }
}
