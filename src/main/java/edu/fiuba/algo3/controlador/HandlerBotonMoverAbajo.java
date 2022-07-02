package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.excepciones.PosicionFueraDeLimite;
import edu.fiuba.algo3.modelo.excepciones.VehiculoNoPuedePasar;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Abajo;
import edu.fiuba.algo3.vista.VistaDeLaPartida;
import edu.fiuba.algo3.vista.VistaFinDelJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HandlerBotonMoverAbajo implements EventHandler<ActionEvent> {
    private Stage stage;
    private Abajo abajo;
    private Label etiquetaSucesosDeLaPartida;

    public HandlerBotonMoverAbajo(Stage stage, Label etiqueta) {
        this.abajo = new Abajo();
        this.stage = stage;
        this.etiquetaSucesosDeLaPartida = etiqueta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.etiquetaSucesosDeLaPartida.setText("abajo");
        this.etiquetaSucesosDeLaPartida.setTextFill(Color.GREEN);
        String datosGanador;
        Juego juego = Juego.getInstance();
        try {
            juego.jugadorConTurnoActualMueveVehiculo(this.abajo);
        } catch (PosicionFueraDeLimite error) {
            this.etiquetaSucesosDeLaPartida.setText("Te fuiste ameo");
            this.etiquetaSucesosDeLaPartida.setTextFill(Color.RED);
        } catch (VehiculoNoPuedePasar error) {
            this.etiquetaSucesosDeLaPartida.setText("Hay un piquete ahi!");
            this.etiquetaSucesosDeLaPartida.setTextFill(Color.RED);
        }
        if ((datosGanador = juego.obtenerGanador()) != null) {
            try {
                juego.exportarPuntajesAltos();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            VistaFinDelJuego vistaDeLaPartida = new VistaFinDelJuego(this.stage);
            vistaDeLaPartida.mostrarPantallaGanador (datosGanador, juego.obtenerPuntajesAltos());
        }else  {
            VistaDeLaPartida vistaDeLaPartida = new VistaDeLaPartida(this.stage, this.etiquetaSucesosDeLaPartida);
            vistaDeLaPartida.mostrarPantalla();
        }
    }
}
