package org.example.ajedrez;

public class Torre extends Pieza{

    protected boolean usadotorre = false;

    public Torre(String color) {
        super(color);
        if (color.equals("negra")){
            nombre="\u2656  ";
        }
        else{
            nombre="\u265C  ";
        }
    }

    @Override
    boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean movimientovalido = false;
        if (mov.esHorizontal() || mov.esVertical()){
            usadotorre = true;
            movimientovalido=true;
        }
        return movimientovalido;
    }
}
