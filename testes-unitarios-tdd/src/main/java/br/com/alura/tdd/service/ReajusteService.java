package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void reajustar(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal reajuste;
		if (desempenho == Desempenho.A_DESEJAR) {
			reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
			funcionario.reajustarSalario(reajuste);
		} else if (desempenho == Desempenho.BOM) {
			reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
			funcionario.reajustarSalario(reajuste);
		} else if (desempenho == Desempenho.OTIMO) {
			reajuste = funcionario.getSalario().multiply(new BigDecimal("0.20"));
			funcionario.reajustarSalario(reajuste);
		} else {
			throw new IllegalArgumentException("Desempenho não encontrado!");
		}
		
	}

}
