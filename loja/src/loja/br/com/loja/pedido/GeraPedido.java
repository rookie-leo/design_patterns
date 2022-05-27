package loja.br.com.loja.pedido;

import java.math.BigDecimal;

public class GeraPedido {

	private String cliente;
	private BigDecimal valorDoOrcamento;
	private int qtdItens;
	
	public GeraPedido(String cliente, BigDecimal valorDoOrcamento, int qtdItens) {
		this.cliente = cliente;
		this.valorDoOrcamento = valorDoOrcamento;
		this.qtdItens = qtdItens;
	}
	
//	public void executa() {
//
//	}

	public String getCliente() {
		return cliente;
	}

	public BigDecimal getValorDoOrcamento() {
		return valorDoOrcamento;
	}
	public int getQtdItens() {
		return qtdItens;
	}	

}
