package loja.br.com.loja;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import loja.br.com.loja.orcamento.Orcamento;
import loja.br.com.loja.pedido.Pedido;

public class TestePedido {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(new BigDecimal("600"), 4);
		String cliente = "Ana Silva";
		LocalDateTime data = LocalDateTime.now();
		
		Pedido pedido = new Pedido(cliente, data, orcamento);
	}
	
}
