package Pratica9;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Agenda implements AgendaDistribuida{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HashMap<String, Contato> contatos = new HashMap<String, Contato>();
	
	public boolean cadastrar(String nome, String telefone, String endereco) {
		Contato novoContato = new Contato(nome, telefone, endereco);
		if(!contatos.containsKey(nome)) {
			contatos.put(nome, novoContato);
			return true;
		}else {
			return false;
		}
		
	}
	
	public ArrayList<String> listar() {
		ArrayList<String> nomeDeContatos = new ArrayList<String>(contatos.keySet());
		return nomeDeContatos;
	}
	
	public boolean alterar(String nome, String telefone, String endereco) {
		if(contatos.containsKey(nome)) {
			Contato novoContato = new Contato(nome, telefone, endereco);
			contatos.put(nome, novoContato);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean remover(String nome) {
		return contatos.remove(nome) == null ?false:true;
	}
	
}
