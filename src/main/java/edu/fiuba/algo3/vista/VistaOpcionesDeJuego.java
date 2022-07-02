package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.HandlerOpcionMapaChico;
import edu.fiuba.algo3.controlador.HandlerOpcionMapaGrande;
import edu.fiuba.algo3.controlador.HandlerOpcionMapaMediano;
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

public class VistaOpcionesDeJuego {
    private final Stage stage;

    public VistaOpcionesDeJuego (Stage stage) {
        super();
        this.stage = stage;
    }

    public void mostrarPantalla() {
        /*
        TextField texto = new TextField();
        texto.setPromptText("Seleccione Un tamaño del mapa");
    */

        Label etiqueta = new Label();
        etiqueta.setText("Seleccione tamaño del mapa");

        StackPane root =  new StackPane();

        Button botonMapaChico = new Button();
        botonMapaChico.setText("Mapa Chico");
        botonMapaChico.setOnAction(new HandlerOpcionMapaChico(stage));

        Button botonMapaMediano = new Button();
        botonMapaMediano.setText("Mapa Mediano");
        botonMapaMediano.setOnAction(new HandlerOpcionMapaMediano(stage));

        Button botonMapaGrande = new Button();
        botonMapaGrande.setText("Mapa Grande");
        botonMapaGrande.setOnAction(new HandlerOpcionMapaGrande(stage));

        HBox contenedorHorizontal = new HBox (botonMapaChico, botonMapaMediano, botonMapaGrande);
        contenedorHorizontal.setSpacing (25);
        contenedorHorizontal.setAlignment(Pos.CENTER);

        VBox contenedorVertical = new VBox (etiqueta, contenedorHorizontal);
        contenedorVertical.setSpacing (10);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.setAlignment(Pos.CENTER);

        Image imagen = new Image("file:src/recursos/img/LaMatanzaMapa.png",500,300,true,true);
        final ImageView imagenVista = new ImageView(imagen);

        root.getChildren().addAll(imagenVista, contenedorVertical);

        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add("file:style.css");

        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
    }
}