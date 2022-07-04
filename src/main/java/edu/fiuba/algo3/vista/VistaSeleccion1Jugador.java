package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaSeleccion1Jugador {
    private final Stage stage;

    public VistaSeleccion1Jugador(Stage stage) {
        super();
        this.stage = stage;
    }

    public void mostrarPantalla() {
        BarraDeMenu menuBar = new BarraDeMenu(stage);
        VBox vBoxMenuBarra = new VBox(menuBar.getMenuBar());
        //////////////////////
        StackPane root =  new StackPane();

        TextField textoCuadroNickName = new TextField();
        textoCuadroNickName.setPromptText("Ingrese su nickname");

        Label etiquetaInfo = new Label();
        etiquetaInfo.setText("");

        Button botonEmpezarJuego = new Button();
        botonEmpezarJuego.setText("MANDALE MECHA!");
        botonEmpezarJuego.setVisible(false);
        botonEmpezarJuego.setOnAction(new HandlerComienzoJuegoEnGrilla (stage));


        VBox contenedorVertical = new VBox (textoCuadroNickName, etiquetaInfo , botonEmpezarJuego);
        contenedorVertical.setSpacing (10);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.setAlignment(Pos.CENTER);

        Image imagen = new Image("file:src/recursos/img/SeleccionDeJugadores.PNG",500,300,true,true);
        final ImageView imagenVista = new ImageView(imagen);
        ///////////////////
        VBox contenedorVerticalFinal = new VBox (vBoxMenuBarra, contenedorVertical);
        contenedorVerticalFinal.setSpacing (200);

        root.getChildren().addAll(imagenVista, contenedorVerticalFinal);

        TextoSeleccionJugadorHandler textoSeleccionJugadorHandler =
                new TextoSeleccionJugadorHandler (etiquetaInfo, textoCuadroNickName, botonEmpezarJuego);
        textoCuadroNickName.setOnKeyPressed(textoSeleccionJugadorHandler);

        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add("file:style.css");

        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
    }
}