package loja.br.com.loja.imposto;

import java.math.BigDecimal;

import loja.br.com.loja.orcamento.Orcamento;

public class CalculadoraDeImpostos {

	public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
		return imposto.calcular(orcamento);
	}
	
}
