package aplicacao;

import java.util.List;

import db.DB;
import model.dao.AlunoDaoJDBC;
import model.entidades.Aluno;

public class TestaListarDao {
	
	public static void main(String[] args) {
		
		AlunoDaoJDBC adj = new AlunoDaoJDBC();
		
		List<Aluno> alunos = adj.listar();
		
		for (Aluno aluno : alunos) {
			System.out.println("-----------------------------");
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Email: " + aluno.getEmail());
			System.out.println("cpf: " + aluno.getCpf());
			System.out.println("Data: " + aluno.getDataDeNascimento());
			System.out.println("Naturalidade: " + aluno.getNaturalidade());
			System.out.println("Endereco: " + aluno.getEndereco());
		}
		
		DB.closeConnection();
	}
}
