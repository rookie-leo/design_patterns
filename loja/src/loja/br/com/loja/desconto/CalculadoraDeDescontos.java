package loja.br.com.loja.desconto;

import java.math.BigDecimal;

import loja.br.com.loja.orcamento.Orcamento;

public class CalculadoraDeDescontos {
	
	public BigDecimal calcular(Orcamento orcamento) {
		if (orcamento.getQtdeItens() > 5) {
			return orcamento.getValor().multiply(new BigDecimal("0.1"));
		}
		
		if (orcamento.getValor().compareTo(new BigDecimal("500")) > 0) {
			return orcamento.getValor().multiply(new BigDecimal("0.1"));
		}
		
		return BigDecimal.ZERO;
	}

}
