package universidade;

public class Curso {
	private int id;
	private String nome;
	private String nivel;
	private int ano;
	
	public Curso(int id, String nome, String nivel, int ano) {
		this.id = id;
		this.nome = nome;
		this.nivel = nivel;
		this.ano = ano;
	}
	
	public String getFile() {
		return getNome() + "_" + getNivel() + "_" + getAno();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int cod_aluno) {
		this.id = cod_aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	 
	
}
