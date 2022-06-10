package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

	protected WebDriver browser;
	
	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");// Seta onde está contido o drive de acesso do chrome	
		
		if(browser == null) {
			this.browser = new ChromeDriver();// Inicializa o obj contendo o navegador	
		} else {
			this.browser = browser;
		}
	}
	
	public void fechar() {
		this.browser.quit();
	}
	
}
