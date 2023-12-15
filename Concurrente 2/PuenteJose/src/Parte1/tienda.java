package Parte1;

import java.util.Random;

public class tienda extends Thread {
	
	private static int producerCount = 0;
	private int ProduceID;
	
	public tienda() {
		ProduceID = ++producerCount;
		start();
	}

	private void tiendita() {
		Random rdm = new Random();
		int numT = rdm.nextInt(999)+ 1;
		int sleepTime = rdm.nextInt(250 - 25 + 1) + 25;
		
		try {
			sleep(sleepTime);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Productor_ "+ ProduceID + ": Numero" +numT + "producido");
		
		synchronized(Semaforos.getStore()) {
			
			Semaforos.getStore().add(numT);
			
		}
		
		
	    }
	
	public void run() {
		while(true) {
			
			if(Semaforos.getStore().size() == Semaforos.tamano ) {
				System.out.println("Productor: "+ ProduceID +"El buffer esta lleno, esperando a que libere trabaje");
			}
			
			try {
				Semaforos.getLibera().acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tiendita();
			Semaforos.getReserva().release();
			
		}
	}
	
	
	
}
	
	
