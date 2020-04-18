package universidade;

public class Main {
	
	public static void main(String args[]) {
		
		Database db = new Database();
		
		/*
		 * Exemplos de como utilizar os métodos da classe Database, para acessar informações do banco de dados
		 * 
		 * Os métodos retornam um objecto respetivo a o que está sendo pesquisado. 
		 * Por exemplo, os métodos .searchAlunoById e .searchAlunoByNome, retornam um objeto Aluno com os atributos
		 * .id, .nome e .curso (.curso é um objeto da classe curso).
		 */ 
		
		System.out.println("---------- Pesquisando um Aluno ----------");
		db.searchAlunoById("100").imprimirDados(); //Método .searchAlunoById(id) para pesquisar aluno por sua ID
		System.out.println("--------------------");
		db.searchAlunoByNome("Noah Oliveira").imprimirDados(); //Método .searchAlunoByNome(id) para pesquisar aluno por seu nome
		
		System.out.println("\n---------- Pesquisando um Curso ----------");
		db.searchCursoById("5").imprimirDados(); //Método .searchCursoById(id) para pesquisar curso por sua ID
		System.out.println("--------------------");
		db.searchCursoByNome("Sistemas Para Internet").imprimirDados(); //Método .searchCursoByNome(id) para pesquisar curso por seu nome

		System.out.println("\n---------- Pesquisando uma Disciplina ----------");
		db.searchDisciplinaById("66").imprimirDados(); //Método .searchCursoById(id) para pesquisar curso por sua ID
		System.out.println("--------------------");
		db.searchDisciplinaByNome("Geoprocessamento").imprimirDados(); //Método .searchCursoByNome(id) para pesquisar curso por seu nome
	
		System.out.println("\n---------- Pesquisando uma Nota ----------");
		db.searchNotaById("365").imprimirDados(); //Método .searchNotaById(id) para pesquisar uma nota de um aluno por sua ID
		
	
		
	}
	
	
}