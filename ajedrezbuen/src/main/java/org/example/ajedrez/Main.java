package org.example.ajedrez;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Tablero tablero = new Tablero();
        Juego juego = new Juego();
        boolean jugar = true;
        Movimiento movimiento = null;
        do {

            tablero.pintarTablero();
            do {
                System.out.print("\n\tIntroduzca jugada: ");
                String mov = lector.nextLine();
                movimiento = juego.jugada(mov, tablero); //validar la jugada en condiciones generales
            } while (movimiento == null);
            System.out.println(juego.elTurno);
            if (tablero.tablero[movimiento.getPosInicial().getFila()][movimiento.getPosInicial().getColumna()].validoMovimiento(movimiento, tablero)) {//valido en cuanto a la pieza y si hay en medio

                if (tablero.hayPiezasEntre(movimiento) == false) {
                    tablero.mover(movimiento);
                    juego.cambiarTURNO();
                }

            }


        } while (jugar);


    }
}
