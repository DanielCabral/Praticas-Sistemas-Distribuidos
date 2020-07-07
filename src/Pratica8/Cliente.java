package Pratica8;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
	private static String nomeServidor = "127.0.0.1";
	private static int porta = 12345;
	private static final String NOMEOBJDIST = "MinhaCalculadora";
	public static void main(String args[]) {
		try {
			System.out.println("Conectando no servidor "+ nomeServidor);
			
			// Obtendo refer^encia do servi¸co de registro
			Registry registro = LocateRegistry.getRegistry(nomeServidor, porta);
			
			// Procurando pelo objeto distribu´ıdo registrado previamente com o NOMEOBJDIST
			CalculadoraDistribuida stub = (CalculadoraDistribuida) registro.lookup(NOMEOBJDIST);
			
			// Invocando m´etodos do objeto distribu´ıdo			
					
			System.out.println("Soma de 4 por 5: " + stub.somarDoisNumeros(4, 5));
			System.out.println("Subtração de 4 por 5: " + stub.subtrairDoisNumeros(4, 5));
			System.out.println("Multiplicação de 4 por 5: " + stub.multiplicaDoisNumeros(4, 5));
			System.out.println("Divisão de 4 por 5: " + stub.dividirDoisNumeros(4, 5));
			System.out.println("Divisão com resto de 4 por 5: " + stub.dividirDoisNumerosResto(4, 5));
			System.out.println("Raiz de 9: " + stub.raizQuadrada(9));
			System.out.println("Potência de 4 elevado 5: " + stub.potencia(4, 5));
			
			System.out.println("Fim da execução do cliente!"); 
		} catch (RemoteException | NotBoundException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
