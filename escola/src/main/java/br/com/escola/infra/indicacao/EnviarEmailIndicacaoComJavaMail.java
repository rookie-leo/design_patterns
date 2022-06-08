package br.com.escola.infra.indicacao;

import br.com.escola.dominio.EnviarEmailIndicacao;
import br.com.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno indicado) {
		//TODO desafio: implementar o envio de email com a lib Java Mail
	}

}
