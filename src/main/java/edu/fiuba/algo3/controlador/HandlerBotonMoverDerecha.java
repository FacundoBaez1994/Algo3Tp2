package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.excepciones.PosicionFueraDeLimite;
import edu.fiuba.algo3.modelo.excepciones.VehiculoNoPuedePasar;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Derecha;
import edu.fiuba.algo3.vista.VistaBotonera;
import edu.fiuba.algo3.vista.VistaDeLaPartida;
import edu.fiuba.algo3.vista.VistaFinDelJuego;
import edu.fiuba.algo3.vista.VistaSeleccion1Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HandlerBotonMoverDerecha implements EventHandler<ActionEvent> {
    private Stage stage;
    private Derecha derecha;
    private Label etiquetaSucesosDeLaPartida;

    public HandlerBotonMoverDerecha (Stage stage, Label etiqueta) {
        this.derecha = new Derecha();
        this.stage = stage;
        this.etiquetaSucesosDeLaPartida = etiqueta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.etiquetaSucesosDeLaPartida.setText("derecha");
        this.etiquetaSucesosDeLaPartida.setTextFill(Color.GREEN);
        String datosGanador;
        Juego juego = Juego.getInstance();
        try {
            juego.jugadorConTurnoActualMueveVehiculo(this.derecha);
        } catch (PosicionFueraDeLimite error) {
            this.etiquetaSucesosDeLaPartida.setText("Te fuiste ameo");
            this.etiquetaSucesosDeLaPartida.setTextFill(Color.RED);
            return;
        } catch (VehiculoNoPuedePasar error) {
            this.etiquetaSucesosDeLaPartida.setText("Hay un piquete ahi!");
            this.etiquetaSucesosDeLaPartida.setTextFill(Color.RED);
            return;
        }
        if ((datosGanador = juego.obtenerGanador()) != null) {
            VistaFinDelJuego vistaDeLaPartida = new VistaFinDelJuego(this.stage);
            vistaDeLaPartida.mostrarPantallaGanador (datosGanador);
        } else  {
            VistaDeLaPartida vistaDeLaPartida = new VistaDeLaPartida(this.stage, this.etiquetaSucesosDeLaPartida);
            vistaDeLaPartida.mostrarPantalla();
        }
    }
}
