package Parte1;

import java.util.Random;

public class consume extends Thread{
	
	private static int consumerCount = 0;
	private int consumerID;

	public consume() {
		consumerID = ++consumerCount;
		start();
	}
	
	private void consume() {
		Random rdmNum = new Random();
		int sleepTime = rdmNum.nextInt(250 - 25 + 1 )+ 25;
		
		try {
			sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized(Semaforos.getStore()) {
			//liberar el elemento
			int liberarNumero = Semaforos.getStore().poll();
			System.out.println("Consumidor "+ consumerID + liberarNumero + "consumido");
		}
		
	
		
	}
	
	public void run() {
		while(true) {
			
			if(Semaforos.getStore().size() == 0) {
				System.out.println("Consumidor:" + consumerID +"el reserva, esta vacio, esperando a que se generen mas recursos");
				
			}
			
			try {
				Semaforos.getReserva().acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			consume();
			Semaforos.getLibera().release();
			
		}
	}
	
	
}
