package com.inforcap.main;

import com.inforcap.exportador.ExportarTxt;
import com.inforcap.modelo.ArchivoServicio;
import com.inforcap.modelo.Producto;
import com.inforcap.modelo.ProductoServicio;
import com.inforcap.utilidades.Utilidad;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    public static ProductoServicio ps = new ProductoServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();
    private ExportarTxt exportarTxt = new ExportarTxt();
    private String nombreArchivo = "productos";

    public void iniciarMenu(){
        boolean flag = true;
        while (flag){
            String opcion = "0";
            do {
                try{
                    System.out.println("[1] Listar productos");
                    System.out.println("[2] Agregar producto");
                    System.out.println("[3] Editar Productos");
                    System.out.println("[4] Cargar Productos");
                    System.out.println("[5] Exportar productos");
                    System.out.println("[6] Salir");
                    System.out.print("Seleccione opción: ");
                    opcion = scanner.nextLine();
                    if (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3") && !opcion.equals("4") && !opcion.equals("5") && !opcion.equals("6")){
                        System.out.println("Valor no válido.");
                        Utilidad.stopAndContinue();
                    }
                    else {
                        switch (opcion){
                            case "1": listaProductos(); break;
                            case "2": agregarProducto(); break;
                            case "3": editarProducto();break;
                            case "4": cargarDatos();break;
                            case "5": exportarProductos(); break;
                            case "6": salirSistema(); flag = false; break;
                        }
                    }

                }catch (Exception ex){
                    System.out.println("Valor no válido.");
                    Utilidad.stopAndContinue();
                }
            } while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3") && !opcion.equals("4") && !opcion.equals("5") && !opcion.equals("6"));
        }
    }

    public void listaProductos(){
        ps.listarProductos();
        Utilidad.stopAndContinue();
    }

    public void agregarProducto(){
        System.out.println("Crear producto");
        scanner.nextLine();
        System.out.println("Ingresar nombre articulo: ");
        String articulo = scanner.nextLine();
        System.out.println("Ingresar precio articulo: ");
        String precio = scanner.nextLine();
        System.out.println("Ingresar descripcion articulo: ");
        String descripcion = scanner.nextLine();
        System.out.println("Ingresar código articulo: ");
        String codigo = scanner.nextLine();
        System.out.println("Ingresar talla articulo: ");
        String talla = scanner.nextLine();
        System.out.println("Ingresar marca articulo: ");
        String marca = scanner.nextLine();
        System.out.println("Ingresar color articulo: ");
        String color = scanner.nextLine();
        Producto p = new Producto(articulo,precio,descripcion,codigo,talla,marca,color);
        ps.agregarProductos(p);
        Utilidad.stopAndContinue();
    }

    public void editarProducto(){
        System.out.println("Editar Producto");
        System.out.print("Ingrese el codigo del producto que desea editar: ");
        String codigo = scanner.nextLine();

        ArrayList<Producto> productos = ps.getProductos();

        for(Producto p : productos){
            if (codigo.equals(p.getCodigo())){
                editarDatosProducto(p);
            }
        }
    }

    public void editarDatosProducto(Producto p){
        System.out.println("[1] Nombre del producto: " + p.getArticulo());
        System.out.println("[2] Código del producto: " + p.getCodigo());
        System.out.println("[3] Color del producto: " + p.getColor());
        System.out.println("[4] Descripción del producto: " + p.getDescripcion());
        System.out.println("[5] Marca del producto: " + p.getMarca());
        System.out.println("[6] Precio del producto: " + p.getPrecio());
        System.out.println("[7] Talla del producto: " + p.getTalla());
        System.out.println("Ingrese la opción a editar de los datos del producto: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion){
            case 1:
                System.out.print("Ingrese nuevo nombre del articulo");
                String nombreArticulo = scanner.nextLine();
                p.setArticulo(nombreArticulo);
                break;
            case 2:
                System.out.print("Ingrese nuevo código del articulo");
                String codigoArticulo = scanner.nextLine();
                p.setArticulo(codigoArticulo);
                break;
            case 3:
                System.out.print("Ingrese nuevo color del articulo");
                String colorArticulo = scanner.nextLine();
                p.setArticulo(colorArticulo);
                break;
            case 4:
                System.out.print("Ingrese nueva descripción del articulo");
                String descripcionArticulo = scanner.nextLine();
                p.setArticulo(descripcionArticulo);
                break;
            case 5:
                System.out.print("Ingrese nueva marca del articulo");
                String marcaArticulo = scanner.nextLine();
                p.setArticulo(marcaArticulo);
                break;
            case 6:
                System.out.print("Ingrese nuevo precio del articulo");
                String precioArticulo = scanner.nextLine();
                p.setArticulo(precioArticulo);
                break;
            case 7:
                System.out.print("Ingrese nueva talla del articulo");
                String tallaArticulo = scanner.nextLine();
                p.setArticulo(tallaArticulo);
                break;
            default:
                System.out.println("Opción no válida");
        }


    }

    public void exportarProductos(){
        ArrayList<Producto> productosExportacion = ps.getProductos();
        exportarTxt.exportar(nombreArchivo,productosExportacion);
        Utilidad.stopAndContinue();
    }

    public void cargarDatos(){
        System.out.println("Cargas Datos");
        archivoServicio.cargarDatos();
    }

    public void salirSistema(){
        System.out.println("Muchas gracias por utilizar nuestros sistemas...");
        Utilidad.stopAndContinue();
    }
}
