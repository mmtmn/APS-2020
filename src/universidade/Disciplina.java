package universidade;

public class Disciplina extends Tabela {

	private Curso curso;
	
	public Disciplina(int id, String nome, Curso curso) {
		super(id, nome);
		this.curso = curso;
	}
	
	public void imprimirDados() {
		System.out.println("ID da disciplina: " + this.getId());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Curso: " + this.curso.getNome());
	}
	
}
