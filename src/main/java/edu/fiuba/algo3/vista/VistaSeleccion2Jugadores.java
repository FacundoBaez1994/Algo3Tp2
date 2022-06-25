package edu.fiuba.algo3.vista;

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

public class VistaSeleccion2Jugadores {
    private final Stage stage;

    public VistaSeleccion2Jugadores (Stage stage) {
        super();
        this.stage = stage;
    }

    public void mostrarPantalla() {

        TextField textoCuadroNickName1 = new TextField();
        textoCuadroNickName1.setPromptText("Ingrese nickname Jugador 1");

        TextField textoCuadroNickName2 = new TextField();
        textoCuadroNickName2.setPromptText("Ingrese nickname Jugador 2");

        Label etiqueta = new Label();
        etiqueta.setText("Seleccione cantidad de jugadores");
        StackPane root =  new StackPane();

        Button boton1Jugador = new Button();
        boton1Jugador .setText("SELECCION");
       // boton1Jugador.setOnAction(new HandlerSeleccion1Jugador(stage));


        VBox contenedorVertical = new VBox ( textoCuadroNickName1, textoCuadroNickName2, boton1Jugador);
        contenedorVertical.setSpacing (10);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.setAlignment(Pos.CENTER);

        Image imagen = new Image("file:src/recursos/img/SeleccionDeJugadores.PNG",500,300,true,true);
        final ImageView imagenVista = new ImageView(imagen);

        root.getChildren().addAll(imagenVista, contenedorVertical);

        Scene scene = new Scene(root, 500, 500);

        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
    }
}