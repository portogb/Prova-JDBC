package aplicacao;

import java.util.Scanner;

import db.DB;
import model.dao.AlunoDaoJDBC;
import model.entidades.Aluno;

public class TestaDeleteDao {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Qual id do aluno deseja remover?");
		int id = sc.nextInt();
		sc.nextLine();
		
		AlunoDaoJDBC alunoJdbc = new AlunoDaoJDBC();
		Aluno aluno = alunoJdbc.buscaPorId(id);
		
		alunoJdbc.deletar(id);
		System.out.println("Aluno deletado com sucesso!");
		
		sc.close();
		DB.closeConnection();
	}

}
