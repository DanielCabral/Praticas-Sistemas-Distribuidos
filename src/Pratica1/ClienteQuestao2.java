package Pratica1;

import java.io.IOException;
import java.util.Scanner;

import Cliente_Servidor.Cliente;

public class ClienteQuestao2 {
	
	public static void main(String [] args) throws IOException {
				
		Cliente cliente = new Cliente("localhost", 5000);	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite uma mensagem: ");
		String msg = sc.nextLine();
		System.out.println("\n\n <-- Mensagem enviada ao servidor: "+ msg);
		
		cliente.send(msg);
		
		msg = cliente.receive();
		
		System.out.println("\n\n --> Mensagem recebida do servidor : "+ msg
		+ "\n\n");

		cliente.close();
		
		sc.close();
	}
	
}
