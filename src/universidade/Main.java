package universidade;

public class Main {
	
	public static void main(String args[]) {
		
		Database db = new Database();
			
		System.out.println("------ Pesquisando Aluno com ID igual a 100 ------");
		db.searchAlunoById("100").imprimirDados();
		System.out.println("\n------ Pesquisando Aluno com nome igual a João Lucas ------");
		imprimirLista(db.searchAlunoByNome("João Lucas"));	
		
		System.out.println("\n------ Pesquisando Curso com ID igual a 5 ------");
		db.searchCursoById("5").imprimirDados();
		System.out.println("\n------ Pesquisando Curso com nome igual a Ciência ------");
		imprimirLista(db.searchCursoByNome("Ciência"));
		
		System.out.println("\n------ Pesquisando Disicplina com ID igual a 5 ------");
		db.searchDisciplinaById("66").imprimirDados();
		System.out.println("\n------ Pesquisando Disicplina com nome igual a Geoprocessamento ------");
		imprimirLista(db.searchDisciplinaByNome("Geoprocessamento"));

		System.out.println("\n------ Pesquisando Nota com ID igual a 365 ------");
		db.searchNotaById("365").imprimirDados();
				

		System.out.println("\n---------- Inserindo um aluno no BD ----------");
		System.out.println(db.insert("aluno", "Alan Turing,5"));
		
		System.out.println("\n------ Pesquisando Aluno com nome igual a Alan Turing ------");
		imprimirLista(db.searchAlunoByNome("Alan Turing"));
		
		System.out.println("\n---------- Alterando o curso do Aluno Id 700 ----------");
		System.out.println(db.alter("aluno", 700, "Alan Turing,10"));
		
		System.out.println("\n------ Pesquisando Aluno com nome igual a Alan Turing ------");
		imprimirLista(db.searchAlunoByNome("Alan Turing"));

		System.out.println("\n---------- Deletando dados do Aluno de id 700 ----------");
		System.out.println(db.delete("aluno", 700));

		System.out.println("\n------ Pesquisando Aluno com nome igual a Alan Turing ------");
		imprimirLista(db.searchAlunoByNome("Alan Turing"));
		
		System.out.println("\n");
			
						
	}
	
	public static void imprimirLista(Tabela[] alunos) {
		if (alunos.length == 0) {
			  System.out.println("Nenhum resultado encontrado!!!");
		}else {
			for (Tabela aluno : alunos) {
				aluno.imprimirDados();
				System.out.println("*********");	
			}
		}
	}
}