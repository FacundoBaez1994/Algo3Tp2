package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        Image imagen = new Image("file:src/recursos/img/InicioGPSChallenge.png",500,300,true,true);
        final ImageView imagenVista = new ImageView(imagen);

        root.getChildren().addAll(imagenVista, buttonInicio);

        Scene scene = new Scene(root, 500, 500);

        stage.setTitle("GPS CHALLENGE");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}