package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	private BonusService service;
	
	@BeforeEach
	public void inicializar() {
		this.service = new BonusService();
	}

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioAcimaDeDezMil() {		
		assertThrows(IllegalArgumentException.class,
				() -> service.calcularBonus(new Funcionario("Teste da Silva", 
						LocalDate.now(), 
						new BigDecimal(10000.01))));
	}

	@Test
	void bonusDeveriaSerDezPorCentoDoSalarioAbaixoDeDezMil() {
		BigDecimal bonus = service.calcularBonus(new Funcionario("Teste da Silva", LocalDate.now(), new BigDecimal(5000)));
		
		assertEquals(new BigDecimal("500.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoDoSalarioDeDezMil() {
		BigDecimal bonus = service.calcularBonus(new Funcionario("Teste da Silva", LocalDate.now(), new BigDecimal(10000)));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
