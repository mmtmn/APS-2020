package universidade;


public class Curso extends Tabela {
	private String nivel;
	
	public Curso(int id, String nome, String nivel) {
    	super(id, nome);
		this.nivel = nivel;
	}

	public void imprimirDados() {
		System.out.println("Id do curso: " + this.getId());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Nível: " + this.nivel);
	}

}