package br.com.escola;

import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.FabricaDeAluno;

public class Main {

	public static void main(String[] args) {
		FabricaDeAluno fabrica = new FabricaDeAluno();
		Aluno aluno = fabrica.comNomeCPFEmail("123.456.789-98", "", "")
			.comTelefone("", "")
			.comTelefone("", "")
			.criar();

	}

}
