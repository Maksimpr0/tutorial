package org.example.ajedrez;

public class Rey extends Pieza{

    protected boolean usadorey = false;
    public Rey(String color) {
        super(color);
        if (color=="negra"){
            nombre="\u2654  ";
        }
        else{
            nombre="\u265A  ";
        }
    }

    @Override
    boolean validoMovimiento(Movimiento mov,Tablero tablero) {
        boolean movimientovalido = false;
if (mov.esDiagonal() || (mov.esVertical() && Math.abs(mov.saltoVertical())==1)|| mov.esHorizontal() && Math.abs(mov.saltoHorizontal())==1){
    movimientovalido = true;
    usadorey = true;
}



        return movimientovalido;
        }
}
