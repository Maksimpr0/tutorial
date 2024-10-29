package org.example.ajedrez;

public class Movimiento {

    private Posicion posInicial;
    private Posicion posFinal;

    public Movimiento() {

    }

    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }
    public boolean esVertical(){
        return posInicial.getColumna()==posFinal.getColumna();
    }
    public boolean esHorizontal(){
        return posInicial.getFila()==posFinal.getFila();
    }
    public boolean esDiagonal(){
        return (Math.abs(posFinal.getFila()-posInicial.getFila()))==(Math.abs(posFinal.getColumna()-posInicial.getColumna()));
    }
    public int saltoVertical(){
        return posFinal.getFila()- posInicial.getFila();
    }
    int saltoHorizontal(){
        return posFinal.getColumna()- posInicial.getColumna();
    }


    public Posicion getPosInicial() {
        return posInicial;
    }

    public Posicion getPosFinal() {
        return posFinal;
    }
}

