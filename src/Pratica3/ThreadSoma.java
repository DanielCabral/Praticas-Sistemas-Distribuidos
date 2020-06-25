package Pratica3;


public class ThreadSoma implements Runnable{
	String mensagem="";
	
	
	
	public String getMensagem() {
		return mensagem;
	}



	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}



	public void run	 () {
		while(true) {
				int soma=0;
				for(int i=1; i<1000;i++)
					soma+=i;
				
				System.out.println("Soma de 1 a 1000: "+soma);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			
		}
	}
}
