package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.HandlerInicioDeJuego;
import edu.fiuba.algo3.controlador.sonido.HandlerTemaPrincipal;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaInicioDeJuego {
    private Stage stage;

    public VistaInicioDeJuego(Stage stage){
        this.stage = stage;
    }

    public void mostrarPantalla() {
        HandlerTemaPrincipal handlerTemaPrincipal = new HandlerTemaPrincipal ();
        handlerTemaPrincipal.reproducirSonido();

        BarraDeMenu menuBar = new BarraDeMenu(stage);



        StackPane root =  new StackPane();
        Button buttonInicio = new Button();
        buttonInicio.setText("Iniciar juego");
        buttonInicio.setOnAction(new HandlerInicioDeJuego(stage));
        buttonInicio.setMaxSize(120,60);


        Image imagen = new Image("file:src/recursos/img/InicioGPSChallenge.png",1000, 800,true,true);
        final ImageView imagenVista = new ImageView(imagen);


        VBox vBox = new VBox(menuBar.getMenuBar());
        root.getChildren().addAll(imagenVista, vBox, buttonInicio);




        Scene scene = new Scene(root, 1000, 800);
        scene.getStylesheets().add("file:style.css");
        stage.setTitle("GPS CHALLENGE");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
