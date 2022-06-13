package br.com.alura.leilao.acceptance.steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {

	private Browser browser;
	private LoginPage loginPage;
	private LeiloesPage leiloesPage;

	@Dado("o usuario valido")
	public void o_usuario_valido() {
		browser = new Browser();
		browser.seed();
		loginPage = browser.getLoginPage();
	}

	@Quando("realiza o login")
	public void realiza_o_login() {
		leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
	}
	
	@Entao("eh direcionado para a pagina de leiloes")
	public void eh_direcionado_para_a_pagina_de_leiloes() {
		assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
	}
	
	@Dado("o usuario invalido")
	public void o_usuario_invalido() {
		browser = new Browser();
		browser.seed();
		loginPage = browser.getLoginPage();
	}
	
	@Quando("tenta se logar")
	public void tenta_se_logar() {
		leiloesPage = this.loginPage.realizaLoginComo("invalido", "INVALIDO");
	}
	
	@Entao("continua na pagina de login")
	public void continua_na_pagina_de_login() {
		assertFalse(this.leiloesPage.estaNaPaginaDeLeiloes());
	}
	
}
