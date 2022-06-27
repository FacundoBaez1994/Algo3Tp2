package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.HandlerBotonMoverDerecha;
import edu.fiuba.algo3.controlador.HandlerOpcionMapaChico;
import edu.fiuba.algo3.controlador.HandlerOpcionMapaGrande;
import edu.fiuba.algo3.controlador.HandlerOpcionMapaMediano;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class VistaBotonera {


    public VistaBotonera () {
        super();
    }
    public void mostrarPantalla() {
        StackPane root =  new StackPane();

        Button botonMoverDerecha = new Button();
        botonMoverDerecha.setText("Derecha");
       // botonMoverDerecha.setOnAction(new HandlerBotonMoverDerecha());

       /* Button botonMapaMediano = new Button();
        botonMapaMediano.setText("Izquierda");
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

        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
    }*/
    }
}
