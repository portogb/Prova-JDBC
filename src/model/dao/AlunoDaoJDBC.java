package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.entidades.Aluno;

public class AlunoDaoJDBC implements AlunoDao{
	
	private Connection conn; 

	@Override
	public void inserir(Aluno obj) {
		
		conn = DB.getConnection();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
							"INSERT INTO alunos "
							+ "(nome, email, cpf, dataDeNascimento, naturalidade, endereco) "
							+ "VALUES "
							+ "(?, ?, ?, ?, ?, ?)");
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getEmail());
			st.setLong(3, obj.getCpf());
			st.setString(4, obj.getDataDeNascimento());
			st.setString(5, obj.getNaturalidade());
			st.setString(6, obj.getEndereco());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage()); 
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void alterar(Aluno obj, Integer id) {
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement(
					"UPDATE alunos "
					+ "SET nome = ?, email = ?, cpf = ?, dataDeNascimento = ?, naturalidade = ?, endereco = ? "
					+ "WHERE id = ?");
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getEmail());
			st.setLong(3, obj.getCpf());
			st.setString(4, obj.getDataDeNascimento());
			st.setString(5, obj.getNaturalidade());
			st.setString(6, obj.getEndereco());
			st.setInt(7, obj.getId());
		
			st.executeUpdate();
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deletar(Integer id) {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement(
					"DELETE FROM alunos WHERE id = ?");
			
			st.setInt(1, id);
			st.executeUpdate();
	
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Aluno> listar() {
		
		conn = DB.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from alunos";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
		
			List<Aluno> alunos = new ArrayList<Aluno>();
			
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setCpf(rs.getLong("cpf"));
				aluno.setDataDeNascimento(rs.getString("dataDeNascimento"));
				aluno.setNaturalidade(rs.getString("naturalidade"));
				aluno.setEndereco(rs.getString("endereco"));
				alunos.add(aluno);
			}

			return alunos;
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage()); 
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Aluno> filtrarPorLetra(String letra) {
		
		conn = DB.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM alunos WHERE nome like '" + letra + "%'";
			
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			
			List<Aluno> alunos = new ArrayList<Aluno>();
			
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setCpf(rs.getLong("cpf"));
				aluno.setDataDeNascimento(rs.getString("dataDeNascimento"));
				aluno.setNaturalidade(rs.getString("naturalidade"));
				aluno.setEndereco(rs.getString("endereco"));
				alunos.add(aluno);
			}
			
			return alunos;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage()); 
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public Aluno buscaPorId(Integer id) {
		
		conn = DB.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement(
					"SELECT * FROM alunos "
					+ "WHERE id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setCpf(rs.getLong("cpf"));
				aluno.setDataDeNascimento(rs.getString("dataDeNascimento"));
				aluno.setNaturalidade(rs.getString("naturalidade"));
				aluno.setEndereco(rs.getString("endereco"));
				return aluno;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage()); 
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
