package loja.br.com.loja.desconto;

import java.math.BigDecimal;

import loja.br.com.loja.orcamento.Orcamento;

public class CalculadoraDeDescontos {
	
	public BigDecimal calcular(Orcamento orcamento) {
		Desconto cadeiaDeDescontos = new DescontoValorMaiorQuinhentos(
								new DescontoAcimaDeCincoItens(
										new SemDesconto()));
		
		return cadeiaDeDescontos.calcular(orcamento);
	}

}
