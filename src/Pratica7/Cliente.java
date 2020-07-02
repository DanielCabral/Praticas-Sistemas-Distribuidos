package Pratica7;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
	private static String nomeServidor = "127.0.0.1";
	private static int porta = 12345;
	private static final String NOMEOBJDIST = "MeuContador";
	public static void main(String args[]) {
		try {
//			if (args[0] != null){
//				nomeServidor = args[0];
//			}
//			if (args[1] != null){
//				porta = Integer.parseInt(args[1]);
//			}
			System.out.println("Conectando no servidor "+ nomeServidor);
			
			// Obtendo refer^encia do servi¸co de registro
			Registry registro = LocateRegistry.getRegistry(nomeServidor, porta);
			
			// Procurando pelo objeto distribu´ıdo registrado previamente com o NOMEOBJDIST
			CalculadoraDistribuida stub = (CalculadoraDistribuida) registro.lookup(NOMEOBJDIST);
			
			// Invocando m´etodos do objeto distribu´ıdo

			System.out.println("Solicitando ao servidor para incrementar o contador");
			
					
			System.out.println("Valor atual: " + stub.somarDoisNumeros(4, 5));
			System.out.println("Fim da execução do cliente!"); 
		} catch (RemoteException | NotBoundException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
