package actividad2;

import java.util.concurrent.LinkedBlockingQueue;

public class Puente {

    public static final int NORTE = 0;
    public static final int SUR = 1;

    public final LinkedBlockingQueue<Coche> cochesEsperando;
    public int direccion;

    public Puente() {
        cochesEsperando = new LinkedBlockingQueue<>();
        direccion = NORTE;
    }

    public void entrar(int direccion) throws InterruptedException {
        cochesEsperando.put(new Coche(direccion));
    }

    public void salir() throws InterruptedException {
        Coche coche = cochesEsperando.take();
        this.direccion = coche.direccion;
    }
}

