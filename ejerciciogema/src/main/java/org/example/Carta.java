package org.example;
import java.util.Random;
public class Carta {

    protected static String[] tipos = {"piedra", "papel", "tijera"};
    protected static String[] colores = {"azul", "verde"};
    protected String tipo;
    protected String color;
    Random random = new Random();
    int valor;
    public Carta(String[] tipo, String[] color) {
        this.tipos = tipos;
        this.colores = colores;

    }

    public Carta(String tipo, String color) {
    }

    public void setTipo(String[] tipo) {

    }


    public void setColor(String[] color) {
        this.colores = colores;


    }
    public String ponerTipo(){
        Random random = new Random();
        int valor = random.nextInt(0,3);
        tipo = tipos[valor];
        return tipo;
    }
    public String ponerColor(){
        Random random = new Random();
        int valor = random.nextInt(0,2);
        color = colores[valor];
        return color;
    }

    public Carta() {

    }

    @Override
    public String toString() {
        return "Carta{" +
                "tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
