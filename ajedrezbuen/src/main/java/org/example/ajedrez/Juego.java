package org.example.ajedrez;

import java.util.Scanner;

public class Juego {

    private boolean blanca = true;

    public String elTurno;

    public void setTurno() {
    }

    public Juego() {
        elTurno = "blanca";
    }

    public boolean noEnRango(int numero) {
        return !(numero >= 0 && numero <= 7);
    }

    public Movimiento jugada(String jugada, Tablero tablero) {
        jugada = jugada.toUpperCase();
        Movimiento mov = null;

        int columnainicial = (jugada.charAt(0) - 65);
        int filainicial = 7 - (jugada.charAt(1) - 49);
        int columnafinal = (jugada.charAt(2) - 65);
        int filafinal = 7 - (jugada.charAt(3) - 49);
        //todas las validaciones generales del word (1..6)
        if (jugada.length() != 4)
            System.out.println("Error. La jugada tiene que ser del tipo A2A3");
        else if (noEnRango(filainicial) || (noEnRango(columnainicial))) //están entre 0 y 7 ****
            System.out.println("Error. Las filas van de 1 a 8, y las columnas de la A a la H");
        else if (!(tablero.hayPieza(filainicial, columnainicial))) {
            System.out.println("Error. No hay ninguna pieza en esa posicion.");
        } else if (!tablero.DevuelvePieza(filainicial, columnainicial).color.equals(elTurno)) {
            System.out.println("Error no puedes mover una pieza que no es tuya");

        } else { //ole ole ya tengo movimiento válido en condiciones generales
            mov = new Movimiento(new Posicion(filainicial, columnainicial), new Posicion(filafinal, columnafinal));
        }
        return mov;
    }


    public Movimiento validarJugada(String jugada, Tablero tablero) {


        return null;
    }

    public void cambiarTURNO() {

        if (elTurno.equals("negra")) {
            elTurno = "blanca";

        } else {
            elTurno = "negra";
        }

    }

    public static String promocionElegir(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Elige entre estas opciones : Reina , Alfil , Caballo , Torre");
        String piezaelegida = lector.nextLine();
        return piezaelegida;
    }
//torre no come, caballo no se mueve,no pide ficha nueva,
}






