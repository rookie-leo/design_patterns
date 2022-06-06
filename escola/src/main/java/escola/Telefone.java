package escola;

public class Telefone {

	private String ddd;
	private String numero;
	
	public Telefone(String ddd, String numero) {
		if (ddd == null || ddd.matches("(^\\s{2}$)")) {
			throw new IllegalArgumentException("DDD invalido!");
		} else if (numero == null || !numero.matches("^\\d{4,5}-\\d{4}$")) {
			throw new IllegalArgumentException("Numero de telefone invalido!");
		}
		
		this.ddd = ddd;
		this.numero = numero;
	}
	
}
 