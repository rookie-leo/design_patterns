package br.com.escola.aluno;

public class Email {

	//Value Object
	
	private String endereco;
	
	public Email(String endereco) {
		if (endereco == null || !endereco.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
			throw new IllegalArgumentException("E-mail invalido!");
		}
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return endereco;
	}
}
