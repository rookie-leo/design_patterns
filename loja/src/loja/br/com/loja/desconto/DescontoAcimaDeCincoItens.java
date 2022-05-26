package loja.br.com.loja.desconto;

import java.math.BigDecimal;

import loja.br.com.loja.orcamento.Orcamento;

public class DescontoAcimaDeCincoItens extends Desconto{

	public DescontoAcimaDeCincoItens(Desconto proximo) {
		super(proximo);
	}

	public BigDecimal calcular(Orcamento orcamento) {
		if (orcamento.getQtdeItens() > 5) {
			return orcamento.getValor().multiply(new BigDecimal("0.1"));
		}
		
		return proximo.calcular(orcamento);
	}		
}
