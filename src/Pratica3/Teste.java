package Pratica3;

public class Teste {
	public static void main(String[] args) {
		Programa p1 = new Programa();
		p1.setId(1);
		Thread t1 = new Thread(p1);
		t1.start();
		Programa p2 = new Programa();
		p2.setId(2);
		Thread t2 = new Thread(p2);
		t2.start();
		OutroPrograma p3 = new OutroPrograma();
		p3.setId(3);
		Thread t3 = new Thread(p3);
		t3.start();
		OutroPrograma p4 = new OutroPrograma();
		p4.setId(4);
		Thread t4 = new Thread(p4);
		t4.start();
				
	}
}
