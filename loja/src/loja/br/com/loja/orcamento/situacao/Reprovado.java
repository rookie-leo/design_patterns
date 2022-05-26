package loja.br.com.loja.orcamento.situacao;

import loja.br.com.loja.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento {

	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setSituacao(new Finalizado());
	}
}
