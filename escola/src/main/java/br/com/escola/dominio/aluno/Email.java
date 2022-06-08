package br.com.escola.dominio.aluno;

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

	@Override
	public String toString() {
		return "Email [endereco=" + endereco + "]";
	}

}
