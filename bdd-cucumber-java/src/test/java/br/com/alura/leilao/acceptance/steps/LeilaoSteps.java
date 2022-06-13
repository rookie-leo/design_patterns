package br.com.alura.leilao.acceptance.steps;

import static org.junit.Assert.assertTrue;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LeilaoSteps {

	private LoginPage loginPage;
	private LeiloesPage leiloesPage;
	private NovoLeilaoPage novoLeilaoPage;

	@Dado("o usuario logado")
	public void o_usuario_logado() {
		Browser browser = new Browser();
		browser.seed();
		loginPage = browser.getLoginPage();
		leiloesPage = loginPage.realizaLoginComoFulano();
	}

	@Quando("acessa a pagina de novo leilao")
	public void acessa_a_pagina_de_novo_leilao() {
		novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
	}
	
	@Quando("preenche o formulario com dados validos")
	public void preenche_o_formulario_com_dados_validos() {
		this.leiloesPage = this.novoLeilaoPage.preencheForm("Smart thermometer", "385", "13/06/2022");
	}
	
	@Entao("volta para a pagina de leiloes")
	public void volta_para_a_pagina_de_leiloes() {
		assertTrue(leiloesPage.estaNaPaginaDeLeiloes());
	}
	
	@Entao("o novo leilao aparece na tabela")
	public void o_novo_leilao_aparece_na_tabela() {
		assertTrue(this.leiloesPage.existe("Smart thermometer", "385", "13/06/2022", "fulano"));
	}
	
}
