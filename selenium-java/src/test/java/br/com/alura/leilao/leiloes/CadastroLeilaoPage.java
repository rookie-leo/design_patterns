package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
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

	public LeiloesPage cadastrarLeilao(String nomeLeilao, String valorInicial, String dataAbertura) {
		this.browser.findElement(By.id("nome")).sendKeys(nomeLeilao);
		this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
		this.browser.findElement(By.id("button-submit")).submit();
		
		return new LeiloesPage(browser);
	}
}
