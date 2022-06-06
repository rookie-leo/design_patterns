package escola;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	//Entity
	
	private CPF cpf;
	private String nome;
	private Email email; 
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public void adicionaTelefone(String ddd, String numero) {
		this.telefones.add(new Telefone(ddd, numero));
	}

	public CPF getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Email getEmail() {
		return email;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}
	
}
