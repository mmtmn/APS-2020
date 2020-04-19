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
		Map<Integer, String[]> dados = search("aluno", "cod_aluno", q);
		String[] row = dados.get(0);
		return new Aluno(Integer.parseInt(row[0]), row[1], searchCursoById(row[2]));
		
	}
	
	public Aluno[] searchAlunoByNome(String q) {
		Map<Integer, String[]> dados = search("aluno", "nome", q);
		Aluno[] alunos = new Aluno[dados.size()] ;
		
		for (int i = 0; i < dados.size(); i++) {
			String[] row = dados.get(i); 
			alunos[i] = new Aluno(Integer.parseInt(row[0]), row[1], searchCursoById(row[2]));
		}
		return alunos;
		
	}
	
	public Disciplina searchDisciplinaById(String q) {
		Map<Integer, String[]> dados = search("disciplina", "cod_disciplina", q);
		String[] row = dados.get(0);
		return new Disciplina(Integer.parseInt(row[0]), row[1], searchCursoById(row[2]));
		
	}
	
	public Disciplina[] searchDisciplinaByNome(String q) {
		Map<Integer, String[]> dados = search("disciplina", "nome", q);
		Disciplina[] disciplinas = new Disciplina[dados.size()] ;
		
		for (int i = 0; i < dados.size(); i++) {
			String[] row = dados.get(i); 
			disciplinas[i] = new Disciplina(Integer.parseInt(row[0]), row[1], searchCursoById(row[2]));
		}
		return disciplinas;
		
	}
	
	public Curso[] searchCursoByNome(String q) {
		Map<Integer, String[]> dados = search("curso", "nome", q);
		Curso[] cursos = new Curso[dados.size()] ;
		
		for (int i = 0; i < dados.size(); i++) {
			String[] row = dados.get(i); 
			cursos[i] = new Curso(Integer.parseInt(row[0]), row[1], row[2]);
		}
		return cursos;
	}

	public Curso searchCursoById(String q) {
		Map<Integer, String[]> dados = search("curso", "cod_curso", q);
		String[] row = dados.get(0);
		return new Curso(Integer.parseInt(row[0]), row[1], row[2]);
		
	}
	
	public Nota searchNotaById(String q) {
		Map<Integer, String[]> dados = search("nota", "cod_nota", q);
		String[] row = dados.get(0);
		return (new Nota(Integer.parseInt(row[0]), 
				Double.parseDouble(row[1]),
				Double.parseDouble(row[2]),
				Double.parseDouble(row[3]),
				Integer.parseInt(row[4]),
				Integer.parseInt(row[5]),
				searchDisciplinaById(row[6]),
				searchAlunoById(row[7])));
	}
	
	private static Map<Integer, String[]> search(String tabela, String coluna, String q) {
		
		File file = new File("database/" + tabela + ".csv");
		
		try (Scanner inputStream = new Scanner(file)) {
			
			Map<String,Integer> colunas = new HashMap<String,Integer>();
			
			String data = inputStream.nextLine();
			String[] dados = data.split(",");
			
			for(int i = 0; dados.length > i; i++) {
				colunas.put(dados[i], i);
			}
						
			Map<Integer, String[]> resultados = new HashMap<Integer, String[]>();
			
			while (inputStream.hasNext()) {				
				data = inputStream.nextLine();
				dados = data.split(",");
				
				if (dados[colunas.get(coluna)].matches(".*" + q + ".*")) {
					resultados.put(resultados.size(), dados);
				}
				
			}
			return resultados;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
}