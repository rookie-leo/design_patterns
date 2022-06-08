package br.com.escola.aplicacao.aluno;

import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.CPF;
import br.com.escola.dominio.aluno.Email;

public class AlunoDTO {

	private String nomeAluno;
	private String cpfAluno;
	private String emailAluno;
	
	public AlunoDTO(String nomeAluno, String cpfAluno, String emailAluno) {
		super();
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.emailAluno = emailAluno;
	}

	public Aluno criaAluno() {
		return new Aluno(new CPF(cpfAluno), nomeAluno, new Email(emailAluno));
	}
	
	
}
