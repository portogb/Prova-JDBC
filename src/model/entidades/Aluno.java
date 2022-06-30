package model.entidades;

public class Aluno {
	
	private Integer id;
	private String nome;
	private String email;
	private long cpf;
	private String dataDeNascimento;
	private String naturalidade;
	private String endereco;
	
	public Aluno() {
	}

	public Aluno(String nome, String email, long cpf, String dataDeNascimento, String naturalidade,
			String endereco) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.naturalidade = naturalidade;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", dataDeNascimento="
				+ dataDeNascimento + ", naturalidade=" + naturalidade + ", endereco=" + endereco + "]";
	}
}
