package universidade;

public class Tabela {
	
	private int id;
	private String nome;
	
	public Tabela(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void imprimirDados() {
		System.out.println("ID: " + this.id);
		System.out.println("Nome: " + this.nome);
	}
	

}
