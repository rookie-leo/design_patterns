package br.com.escola.aplicacao.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.CPF;
import br.com.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.escola.repository.AlunoRepository;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		AlunoRepository repository = new RepositorioDeAlunosEmMemoria();
		MatricularAluno aluno = new MatricularAluno(repository);
		
		AlunoDTO dto = new AlunoDTO("Raul Seixas", "123.456.789-98", "email@email.com");
		aluno.matricular(dto);
		
		Aluno encontrado = repository.buscarAlunoPorCPF(new CPF("123.456.789-98"));
		
		assertEquals("Raul Seixas", encontrado.getNome());
		assertEquals("123.456.789-98", encontrado.getCpf());
		assertEquals("email@email.com", encontrado.getEmail());
	}

}
