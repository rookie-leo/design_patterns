package loja.br.com.loja.pedido.service;

import loja.br.com.loja.pedido.Pedido;

public class EnviaEmailPedido implements AcoesAposGerarPedido {

	public void executar(Pedido pedido) {
		System.out.println("Enviando email com dados do pedido");
	}
	
}
