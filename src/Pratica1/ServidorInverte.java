package Pratica1;

import java.io.IOException;

import Cliente_ServidorTCP.Servidor;

public class ServidorInverte extends Servidor{
	public ServidorInverte(int port) throws IOException {
		super(port);
	}
	
	public void send(String message) throws IOException{
		byte [] strAsByteArray = message.getBytes(); 
		  
        byte [] result =  
                   new byte [strAsByteArray.length]; 
  
        // Store result in reverse order into the 
        // result byte[] 
        for (int i = 0; i<strAsByteArray.length; i++) 
            result[i] =  
             strAsByteArray[strAsByteArray.length-i-1];
        
		 System.out.println("--> Servidor enviando mensagem: " + result);
        
		this.getFluxoSaida().writeUTF(new String(result)); //Envia uma string. 
	}
	
	public static void main(String [] args) throws IOException {
		ServidorInverte server= new ServidorInverte(5000);
		server.accept();
		
		 String msg = server.receive();

		 System.out.println("--> Mensagem recebida do cliente: " + msg);


		 server.send(msg);
		 
		 server.closeClientConnection();
		 
		 System.out.println("*****Conexão finalizada*****\n");
		 //Fechando o servidor.
		 
		server.closeClientConnection();
		server.closeServer();
	}
}
