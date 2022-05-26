package loja.br.com.loja.orcamento.situacao;

import java.math.BigDecimal;

import loja.br.com.loja.DomainException;
import loja.br.com.loja.orcamento.Orcamento;

public abstract class SituacaoOrcamento {
	
	public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}

	public void aprovar(Orcamento orcamento) {
		throw new DomainException("Or�amento n�o pode ser aprovado!");
	}

	public void reprovar(Orcamento orcamento) {
		throw new DomainException("Or�amento n�o pode ser reprovado!");
	}

	public void finalizar(Orcamento orcamento) {
		throw new DomainException("Or�amento n�o pode ser finalizado!");
	}
	
}
