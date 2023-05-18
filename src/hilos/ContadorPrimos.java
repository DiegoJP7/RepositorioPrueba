package hilos;

import java.util.ArrayList;
import java.util.List;

public class ContadorPrimos {

    public static void main(String[] args) {
        System.out.println("Hola mundo");
        //prueba
        /*
        Aqui tenemos un buen ejemplo de como no se debe hacer hilos
         */

        int inicio = 1;
        int fin = 100;
        int numeroHilos = 4;

        List<ContadorHilo> hilos = new ArrayList<>();

        // Calcula el tamaño del rango para cada hilo
        int rango = (fin - inicio + 1) / numeroHilos;

        // Crea los hilos y establece el rango para cada uno
        for (int i = 0; i < numeroHilos; i++) {
            int hiloInicio = inicio + (i * rango);
            int hiloFin = hiloInicio + rango - 1;
            hilos.add(new ContadorHilo(hiloInicio, hiloFin));
        }

        // Inicia los hilos
        for (ContadorHilo hilo : hilos) {
            hilo.start();
            System.out.println(hilo.getName());
        }


        // Espera a que los hilos terminen
        for (ContadorHilo hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Obtiene el total de números primos de todos los hilos
        int totalPrimos = 0;
        for (ContadorHilo hilo : hilos) {
            totalPrimos += hilo.getContadorPrimos();
        }

        System.out.println("Total de números primos encontrados: " + totalPrimos);
    }
}

