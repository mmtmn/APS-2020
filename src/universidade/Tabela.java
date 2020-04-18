package universidade;

public class Tabela {
	
	private int id;
	private String nome;
	
	public Tabela(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void imprimirDados() {
		System.out.println("ID da disciplina: " + this.id);
		System.out.println("Nome: " + this.nome);
	}
	

}
