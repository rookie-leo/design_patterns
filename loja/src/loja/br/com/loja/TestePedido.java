package loja.br.com.loja;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import loja.br.com.loja.pedido.GeraPedido;
import loja.br.com.loja.pedido.PedidoCommandHandler;
import loja.br.com.loja.pedido.service.EnviaEmailPedido;
import loja.br.com.loja.pedido.service.SalvaPedido;

public class TestePedido {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome do cliente: ");
		String cliente = sc.nextLine();
		System.out.println("Digite o valor do or�amento realizado: ");
		BigDecimal valorDoOrcamento = sc.nextBigDecimal();
		System.out.println("Digite a quantidade de itens: ");
		int qtdeItens = sc.nextInt();

		sc.close();

		GeraPedido gerador = new GeraPedido(cliente, valorDoOrcamento, qtdeItens);
		PedidoCommandHandler command = new PedidoCommandHandler(
				Arrays.asList(
						new SalvaPedido(), 
						new EnviaEmailPedido()
						));
		command.execute(gerador);

	}

}
