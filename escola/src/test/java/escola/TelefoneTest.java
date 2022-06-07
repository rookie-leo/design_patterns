package escola;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.escola.aluno.Telefone;

class TelefoneTest {

	@Test
	void cadastraNumeroDeTelefoneComDDDInvalido() {
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone(null, "12345678"));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("12", "12345678"));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("(1)", "12345678"));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("", "12345678"));
	}
	
	@Test
	void cadastraNumeroDeTelefoneInvalido() {
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("(11)", null));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("(11)", ""));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("(11)", "123456789654"));
	}
	
	@Test
	void devePermitirCriarTelefoneComDddETelefoneCorretos() {
		String ddd = "11";
		String numero = "1234-5678";
		Telefone telefone = new Telefone(ddd, numero);
		
		assertEquals(ddd, telefone.getDdd());
		assertEquals(numero,  telefone.getNumero());
	}

}
