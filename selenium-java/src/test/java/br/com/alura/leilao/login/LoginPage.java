package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

//Page Object
public class LoginPage extends PageObject {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	
	public LoginPage() {
		super(null);
		this.browser.navigate().to(URL_LOGIN);// passa o caminho que o navegador deve acessar		
	}

	public void preencheFormularioDeLogin(String username, String password) {
		this.browser.findElement(By.id("username")).sendKeys(username);// procura pelo elemento determinado no metodo findElement() passando dados pelo metodo sendKeys() 
		this.browser.findElement(By.id("password")).sendKeys(password);
	}

	public LeiloesPage efetuaLogin() {
		browser.findElement(By.id("login-form")).submit();// o metodo submit() funciona como um click no elemento especificado pelo id
		return new LeiloesPage(browser);
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
