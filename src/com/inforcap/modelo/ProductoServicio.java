package com.inforcap.modelo;

import java.util.ArrayList;

public class ProductoServicio {

    private ArrayList<Producto> productos = new ArrayList<>();

    public ProductoServicio() {
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void listarProductos(){
        if (productos.size() > 0){
            for (Producto p: productos){
                System.out.println(p);
                System.out.println("------------------------------------------------------------------------------------");
            }
        } else {
            System.out.println("No hay productos registrados...");
        }
    }

    public void agregarProductos(Producto p){
        productos.add(p);
    }




}
