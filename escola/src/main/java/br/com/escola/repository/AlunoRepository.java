package br.com.escola.repository;

import java.util.List;

import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.CPF;

public interface AlunoRepository {

	void matricular(Aluno aluno);
	
	Aluno buscarAlunoPorCPF(CPF cprf);
	
	List<Aluno> listarAlunos();
	
}
