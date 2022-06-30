package aplicacao;

import java.util.Scanner;

import db.DB;
import model.dao.AlunoDaoJDBC;
import model.entidades.Aluno;

public class TestaAtualizarDao {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o id que deseja altear: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		AlunoDaoJDBC alunoJdbc = new AlunoDaoJDBC();
		Aluno aluno = new Aluno();
		aluno = alunoJdbc.buscaPorId(id);
		System.out.println(aluno.toString());
		
		System.out.println("Informe o dado que deseja alterar: ");
		System.out.println("1 - (nome), 2 - (email), 3 - (endereco)");
		int op = sc.nextInt();
		sc.nextLine();
		
		switch(op) {
			
			case 1: {
				System.out.println("Digite o novo nome: ");
				aluno.setNome(sc.nextLine());
				System.out.println("Nome alterado!");
			}
			break;
			
			case 2: { 
				System.out.println("Digite um novo email: ");
				aluno.setEmail(sc.nextLine());
				System.out.println("Email alterado!");
			}
			break;
			
			case 3:{
				System.out.println("Digite um novo endereco: ");
				aluno.setEndereco(sc.nextLine());
				System.out.println("Endereco alterado!");
			}
			break;
			default:
				System.out.println("Opcao invalida, escolha uma opcao entre 1 e 3");
		}
		
		alunoJdbc.alterar(aluno, id);
		System.out.println("------------------");
		System.out.println("Cadastro atualizado: ");
		System.out.println(aluno.toString());
		
		sc.close();
		DB.closeConnection();
	}

}
