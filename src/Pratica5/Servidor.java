package Pratica5;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] args) throws IOException {
		ServerSocket servidor = new ServerSocket(54321);
		
		System.out.println("Servidor rodando na porta "+servidor.getLocalPort());
		 System.out.println("HostAddress = "+ InetAddress.getLocalHost().getHostAddress());
		 System.out.println("HostName = "+ InetAddress.getLocalHost().getHostName());
		 
		Socket cliente = servidor.accept();
		
		System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
		
		Scanner entrada = new Scanner(cliente.getInputStream());
		
		while (entrada.hasNextLine()) {
			System.out.println(entrada.nextLine());
		}
		
		/*
		 * 			if(mensagem.equals("close")) {
				System.out.println("Fechando...");
				DataOutputStream fluxoSaida = new DataOutputStream(cliente.getOutputStream());
				fluxoSaida.writeChar(0);
				break;
			}
		 * */
		
		entrada.close();
		servidor.close();
	}
}
