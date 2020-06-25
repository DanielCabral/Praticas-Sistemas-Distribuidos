package Pratica3;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadGravar implements Runnable{
	String mensagem="";
	
	
	
	public String getMensagem() {
		return mensagem;
	}



	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}



	public void run () {
		//Loop infinito
		while(true) {
			
			//Testar se mensagem foi enviada
			if(!mensagem.equals("")) {
				try {
					FileOutputStream file = new FileOutputStream(new File(".\\src\\Pratica3\\mensagem.txt").getCanonicalFile());
					BufferedOutputStream buffer= new BufferedOutputStream(file);
					
					buffer.write(mensagem.getBytes());
					
					System.out.println("Mensagem gravada");
					
					buffer.close();
					file.close();
					
					//String vazia em mensagem
					mensagem = "";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			
		}
	}
}
