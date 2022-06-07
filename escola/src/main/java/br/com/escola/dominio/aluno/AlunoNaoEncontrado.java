package br.com.escola.dominio.aluno;

public class AlunoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public AlunoNaoEncontrado(CPF cpf) {
		super("Aluno n�o encontrado! CPF:" + cpf.getNumero());
	}

}
