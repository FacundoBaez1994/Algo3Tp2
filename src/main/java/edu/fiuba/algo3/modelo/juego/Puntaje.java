package edu.fiuba.algo3.modelo.juego;

public class Puntaje {
    private String nombre = "";
    private int cantidadDePuntos = 0;

    public Puntaje(String unNombre, int puntos){
        this.nombre = unNombre;
        this.cantidadDePuntos = puntos;
    }

    public int getCantidadDePuntos() {
        return cantidadDePuntos;
    }

    public String getNombre() {
        return nombre;
    }
}
