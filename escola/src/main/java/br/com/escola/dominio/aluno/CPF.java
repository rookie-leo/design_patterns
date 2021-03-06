package br.com.escola.dominio.aluno;

public class CPF {
	
	private String numero;
	
	public CPF(String numero) {
		if (numero == null || !numero.matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")) {
			throw new IllegalArgumentException("CPF invalido!");
		}
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "CPF [numero=" + numero + "]";
	}
	
}
