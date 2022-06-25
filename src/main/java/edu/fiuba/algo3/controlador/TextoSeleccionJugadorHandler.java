package edu.fiuba.algo3.controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextoSeleccionJugadorHandler implements EventHandler <KeyEvent> {

    private Label unaEtiqueta;
    private TextField unNickName;
    public TextoSeleccionJugadorHandler (Label etiquetaInfo, TextField  textoCuadroNickName){
        this.unaEtiqueta = etiquetaInfo;
        this.unNickName = textoCuadroNickName;
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

        }
    }
}
