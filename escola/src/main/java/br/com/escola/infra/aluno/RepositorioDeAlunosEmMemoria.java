package br.com.escola.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.escola.dominio.aluno.CPF;
import br.com.escola.repository.AlunoRepository;

public class RepositorioDeAlunosEmMemoria implements AlunoRepository {

	private List<Aluno> matriculados = new ArrayList<Aluno>();
	
	@Override
	public void matricular(Aluno aluno) {
		this.matriculados.add(aluno);

	}

	@Override
	public Aluno buscarAlunoPorCPF(CPF cpf) {
		return this.matriculados.stream()
				.filter(a -> a.getCpf().equals(cpf.getNumero()))
				.findFirst()
				.orElseThrow(() -> new AlunoNaoEncontrado(cpf));
	}

	@Override
	public List<Aluno> listarAlunos() {
		return this.matriculados;
	}

}
