package loja.br.com.loja.pedido;

import java.time.LocalDateTime;

import loja.br.com.loja.orcamento.Orcamento;

public class PedidoCommandHandler {

	public void execute(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorDoOrcamento(), dados.getQtdItens());
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		
		System.out.println("Pedido realizado com sucesso");//Salvando no banco de dados
		System.out.println("Enviando e-mail com dados da compra");//Enviando e-mail para o cliente
	}
	
}
