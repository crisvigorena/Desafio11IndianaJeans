package com.inforcap.exportador;

import com.inforcap.modelo.Producto;

import java.util.ArrayList;

public abstract class Exportador {

    public abstract void exportar(String nombreArchivo, ArrayList<Producto> productos);

}
