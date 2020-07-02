package Pratica5;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class ClienteSemThreads {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket cliente = new Socket("127.0.0.1", 54321);
		System.out.println("O cliente se conectou ao servidor!");
		InetAddress inet = cliente.getInetAddress();
		 System.out.println("HostAddress = "+inet.getHostAddress());
		 System.out.println("HostName = "+inet.getHostName());
		Scanner teclado = new Scanner(System.in);
		//Scanner entrada = new Scanner(cliente.getInputStream());
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		while (teclado.hasNextLine()) {
			saida.println(teclado.nextLine());
		}
		saida.close();
		teclado.close();
		//entrada.close();
		cliente.close();
	}
}