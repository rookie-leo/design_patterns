package br.com.alura.leilao.leiloes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;

	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
		this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.fechar();
	}

	@Test
	public void deveriaCadastrarLeilao() {
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilão do dia " + hoje;
		String valor = "500.00";
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
		
		assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
	
	@Test
	void deveriaValidarCadastroDeLeilao() {
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", "");
		
		assertFalse(this.paginaDeCadastro.isPaginaAtual());
		assertTrue(this.paginaDeLeiloes.isPaginaAtual());
		assertTrue(this.paginaDeCadastro.isMensagensVisiveis());
	}
}
