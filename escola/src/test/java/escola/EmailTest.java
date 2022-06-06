package escola;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
		String endereco =  "email@email.com";
		Email email = new Email(endereco);
		
		assertEquals(endereco, email.getEndereco());
	}

}
