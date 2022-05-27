package loja.br.com.loja.pedido;

import java.time.LocalDateTime;

import loja.br.com.loja.orcamento.Orcamento;
import loja.br.com.loja.pedido.service.EnviaEmailPedido;
import loja.br.com.loja.pedido.service.SalvaPedido;

public class PedidoCommandHandler {

	public void execute(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorDoOrcamento(), dados.getQtdItens());
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		
		EnviaEmailPedido email = new EnviaEmailPedido();
		SalvaPedido salva = new SalvaPedido();
		
		email.executar(pedido);
		salva.executar(pedido);
	}
	
}
