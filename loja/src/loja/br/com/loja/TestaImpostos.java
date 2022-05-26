package loja.br.com.loja;

import java.math.BigDecimal;

import loja.br.com.loja.imposto.CalculadoraDeImpostos;
import loja.br.com.loja.imposto.ICMS;
import loja.br.com.loja.imposto.ISS;
import loja.br.com.loja.orcamento.Orcamento;

public class TestaImpostos {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		System.out.println(calculadora.calcular(orcamento, new ISS()));
		System.out.println(calculadora.calcular(orcamento, new ICMS()));
	}
	
}
