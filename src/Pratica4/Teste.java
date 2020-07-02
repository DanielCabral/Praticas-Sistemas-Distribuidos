package Pratica4;

public class Teste {
	public static void main(String[] args) {
		MinhaThread p1 = new MinhaThread(1, 500);
		Thread t1 = new Thread(p1);
		t1.start();
		MinhaThread p2 = new MinhaThread(2, 750);
		Thread t2 = new Thread(p2);
		t2.start();
		MinhaThread p3 = new MinhaThread(3, 900);
		Thread t3 = new Thread(p3);
		t3.start();
	}
}
