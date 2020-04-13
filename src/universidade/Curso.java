package universidade;


public class Curso {
	int id;
	String nome;
	String nivel;
	
	public Curso(int idC, String nomeC, String nivelC) {
		id = idC;
		nome = nomeC;
		nivel = nivelC;
	}
	
	public void imprimirDados() {
		System.out.println("ID do curso: " + id);
		System.out.println("Nome: " + nome);
		System.out.println("Nível: " + nivel);
	}
}