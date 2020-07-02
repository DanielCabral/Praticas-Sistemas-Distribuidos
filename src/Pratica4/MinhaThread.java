package Pratica4;

public class MinhaThread implements Runnable {
	
	private int id;
	private int tempo;
	
	public MinhaThread(int id, int tempo) {
		this.id = id;
		this.tempo = tempo;
	}
	
	public void run () {
		for (int i = 0; i < 1000; i++) {
			System.out.println("Thread " + id + " valor: " + i);
			try {
				Thread.sleep(this.tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
