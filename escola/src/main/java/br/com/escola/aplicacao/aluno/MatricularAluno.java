package br.com.escola.aplicacao.aluno;

import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.repository.AlunoRepository;

public class MatricularAluno {

	private final AlunoRepository repository;
	
	public MatricularAluno(AlunoRepository repository) {
		this.repository = repository;
	}
	
	// COMMAND
	public void matricular(AlunoDTO dto) {
		Aluno novo = dto.criaAluno();
		repository.matricular(novo);
	}
	
}
