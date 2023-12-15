package Parte1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Semaforos {
	
	private static Queue<Integer> store = new LinkedList<Integer>();
	
	public static final int tamano = Integer.MAX_VALUE;
	
	private static Semaphore reserva = new Semaphore(0, true); //no vacio
	private static Semaphore libera = new Semaphore(tamano, true); // no lleno
	
	public static Queue<Integer> getStore() {
		return store;
	}
	
	public static Semaphore getReserva() {
		return reserva;
	}
	public static Semaphore getLibera() {
		return libera;
	}
	
	
}
