package Parte1;

public class programa {

	public static final int Producers = 100;
	public static final int consumer = 100;
	
	
	
	
	public static void main(String[] args) {
		
		
		for(int i = 0; i < Producers; i ++) {
			new consume();
		}
		
		for(int i = 0; i < consumer; i ++) {
			new tienda();
		}
		
		

	}

}
