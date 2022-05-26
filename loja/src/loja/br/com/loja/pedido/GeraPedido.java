package loja.br.com.loja.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import loja.br.com.loja.orcamento.Orcamento;

public class GeraPedido {

	private String cliente;
	private BigDecimal valorDoOrcamento;
	private int qtdItens;
	
	public GeraPedido(String cliente, BigDecimal valorDoOrcamento, int qtdItens) {
		this.cliente = cliente;
		this.valorDoOrcamento = valorDoOrcamento;
		this.qtdItens = qtdItens;
	}
	
	public void executa() {
		Orcamento orcamento = new Orcamento(this.valorDoOrcamento, this.qtdItens);
		Pedido pedido = new Pedido(this.cliente, LocalDateTime.now(), orcamento);
		
		System.out.println("Pedido realizado com sucesso");//Salvando no banco de dados
		System.out.println("Enviando e-mail com dados da compra");//Enviando e-mail para o cliente
	}

}
