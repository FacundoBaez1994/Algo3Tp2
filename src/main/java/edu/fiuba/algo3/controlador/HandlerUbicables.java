package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.sonido.HandlerControlPolicial;
import edu.fiuba.algo3.controlador.sonido.HandlerPiquete;
import edu.fiuba.algo3.controlador.sonido.HandlerPozo;
import edu.fiuba.algo3.controlador.sonido.HandlerSorpresa;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.grilla.Ubicable;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaNoFavorable;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class HandlerUbicables {

    public HandlerUbicables () {}

    static public void handleUbicableEnDireccion (Posicion posJugador ,Direccion direccion, Stage stage){
        Grilla grilla = Grilla.getInstance();
        Posicion posicionRelativa = posJugador.obtenerSumaDeCoordenadas(direccion.posicionRelativa());
        Ubicable ubicable = grilla.getUbicableEn(posicionRelativa);
        for (int i =0; i < 2; i++) {
            if ( ubicable != null) {
                if (ubicable.getClass() == (new ControlPolicial()).getClass()){
                    HandlerControlPolicial.reproducirSonido();
                }
                if (ubicable.getClass() == (new Pozo()).getClass()){
                    HandlerPozo.reproducirSonido();
                }
                if (ubicable.getClass() == (new SorpresaNoFavorable()).getClass() )  {
                    HandlerSorpresa.reproducirSonido();
                    PopupSorpresa pop = new PopupSorpresa( "Sorpresa No favorable encontrada");
                    pop.mostrar(stage);
                }
                if (ubicable.getClass() == (new SorpresaFavorable()).getClass() )  {
                    HandlerSorpresa.reproducirSonido();
                    PopupSorpresa pop = new PopupSorpresa( "Sorpresa favorable encontrada");
                    pop.mostrar(stage);
                }
                if (ubicable.getClass() == (new CambioDeVehiculo()).getClass() )  {
                    HandlerSorpresa.reproducirSonido();
                    PopupSorpresa pop = new PopupSorpresa( "Cambio De Vehiculo!");
                    pop.mostrar(stage);
                }
            }
            posicionRelativa = posicionRelativa.obtenerSumaDeCoordenadas(direccion.posicionRelativa());
            ubicable = grilla.getUbicableEn(posicionRelativa);
        }

    }

}
