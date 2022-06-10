package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Page Object
public class LoginPage {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;
	
	public LoginPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver102.exe");// Seta onde está contido o drive de acesso do chrome	
		this.browser = new ChromeDriver();// Inicializa o obj contendo o navegador		
		this.browser.navigate().to(URL_LOGIN);// passa o caminho que o navegador deve acessar		
	}

	public void fechar() {
		this.browser.quit();
	}

	public void preencheFormularioDeLogin(String username, String password) {
		this.browser.findElement(By.id("username")).sendKeys(username);// procura pelo elemento determinado no metodo findElement() passando dados pelo metodo sendKeys() 
		this.browser.findElement(By.id("password")).sendKeys(password);
	}

	public void efetuaLogin() {
		browser.findElement(By.id("login-form")).submit();// o metodo submit() funciona como um click no elemento especificado pelo id
	}

	public boolean isPaginaAtual() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public String getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	public void navegaParaPaginasDeLances() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");		
	}

	public boolean contemTexto(String texto) {
		return this.browser.getPageSource().contains(texto);
	}

}
