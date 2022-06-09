package br.com.alura.leilao.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginTest {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;

	@BeforeAll
	public static void beforeAll() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver102.exe");// Seta onde está contido o drive de acesso do chrome		
	}
	
	@BeforeEach
	public void beforeEach() {
		this.browser = new ChromeDriver();// Inicializa o obj contendo o navegador		
	}
	
	@AfterEach
	public void afterEach() {
		this.browser.quit();
	}

	@Test
	void deveriaEfetuarLoginComDadosValidos() {
		browser.navigate().to(URL_LOGIN);// passa o caminho que o navegador deve acessar
		
		browser.findElement(By.id("username")).sendKeys("fulano");// procura pelo elemento determinado no metodo findElement() passando dados pelo metodo sendKeys() 
		browser.findElement(By.id("password")).sendKeys("pass");
		browser.findElement(By.id("login-form")).submit();// o metodo submit() funciona como um click no elemento especificado pelo id
		
		assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
		assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
	}

	@Test
	void naoDeveriaEfetuarLoginComDadosInvalidos() {
		browser.navigate().to(URL_LOGIN);
		
		browser.findElement(By.id("username")).sendKeys("invalido");
		browser.findElement(By.id("password")).sendKeys("1234");
		browser.findElement(By.id("login-form")).submit();
		
		assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
		assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));// Traz o codigo font do HTML
		assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")).getText());
	}
	
	@Test
	void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
		
		assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login"));
		assertFalse(browser.getPageSource().contains("Dados do Leilão"));
	}

}
