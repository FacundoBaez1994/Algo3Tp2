package edu.fiuba.algo3.modelo;

public class Piquete implements Obstaculo {

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals( obj.getClass() );
    }

}
