package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.HandlerBotonVolver;
import edu.fiuba.algo3.controlador.HandlerOpcionMapaMediano;
import edu.fiuba.algo3.controlador.sonido.HandlerTemaPrincipal;
import edu.fiuba.algo3.controlador.sonido.HandlerVictoria;

import edu.fiuba.algo3.modelo.juego.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


public class VistaFinDelJuego {
    private Stage stage;

    public VistaFinDelJuego(Stage stage){
        this.stage = stage;
    }

    public void mostrarPantallaGanador(String datosGanador, ArrayList<Jugador> jugadores){
        HandlerTemaPrincipal.detenerSonido();
        HandlerVictoria.reproducirSonido();
        StackPane root =  new StackPane();
        Label etiquetaJugador = new Label();
        Button botonVolver = new Button();

        botonVolver.setText("Volver a jugar");
        etiquetaJugador.setText("".concat(datosGanador).concat(", has llegado a la meta."));

        botonVolver.setOnAction(new HandlerBotonVolver(stage));

        HBox vboxJugadorGanador = new HBox(etiquetaJugador);

        ObservableList<Jugador> miembrosDelRanking = FXCollections.observableArrayList(jugadores);

        TableView<Jugador> tablaRanking = new TableView<>(miembrosDelRanking);

        TableColumn<Jugador, String> columnaNickname = new TableColumn<>("Nickname");
        columnaNickname.setMinWidth(200);
        columnaNickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));

        TableColumn<Jugador, Integer> columnaPuntaje = new TableColumn<>("Puntaje");
        columnaPuntaje.setMinWidth(200);
        columnaPuntaje.setCellValueFactory(new PropertyValueFactory<>("puntaje"));


        tablaRanking.getColumns().add(columnaNickname);
        tablaRanking.getColumns().add(columnaPuntaje);
        tablaRanking.setMaxHeight(400);
        tablaRanking.setMaxWidth(400);

        etiquetaJugador.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.setSpacing (25);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(etiquetaJugador);
        vbox.getChildren().add(tablaRanking);
        vbox.getChildren().add(botonVolver);

        Image imagen = new Image("file:src/recursos/img/ganador.png",1000,800,true,true);
        final ImageView imagenVista = new ImageView(imagen);

        root.getChildren().addAll(imagenVista, vbox);

        Scene scene = new Scene(root, 1000, 800);
        scene.getStylesheets().add("file:style.css");
        etiquetaJugador.setFont(new Font("Arial",40));
        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
        stage.show();
    }

}
