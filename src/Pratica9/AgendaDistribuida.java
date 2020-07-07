package Pratica9;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AgendaDistribuida extends Remote{
	public boolean cadastrar(String nome, String telefone, String endereco) throws RemoteException;
	public ArrayList<String> listar() throws RemoteException;
	public boolean alterar(String nome, String telefone, String endereco) throws RemoteException;
	public boolean remover(String nome) throws RemoteException;
}
