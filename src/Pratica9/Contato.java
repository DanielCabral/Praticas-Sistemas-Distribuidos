package Pratica9;

import java.io.Serializable;

public class Contato implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nome;
	String telefone;
	String endereco;
	
	public Contato(String nome, String telefone, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco= endereco;
	}
}
