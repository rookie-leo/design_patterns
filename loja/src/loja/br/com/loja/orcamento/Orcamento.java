package loja.br.com.loja.orcamento;

import java.math.BigDecimal;

public class Orcamento {

	private BigDecimal valor;
	private int qtdeItens;
	private String situacao;
	
	public Orcamento(BigDecimal valor, int qtdeItens) {
		this.valor = valor;
		this.qtdeItens = qtdeItens;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public int getQtdeItens() {
		return qtdeItens;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void aplicarDescontoExtra() {
		BigDecimal valorDoDescontoExtra = BigDecimal.ZERO;
		
		if (situacao.equals("EM_ANALISE")) {
			valorDoDescontoExtra = new BigDecimal("0.05");
		} else if (situacao.equals("APROVADO")) {
			valorDoDescontoExtra = new BigDecimal("0.02");
		}
		
		this.valor = this.valor.subtract(valorDoDescontoExtra);
	}
	
}
