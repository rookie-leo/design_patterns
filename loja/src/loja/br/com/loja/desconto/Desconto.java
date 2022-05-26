package loja.br.com.loja.desconto;

import java.math.BigDecimal;

import loja.br.com.loja.orcamento.Orcamento;

public abstract class Desconto {
	
	protected Desconto proximo;
	
	public Desconto(Desconto proximo) {
		this.proximo = proximo;
	}

	protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);
	public abstract boolean deveAplicar(Orcamento orcamento);
	
	public BigDecimal calcular(Orcamento orcamento) {
		if (deveAplicar(orcamento)) {
			return efetuarCalculo(orcamento);
		}
		
		return proximo.calcular(orcamento);
	}
	
}
