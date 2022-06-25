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

        StackPane root =  new StackPane();

        TextField textoCuadroNickName = new TextField();
        textoCuadroNickName.setPromptText("Ingrese su nickname");

        Label etiquetaInfo = new Label();
        etiquetaInfo.setText("");

        Button boton1Jugador = new Button();
        boton1Jugador.setText("MANDALE MECHA");
        //boton1Jugador.setOnAction(new HandlerSeleccion1Jugador(stage));


        VBox contenedorVertical = new VBox (textoCuadroNickName, etiquetaInfo , boton1Jugador);
        contenedorVertical.setSpacing (10);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.setAlignment(Pos.CENTER);

        Image imagen = new Image("file:src/recursos/img/SeleccionDeJugadores.PNG",500,300,true,true);
        final ImageView imagenVista = new ImageView(imagen);

        root.getChildren().addAll(imagenVista, contenedorVertical);

        TextoSeleccionJugadorHandler textoSeleccionJugadorHandler =
                new TextoSeleccionJugadorHandler (etiquetaInfo, textoCuadroNickName);
        textoCuadroNickName.setOnKeyPressed(textoSeleccionJugadorHandler);

        Scene scene = new Scene(root, 500, 500);

        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
    }
}