package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

//Page Object
public class CadastroLeilaoPage {
	private WebDriver browser;
	
	public CadastroLeilaoPage(WebDriver browser) {
		this.browser = browser;		
	}

	public void fechar() {
		this.browser.quit();
	}
}
