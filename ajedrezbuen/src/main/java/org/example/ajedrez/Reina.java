package org.example.ajedrez;

public class Reina extends Pieza{

    public Reina(String color) {
        super(color);
        if (color.equals("negra")){
            nombre="\u2655  ";
        }
        else  {
            nombre="\u265B  ";
        }
    }

    @Override
    boolean validoMovimiento(Movimiento mov,Tablero tablero) {
        return mov.esDiagonal() || mov.esVertical() || mov.esHorizontal();
    }

}
