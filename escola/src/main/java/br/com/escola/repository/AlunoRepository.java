package br.com.escola.repository;

import java.util.List;

import br.com.escola.dominio.aluno.Aluno;

public interface AlunoRepository {

	void matricular(Aluno aluno);
	
	Aluno buscarAlunoPorCPF();
	
	List<Aluno> listarAlunos();
	
}
