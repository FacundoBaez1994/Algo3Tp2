package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class PuntajesAltos {

    Map<String, Integer> ranking = null;
  //  Map<String, Integer> map = new HashMap<String, Integer>();
    public PuntajesAltos(){
       this.ranking =  new HashMap<String, Integer>();
    }
    public void agregarPuntaje(){
       // this.ranking.put("Ramon", 28000);
    }
   /* public int obtenerPuntajeMasAlto(){
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            final int valorActual = entry.getValue();

            if (valorActual > valorMax)
                valorMax = valorActual;
        }
    }*/
}
