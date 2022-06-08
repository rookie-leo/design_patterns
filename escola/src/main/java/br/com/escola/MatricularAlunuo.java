package br.com.escola;

import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.FabricaDeAluno;
import br.com.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.escola.repository.AlunoRepository;

public class MatricularAlunuo {

	public static void main(String[] args) {
		
		FabricaDeAluno fabrica = new FabricaDeAluno();
		Aluno aluno = fabrica.comNomeCPFEmail("Douglas Drumound", "123.456.789-98", "email@email.com").criar();
		AlunoRepository repositorio = new RepositorioDeAlunosEmMemoria();
		repositorio.matricular(aluno);
		
		System.out.println(aluno.toString());

	}

}
