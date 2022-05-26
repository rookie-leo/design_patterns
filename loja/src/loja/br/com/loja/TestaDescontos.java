package loja.br.com.loja;

import java.math.BigDecimal;

import loja.br.com.loja.desconto.CalculadoraDeDescontos;
import loja.br.com.loja.orcamento.Orcamento;

public class TestaDescontos {

	public static void main(String[] args) {
		Orcamento orcamento1 = new Orcamento(new BigDecimal("100"), 5);
		Orcamento orcamento2 = new Orcamento(new BigDecimal("1000"), 6);
		
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		System.out.println(calculadora.calcular(orcamento1));
		System.out.println(calculadora.calcular(orcamento2));
		
	}
	
}
