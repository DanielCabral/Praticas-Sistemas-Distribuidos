package Pratica2;


import java.io.IOException;
import java.net.DatagramPacket;

import Cliente_ServidorUDP.Servidor;

public class ServidorVariasMensagens extends Servidor{
	public ServidorVariasMensagens(int port) throws IOException {
		super(port);
	}
	
	public void send(String message) throws IOException{
		
		
		byte[] resultado= message.getBytes();
		 System.out.println("--> Servidor enviando mensagem: " + message);
		 
		 DatagramPacket pacoteEnvio = new DatagramPacket (resultado,
					resultado.length, this.getDatagramaRecebimento().getAddress(),
					this.getDatagramaRecebimento().getPort());
		this.getDatagramSocket().send(pacoteEnvio); //Envia uma string. 
	}
	
	public static void main(String [] args) throws IOException {
		 ServidorVariasMensagens server= new ServidorVariasMensagens(5000);
		 String msg = new String(server.receive())+"\"" ;

		 System.out.println("--> Mensagem recebida do cliente: " + msg);

		 //Erro input string
		 server.send("Nome: Daniel Cabral");
		 server.send("Idade: 22");
		 server.send("Endereço: Rua tal");
		 
		 
		 
		 System.out.println("*****Conexão finalizada*****\n");
		 //Fechando o servidor.

		 
		server.close();
	}
}
