package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class GridPaneGrilla extends GridPane {
    private Stage ventana = new Stage();

    public GridPaneGrilla () {
        super();
        Grilla grilla = Grilla.getInstance();
        int maxCoordenadaY = grilla.getMaximaCantidadDePosicionesEnY();
        for(int j=0; j< maxCoordenadaY; j++) {
                this.cargarVistaDeFilaGrilla (j);
        }
    }

    private void cargarVistaDeFilaGrilla (int unaFila){
        Grilla grilla = Grilla.getInstance();
        int maxCoordenadaX = grilla.getMaximaCantidadDePosicionesEnX();
        for(int i=0; i< maxCoordenadaX; i++) {
            if (unaFila == 0 ||  ((unaFila % 2) == 0) ) {
                if (i == 0 || ((i % 2) == 0) ) {
                    // MANZANA es una STACKPANE
                    VistaManzana vistaManzana = new VistaManzana (new Posicion(i, unaFila));
                    this.add(vistaManzana, i, unaFila);
                }else {
                // CALLEVERTICAL es un STACKPANE
                    VistaCalleVertical vistaCalleVertical = new VistaCalleVertical (new Posicion(i, unaFila));
                    this.add(vistaCalleVertical, i, unaFila);
                }
            } else {
                if (i == 0 || ((i % 2) == 0) ) {
                    // CALLE HORIZONTAL es una STACKPANE
                    VistaCalleHorizontal vistaCalleHorizontal = new VistaCalleHorizontal (new Posicion(i, unaFila));
                    this.add(vistaCalleHorizontal, i, unaFila);
                } else {
                    // ESQUINA es un STACKPANE
                    VistaEsquina vistaEsquina = new VistaEsquina (new Posicion(i, unaFila));
                    this.add(vistaEsquina , i, unaFila);
                }
            }
        }
    }
}