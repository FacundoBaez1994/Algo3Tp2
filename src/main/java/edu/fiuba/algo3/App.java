package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.HandlerInicioDeJuego;
import edu.fiuba.algo3.controlador.sonido.HandlerTemaPrincipal;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.VistaInicioDeJuego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.getIcons().add(new Image("file:src/recursos/img/malaFamaIconoDeJuego.png"));
        VistaInicioDeJuego vistaInicioDeJuego = new VistaInicioDeJuego(stage);
        vistaInicioDeJuego.mostrarPantalla();
    }

    public static void main(String[] args) {
        launch();
    }

}