package aplicacao;

import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.AlunoDaoJDBC;
import model.entidades.Aluno;

public class TestaFiltrarPorLetraDao {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por qual letra deseja filtrar?");
		String letra = sc.next();
		
		AlunoDaoJDBC alunoJdbc = new AlunoDaoJDBC();
		
		List<Aluno> alunos = alunoJdbc.filtrarPorLetra(letra);
		
		for (Aluno aluno : alunos) {
			System.out.println("-----------------------------");
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Email: " + aluno.getEmail());
			System.out.println("cpf: " + aluno.getCpf());
			System.out.println("Data: " + aluno.getDataDeNascimento());
			System.out.println("Naturalidade: " + aluno.getNaturalidade());
			System.out.println("Endereco: " + aluno.getEndereco());
		}
		
		sc.close();
		DB.closeConnection();
	}

}
