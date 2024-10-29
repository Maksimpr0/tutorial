package org.example.ajedrez;

public abstract class Pieza {
    protected String color;
    protected String nombre;

    public Pieza(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }


   abstract boolean validoMovimiento (Movimiento mov, Tablero tablero);



    @Override
    public String toString() {
        return nombre;
    }



}
