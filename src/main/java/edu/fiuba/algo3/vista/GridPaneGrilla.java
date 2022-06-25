package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.grilla.Grilla;
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
                // MANZANA o CALLEVERTICAL SON STACKPANE
                // this.add(MANZANA o CALLEVERTICAL, i, unaFila);
            } else {
                // CALLEHORIZONTAL o ESQUINA SON STACKPANE
                // this.add(MANZANA o CALLEVERTICAL, i, unaFila);
            }


        }
    }
}