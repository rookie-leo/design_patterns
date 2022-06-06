package escola;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void naoDeveCriaraEmailsComEnderecoInvalidos() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Email(null));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Email(""));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Email("emailarrobaemail.com"));
	}
	
	@Test
	void deveCriarEmailValido() {
		//TODO validar se o email cadastrado é valido
	}

}
