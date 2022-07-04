package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaDeLaPartida {
    private final Stage stage;
    private GridPaneGrilla vistaGrilla;
    private Label etiquetaSucesosDeLaPartida;

    public VistaDeLaPartida (Stage stage) {
        super();
        this.stage = stage;
        this.vistaGrilla = new GridPaneGrilla();
        this.etiquetaSucesosDeLaPartida = new Label();
    }

    public VistaDeLaPartida (Stage stage, Label etiquetaSucesosDeLaPartida) {
        super();
        this.stage = stage;
        this.vistaGrilla = new GridPaneGrilla();
        this.etiquetaSucesosDeLaPartida = etiquetaSucesosDeLaPartida;
    }

    public void mostrarPantalla() {
        BarraDeMenu menuBar = new BarraDeMenu(stage);
        VBox vBoxMenuBarra = new VBox(menuBar.getMenuBar());

        String textoNicknameJugador = null;
        String textoPuntajeJugador = null;
        textoNicknameJugador = Juego.getInstance().obtenerNicknameJugadorActual();
        Label etiquetaNicknameJugador = new Label();
        etiquetaNicknameJugador.setText("Jugador turno actual: ".concat(textoNicknameJugador));
        textoPuntajeJugador = String.valueOf(Juego.getInstance().obtenerPuntajeJugadorActual());
        Label etiquetaPuntajeJugador = new Label();
        etiquetaPuntajeJugador.setText("Puntos: ".concat(textoPuntajeJugador));


        VBox vboxInfoJugador = new VBox(etiquetaNicknameJugador, etiquetaPuntajeJugador,this.etiquetaSucesosDeLaPartida );





        VBox vboxComandos = new VBox(vboxInfoJugador);

        VBox root = new VBox();
        root.getChildren().add(vBoxMenuBarra);
        root.getChildren().add(vboxComandos);
        root.getChildren().add(this.vistaGrilla);
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
