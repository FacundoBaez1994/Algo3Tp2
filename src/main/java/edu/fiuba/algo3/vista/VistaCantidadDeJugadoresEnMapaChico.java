package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.HandlerSeleccion1Jugador;
import edu.fiuba.algo3.controlador.HandlerSeleccion2Jugadores;
import javafx.geometry.Insets;
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

public class VistaCantidadDeJugadoresEnMapaChico {
    private final Stage stage;

    public VistaCantidadDeJugadoresEnMapaChico(Stage stage) {
        super();
        this.stage = stage;
    }

    public void mostrarPantalla() {
        BarraDeMenu menuBar = new BarraDeMenu(stage);
        VBox vBoxMenuBarra = new VBox(menuBar.getMenuBar());
        //////////////////////

        Label etiqueta = new Label();
        etiqueta.setText("Seleccione cantidad de jugadores");

        StackPane root =  new StackPane();

        Button boton1Jugador = new Button();
        boton1Jugador.setText("1 Jugador");
        boton1Jugador.setOnAction(new HandlerSeleccion1Jugador(stage));

        Button boton2Jugadores = new Button();
        boton2Jugadores.setText("2 Jugadores");
        boton2Jugadores.setOnAction(new HandlerSeleccion2Jugadores(stage));

        VBox contenedorVertical = new VBox (etiqueta, boton1Jugador, boton2Jugadores);
        contenedorVertical.setSpacing (10);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.setAlignment(Pos.CENTER);

        Image imagen = new Image("file:src/recursos/img/SeleccionDeJugadores.PNG",1000, 800,true,true);
        final ImageView imagenVista = new ImageView(imagen);
        ///////////////////
        VBox contenedorVerticalFinal = new VBox (vBoxMenuBarra, contenedorVertical);
        contenedorVerticalFinal.setSpacing (100);

        root.getChildren().addAll(imagenVista, contenedorVerticalFinal);

        Scene scene = new Scene(root, 1000, 800);
        scene.getStylesheets().add("file:style.css");

        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
    }
}