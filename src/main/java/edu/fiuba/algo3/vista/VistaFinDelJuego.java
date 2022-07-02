package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.juego.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Map;

public class VistaFinDelJuego {
    private Stage stage;

    public VistaFinDelJuego(Stage stage){
        this.stage = stage;
    }

    public void mostrarPantallaGanador(String datosGanador, ArrayList<Jugador> jugadores){
        StackPane root =  new StackPane();

        Label etiquetaJugador = new Label();
        etiquetaJugador.setText("Jugador ganador: ".concat(datosGanador));

        HBox vboxJugadorGanador = new HBox(etiquetaJugador);

        ObservableList<Jugador> miembrosDelRanking = FXCollections.observableArrayList(jugadores);

        TableView<Jugador> tablaRanking = new TableView<>(miembrosDelRanking);

        TableColumn<Jugador, String> columnaNickname = new TableColumn<>("Nickname");
        columnaNickname.setMaxWidth(100);
        columnaNickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));

        TableColumn<Jugador, Integer> columnaPuntaje = new TableColumn<>("Puntaje");
        columnaPuntaje.setMaxWidth(100);
        columnaPuntaje.setCellValueFactory(new PropertyValueFactory<>("puntaje"));


        tablaRanking.getColumns().add(columnaNickname);
        tablaRanking.getColumns().add(columnaPuntaje);
        //tablaRanking.setMaxHeight(300);
        tablaRanking.setMaxWidth(200);


        VBox vbox = new VBox();
        vbox.setSpacing (25);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(vboxJugadorGanador);
        vbox.getChildren().add(tablaRanking);

        Image imagen = new Image("file:src/recursos/img/ganador.png",1000,800,true,true);
        final ImageView imagenVista = new ImageView(imagen);

        root.getChildren().addAll(imagenVista, vbox);

        Scene scene = new Scene(root, 1000, 800);
        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
        stage.show();
    }

}
