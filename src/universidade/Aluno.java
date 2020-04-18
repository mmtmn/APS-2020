package universidade;

public class Aluno extends Tabela {
	
	Curso curso;
	
	
	public Aluno(int id, String nome, Curso curso) {
		super(id, nome);
		this.curso = curso;
	}

	public void imprimirDados() {
		System.out.println("Id do aluno: " + this.getId());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Curso: " + this.curso.getNome());
	}

}