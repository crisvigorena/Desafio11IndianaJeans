package com.inforcap.exportador;

import com.inforcap.modelo.Producto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExportarTxt extends Exportador{

    @Override
    public void exportar(String nombreArchivo, ArrayList<Producto> productos) {
        if(productos.size() > 0){
            crearDirectorio("ficheros",nombreArchivo);

            File directorio = new File("src/ficheros");
            File archivo = new File(directorio.getPath() + "/" + nombreArchivo + ".txt");
            try {
                FileWriter fileWriter = new FileWriter(archivo,false);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                for(Producto p: productos){
                    printWriter
                            .append(p.getArticulo()).append(",")
                            .append(p.getPrecio()).append(",")
                            .append(p.getDescripcion()).append(",")
                            .append(p.getCodigo()).append(",")
                            .append(p.getTalla()).append(",")
                            .append(p.getMarca()).append(",")
                            .append(p.getColor()).append(System.lineSeparator());
                }
                printWriter.close();
                fileWriter.close();
                System.out.println("Datos exportados satisfactoriamente...");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } else {
            System.out.println("La lista de productos está vacía por lo tanto no podemos completar el proceso de exportación.");
        }
    }

    private void crearDirectorio(String nombreDirectorio, String nombreArchivo) {
        File directorio = new File("src/" + nombreDirectorio);
        File archivo = new File(directorio.getPath() + "/" + nombreArchivo + ".txt");
        if (!directorio.exists()) {
            directorio.mkdirs();
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                if(!archivo.exists()){
                    archivo.createNewFile();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
