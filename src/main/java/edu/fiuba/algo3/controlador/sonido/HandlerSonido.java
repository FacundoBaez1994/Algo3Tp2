package edu.fiuba.algo3.controlador.sonido;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class HandlerSonido {
    private File archivoSonido;
    private MediaPlayer mediaPlayer;

    public HandlerSonido(File file){
        this.archivoSonido = file;
    }

    public void reproducirSonido(){
        this.detenerSonido();
        Media sound = new Media(this.archivoSonido.toURI().toString());
        this.mediaPlayer = new MediaPlayer(sound);
        this.mediaPlayer.play();

    }

    public void detenerSonido() {
            if(this.mediaPlayer != null){
                this.mediaPlayer.stop();
            }
        }

}
