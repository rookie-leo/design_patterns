package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;

	@BeforeEach
	public void iniciarlizar() {
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Teste", LocalDate.now(), new BigDecimal("1000"));
	}
	
	@Test
	void reajusteDeveriaSerDeTresPorCentoQuandoODesempenhoForADesejar() {		
		service.reajustar(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	void reajusteDeveriaSerDeQuinzePorCentoQuandoODesempenhoForBom() {
		service.reajustar(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	void reajusteDeveriaSerDeVintePorCentoQuandoODesempenhoForOtimo() {		
		service.reajustar(funcionario, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}
