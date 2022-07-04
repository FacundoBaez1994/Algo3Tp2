package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.sonido.HandlerJapish;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.vista.VistaCantidadDeJugadoresEnMapaGrande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerOpcionMapaGrande implements EventHandler<ActionEvent> {
    private Stage stage;
    private final int LARGO_DE_GRILLA_EN_X = 20;
    private final int LARGO_DE_GRILLA_EN_Y = 20;

    public HandlerOpcionMapaGrande (Stage stage) {
        super();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        HandlerJapish.reproducirSonido();
        Grilla unaGrilla = Grilla.getInstance(LARGO_DE_GRILLA_EN_X,LARGO_DE_GRILLA_EN_Y);
        unaGrilla.generarUbicablesRandom();
        unaGrilla.generarMeta();
        VistaCantidadDeJugadoresEnMapaGrande vistaCantidadDeJugadoresEnMapaGrande  =
                new VistaCantidadDeJugadoresEnMapaGrande(this.stage);
        vistaCantidadDeJugadoresEnMapaGrande.mostrarPantalla();
    }
}