package universidade;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Database {
	
	public Database() {
		
	}

	public Aluno searchAlunoById(String q) {
		String [] dados = search("aluno", "cod_aluno", q);
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
		String [] dados = search("curso", "cod_curso", q);
		return (new Curso(Integer.parseInt(dados[0]), dados[1], dados[2]));
	}

	public Disciplina searchDisciplinaById(String q) {
		String [] dados = search("disciplina", "cod_disciplina", q);
		return (new Disciplina(Integer.parseInt(dados[0]), dados[1], searchCursoById(dados[2])));
	}

	public Disciplina searchDisciplinaByNome(String q) {
		String [] dados = search("disciplina", "nome", q);
		return (new Disciplina(Integer.parseInt(dados[0]), dados[1], searchCursoById(dados[2])));
	}

	
	public Nota searchNotaById(String q) {
		String [] dados = search("nota", "cod_nota", q);
		return (new Nota(Integer.parseInt(dados[0]), 
				Double.parseDouble(dados[1]),
				Double.parseDouble(dados[2]),
				Double.parseDouble(dados[3]),
				Integer.parseInt(dados[4]),
				Integer.parseInt(dados[5]),
				searchDisciplinaById(dados[6]),
				searchAlunoById(dados[7])));
	}
	
	private String[] search(String tabela, String coluna, String q) {
			
		File file = new File("database/" + tabela + ".csv");
		
		try (Scanner inputStream = new Scanner(file)) {
			
			Map<String,Integer> colunas = new HashMap<String,Integer>();
			
			String data = inputStream.nextLine();
			String[] dados = data.split(",");
			
			for(int i = 0; dados.length > i; i++) {
				colunas.put(dados[i], i);
			}
			
			while (inputStream.hasNext()) {				
				data = inputStream.nextLine();
				dados = data.split(",");
				
				if (dados[colunas.get(coluna)].contentEquals(q)) {
					return (dados);
				}
				
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
