package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.HandlerInicioDeJuego;
import edu.fiuba.algo3.controlador.sonido.HandlerTemaPrincipal;
import edu.fiuba.algo3.vista.VistaInicioDeJuego;
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
        VistaInicioDeJuego vistaInicioDeJuego = new VistaInicioDeJuego(stage);
        vistaInicioDeJuego.mostrarPantalla();
    }

    public static void main(String[] args) {
        launch();
    }

}