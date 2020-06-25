package Pratica1;

import java.io.IOException;

import Cliente_Servidor.Servidor;

public class ServidorParImpar extends Servidor{
	public ServidorParImpar(int port) throws IOException {
		super(port);
	}
	
	public void send(int message) throws IOException{
		String valor;
		if(message==0) {
			valor= "zero";
		}else if(message % 2 == 0) {
			valor= ""+(message*10);
		}else {
			valor= ""+(message*11);
		}
		
		 System.out.println("--> Servidor enviando mensagem: " + valor);
		this.getFluxoSaida().writeUTF(valor); //Envia uma string. 
	}
	
	public static void main(String [] args) throws IOException {
		ServidorParImpar server= new ServidorParImpar(5000);
		server.accept();
		
		 String msg = server.receive();

		 System.out.println("--> Mensagem recebida do cliente: " + msg);


		 server.send(Integer.parseInt(msg));
		 
		 server.closeClientConnection();
		 
		 System.out.println("*****Conexão finalizada*****\n");
		 //Fechando o servidor.
		 
		server.closeClientConnection();
		server.closeServer();
	}
}
