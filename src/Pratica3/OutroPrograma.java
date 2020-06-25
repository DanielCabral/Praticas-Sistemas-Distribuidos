package Pratica3;

public class OutroPrograma implements Runnable {
	private int id;
	public void setId(int i){
		this.id = i;
	}
	public int getId(){
		return this.id;
	}
	public void run () {
		for (int i = 1000; i < 2000; i++) {
			System.out.println("Programa " + id + " valor: " + i);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
