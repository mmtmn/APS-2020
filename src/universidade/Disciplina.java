package universidade;

public class Disciplina {
	int id;
	String nome;
	Curso curso;
	
	public Disciplina(int idC, String nomeC, Curso cursoC) {
		id = idC;
		nome = nomeC;
		curso = cursoC;
	}
	
	public void imprimirDados() {
		System.out.println("ID da disciplina: " + id);
		System.out.println("Nome: " + nome);
		System.out.println("Curso: " + curso.nome);
	}
}
