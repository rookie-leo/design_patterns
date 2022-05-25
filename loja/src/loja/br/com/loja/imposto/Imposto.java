package loja.br.com.loja.imposto;

import java.math.BigDecimal;

import loja.br.com.loja.orcamento.Orcamento;

public interface Imposto {

	BigDecimal calcular(Orcamento orcamento);
	
}
