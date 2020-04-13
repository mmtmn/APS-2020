package universidade;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Database {
	
	public Database() {
		
	}

	public Aluno searchAlunoById(String q) {
		String [] dados = search("aluno", "id", q);
		return (new Aluno(Integer.parseInt(dados[0]), dados[1], searchCursoById(dados[2])));
	}
	
	public Aluno searchAlunoByNome(String q) {
		String [] dados = search("aluno", "nome", q);
		return (new Aluno(Integer.parseInt(dados[0]), dados[1], searchCursoById(dados[2])));
	}
	
	public Curso searchCursoByNome(String q) {
		String [] dados = search("curso", "nome", q);
		return (new Curso(Integer.parseInt(dados[0]), dados[1], dados[2]));
	}

	public Curso searchCursoById(String q) {
		String [] dados = search("curso", "id", q);
		return (new Curso(Integer.parseInt(dados[0]), dados[1], dados[2]));
	}

	public Disciplina searchDisciplinaById(String q) {
		String [] dados = search("disciplina", "id", q);
		return (new Disciplina(Integer.parseInt(dados[0]), dados[1], searchCursoById(dados[2])));
	}

	public Disciplina searchDisciplinaByNome(String q) {
		String [] dados = search("disciplina", "nome", q);
		return (new Disciplina(Integer.parseInt(dados[0]), dados[1], searchCursoById(dados[2])));
	}
	
	public Nota searchNotaById(String q) {
		String [] dados = search("nota", "id", q);
		return (new Nota(Integer.parseInt(dados[0]), 
				Double.parseDouble(dados[1]),
				Double.parseDouble(dados[2]),
				Double.parseDouble(dados[3]),
				Integer.parseInt(dados[4]),
				Integer.parseInt(dados[5]),
				searchDisciplinaById(dados[6]),
				searchAlunoById(dados[7])));
	}
	
	private String[] search(String what, String by, String q) {
		
		String fileName = "";
		
		if (what.equals("aluno")) {
			fileName = "database/alunos.csv";
		} else if (what.equals("curso")) {
			fileName = "database/cursos.csv";
		} else if (what.equals("disciplina")) {
			fileName = "database/disciplinas.csv";
		} else if (what.equals("nota")) {
			fileName = "database/notas.csv";
		}
		
		File file = new File(fileName);
	
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				
				String data = inputStream.nextLine();
				String[] dados = data.split(",");
				
				if (by.equals("id")) {
					if (dados[0].contentEquals(q)) {
						return (dados);
					}
				}else if (by.equals("nome")) {
					if (dados[1].contentEquals(q)) {
						return (dados);
					}
				}
			}
			inputStream.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}