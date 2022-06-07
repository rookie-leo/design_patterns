package br.com.escola;

import br.com.escola.aluno.Aluno;
import br.com.escola.aluno.FabricaDeAluno;

public class Main {

	public static void main(String[] args) {
		FabricaDeAluno fabrica = new FabricaDeAluno();
		Aluno aluno = fabrica.comNomeCPFEmail("12345678956", "", "")
			.comTelefone("", "")
			.comTelefone("", "")
			.criar();

	}

}
