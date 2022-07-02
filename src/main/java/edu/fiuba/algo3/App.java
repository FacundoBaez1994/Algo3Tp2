package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.HandlerInicioDeJuego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        StackPane root =  new StackPane();
        Button buttonInicio = new Button();
        buttonInicio.setText("Iniciar juego");
        buttonInicio.setOnAction(new HandlerInicioDeJuego(stage));

        Image imagen = new Image("file:src/recursos/img/InicioGPSChallenge.png",500,300,true,true);
        final ImageView imagenVista = new ImageView(imagen);

        root.getChildren().addAll(imagenVista, buttonInicio);

        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add("file:style.css");
        stage.setTitle("GPS CHALLENGE");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}