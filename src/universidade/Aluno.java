package universidade;

public class Aluno {
	
	int id;
	String nome;
	
	Curso curso;
	
	
	public Aluno(int idC, String nomeC, Curso cursoC) {
		id = idC;
		nome = nomeC;
		curso = cursoC;
	}
	
	public void imprimirDados() {
		System.out.println("ID do aluno: " + id);
		System.out.println("Nome: " + nome);
		System.out.println("Curso: " + curso.nome);
	}
}