package loja.br.com.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import loja.br.com.loja.orcamento.Orcamento;
import loja.br.com.loja.pedido.service.AcoesAposGerarPedido;

public class PedidoCommandHandler {

	private List<AcoesAposGerarPedido> acoes;
	
	public PedidoCommandHandler(List<AcoesAposGerarPedido> acoes) {
		this.acoes = acoes;
	}
	
	public void execute(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorDoOrcamento(), dados.getQtdItens());
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

		acoes.forEach(acao -> acao.executar(pedido));
	}
	
}
