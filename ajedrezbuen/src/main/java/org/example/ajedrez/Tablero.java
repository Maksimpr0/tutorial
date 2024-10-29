package org.example.ajedrez;

public class Tablero {

    protected Pieza[][] tablero;

    public Tablero() {
        tablero = new Pieza[8][8];
        tablero[0][0] = new Torre("negra");
        tablero[0][1] = new Caballo("negra");
        tablero[0][2] = new Alfil("negra");
        tablero[0][3] = new Reina("negra");
        tablero[0][4] = new Rey("negra");
        tablero[0][5] = new Alfil("negra");
        tablero[0][6] = new Caballo("negra");
        tablero[0][7] = new Torre("negra");
        for (int j = 0; j < 8; j++) {
            tablero[1][j] = new Peon("negra");
        }
        tablero[7][0] = new Torre("blanca");
        tablero[7][1] = new Caballo("blanca");
        tablero[7][2] = new Alfil("blanca");
        tablero[7][3] = new Reina("blanca");
        tablero[7][4] = new Rey("blanca");
        tablero[7][5] = new Alfil("blanca");
        tablero[7][6] = new Caballo("blanca");
        tablero[7][7] = new Torre("blanca");
        for (int j = 0; j < 8; j++) {
            tablero[6][j] = new Peon("blanca");
        }


    }


    public void pintarTablero() {
        for (int i = 0; i < 8; i++) {
            System.out.print((7- i+1) + "\t");
            for (int j = 0; j < 8; j++) {
                //****
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void Enroque(){


    }


    public void mover(Movimiento mover) {
        tablero[mover.getPosFinal().getFila()][mover.getPosFinal().getColumna()] = tablero[mover.getPosInicial().getFila()][mover.getPosInicial().getColumna()];
        tablero[mover.getPosInicial().getFila()][mover.getPosInicial().getColumna()] = null;

    }

    public boolean hayPieza(int fila, int columna) {

        return tablero[fila][columna] != null;
    }

    public boolean hayPieza(Posicion pos) {

        return hayPieza(pos.getFila(), pos.getColumna());
    }

    public boolean hayPiezasEntre(Movimiento mov) {
        boolean respuesta = false;
        //si no es caballo respuesta false****
        //if(hayPieza(mov.getPosInicial()) && DevuelvePieza(mov.getPosInicial()) instanceof Caballo
        if (mov.esVertical()) {
            if (mov.getPosInicial().getFila() < mov.getPosFinal().getFila()) {
                for (int fila = mov.getPosInicial().getFila() + 1; fila < mov.getPosFinal().getFila(); fila++) {
                    if (hayPieza(fila,mov.getPosInicial().getColumna())){
                        respuesta = true;
                    }

                }
            } else
                for (int i = mov.getPosInicial().getFila() - 1; i > mov.getPosFinal().getFila(); i--) {
                    if (hayPieza(i,mov.getPosInicial().getColumna())){
                        respuesta = true;
                    }

                }
        }
        else if (mov.esHorizontal()){
            if (mov.getPosInicial().getColumna()<mov.getPosFinal().getColumna()){
                for (int i = mov.getPosInicial().getColumna()+1; i < mov.getPosFinal().getColumna(); i++) {
                    if (hayPieza(i,mov.getPosInicial().getFila())){
                        respuesta = true;
                    }
                }

            }
            else
                for (int i = mov.getPosInicial().getColumna()-1; i > mov.getPosFinal().getColumna(); i--) {
                    if (hayPieza(i,mov.getPosInicial().getFila())){
                        respuesta = true;
                    }

                }

        }
        else if (mov.esDiagonal()){
            if (mov.getPosInicial().getColumna()<mov.getPosFinal().getColumna()){

            }

        }


        return respuesta;
    }

    public void ponPieza(Pieza figura, int fila, int columna) {
    tablero[fila][columna]= figura;

    }

    public void ponPieza(Pieza figura, Posicion Pos) {
    tablero[Pos.getFila()][Pos.getColumna()]=figura;

    }

    public void quitaPieza(int fila, int columna) {


    }

    public void QuitaPieza(Posicion pos) {


    }

    public Pieza DevuelvePieza(int fila, int columna) {
        return tablero[fila][columna];
    }

    public Pieza DevuelvePieza(Posicion pos) {

        return null;
    }


}
