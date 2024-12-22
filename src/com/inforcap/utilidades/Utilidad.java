package com.inforcap.utilidades;

public class Utilidad {

    public static void stopAndContinue(){
        timeToWait();
        limpiarPantalla();
        //limpiezaPantalla();
    }

    public static void limpiarPantalla(){

        for(int i=0; i < 50; i++){
            System.out.println("");
        }
        System.out.flush();
    }

    public static void timeToWait() {
        int time = 3;
        try {
            for (int i=0; i < time; i++){
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Tiempo de espera interrumpido...");;
        }
    }

    public static void limpiezaPantalla() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Método para limpiar consola en Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Método para limpiar consola en Unix/Linux/MacOS
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
        }
    }

}
