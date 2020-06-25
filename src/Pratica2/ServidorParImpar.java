package Pratica2;


import java.io.IOException;
import java.net.DatagramPacket;

import Cliente_ServidorUDP.Servidor;

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
		
		byte[] resultado= valor.getBytes();
		 System.out.println("--> Servidor enviando mensagem: " + valor);
		 
		 DatagramPacket pacoteEnvio = new DatagramPacket (resultado,
					resultado.length, this.getDatagramaRecebimento().getAddress(),
					this.getDatagramaRecebimento().getPort());
		this.getDatagramSocket().send(pacoteEnvio); //Envia uma string. 
	}
	
	public static void main(String [] args) throws IOException {
		 ServidorParImpar server= new ServidorParImpar(5000);
		 String msg = server.receive();

		 System.out.println("--> Mensagem recebida do cliente: " + msg);

		 //Erro input string
		 server.send(Integer.parseInt(msg));
		 
		 
		 System.out.println("*****Conexão finalizada*****\n");
		 //Fechando o servidor.

		 
		server.close();
	}
}
