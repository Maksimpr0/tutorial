package org.example.ajedrez;

public class Caballo extends Pieza{

    public Caballo(String color) {
        super(color);
        if (color=="negra"){
            nombre="\u2658  ";
        }
        else
            nombre="\u265E  ";

    }

    @Override
    boolean validoMovimiento(Movimiento mov ,Tablero tablero) {





        return (Math.abs(mov.saltoVertical())==1 && (Math.abs(mov.saltoHorizontal())==2))||(Math.abs(mov.saltoVertical())==2 && Math.abs(mov.saltoHorizontal())==1);
    }
}
