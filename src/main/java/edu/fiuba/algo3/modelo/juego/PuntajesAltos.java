package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.grilla.Ubicable;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class PuntajesAltos {
    private ArrayList<Puntaje> puntajes = null;
    public PuntajesAltos(){
       this.puntajes =  new ArrayList<>();
    }
    public void agregarPuntaje(Puntaje unPuntaje){
       puntajes.add(unPuntaje);
    }
    public void ordenarPuntajes(){
    }

}
