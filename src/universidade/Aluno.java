package universidade;

public class Aluno {
	private String id;
	private String nome;
	
	public Aluno(String id, String nome) {
		this.setId(id);
		this.setNome(nome);

	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
