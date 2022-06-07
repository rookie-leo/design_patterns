package br.com.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.CPF;
import br.com.escola.dominio.aluno.Telefone;
import br.com.escola.repository.AlunoRepository;

public class RepositorioDeAlunoComJDBC implements AlunoRepository {

	private final Connection connection;
	
	public RepositorioDeAlunoComJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void matricular(Aluno aluno) {
		try {
			String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();
			
			sql = "INSERT INTO TELEFONE VALUES(?, ?)";
			ps = connection.prepareStatement(sql);
			for (Telefone tel : aluno.getTelefones()) {
				ps.setString(1, tel.getDdd());
				ps.setString(2, tel.getNumero());
				ps.execute();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Aluno buscarAlunoPorCPF(CPF cpf) {
		
		
		return null;
	}

	@Override
	public List<Aluno> listarAlunos() {
		return null;
	}

}
