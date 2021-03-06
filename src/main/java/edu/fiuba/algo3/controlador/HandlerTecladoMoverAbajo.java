package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.sonido.HandlerPiquete;
import edu.fiuba.algo3.controlador.sonido.HandlerSonidoError;
import edu.fiuba.algo3.modelo.excepciones.PosicionFueraDeLimite;
import edu.fiuba.algo3.modelo.excepciones.VehiculoNoPuedePasar;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Abajo;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.VistaDeLaPartida;
import edu.fiuba.algo3.vista.VistaFinDelJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HandlerTecladoMoverAbajo implements EventHandler <KeyEvent>  {
    private Stage stage;
    private Abajo abajo;
    private Label etiquetaSucesosDeLaPartida;

    public HandlerTecladoMoverAbajo(Stage stage, Label etiqueta) {
        this.abajo = new Abajo();
        this.stage = stage;
        this.etiquetaSucesosDeLaPartida = etiqueta;
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.W) {
            this.etiquetaSucesosDeLaPartida.setText("arriba");
            this.etiquetaSucesosDeLaPartida.setTextFill(Color.GREEN);
            String datosGanador;
            Juego juego = Juego.getInstance();
            Posicion posJugador = new Posicion (juego.obtenerPosicionDeJugadorActual ());
            try {
                juego.jugadorConTurnoActualMueveVehiculo(this.abajo);
                HandlerUbicables.handleUbicableEnDireccion(posJugador, this.abajo, this.stage);
            } catch (PosicionFueraDeLimite error) {
                HandlerSonidoError.reproducirSonido();
                PopupSorpresa pop = new PopupSorpresa( "Te fuiste del mapa");
                pop.mostrar(stage);
                return;
            } catch (VehiculoNoPuedePasar error) {
                HandlerPiquete.reproducirSonido();
                PopupSorpresa pop = new PopupSorpresa( "Hay un piquete!");
                pop.mostrar(stage);
                return;
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
}
