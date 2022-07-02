package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaOpcionesDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Popup;
import javafx.stage.Stage;
import edu.fiuba.algo3.controlador.sonido.HandlerTemaPrincipal;
import edu.fiuba.algo3.vista.VistaOpcionesDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HandlerBotonPopupSorpresa implements EventHandler<ActionEvent>  {
        private Popup popup;


        public HandlerBotonPopupSorpresa (Popup popup) {
            super();
            this.popup = popup;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            this.popup.hide();
        }
}

