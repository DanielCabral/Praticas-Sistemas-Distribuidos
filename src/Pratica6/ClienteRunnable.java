package Pratica6;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
public class ClienteRunnable implements Runnable{
private Socket cliente;
private boolean conexao = true;

public ClienteRunnable(Socket c){
	this.cliente = c;
}

public void run() {
	try {
		PrintStream saida;
		System.out.println("O cliente conectou ao servidor");
		//Prepara para leitura do teclado
		Scanner teclado = new Scanner(System.in);
		//Cria objeto para enviar a mensagem ao servidor
		saida = new PrintStream(this.cliente.getOutputStream());
		//Envia mensagem ao servidor
		String snd;
		
		//Escutar servidor
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Scanner s = null;
					s = new Scanner(cliente.getInputStream());
					String rcv;
					System.out.println("Escutando servidor");
					 //Exibe mensagem no console
					while(s.hasNextLine()){
						rcv = s.nextLine();
						if (rcv.equalsIgnoreCase("fim"))
							break;
						else
							System.out.println(rcv);

					}
					//Finaliza scanner e socket
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		t.start();
		
		while(conexao){
			System.out.println("Digite uma mensagem: ");
			snd = teclado.nextLine();
			if (snd.equalsIgnoreCase("fim"))
			conexao = false;
			else
			System.out.println(snd);
			saida.println(snd);
		}
			saida.close();
			teclado.close();
			cliente.close();
			System.out.println("Cliente finaliza conex�o.");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
