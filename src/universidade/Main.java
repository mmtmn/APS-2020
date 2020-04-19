package universidade;

public class Main {
	
	public static void main(String args[]) {
		
		Database db2 = new Database();
		
		/*
		 * Exemplos de como utilizar os m�todos da classe Database, para acessar informa��es do banco de dados
		 * 
		 * Os m�todos retornam um objecto respetivo a o que est� sendo pesquisado. 
		 * Por exemplo, os m�todos .searchAlunoById e .searchAlunoByNome, retornam um objeto Aluno com os atributos
		 * .id, .nome e .curso (.curso � um objeto da classe curso).
		 */ 
		
		System.out.println("------ Pesquisando Aluno com ID igual a 100 ------");
		db2.searchAlunoById("100").imprimirDados();
		System.out.println("\n------ Pesquisando Aluno com nome igual a Lucas ------");
		for (Aluno aluno : db2.searchAlunoByNome("João Lucas")) {
			aluno.imprimirDados();
			System.out.println("*********");	
		}	
		
		System.out.println("\n------ Pesquisando Curso com ID igual a 5 ------");
		db2.searchCursoById("5").imprimirDados();
		System.out.println("\n------ Pesquisando Curso com nome igual a Ciência ------");
		for (Curso curso : db2.searchCursoByNome("Ciência")) {
			curso.imprimirDados();
			System.out.println("*********");	
		}		
		
		System.out.println("\n------ Pesquisando Disicplina com ID igual a 5 ------");
		db2.searchDisciplinaById("66").imprimirDados();
		System.out.println("\n------ Pesquisando Disicplina com nome igual a Geoprocessamento ------");
		for (Disciplina disciplina : db2.searchDisciplinaByNome("Produção Vegetal II")) {
			disciplina.imprimirDados();
			System.out.println("*********");	
		}	

		System.out.println("\n------ Pesquisando Nota com ID igual a 365 ------");
		db2.searchNotaById("365").imprimirDados();
		
		/*
		System.out.println("\n---------- Inserindo um aluno no BD ----------");
        String[] q = {"1198", "Michael Scofield", "5"}; 
		System.out.println(db2.insert("aluno", q));*/			
				
	}
		
}