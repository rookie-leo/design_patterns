package loja.br.com.loja.desconto;

import java.math.BigDecimal;

import loja.br.com.loja.orcamento.Orcamento;

public class DescontoValorMaiorQuinhentos extends Desconto {

	public DescontoValorMaiorQuinhentos(Desconto proximo) {
		super(proximo);
	}

	public BigDecimal efetuarCalculo(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.1"));
	}

	@Override
	public boolean deveAplicar(Orcamento orcamento) {
		return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
	}
}
