package escola;

public class Main {

	public static void main(String[] args) {
		FabricaDeAluno fabrica = new FabricaDeAluno();
		Aluno aluno = fabrica.comNomeCPFEmail("12345678956", "", "")
			.comTelefone("", "")
			.comTelefone("", "")
			.criar();

	}

}
