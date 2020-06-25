package Pratica3;

import java.util.Scanner;

public class TesteQuestao2 {
	
	public static void main (String [] args) {
		ThreadGravar thread=new ThreadGravar();
		Thread t1 = new Thread(thread);
		t1.start();
		
		ThreadSoma threadsoma=new ThreadSoma();
		Thread t2 = new Thread(threadsoma);
		t2.start();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Digite a mensagem: ");
		
		String mensagem = sc.next();
		
		thread.setMensagem(mensagem);
	
		
		
	}
	
}
