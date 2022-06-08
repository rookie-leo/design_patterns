package br.com.escola;

import br.com.escola.aplicacao.aluno.AlunoDTO;
import br.com.escola.aplicacao.aluno.MatricularAluno;
import br.com.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoApp {

	public static void main(String[] args) {
		String nome = "Raul Seixas";
		String cpf = "123.456.789-98";
		String email = "email@email.com";
		
		MatricularAluno novo = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
		novo.matricular(new AlunoDTO(nome, cpf, email));
	}
		
}
