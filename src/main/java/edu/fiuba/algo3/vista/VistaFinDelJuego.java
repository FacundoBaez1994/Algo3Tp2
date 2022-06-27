package edu.fiuba.algo3.vista;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaFinDelJuego {
    private Stage stage;

    public VistaFinDelJuego(Stage stage){
        this.stage = stage;
    }

    public void mostrarPantallaGanador(String textoNicknameJugador, String textoPuntajeJugador){
        Label etiquetaNicknameJugador = new Label();
        etiquetaNicknameJugador.setText("Jugador ganador: ".concat(textoNicknameJugador));

        Label etiquetaPuntajeJugador = new Label();
        etiquetaPuntajeJugador.setText("Puntos: ".concat(textoPuntajeJugador));

        HBox vboxJugadorGanador = new HBox(etiquetaNicknameJugador, etiquetaPuntajeJugador);

        HBox root = new HBox();
        root.getChildren().add(vboxJugadorGanador);

        Scene scene = new Scene(root, 1000, 800);
        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
        stage.show();
    }

}
