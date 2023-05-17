package hilos;

/**
 *
 * @author alexa
 */

public class ContadorHilo extends Thread {
    public int inicio;
    public int fin;
    public int contadorPrimos;

    public ContadorHilo(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
        this.contadorPrimos = 0;
    }

    public int getContadorPrimos() {
        return contadorPrimos;
    }

    @Override
    public void run() {
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) {
                contadorPrimos++;
                System.out.println(i);
            }
            // System.out.println(i);
        }
    }

    private boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }
}

