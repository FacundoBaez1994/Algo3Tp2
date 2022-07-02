package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.sonido.HandlerPiquete;
import edu.fiuba.algo3.controlador.sonido.HandlerSonidoError;
import edu.fiuba.algo3.controlador.sonido.HandlerVictoria;
import edu.fiuba.algo3.modelo.excepciones.PosicionFueraDeLimite;
import edu.fiuba.algo3.modelo.excepciones.VehiculoNoPuedePasar;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Arriba;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.VistaDeLaPartida;
import edu.fiuba.algo3.vista.VistaFinDelJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HandlerBotonMoverArriba implements EventHandler<ActionEvent> {
    private Stage stage;
    private Arriba Arriba;
    private Label etiquetaSucesosDeLaPartida;

    public HandlerBotonMoverArriba(Stage stage, Label etiqueta) {
        this.Arriba = new Arriba();
        this.stage = stage;
        this.etiquetaSucesosDeLaPartida = etiqueta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.etiquetaSucesosDeLaPartida.setText("arriba");
        this.etiquetaSucesosDeLaPartida.setTextFill(Color.GREEN);
        String datosGanador;
        Juego juego = Juego.getInstance();
        Posicion posJugador = new Posicion (juego.obtenerPosicionDeJugadorActual ());
        try {
            juego.jugadorConTurnoActualMueveVehiculo(this.Arriba);
            HandlerUbicables.handleUbicableEnDireccion(posJugador, this.Arriba,  this.stage);
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
            VistaFinDelJuego vistaDeLaPartida = new VistaFinDelJuego(this.stage);
            vistaDeLaPartida.mostrarPantallaGanador (datosGanador);
        } else  {
            VistaDeLaPartida vistaDeLaPartida = new VistaDeLaPartida(this.stage, this.etiquetaSucesosDeLaPartida);
            vistaDeLaPartida.mostrarPantalla();
        }
    }
}
