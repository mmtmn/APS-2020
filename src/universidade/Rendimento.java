package universidade;

public class Rendimento {
	
	private float np1;
	private float np2;
	private float reposicao;
	private float exame;
	private float media;
	private String  aprovado;
	
	public Rendimento (String[] notas) {
		this.np1 = Float.parseFloat(notas[2]);
		this.np2 =Float.parseFloat(notas[3]);
		this.reposicao = Float.parseFloat(notas[4]);
		this.exame = Float.parseFloat(notas[5]);
		this.media = Float.parseFloat(notas[6]);
		this.aprovado = notas[7];
	}
	
	public Rendimento(float np12, float np22, float reposicao2, float exame2, float mediaFinal, String aprovado2) {
		// TODO Auto-generated constructor stub
		this.np1 = np12;
		this.np2 = np22;
		this.reposicao = reposicao2;
		this.exame = exame2;
		this.media = mediaFinal;
		this.aprovado = aprovado2;
	}

	public void print() {
		System.out.println("\nNP1: " + np1 +
						   "\nNP2: " + np2 +
						   "\nReposição: " + reposicao +
						   "\nExame: " + exame +
						   "\nMédia: " + media +
						   "\nAprovado: " + aprovado);
	}
}
