package loja.br.com.loja.pedido.service;

import loja.br.com.loja.pedido.Pedido;

public class SalvaPedido implements AcoesAposGerarPedido {

	public void executar(Pedido pedido) {
		System.out.println("Salvando dados do pedido no banco de dados");
	}
	
}
