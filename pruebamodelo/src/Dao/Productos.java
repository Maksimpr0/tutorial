package Dao;

import Domain.Producto;

import java.util.ArrayList;

public class Productos {

    private ArrayList<Producto> productos;

    public Productos() {
        for (int i = 0; i < 10; i++) {
            productos.add(new Producto("lejia"));
        }
    }
}
