package org.example.ajedrez;

public class Alfil extends Pieza{

    public Alfil(String color) {
        super(color);
        if (color.equals("negra")){
            nombre="\u2657  ";
        }
        else{
            nombre="\u265D  ";
        }
    }

    @Override
    boolean validoMovimiento(Movimiento mov , Tablero tablero) {
        return mov.esDiagonal();
    }


}
