package br.com.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.escola.dominio.aluno.CPF;
import br.com.escola.dominio.aluno.Email;
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
		try {
			String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumero());
			
			ResultSet rs = ps.executeQuery();
			boolean encontrou = rs.next();
			if(!encontrou) {
				throw new AlunoNaoEncontrado(cpf);
			}
			
			String nome = rs.getString("nome");
			Email email = new Email(rs.getString("email"));
			Aluno encontrado = new Aluno(cpf, nome, email);
			
			Long id = rs.getLong("id");
			sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String numero = rs.getString("numero");
				String ddd = rs.getString("ddd");
				encontrado.adicionaTelefone(ddd, numero);
			}
			
			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Aluno> listarAlunos() {
		try {
			String sql = "SELECT id, cpf, nome, email  FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Aluno> alunos = new ArrayList<>();
			
			while (rs.next()) {
				CPF cpf = new CPF(rs.getString("cpf"));
				String nome = rs.getString("nome");
				Email email = new Email(rs.getString("email"));
				Aluno aluno = new Aluno(cpf, nome, email);
				
				Long id = rs.getLong("id");
				sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
				PreparedStatement psTelefone = connection.prepareStatement(sql);
				psTelefone.setLong(1, id);
				
				ResultSet rsTelefone = psTelefone.executeQuery();
				while (rsTelefone.next()) {
					String ddd = rsTelefone.getString("ddd");
					String numero = rsTelefone.getString("numero");
					aluno.adicionaTelefone(ddd, numero);
				}
				
				alunos.add(aluno);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

}
