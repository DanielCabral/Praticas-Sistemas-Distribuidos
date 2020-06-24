package Pratica1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	private static Scanner sc;
	private String addresss;
	private int port;
	private Socket socket;
	private DataInputStream fluxoEntrada;
	private DataOutputStream fluxoSaida;
	
	
	public Cliente(String addresss, int port) throws UnknownHostException,
	IOException {
		super();
		this.addresss = addresss;
		this.port = port;
		
		socket = new Socket("localhost", 5000);
		
		//Criar fluxo de entrada
		fluxoEntrada = new DataInputStream(socket.getInputStream());
		
		//Criar fluxo de saida
		fluxoSaida = new DataOutputStream(socket.getOutputStream());
	}


	

	public String getAddresss() {
		return addresss;
	}




	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}




	public int getPort() {
		return port;
	}




	public void setPort(int port) {
		this.port = port;
	}

	public void send(String message) throws IOException{
		fluxoSaida.writeUTF(message);
	}
	
	public String receive() throws IOException{
		return fluxoEntrada.readUTF(); //Aguarda o recebimento de uma string.
	}

	public void close() throws IOException{
		//Fecha os canais de entrada e saída.
		
		fluxoEntrada.close();
		fluxoSaida.close(); 

		//Fecha o socket.
		socket.close();
	}

	public static void main(String[] args)  throws UnknownHostException,
	IOException {
		
		Cliente cliente = new Cliente("localhost", 5000);
		

		sc = new Scanner(System.in);
		System.out.println("Digite uma mensagem: ");
		String msg = sc.nextLine();
		System.out.println("\n\n <-- Mensagem enviada ao servidor: "+ msg);
		
		cliente.send(msg);
		
		cliente.receive();
		
		System.out.println("\n\n --> Mensagem recebida do servidor : "+ msg
		+ "\n\n");

		cliente.close();
		
	}

}
