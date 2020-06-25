package Cliente_ServidorTCP;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
	
	private int port;
	ServerSocket serverSocket; 
	private DataInputStream fluxoEntrada;
	private DataOutputStream fluxoSaida;
	Socket socket;
	

	
public Servidor(int port) throws IOException {
		super();
		this.port = port;
		
		serverSocket=new ServerSocket(5000);
		System.out.println(" Servidor Iniciado... ");
	}


public void accept() throws IOException{
	socket = serverSocket.accept();
	
	 // imprime o ip do cliente
	 System.out.println("Nova conexão com o cliente " +
	socket.getInetAddress().getHostAddress());
	 //Cria um canal para receber dados.
	
	fluxoEntrada = new DataInputStream(socket.getInputStream());
	//Cria um canal para enviar dados.
	fluxoSaida = new DataOutputStream(socket.getOutputStream());
}

public String receive() throws IOException{
	 return fluxoEntrada.readUTF(); //Aguarda o recebimento de uma string.
}

public void send(String message) throws IOException{
	fluxoSaida.writeUTF(message); //Envia uma string. 
}

public void closeClientConnection() throws IOException{
	//Fecha os canais in e out do socket que estão atendendo ao cliente
	 fluxoEntrada.close();
	 fluxoSaida.close();
	 //Fecha o socket para o cliente.
	 socket.close();
}

public void closeServer() throws IOException{
	 serverSocket.close();
}




public int getPort() {
	return port;
}


public void setPort(int port) {
	this.port = port;
}


public DataInputStream getFluxoEntrada() {
	return fluxoEntrada;
}


public void setFluxoEntrada(DataInputStream fluxoEntrada) {
	this.fluxoEntrada = fluxoEntrada;
}


public DataOutputStream getFluxoSaida() {
	return fluxoSaida;
}


public void setFluxoSaida(DataOutputStream fluxoSaida) {
	this.fluxoSaida = fluxoSaida;
}


public static void main(String [] args) throws IOException {

Servidor server= new Servidor(5000);


System.out.println("\n\nIniciando servidor TCP...\n");
System.out.println("Servidor pronto para receber conexões...\n\n"); 

	
 server.accept();


 
 String msg = server.receive();

 System.out.println("--> Mensagem recebida do cliente: " + msg);

 
 msg = "Bem vindo e tchau!";

 System.out.println("--> Servidor enviando mensagem: " + msg);

 server.send(msg);
 
 server.closeClientConnection();
 
 System.out.println("*****Conexão finalizada*****\n");
 //Fechando o servidor.

 server.closeServer();
 
}
}