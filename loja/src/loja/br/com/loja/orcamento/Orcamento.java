package loja.br.com.loja.orcamento;

import java.math.BigDecimal;

public class Orcamento {

	private BigDecimal valor;
	private int qtdeItens;
	
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
	
}
