package Pratica9;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
	private static String nomeServidor = "127.0.0.1";
	private static int porta = 12345;
	private static final String NOMEOBJDIST = "MinhaAgenda";
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
			AgendaDistribuida stub = (AgendaDistribuida) registro.lookup(NOMEOBJDIST);
			
			// Invocando m´etodos do objeto distribu´ıdo			
					
			System.out.println(stub.cadastrar("Daniel", "832323232", "Rua Francisco Horacio, 103"));
			System.out.println(Arrays.toString(stub.listar().toArray()));
			System.out.println(stub.remover("Jose"));
			
			System.out.println("Fim da execução do cliente!"); 
		} catch (RemoteException | NotBoundException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
