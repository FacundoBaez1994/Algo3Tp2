package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.HandlerComienzoJuegoEnGrilla;
import edu.fiuba.algo3.controlador.TextoSeleccionJugadorHandler;
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

public class VistaSeleccion3Jugadores {
    private final Stage stage;

    public VistaSeleccion3Jugadores (Stage stage) {
        super();
        this.stage = stage;
    }

    public void mostrarPantalla() {
        BarraDeMenu menuBar = new BarraDeMenu(stage);
        VBox vBoxMenuBarra = new VBox(menuBar.getMenuBar());
        //////////////////////

        TextField textoCuadroNickName1 = new TextField();
        textoCuadroNickName1.setPromptText("Ingrese nickname Jugador 1");
        Label etiquetaInfoSobreNickName1 = new Label();
        etiquetaInfoSobreNickName1.setText("");

        TextField textoCuadroNickName2 = new TextField();
        textoCuadroNickName2.setPromptText("Ingrese nickname Jugador 2");
        Label etiquetaInfoSobreNickName2 = new Label();
        etiquetaInfoSobreNickName2.setText("");

        TextField textoCuadroNickName3 = new TextField();
        textoCuadroNickName3.setPromptText("Ingrese nickname Jugador 3");
        Label etiquetaInfoSobreNickName3 = new Label();
        etiquetaInfoSobreNickName3.setText("");

        StackPane root =  new StackPane();

        Button botonEmpezarJuego = new Button();
        botonEmpezarJuego.setText("Mandale Mecha!");
        botonEmpezarJuego.setOnAction(new HandlerComienzoJuegoEnGrilla(stage));
        botonEmpezarJuego.setVisible(false);

        VBox contenedorVertical = new VBox ( textoCuadroNickName1, etiquetaInfoSobreNickName1
                ,textoCuadroNickName2, etiquetaInfoSobreNickName2, textoCuadroNickName3,
                etiquetaInfoSobreNickName3 ,botonEmpezarJuego);
        contenedorVertical.setSpacing (10);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.setAlignment(Pos.CENTER);

        Image imagen = new Image("file:src/recursos/img/SeleccionDeJugadores.PNG",500,300,true,true);
        final ImageView imagenVista = new ImageView(imagen);
        ///////////////////
        VBox contenedorVerticalFinal = new VBox (vBoxMenuBarra, contenedorVertical);
        contenedorVerticalFinal.setSpacing (100);

        root.getChildren().addAll(imagenVista, contenedorVerticalFinal);

        TextoSeleccionJugadorHandler textoSeleccionJugadorHandler1 =
                new TextoSeleccionJugadorHandler (etiquetaInfoSobreNickName1, textoCuadroNickName1, textoCuadroNickName2 );
        textoCuadroNickName1.setOnKeyPressed(textoSeleccionJugadorHandler1);

        TextoSeleccionJugadorHandler textoSeleccionJugadorHandler2 =
                new TextoSeleccionJugadorHandler (etiquetaInfoSobreNickName2, textoCuadroNickName2, textoCuadroNickName3 );
        textoCuadroNickName2.setOnKeyPressed(textoSeleccionJugadorHandler2);

        TextoSeleccionJugadorHandler textoSeleccionJugadorHandler3 =
                new TextoSeleccionJugadorHandler (etiquetaInfoSobreNickName3, textoCuadroNickName3, botonEmpezarJuego );
        textoCuadroNickName3.setOnKeyPressed(textoSeleccionJugadorHandler3);

        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add("file:style.css");

        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
    }
}