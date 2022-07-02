package edu.fiuba.algo3.controlador.sonido;

import java.io.File;

public class HandlerControlPolicial {
        private static HandlerSonido sonido =
                new HandlerSonido(new File("src/recursos/sonidos/woopwoop.mp3"));
        static public void reproducirSonido(){
            sonido.reproducirSonido();
        }

        static public void detenerSonido(){
            sonido.detenerSonido();
        }
}
