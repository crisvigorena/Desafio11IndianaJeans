package com.inforcap.modelo;

import com.inforcap.main.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoServicio {

    Scanner scanner = new Scanner(System.in);


    public void cargarDatos(){
        System.out.println("Ingresa la ruta donde se encuentra el archivo ProductosImportados.csv: ");
        String filePath = scanner.nextLine();
        File directorio = new File("src/" + filePath);
        File archivo = new File(directorio.getPath() + "/ProductosImportados.csv");

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line= "";
        try {
            if (archivo.exists()){
                fileReader = new FileReader(archivo);
                bufferedReader = new BufferedReader(fileReader);
                line = bufferedReader.readLine();
                while(line != null){
                    Producto p = parseProducto(line);
                    if (p != null){
                        Menu.ps.agregarProductos(p);
                    }
                    line = bufferedReader.readLine();
                }
            }
            else{
                System.out.println("El archivo no existe...");
            }

        } catch (Exception e) {
            System.out.println("No se pudo cargar el archivo");
        }
        finally {
            try{
                bufferedReader.close();
                fileReader.close();

            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }


    }

    private Producto parseProducto(String linea) {
        String[] partes = linea.split(",");

        if (partes.length == 7) {
            return new Producto(
                    partes[0].trim(),
                    partes[1].trim(),
                    partes[2].trim(),
                    partes[3].trim(),
                    partes[4].trim(),
                    partes[5].trim(),
                    partes[6].trim()
            );
        } else {
            return null;
        }
    }

}
