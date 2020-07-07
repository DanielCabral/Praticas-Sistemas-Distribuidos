package Pratica9;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
	// Constantes que indicam onde est´a sendo executado o servi¸co de registro,
	// qual porta e qual o nome do objeto distribu´ıdo
	private static String nomeServidor = "127.0.0.1";
	private static int porta = 12345;
	private static final String NOMEOBJDIST = "MinhaAgenda";
	public static void main(String args[]){
		try {
			Agenda a = new Agenda();
			
			// Definindo o hostname do servidor
			System.setProperty("java.rmi.server.hostname", nomeServidor);
			
			AgendaDistribuida stub = (AgendaDistribuida) UnicastRemoteObject.exportObject(a, 0);
			
			// Criando serviço de registro
			Registry registro = LocateRegistry.createRegistry(porta);
			
			// Registrando objeto distribu´ıdo
			registro.bind(NOMEOBJDIST, stub);
			System.out.println("Servidor pronto!\n");
			System.out.println("Pressione CTRL + C para encerrar...");
		} catch (RemoteException | AlreadyBoundException ex) {
		Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}