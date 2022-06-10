package br.com.alura.leilao.leiloes;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;

	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.fechar();
	}

	@Test
	public void deveriaCadastrarLeilao() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
		CadastroLeilaoPage paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
		
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilão do dia " + hoje;
		String valor = "500.00";
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
		
		assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
}
