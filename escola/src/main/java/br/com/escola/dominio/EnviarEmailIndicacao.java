package br.com.escola.dominio;

import br.com.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

	void enviarPara(Aluno indicado);
	
}
