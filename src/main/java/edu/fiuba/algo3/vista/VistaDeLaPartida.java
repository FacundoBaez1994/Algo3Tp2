package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.excepciones.LlegadaALaMeta;
import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaDeLaPartida {
    private final Stage stage;
    private GridPaneGrilla vistaGrilla;
    private Label etiquetaSucesosDeLaPartida;

    private VistaBotonera vistaBotonera;
    public VistaDeLaPartida (Stage stage) {
        super();
        this.stage = stage;
        this.vistaGrilla = new GridPaneGrilla();
        this.vistaBotonera = new VistaBotonera();
        this.etiquetaSucesosDeLaPartida = new Label();
    }

    public VistaDeLaPartida (Stage stage, Label etiquetaSucesosDeLaPartida) {
        super();
        this.stage = stage;
        this.vistaGrilla = new GridPaneGrilla();
        this.vistaBotonera = new VistaBotonera();
        this.etiquetaSucesosDeLaPartida = etiquetaSucesosDeLaPartida;
    }

    public void mostrarPantalla() {
        String textoNicknameJugador = null;
        String textoPuntajeJugador = null;
        textoNicknameJugador = Juego.getInstance().obtenerNicknameJugadorActual();
        Label etiquetaNicknameJugador = new Label();
        etiquetaNicknameJugador.setText("Jugador turno actual: ".concat(textoNicknameJugador));
        textoPuntajeJugador = String.valueOf(Juego.getInstance().obtenerPuntajeJugadorActual());
        Label etiquetaPuntajeJugador = new Label();
        etiquetaPuntajeJugador.setText("Puntos: ".concat(textoPuntajeJugador));


        VBox vboxInfoJugador = new VBox(etiquetaNicknameJugador, etiquetaPuntajeJugador,this.etiquetaSucesosDeLaPartida );

        Button botonMoverAbajo = new Button();
        botonMoverAbajo.setText("Arriba"); //la etiqueta esta mal a proposito
        Button botonMoverArriba = new Button();
        botonMoverArriba.setText("Abajo"); //la etiqueta esta mal a proposito
        Button botonMoverDerecha = new Button();
        botonMoverDerecha.setText("Derecha");
        Button botonMoverIzquierda = new Button();
        botonMoverIzquierda.setText("Izquierda");

        HBox hboxSuperior = new HBox(botonMoverArriba);
        HBox hboxMedio = new HBox(botonMoverIzquierda, botonMoverDerecha);
        HBox hboxInferior = new HBox(botonMoverAbajo);
        //VBox botonera = new VBox(hboxSuperior, hboxMedio, hboxInferior);
        VBox botonera = new VBox(hboxInferior, hboxMedio, hboxSuperior);

        botonMoverDerecha.setOnAction(new HandlerBotonMoverDerecha(this.stage, this.etiquetaSucesosDeLaPartida) );
        botonMoverIzquierda.setOnAction(new HandlerBotonMoverIzquierda(this.stage, this.etiquetaSucesosDeLaPartida) );
        botonMoverArriba.setOnAction(new HandlerBotonMoverArriba(this.stage, this.etiquetaSucesosDeLaPartida) );
        botonMoverAbajo.setOnAction(new HandlerBotonMoverAbajo(this.stage, this.etiquetaSucesosDeLaPartida));

        VBox vboxComandos = new VBox(vboxInfoJugador, botonera);

        HBox root = new HBox();
        root.getChildren().add(this.vistaGrilla);
        root.getChildren().add(vboxComandos);
        //HandlerTurnos.setVistaPartida(this);

        Scene scene = new Scene(root, 1000, 800);
        scene.getStylesheets().add("file:style.css");
        HandlerTecladoMoverAbajo abajoHandler = new HandlerTecladoMoverAbajo (this.stage, this.etiquetaSucesosDeLaPartida);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, abajoHandler );
        HandlerTecladoMoverArriba arribaHandler = new HandlerTecladoMoverArriba (this.stage, this.etiquetaSucesosDeLaPartida);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, arribaHandler );
        HandlerTecladoMoverIzquierda izqHandler = new HandlerTecladoMoverIzquierda (this.stage, this.etiquetaSucesosDeLaPartida);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, izqHandler );
        HandlerTecladoMoverDerecha derHandler = new HandlerTecladoMoverDerecha (this.stage, this.etiquetaSucesosDeLaPartida);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, derHandler );

        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
        stage.show();
        //Thread.setDefaultUncaughtExceptionHandler()
    }
}
