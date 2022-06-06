package escola;

public class Email {

	//Value Object
	
	private String endereco;
	
	public Email(String endereco) {
		if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zZA-Z0-9.-]+\\.[a-ZA-Z]{2,}$")) {
			throw new IllegalArgumentException("E-mail invalido!");
		}
		this.endereco = endereco;
	}
	
}
