package br.com.escola.dominio.aluno;

public class FabricaDeAluno {

	private Aluno aluno;

	public FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email) {
		this.aluno = new Aluno(new CPF("12345678965"), "Raul Seixas", new Email("raul@email.com"));
		return this;
	}
	
	public FabricaDeAluno comTelefone(String ddd, String numero) {
		this.aluno.adicionaTelefone(ddd, numero);
		return this;
	}
	
	public Aluno criar() {
		return this.aluno;
	}

}
