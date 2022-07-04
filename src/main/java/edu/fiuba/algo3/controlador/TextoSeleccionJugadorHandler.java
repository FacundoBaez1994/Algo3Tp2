package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.sonido.HandlerSonidoError;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class TextoSeleccionJugadorHandler implements EventHandler <KeyEvent> {

    private Label unaEtiqueta;
    private TextField unNickName;
    private TextField unNickNameProximo;
    private Button unBoton;

    public TextoSeleccionJugadorHandler (Label etiquetaInfo,
                                         TextField  textoCuadroNickName,
                                         TextField unNickNameProximo){
        this.unaEtiqueta = etiquetaInfo;
        this.unNickName = textoCuadroNickName;
        this.unNickNameProximo = unNickNameProximo;
        this.unBoton =  new Button();
        this.unNickNameProximo.setEditable(false);
    }

    public TextoSeleccionJugadorHandler (Label etiquetaInfo,
                                         TextField  textoCuadroNickName){
        this.unaEtiqueta = etiquetaInfo;
        this.unNickName = textoCuadroNickName;
        this.unBoton =  new Button();
        this.unBoton.setVisible(false);
        this.unNickNameProximo = new TextField();
    }

    public TextoSeleccionJugadorHandler (Label etiquetaInfo,
                                         TextField  textoCuadroNickName, Button unBoton){
        this.unaEtiqueta = etiquetaInfo;
        this.unNickName = textoCuadroNickName;
        this.unBoton =  unBoton;
        this.unNickNameProximo = new TextField();
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER && unNickName.isEditable()) {
            int maxLength = 50;
            if (this.unNickName.getText().trim().equals("")) {
                HandlerSonidoError.reproducirSonido();
                this.unaEtiqueta.setText("Nombre invalido");
                this.unaEtiqueta.setTextFill(Color.RED);
                this.unNickName.requestFocus();
            }
            if (this.unNickName.getText().length() > maxLength) {
                HandlerSonidoError.reproducirSonido();
                this.unaEtiqueta.setText("Nombre invalido, es muy largo");
                this.unaEtiqueta.setTextFill(Color.RED);
                this.unNickName.requestFocus();
            }
            else {
                this.unaEtiqueta.setText("NickName guardado: " + this.unNickName.getText());
                this.unaEtiqueta.setTextFill(Color.GREEN);
                Grilla grilla = Grilla.getInstance();
                int coordenadaY = 1 + grilla.getMaximaCantidadDePosicionesEnY() / 2;
                Juego juego = Juego.getInstance();
                Jugador unJugador = new Jugador(this.unNickName.getText(),
                        new Posicion(1, coordenadaY));
                juego.agregarJugador (unJugador);
                this.unNickName.setEditable(false);
                this.unNickNameProximo.setEditable(true);
                this.unBoton.setVisible(true);
            }
        }
    }
}
