package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.HandlerInicioDeJuego;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaFinDelJuego {
    private Stage stage;

    public VistaFinDelJuego(Stage stage){
        this.stage = stage;
    }

    public void mostrarPantallaGanador(String datosGanador){
        StackPane root =  new StackPane();

        Label etiquetaJugador = new Label();
        etiquetaJugador.setText("Jugador ganador: ".concat(datosGanador));

        HBox vboxJugadorGanador = new HBox(etiquetaJugador);

        HBox hbox = new HBox();
        hbox.setSpacing (25);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(vboxJugadorGanador);

        Image imagen = new Image("file:src/recursos/img/ganador.png",1000,800,true,true);
        final ImageView imagenVista = new ImageView(imagen);

        root.getChildren().addAll(imagenVista, hbox);

        Scene scene = new Scene(root, 1000, 800);
        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
        stage.show();
    }

}
