package org.example.ajedrez;

public class Peon extends Pieza {

    public Peon(String color) {
        super(color);
        if (color == "negra") {
            nombre = "\u2659  ";
        } else {
            nombre = "\u265F  ";
        }

    }

    @Override
    boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean respuesta = false;

        if ((color.equals("blanca") && mov.getPosInicial().getFila() == 6 && mov.esVertical() && (mov.saltoVertical() == -1 || mov.saltoVertical() == -2) && !tablero.hayPieza(mov.getPosFinal()))
                || ((color.equals("negra") && mov.getPosInicial().getFila() == 1 && mov.esVertical() && (mov.saltoVertical() == 1 || mov.saltoVertical() == 2) && !tablero.hayPieza(mov.getPosFinal())))
                || ((color.equals("blanca") && mov.esDiagonal() && mov.saltoVertical() == -1 && tablero.hayPieza(mov.getPosFinal())))
                || (color.equals("negra") && mov.esDiagonal() && mov.saltoVertical() == 1 && tablero.hayPieza(mov.getPosFinal()))
                || (color.equals("blanca") && mov.esVertical() && mov.saltoVertical() == -1 && !tablero.hayPieza(mov.getPosFinal()))
                || (color.equals("negra") && mov.esVertical() && mov.saltoVertical() == 1 && !tablero.hayPieza(mov.getPosFinal()))) {
            respuesta = true;
        }
        if (respuesta && ((color.equals("negra") && mov.getPosFinal().getFila() == 7) || (color.equals("blanca") && mov.getPosFinal().getFila() == 0))) {
            //  Juego.promocionElegir()
            String piezaelegida = Juego.promocionElegir();
            switch (piezaelegida) {
                case "Reina":
                    tablero.ponPieza(new Reina(color), mov.getPosInicial());
                    break;
                case "Alfil":
                    tablero.ponPieza(new Alfil(color), mov.getPosInicial());
                    break;
                case "Caballo":
                    tablero.ponPieza(new Caballo(color), mov.getPosInicial());
                    break;
                case "Torre":
                    tablero.ponPieza(new Torre(color), mov.getPosInicial());
                    break;


            }






        /* True , 3 y 4 para comer
        1. Blanca, fila 6, si no hay pieza en la pos final,mov vertical, -1 o -2
        2. Negra, fila 1, ....lo mismo que arriba, 1 o 2
        3. Blanca, hay pieza en la final, diagonal, salto -1
        4. Negra, hay pieza en la final, diagonal, salto 1
        5. Blanca, vertical y salto -1
        6. Negra, vertica y salto +1
         */

        }

        return respuesta;
    }
}
