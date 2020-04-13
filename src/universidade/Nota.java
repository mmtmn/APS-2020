package universidade;

public class Nota {
	int id, semestre, ano;
	double np1, np2, exame;
	
	Disciplina disciplina;
	Aluno aluno;
	
	public Nota(int idC, 
				double np1C,
				double np2C,
				double exameC,
				int semestreC, 
				int anoC,
				Disciplina disciplinaC,
				Aluno alunoC) {
		
		id = idC;
		semestre = semestreC;
		ano = anoC;
		np1 = np1C;
		np2 = np2C;
		exame = exameC;
		disciplina = disciplinaC;
		aluno = alunoC;
	}
	
	public void imprimirDados() {
		System.out.println("ID da nota: " + id);
		System.out.println("Aluno: " + aluno.nome);
		System.out.println("Curso: " + aluno.curso.nome);
		System.out.println("Disciplina: " + disciplina.nome);
		System.out.println("NP1: " + np1);
		System.out.println("NP2: " + np2);
		System.out.println("Exame: " + exame);
		System.out.println("Aprovado?: " + foiAprovado());
		
	}
	
	private boolean foiAprovado() {
		Double media = ((np1 + np2) / 2);
		if (media >= 7) {
			return true;
		}else if (((media + exame) / 2) >= 5) {
			return true;	
		}else {
			return false;
		}
	}
	
}
