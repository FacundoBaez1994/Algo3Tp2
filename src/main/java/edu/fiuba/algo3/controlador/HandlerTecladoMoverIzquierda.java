package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.sonido.HandlerPiquete;
import edu.fiuba.algo3.controlador.sonido.HandlerSonidoError;
import edu.fiuba.algo3.modelo.excepciones.PosicionFueraDeLimite;
import edu.fiuba.algo3.modelo.excepciones.VehiculoNoPuedePasar;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Arriba;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.VistaDeLaPartida;
import edu.fiuba.algo3.vista.VistaFinDelJuego;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HandlerTecladoMoverIzquierda implements EventHandler <KeyEvent>  {
    private Stage stage;
    private Izquierda izquierda;
    private Label etiquetaSucesosDeLaPartida;

    public HandlerTecladoMoverIzquierda(Stage stage, Label etiqueta) {
        this.izquierda = new Izquierda ();
        this.stage = stage;
        this.etiquetaSucesosDeLaPartida = etiqueta;
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.A) {
            this.etiquetaSucesosDeLaPartida.setText("izquierda");
            this.etiquetaSucesosDeLaPartida.setTextFill(Color.GREEN);
            String datosGanador;
            Juego juego = Juego.getInstance();
            Posicion posJugador = new Posicion (juego.obtenerPosicionDeJugadorActual ());
            try {
                juego.jugadorConTurnoActualMueveVehiculo(this.izquierda);
                HandlerUbicables.handleUbicableEnDireccion(posJugador, this.izquierda, this.stage);
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
