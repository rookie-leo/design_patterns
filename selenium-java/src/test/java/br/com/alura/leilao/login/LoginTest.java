package br.com.alura.leilao.login;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginTest {
	
	private LoginPage paginaDeLogin;

	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();	
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}

	@Test
	void deveriaEfetuarLoginComDadosValidos() {
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		paginaDeLogin.efetuaLogin();

		assertFalse(paginaDeLogin.isPaginaAtual());
		assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
	}

	@Test
	void naoDeveriaEfetuarLoginComDadosInvalidos() {
		paginaDeLogin.preencheFormularioDeLogin("invalido", "1234");
		paginaDeLogin.efetuaLogin();		
		
		assertFalse(paginaDeLogin.isPaginaAtual());
		assertNull(paginaDeLogin.getNomeUsuarioLogado());
		assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
	}
	
	@Test
	void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		paginaDeLogin.navegaParaPaginasDeLances();
		
		assertTrue(paginaDeLogin.isPaginaAtual());
		assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
	}

}
