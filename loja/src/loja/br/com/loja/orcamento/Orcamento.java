package loja.br.com.loja.orcamento;

import java.math.BigDecimal;

import loja.br.com.loja.orcamento.situacao.EmAnalise;
import loja.br.com.loja.orcamento.situacao.SituacaoOrcamento;

public class Orcamento {

	private BigDecimal valor;
	private int qtdeItens;
	private SituacaoOrcamento situacao;

	public Orcamento(BigDecimal valor, int qtdeItens) {
		this.valor = valor;
		this.qtdeItens = qtdeItens;
		this.situacao = new EmAnalise();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public int getQtdeItens() {
		return qtdeItens;
	}

	public SituacaoOrcamento getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}

	public void aplicarDescontoExtra() {
		BigDecimal valorDoDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
		this.valor = this.valor.subtract(valorDoDescontoExtra);
	}
	
	public void aprovar() {
		this.situacao.aprovar(this);
	}
	
	public void reprovar() {
		this.situacao.reprovar(this);
	}
	
	public void finalizar() {
		this.situacao.finalizar(this);
	}

}
