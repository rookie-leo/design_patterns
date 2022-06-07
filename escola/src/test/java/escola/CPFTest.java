package escola;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.escola.aluno.CPF;

class CPFTest {

	@Test
	void naoDeveCriarCPFInvalido() {	
		assertThrows(IllegalArgumentException.class,
				() -> new CPF("12345678912"));
		
		assertThrows(IllegalArgumentException.class,
				() -> new CPF(""));
		
		assertThrows(IllegalArgumentException.class,
				() -> new CPF(null));
	}
	
	@Test
	void deveCadastrarCPFValido() {
		//TODO implementar logica para testar COF valido
	}

}
