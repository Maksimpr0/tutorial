package org.example;
import java.util.Random;
public class Baraja extends Carta{

    private Carta[] baraja = new Carta[24];
    private Carta[] baraja1 = new Carta[12];
    private Carta[] baraja2 = new Carta[12];
    private int valor;
    Random random = new Random();

    public Baraja(Carta[] baraja) {
        super();
        this.baraja = baraja;

    }

    public Baraja() {

    }

    public void crearBarajaPadre(){

        for (int i = 0; i < baraja.length; i++) {

           baraja [i] = new Carta(ponerTipo(),ponerColor());
            System.out.println(baraja[i]);

        }


    }
    public void decirBaraja(){
        for (int i = 0; i < baraja.length; i++) {
            System.out.println(baraja[i]);
        }
    }
}
