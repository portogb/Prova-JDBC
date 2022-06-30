package model.dao;

import java.util.List;

import model.entidades.Aluno;

public interface AlunoDao {
	
	void inserir(Aluno obj);
	void alterar(Aluno obj, Integer id);
	void deletar(Integer id);
	Aluno buscaPorId(Integer id);
	List<Aluno> listar();
	List<Aluno> filtrarPorLetra(String letra);
}
