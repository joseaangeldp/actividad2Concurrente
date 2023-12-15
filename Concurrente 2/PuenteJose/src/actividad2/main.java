package actividad2;

public class main extends Thread {

    public static void main(String[] args) {
        Puente puente = new Puente();

        Thread cocheNorte = new Thread(() -> {
            try {
                puente.entrar(NORTE);
                System.out.println("Coche del norte cruzando el puente");
                Thread.sleep(1000);
                puente.salir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread cocheSur = new Thread(() -> {
            try {
                puente.entrar(SUR);
                System.out.println("Coche del sur cruzando el puente");
                Thread.sleep(1000);
                puente.salir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        cocheNorte.start();
        cocheSur.start();
    }
}